clear all
close all

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Transmission au format DVB-S                                            %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Paramètres généraux
Fe = 24000;                 % Fréquence d'échantillonnage (Hz)
Te = 1/ Fe;                 % Période d'échantillonnage (s)
Rb = 3000;                  % Débit binaire (bit/s)
Tb = 1 / Rb;                % Période binaire (s)
Fp = 2000;                  % Fréquence porteuse (Hz)

% Création d'une séquence aléatoire de bits dans [0 1]
NbBits = 100;
bits = randi([0 1], 1, NbBits);

% Paramètres du modulateur
M = 4;                      % 2^2 : ordre du modulateur
Rs = Rb / log2(M);          % Débit symbole (symboles/s)
Ts = 1 / Rs;                % Période symbole (s)
Ns = floor(Ts / Te);        % Nombre d'échantillons sur une période symbole
Nbs = NbBits / log2(M);     % Nombre de symboles
Ne = Nbs * Ns;              % Nombre d'échantillons sur la totalité du signal

% Mapping
% symboles = reshape(bits, log2(M), NbBits/log2(M));
% entiers = bit2int(symboles, 2)';
% signal_mappe = pskmod(entiers, M);
signal_mappe = (1-2*bits(1:2:NbBits) + 1i*(1-2*bits(2:2:NbBits))).';

% Filtre de mise en forme en racine de cosinus surélevé
alpha = 0.15;                       % Roll-off
L = 10;
h = rcosdesign(alpha, L, Ns);       % Filtre de mise en forme
%plot(h);

% Filtre de réception adapté
hr = fliplr(h);

% Séparation signal en phase et signal en quadrature
% Signal en phase
signal_phase = real(signal_mappe);

% Signal en quadrature
signal_quadrature = imag(signal_mappe);

% Peigne de Dirac
peigneDirac_phase = [kron(signal_phase', [1 zeros(1, Ns - 1)]) zeros(1,length(h))];
I_t = filter(h, 1, peigneDirac_phase);
peigneDirac_quadrature = [kron(signal_quadrature', [1 zeros(1, Ns - 1)]) zeros(1,length(h))];
Q_t = filter(h, 1, peigneDirac_quadrature);

% Echelle temporelle
% echelle_temps = linspace(0, NbBits*Tb, (NbBits/log2(M))*Ns);
echelle_temps = [0:length(I_t)-1]*Te
% Tracé du signal en phase et du signal en quadrature
figure;
subplot(2,1,1);
plot(echelle_temps, I_t, 'LineWidth', 2);
xlabel("Temps (s)");
ylabel("Signal en phase");
title("Signal en phase transmis");

subplot(2,1,2);
plot(echelle_temps, Q_t, 'LineWidth', 2);
xlabel("Temps (s)");
ylabel("Signal en quadrature");
title("Signal en quadrature transmis");

% Transposition sur fréquence porteuse
signal_phase_porteuse = I_t .* cos(2*pi*Fp*echelle_temps);
signal_quadrature_porteuse = Q_t .* sin(2*pi*Fp*echelle_temps);
signal_porteuse = signal_phase_porteuse - signal_quadrature_porteuse;

% Bruit 
bruitmax1 = 6;
EbN0db = [0:bruitmax1];
EbN0=10.^(EbN0db./10);

for k=1:length(EbN0db)
    rapp = EbN0(k);
    sigma = mean(abs(signal_porteuse).^2)*Ns/(2*log2(4)*rapp);
    bruit = sqrt(sigma)*randn(1,length(signal_porteuse));
    signal_porteuse_bruit = signal_porteuse + bruit;

    %figure;
    %plot(echelle_temps, signal_porteuse_bruit, 'LineWidth', 2);
    %title("Tracé du signal transmis sur fréquence porteuse");
    
    % DSP du signal transmis
    Sx_Welch = pwelch(signal_porteuse_bruit, [],[],[],Fe,'twosided');
    
    %figure;
    %echelle_frequentielle = linspace(-Fe/2, Fe/2, length(Sx_Welch));
    %semilogy(echelle_frequentielle, fftshift(abs(Sx_Welch)), 'r', 'LineWidth', 1.2);
    %xlabel("Fréquences (Hz)")
    %ylabel("DSP")
    %title("Tracé de la DSP de l'enveloppe complexe associé au signal transmis");
    
    % Retour en bande de base
    ret_bdb_phase = signal_porteuse_bruit .* cos(2*pi*Fp*echelle_temps);
    ret_bdb_quadrature = signal_porteuse_bruit .* sin(2*pi*Fp*echelle_temps);
    ret_bdb = ret_bdb_phase - 1i*ret_bdb_quadrature;
    C = length(ret_bdb)
    % Demodulation du signal
    signal_demod = filter(hr, 1, ret_bdb);
    B = length(signal_demod)
    % Echantillonnage du signal démodulé
    n0 = L*Ns+1;
    signaldem_ech = signal_demod(n0+1:Ns:length(signal_demod));
    A = length(signaldem_ech)
    
    % Demapping
    bits_estim = zeros(1, NbBits);
    bits_estim(1:2:NbBits) = real(signaldem_ech) < 0;
    bits_estim(2:2:NbBits) = imag(signaldem_ech) < 0;
    
    % Calcul du TEB
    taux_erreur = sum(bits_estim ~= bits)/length(bits);
    TEB(k) = taux_erreur;
end
TEB_theorique = qfunc(sqrt(2*EbN0));
figure
semilogy(EbN0db, TEB);
hold on
semilogy(EbN0db, TEB_theorique);
