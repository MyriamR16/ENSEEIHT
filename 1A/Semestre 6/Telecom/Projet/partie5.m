clear all;
close all;

% Paramètres généraux
Fe = 6000; % Fréquence d'échantillonnage (Hz)
Rb = 3000; % Débit binaire (bit/s)
fp = 2000; % Fréquence porteuse (non utilisée dans ce script)
Te = 1/Fe; % Période d'échantillonnage (s)
Tb = 1/Rb; % Période binaire (s)

% Génération de bits
NbBits = 9000;
bits = randi([0 1], 1, NbBits);

% Modulation 8-PSK
M = 8; % Ordre de modulation

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Rs = Rb / log2(M); % Débit symbole
Ts = 1/Rs; % Période de symbole
Ns = floor(Fe / Rs); % Nombre d'échantillons par symbole
Nbs = NbBits / log2(M); % Nombre de symboles
Ne = Nbs * Ns; % Nombre total d'échantillons

% Filtre de mise en forme
alpha = 0.2; % Roll-off
SPAN = 10; % Nombre de symboles que couvre le filtre
SPS = Ns; % Samples Per Symbol
h = rcosdesign(alpha, SPAN, SPS);
% Filtre de réception
hr = fliplr(h);

% Mapping 8-PSK
symboles_8PSK1 =  bi2de(reshape(bits, log2(M), length(bits)/log2(M)).');
symboles_8PSK = pskmod(symboles_8PSK1,M,pi/8)

 % Constellation en sortie du mapping
 figure; 
 plot(real(symboles_8PSK), imag(symboles_8PSK), 'r* ');
 xlabel("I"); 
 ylabel("Q");
 title("Constellations en sortie du mapping");

% Génération de la suite de Diracs pondérés par les symboles
Suite_diracs = [kron(symboles_8PSK, [1 zeros(1, Ns - 1)]) zeros(1,length(h))];

% Signal généré à la sortie du filtre de mise en forme
x = filter(h, 1, Suite_diracs);

% Paramètres du bruit
EbN0db = [0:6];
EbN0=10.^(EbN0db./10);

TEB = zeros(1,length(EbN0));

for k=1:length(EbN0db)
    rapp = EbN0(k);


    %Définition du bruit.
    sigma = (mean(abs(x).^2)*Ns)/(2*log2(M)*rapp);
    bruit=sqrt(sigma)*randn(1,length(x));
    
    %Signaux propagés avec bruit.
    signal_propage_avec_bruit = x + (bruit); %avec bruit complexe
   
    %Demodulation bande de base
    zk = filter(hr,1,signal_propage_avec_bruit);  %signal sortie du filtre de reception
    zm = zk(length(h):Ns:length(zk)-1); %Echantillonage

    % Constellation en sortie de l'échantilloneur
    figure; 
    plot(real(zm),0,'B*')
    hold on
    plot(real(symboles_4ASK), imag(symboles_4ASK), 'r*');
    xlabel("I"); 
    ylabel("Q");
    title("Constellations en sortie de l'échantillonneur pour Eb/N0 = ", rapp);

    %Demapping
    symboles_estim = zeros(1, length(zm));
    for i = 1: length(zm)
        if (real(zm(i)) < -2)
            symboles_estim(i) = -3; 
        elseif (real(zm(i)) <= 0)
            symboles_estim(i) = -1; 
        elseif (real(zm(i)) <= 2)
            symboles_estim(i) = 1; 
        else
            symboles_estim(i) = 3; 
        end
    end

    %Calcul du TEB
    taux_erreur = sum(symboles_estim ~= symboles_4ASK) / length(symboles_estim);
    TEB(k) = taux_erreur/2;  %TEB=TES/log2(M) et log2(4)=2

end

%Comparaison TEB avec le TEB théortique.
TEB_theorique  = (3/4)*qfunc(sqrt((4/5)* EbN0));
figure
semilogy(EbN0db, TEB);
hold on
semilogy(EbN0db, TEB_theorique);
xlabel('Eb/N0');
ylabel('TEB');
title("Comparaison TEB empirique avec le TEB théorique");
legend('TEB empirique','TEB Théorique')

