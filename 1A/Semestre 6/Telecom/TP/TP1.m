clear all;
close all;
%--------------------------------------------------
%ETUDE D'UNE CHAINE DE TRANSMISSION EN BANDE DE BASE
Fe = 24000; %fréquence d'échantillonage
Te = 1/Fe;
Rb = 3000; %débit binaire
Tb = 1/Rb;
Nb = 10000
nfft = 1024;
figure;
%MODULATEUR 1--------------------------------------
bits = randi([0 1], 1, Nb);
M = 2;
Rs1 = Rb / log2(M);
Ts1 = 1/Rs1;
Ns1 = 1/(Te * Rs1);
Nbs = Nb/log2(M); %Nombre de symboles
Ne = Nbs*Ns1; %Nombre d'echantillons
symboles1 = bits*2 -1;
signal_mappe1 = kron(symboles1, [1 zeros(1, Ns1-1)]);
x1 = filter(ones(1, Ns1), 1, signal_mappe1);

%affichage du signal
subplot(2,3,1);
plot(x1);
axis([0 Nb-1 -1.5 1.5]);
xlabel('Temps (s)');
ylabel('x1 : signal à la sortie du filtre de mise en forme');

%densité spectrale de puissance (DSP)
DSP1 = pwelch(x1,[],[],[],Fe,'twosided');
frequences1 = linspace(-Fe/2, Fe/2, length(DSP1));
subplot(2,3,4);
semilogy(frequences1,fftshift(abs(DSP1))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')

%MODULATEUR 2--------------------------------------
bits = randi([0 1], 1, Nb);
M = 4;
Rs2 = Rb / log2(M);
Ts2 = 1/Rs2;
Ns2 = 1/(Te*Rs2);
Nbs = Nb/log2(M); %Nombre de symboles
Ne = Nbs*Ns2; %Nombre d'echantillons
symboles2 = reshape(bits, Nb/2, 2);
symboles2 = bi2de(symboles2); %conversion de binaire en decimal
symboles2 = (2 * symboles2 -3)';
signal_mappe2 = kron(symboles2, [1 zeros(1, Ns2-1)]);
x2 = filter(ones(1, Ns2), 1, [signal_mappe2 zeros(1, Ns2)]);

%affichage du signal
subplot(2,3,2);
plot(x2);
axis([0 Nb-1 -3.5 3.5]);
xlabel('Temps (s)');
ylabel('x2 : signal à la sortie du filtre de mise en forme');

%densité spectrale de puissance (DSP)
DSP2 = pwelch(x2,[],[],[],Fe,'twosided');
frequences2 = linspace(-Fe/2, Fe/2, length(DSP2));
subplot(2,3,5);
semilogy(frequences2,fftshift(abs(DSP2))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')

%MODULATEUR 3--------------------------------------
bits = randi([0 1], 1, Nb);
M = 2;
alpha = 0.5;
Rs3 = Rb / log2(M);
Ts3 = 1/Rs3;
Ns3 = 1/(Te*Rs3);
Nbs = Nb/log2(M); %Nombre de symboles
Ne = Nbs*Ns3; %Nombre d'echantillons
symboles3 = 2*bits - 1; % Mapping binaire à moyenne nulle : 0->-1, 1->1
signal_mappe3=kron(symboles3, [1 zeros(1,Ns3-1)]); %suite de dirac pondérée
h3 = rcosdesign(alpha, 15, Ns3);
x3 = filter(h3, 1, [signal_mappe3 zeros(1, Ns3)]);

%affichage du signal
subplot(2,3,3);
plot(x3);
axis([0 Nb-1 -1.5 1.5]);
xlabel('Temps (s)');
ylabel('x3 : signal à la sortie du filtre de mise en forme');

%densité spectrale de puissance (DSP)
DSP3 = pwelch(x3,[],[],[],Fe,'twosided');
frequences3 = linspace(-Fe/2, Fe/2, length(DSP3));
subplot(2,3,6);
semilogy(frequences3,fftshift(abs(DSP3))); 
xlabel('Fréquence (Hz)')
ylabel('DSP')
title('Tracé de la DSP du signal généré avec une échelle fréquentielle en Hz')


%% DSP sur la même courbe-------------------------------------------------
figure;
semilogy(frequences1,fftshift(abs(DSP1))); 
hold on;
semilogy(frequences2,fftshift(abs(DSP2))); 
semilogy(frequences3,fftshift(abs(DSP3))); 
xlabel("Fréquence en Hz");
ylabel("DSP de xi");
title('Comparaison des DSP des trois modulateurs');
legend('DSP de x1', 'DSP de x2', 'DSP de x3');