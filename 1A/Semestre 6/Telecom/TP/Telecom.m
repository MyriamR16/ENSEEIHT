clear all 
close all

Fe = 24000;
Te = 1/Fe;
Rb = 3000;
Tb = 1/Rb;
Nb = 100;

bits = randi([0 1],1,Nb);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulateur 1 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%Génerer les symboles
symboles = bits * 2 - 1;

M = 2;
Nbs = Nb / log2(M);          %Nb de paquets
Rs = Rb / log2(M);
Ts = 1/Rs;
Ns = floor(Ts/Te);   %Nb echantillons sur periode symbole Ts
Ne = Nbs * Ns; %Nb echantillons total

peigneDirac = kron(symboles, [1 zeros(1,Ns-1)]);
x = filter(ones(1,Ns),1,peigneDirac);
%Densité spectrale
DSP1 = pwelch(x,[],[],[],Fe,'twosided');

%Echelle temporelle
temps = linspace(0,Ts,Ne); %Nbs*Tb-Te

%Echelle fréquentielle
frequence1 = linspace(-Fe/2,Fe/2,length(DSP1));

%affichage du signal
subplot(2,1,1);
plot(x);
axis([0 Nb-1 -1.5 1.5]);
xlabel('Temps (s)');
ylabel('signal')
title('Tracé de la réponse impulsionelle : Modulateur 1')

subplot(2,1,2)
semilogy(frequence1,fftshift(abs(DSP1))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulateur 2
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

M = 4;
Nbs = Nb / log2(M);          %Nb de paquets
Rs = Rb / log2(M);
Ts = 1/Rs;
Ns = floor(Ts/Te);   %Nb echantillons sur periode symbole Ts
Ne = Nbs * Ns; %Nb echantillons total

%Génerer les symboles
entiers = bi2de(reshape(bits, log2(M), Nb/log2(M))');
symboles = pammod(entiers,M);

peigneDirac = kron(symboles, [1 zeros(1,Ns-1)]);
x = filter(ones(1,Ns),1,peigneDirac);
%Densité spectrale
DSP2 = pwelch(x,[],[],[],Fe,'twosided');

%Echelle temporelle
temps = linspace(0,Ts,length(symboles)); 

%Echelle fréquentielle
frequence2 = linspace(-Fe/2,Fe/2,length(DSP2));

%affichage du signal
figure
subplot(2,1,1);
plot(x);
axis([0 Nb-1 -5 5]);
xlabel('Temps (s)');
ylabel('signal')
title('Tracé de la réponse impulsionelle : Modulateur 2')

subplot(2,1,2)
semilogy(frequence2,fftshift(abs(DSP2))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulateur 3
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

M = 2;
alpha = 0.5;
Nbs = Nb / log2(M);          %Nb de paquets
Rs = Rb / log2(M);
Ts = 1/Rs;
Ns = floor(Ts/Te);   %Nb echantillons sur periode symbole Ts
Ne = Nbs * Ns; %Nb echantillons total

%Génerer les symboles
symboles = bits * 2 - 1;

peigneDirac = kron(symboles, [1 zeros(1,Ns-1)]);
L = 10;
h = rcosdesign(alpha, L, Ns);
x = filter(h,1,peigneDirac);
%Densité spectrale
DSP3 = pwelch(x,[],[],[],Fe,'twosided');

%Echelle temporelle
temps = linspace(0,Ts,Ne); 

%Echelle fréquentielle
frequence3 = linspace(-Fe/2,Fe/2,length(DSP3));

figure
%affichage du signal
subplot(2,1,1);
plot(x);
axis([0 Nb-1 -1.5 1.5]);
xlabel('Temps (s)')
ylabel('signal')
title('Tracé de la réponse impulsionelle : Modulateur 3')

subplot(2,1,2)
semilogy(frequence3,fftshift(abs(DSP3))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% SUPERPOSITION DES DSP
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

figure
semilogy(frequence1,fftshift(abs(DSP1))); 
hold on 
semilogy(frequence2,fftshift(abs(DSP2))); 
semilogy(frequence3,fftshift(abs(DSP3))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé des 3 DSP des signaux générés avec une échelle fréquentielle en Hz')
legend("DSP1","DSP2","DSP3")
