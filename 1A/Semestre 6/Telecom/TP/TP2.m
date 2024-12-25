clear all;
close all;

%--------------------------------------------------
%ETUDE D'UNE CHAINE DE TRANSMISSION EN BANDE DE BASE
Fe = 24000; %fréquence d'échantillonage
Te = 1/Fe;
Rb = 3000; %débit binaire
Tb = 1/Rb;
Nb = 100;
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
h = ones(1, Ns1);
hr = h; 
x1 = filter(h, 1, signal_mappe1);
z1 = filter(hr, 1, x1);

%affichage du signal
subplot(2,1,1)
plot(x1);
axis([0 Nb-1 -1.5 1.5]);
xlabel('Temps (s)');
ylabel('x1');
title('signal à la sortie du filtre de mise en forme');

subplot(2,1,2)
plot(z1);
hold on
plot(ones(1,100)*Ts1, linspace(-8, 8, 100));
axis([0 Nb-1 -10 10]);
xlabel('Temps (s)');
ylabel('z1');
title("signal à la sortie du filtre de reception");

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Réponse impulsionnelle globale de la chaine de transmission
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

g = conv(h,hr);
figure
%echelle_temporelle = linspace(0,Ts1,length(g))
plot(g)
xlabel('Echantillons');
ylabel('Amplitude');
title("Réponse impulsionnelle globale de la chaine de transmission ")

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%Diagramme de l'oeil
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

figure
plot(reshape(z1,Ns1,length(z1)/Ns1)) 
xlabel('Echantillons');
ylabel('Amplitude');
title("Diagramme de l'oeil")

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Seuil
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
n0 = 3;
echantillons = z1(n0:Ns1:length(z1));
seuil = 0;
BitsDecides = echantillons>seuil;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%TEB
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

TEB = (sum(BitsDecides ~= bits))/Nb


