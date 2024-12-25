clear all;
close all;

%--------------------------------------------------
%ETUDE D'UNE CHAINE DE TRANSMISSION EN BANDE DE BASE
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


Fe = 24000; %fréquence d'échantillonage
Rb = 3000; %débit binaire
fp = 2000; %fréquence porteuse
Te = 1/Fe;
Tb = 1/Rb;
nfft = 1024;

%Génération de bits
NbBits = 1000;
bits = randi([0 1], 1, NbBits);

M = 4;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Rs1 = Rb / log2(M);
Ts1 = 1/Rs1;
Ns1 = floor(1/(Te * Rs1));
Nbs = NbBits/log2(M); %Nombre de symboles

Ne = Nbs*Ns1; %Nombre d'echantillons

dk = 1-2*bits(1:2:NbBits)+1i*(1-2*bits(2:2:NbBits));

SPAN = 10 ;
SPS = floor(Ts1/Te);
alpha = 0.35; %roll off
h = rcosdesign(alpha,SPAN,SPS); %Plus SPAN (2ème parametre) est grand et plus
                                % l'oeil s'ouvre ; SPAN la longueur du filtre 
                                % exprimée en nb de Ts ; SPS = Ts/Te


signal_mappe1 = [kron(dk, [1 zeros(1, Ns1 - 1)]) zeros(1,length(h))];

                        
xe = filter(h, 1, signal_mappe1); %Enveloppe complexe associée à x

% Signal en phase 
I = real(xe);
Q = imag(xe);

temps = [0:length(signal_mappe1)-1]*Te;

%Signal x en sortie  de la transposition de fréquence
x = I.*cos(2*pi*fp*temps) - Q.*sin(2*pi*fp*temps);

%Calcul de la densité spectrale de puissance
DSPe = pwelch(xe,[],[],[],Fe,'twosided');
DSP = pwelch(x,[],[],[],Fe,'twosided');

frequence = linspace(-Fe/2,Fe/2,length(DSPe));

%affichage du signal
figure
subplot(1,2,1);
plot(temps,I);
xlabel('Temps (s)');
ylabel("Composante en phase I(t)");
title('Tracé du signal généré sur la voie en phase avec une échelle temporelle correcte.');

subplot(1,2,2);
plot(temps,Q);
xlabel('Temps (s)');
ylabel("Composante en quadrature Q(t)");
title('Tracé du signal généré sur la voie en quadrature avec une échelle temporelle correcte.');

figure
plot(temps,xe);
xlabel('Temps (s)');
ylabel('xe(t) : Enveloppe complexe associée à x');
title('signal à la sortie du filtre de mise en forme');

figure
plot(temps,x);
xlabel('Temps (s)');
ylabel('x(t)');
title("signal obtenu après transposition de fréquence");

figure
subplot(1,2,1)
semilogy(frequence,fftshift(abs(DSPe))); 
xlabel('Fréquence en Hz');
ylabel('DSP');
title("DSP de xe");

subplot(1,2,2)
semilogy(frequence,fftshift(abs(DSP))); 
xlabel('Fréquence en Hz');
ylabel('DSP');
title("DSP de x");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% TEB
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

bruitmax1 = 6;
EbN0db1 = [0:bruitmax1];
EbN01=10.^(EbN0db1./10);

TEB1 = zeros(1,bruitmax1);

%filtre adapté
hr = fliplr(h);

for k=1:length(EbN0db1)
    rapp = EbN01(k);

    %Définition du bruit.
    sigma1 = mean(abs(x).^2)*Ns1/(2*log2(M)*rapp);
    bruit1=sqrt(sigma1)*randn(1,length(x));
    
    %Signaux propagés avec et sans bruit.
    signal_propage_avec_bruit = x + bruit1; %avec bruit
    signal_propage_sans_bruit = x; %sans bruit
    
    %Retour en bande de base
    x1 = (signal_propage_avec_bruit.* cos(2*pi*fp*temps)) - 1i*(signal_propage_avec_bruit .* sin(2*pi*fp*temps)); 

    %Demodulation bande de base
    z = filter(hr,1,x1);  %signal sortie du filtre de reception

    n0 = SPAN*SPS +1; %Retard du filtre compensé
    zm = z(n0+1:Ns1:length(z)); %Echantillonage
 
    %Demapping
    bits_estim = zeros(1, NbBits);
    bits_estim(1:2:NbBits) = real(zm) < 0;
    bits_estim(2:2:NbBits) = imag(zm) < 0;
    

    %Calcul du TEB
    taux_erreur1 = sum(bits_estim ~= bits) / length(bits);
    TEB1(k) = taux_erreur1;
end

%Comparaison TEB1 avec le TEB théortique.
TEB_theorique1 = qfunc(sqrt((log2(M)*EbN01)));
figure
semilogy(EbN0db1, TEB1);
hold on
semilogy(EbN0db1, TEB_theorique1);
xlabel('Eb/N0');
ylabel('TEB');
title("Comparaison TEB empirique avec le TEB théortique");
legend('TEB empirique','TEB Théorique')

