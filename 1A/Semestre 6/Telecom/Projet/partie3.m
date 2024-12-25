clear all
close all

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% DVB-S                                           
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Fe = 24000;  %fréquence d'échantillonage
Rb = 3000;   %débit binaire
fp = 2000;   %fréquence porteuse
Te = 1/Fe;
Tb = 1/Rb;

% Création des bits 
NbBits = 10000;
bits = randi([0 1], 1, NbBits);

% Paramètres du modulateur
M = 4;                      
Rs = Rb / log2(M);          
Ts = 1 / Rs;                
Ns = floor(Ts / Te);        
Nbs = NbBits / log2(M);    
Ne = Nbs * Ns;             

% Mapping
dk = (1-2*bits(1:2:NbBits) + 1i*(1-2*bits(2:2:NbBits))).';

% Tracé des constellations en sortie de l'échantilloneur
figure
plot(dk, 'pr', 'LineWidth', 3);
xlabel("ak");
ylabel("bk");
title("Tracé des constellations en sortie de l'échantilloneur.")

% Filtre de mise en forme en racine de cosinus surélevé
alpha = 0.35;                       % Roll-off
L = 10;
h = rcosdesign(alpha, L, Ns);       % Filtre de mise en forme

% Filtre de réception adapté
hr = fliplr(h);

% Signal en phase
I = real(dk);

% Signal en quadrature
Q = imag(dk);

% Peigne de Dirac
peigneDiracPhase = [kron(I', [1 zeros(1, Ns - 1)]) zeros(1,length(h))];
I2 = filter(h, 1, peigneDiracPhase);

peigneDiracQuadrature = [kron(Q', [1 zeros(1, Ns - 1)]) zeros(1,length(h))];
Q2 = filter(h, 1, peigneDiracQuadrature);

% Echelle temporelle
temps = [0:length(I2)-1]*Te;

signal = (I2 .* cos(2*pi*fp*temps)) - (Q2 .* sin(2*pi*fp*temps));

% DSP de l'enveloppe complexe associée au signal transmis
DSP = pwelch(I2+1i*Q2, [],[],[],Fe,'twosided');

figure;
echelle_frequentielle = linspace(-Fe/2, Fe/2, length(DSP));
semilogy(echelle_frequentielle, fftshift(abs(DSP)), 'r', 'LineWidth', 1.2);
xlabel("Fréquences (Hz)")
ylabel("DSP")
title("DSP de l'enveloppe complexe sans bruit");
 
bruitmax1 = 6;
EbN0db = [0:bruitmax1];
EbN0 = 10.^(EbN0db./10);

for k=1:length(EbN0db)
    rapp = EbN0(k);
    sigma = mean(abs(signal).^2)*Ns/(log2(4)*rapp);
    bruit = sqrt(sigma)*randn(1,length(signal)) + 1i*sqrt(sigma)*randn(1,length(signal));

    signal_transmis = I2 + 1i*Q2;
    signal_bruit = signal_transmis + bruit;

    Ibruit = I2 + real(bruit);
    Qbruit = Q2 + imag(bruit);

    figure;
    subplot(1,2,1);
    plot(temps, Ibruit);
    xlabel("Temps en secondes)");
    ylabel("Signal en phase");
    title("Signal en phase transmis pour Eb/N0 = " + EbN0db(k));

    subplot(1,2,2);
    plot(temps, Qbruit);
    xlabel("Temps en secondes");
    ylabel("Signal en quadrature");
    title("Signal en quadrature transmis pour Eb/N0(dB) = " + EbN0db(k));
    
    % DSP de l'enveloppe complexe associée au signal transmis
    DSP = pwelch(signal_bruit, [],[],[],Fe,'twosided');
    
    figure;
    echelle_frequentielle = linspace(-Fe/2, Fe/2, length(DSP));
    semilogy(echelle_frequentielle, fftshift(abs(DSP)));
    xlabel("Fréquences (Hz)")
    ylabel("DSP")
    title("DSP de l'enveloppe complexe pour Eb/N0(dB) = " + EbN0db(k));

    % Demodulation du signal
    signal_demod = filter(hr, 1, signal_bruit);
   
    n0 = L*Ns+1;
    dem = signal_demod(n0:Ns:length(signal_demod)-1);

    % Tracé des constellations en sortie du mapping et de l'échantilloneur
    figure
    plot(dem,'dg');
    hold on
    plot(dk, 'pr', 'LineWidth', 3);
    title("Constellations pour Eb/N0(dB) = " + EbN0db(k));
    
    % Demapping
    bits_estim = zeros(1, NbBits);
    bits_estim(1:2:NbBits) = real(dem) < 0;
    bits_estim(2:2:NbBits) = imag(dem) < 0;
    
    % Calcul du TEB
    taux_erreur = sum(bits_estim ~= bits)/length(bits);
    TEB(k) = taux_erreur;
end

%Comparaison TEB1 avec le TEB théortique.
TEB_theorique = qfunc(sqrt((log2(M)*EbN0)));
figure
semilogy(EbN0db, TEB);
hold on
semilogy(EbN0db, TEB_theorique);
xlabel('Eb/N0');
ylabel('TEB');
title("Comparaison TEB empirique avec le TEB théorique");
legend('TEB empirique','TEB Théorique')

