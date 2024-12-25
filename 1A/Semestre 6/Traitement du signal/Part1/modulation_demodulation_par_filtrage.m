clear all;
close all;

N = 20;
Debit = 300;
Ts = 1/Debit;
Fe = 48e3;
Te = 1/Fe;
Ns = Ts*Fe;

%3.1.1

r = randi([0 1],N,1)';
NRZ = kron(r,ones(1, Ns));

%3.1.2

%{
T = Te*(0:N*Ns-1);
plot(T, NRZ, 'b')
xlabel('Temps (seconde)');
ylabel Bit;
title NRZ;
axis padded;
grid on;
%}

%3.1.3

%pwelch(NRZ,[],[],[],Fe,'twosided');

%3.1.4

%{
DSP = pwelch(NRZ,[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
semilogy(f, fftshift(DSP), 'b');
hold on
xlabel('Fréquence (en Hz)')
ylabel('Magnitude (en dB)')


Y=(1/4)*Ts*(pi*sinc(f*Ts).^2);
Y(f==0)=Y(f==0)+1/4;
X = f;
semilogy(X, Y,'r-')

title DSP
legend('DSP estimée','DSP théorique')
%}


%3.2.1 et 3.2.2

Fcentrale = 4000;
deltaf = 2000;
F0 = Fcentrale + deltaf;
F1 = Fcentrale - deltaf;
p0 = rand*2*pi;
p1 = rand*2*pi;
X = (1 - NRZ).*cos(2*pi*F0*Te*(1:Ns*N)+p0) + NRZ.*cos(2*pi*F1*Te*(1:Ns*N)+p1);
T = (1:N*Ns)*Te;

%{
plot(T,X)
ylabel Amplitude
xlabel('Temps (en s)')
title Signal x(t)
axis padded
grid on
%}

%3.2.4

%{
Sx = pwelch(X,[],[],[],Fe,'twosided');
f=(0:(numel(Sx)-1))/numel(Sx)*Fe-Fe/2;
semilogy(f, fftshift(Sx));
xlabel('Fréquence (en Hz)');
ylabel('Magnitude (en dB)');
title('DSP du signal modulé en fréquence')
axis padded
%}

%4

SNRdB = 500;
Ps = mean(abs(X).^2);
sigma = Ps*10^(-SNRdB/10);
Bruit = sigma*randn(1, N*Ns);
NRZbruite = NRZ + Bruit;
T = Te*(0:N*Ns-1);


X = (1 - NRZbruite).*cos(2*pi*F0*Te*(1:Ns*N)+p0) + NRZbruite.*cos(2*pi*F1*Te*(1:Ns*N)+p1);
T = (1:N*Ns)*Te;
%plot(T,X)

%{
plot(T,NRZbruite)
xlabel('Temps (en s)');
ylabel Signal;
title('NRZ bruité (SNR = 5)');
grid on;
axis padded
%}


%5.2.1

fc = (F0+F1)/2;
n0 = 30;
k1 = (30/n0 : 30/n0 : 30);
k2 = flip(-k1);
k = [k2 0 k1];
%fc = Fe*(1/pi)*tan(fc);
filtre_b = 2*fc/Fe*sinc(2*fc*k/Fe);
filtre_h=-filtre_b;
filtre_h(n0+1)=1+filtre_h(n0+1);
Nfft=512;
Hb=fft(filtre_b,Nfft);
Hh=fft(filtre_h,Nfft);

f=(0:(Nfft-1))/Nfft*Fe;

%{
plot(f,(abs(Hb).^2));
hold on
plot(f,(abs(Hh).^2),'r-');

xlabel Fréquence
ylabel Magnitude
title Filtre
%}

%5.3

%{
B = filtre_b;
plot(filter(B,1,X));
B = filtre_h;
plot(filter(B,1,X));
%}


%5.4
%Voie 1 (passe bas)
%5.4.1
tiledlayout(2,1)

nexttile
f = (0:(Nfft-1))/Nfft*Fe - Fe/2;
plot(f,fftshift(abs(Hb).^2),'b');
xlabel('Fréquence (en Hz)')
ylabel('Amplitude')
title('Réponse fréquentielle du filtre passe-bas')
grid on

nexttile
K = (-n0 : n0)*2*fc/Fe;
stem(K, filtre_b, 'r');
xlabel('n')
ylabel('Amplitude')
title('Réponse impulsionelle du filtre passe-bas')
grid on


%5.4.2

%{
DSP = pwelch(X,[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
semilogy(f, fftshift(DSP), 'b');
xlabel('Fréquence (en Hz)')
ylabel('Magnitude (en dB)')
title('DSP du signal reçu et réponse fréquentielle du PB')
grid on


hold on

f = (0:(Nfft-1))/Nfft*Fe - Fe/2;
plot(f,fftshift(abs(Hb).^2),'r');
legend('DSP du signal modulé en fréquence','Réponse fréquentielle du PB')

hold off
%}

%5.4.3

%{
tiledlayout(2,1)

nexttile
B = filtre_b;
T = Te*(0:N*Ns-1);
plot(T, filter(B,1,X));
grid on
xlabel('Temps (en s)')
ylabel('Amplitude')
title('Signal en sortie du filtre PB')

nexttile
DSP = pwelch(filter(B,1,X),[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
semilogy(f, fftshift(DSP), 'b');
xlabel('Fréquence (en Hz)')
ylabel('Magnitude (en dB)')
title('DSP du signal en sortie du filtre PB')
grid on
%}



%Voie 2 (passe haut)
%5.4.1

%{
tiledlayout(2,1)

nexttile
f = (0:(Nfft-1))/Nfft*Fe - Fe/2;
plot(f,fftshift(abs(Hh).^2),'b');
xlabel('Fréquence (en Hz)')
ylabel('Amplitude')
title('Réponse fréquentielle du filtre passe-haut')
grid on

nexttile
K = (-n0 : n0)*2*fc/Fe;
stem(K, filtre_h, 'r');
xlabel('n')
ylabel('Amplitude')
title('Réponse impulsionelle du filtre passe-haut')
grid on
%}

%5.4.2

%{
DSP = pwelch(X,[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
semilogy(f, fftshift(DSP), 'b');
xlabel('Fréquence (en Hz)')
ylabel('Magnitude (en dB)')
title('DSP du signal reçu et réponse fréquentielle du PH')
grid on


hold on

f = (0:(Nfft-1))/Nfft*Fe - Fe/2;
plot(f,fftshift(abs(Hh).^2),'r');
legend('DSP du signal modulé en fréquence','Réponse fréquentielle du PH')

hold off
%}

%5.4.3

%{
tiledlayout(2,1)

nexttile
B = filtre_h;
T = Te*(0:N*Ns-1);
plot(T, filter(B,1,X));
grid on
xlabel('Temps (en s)')
ylabel('Amplitude')
title('Signal en sortie du filtre PH')

nexttile
DSP = pwelch(filter(B,1,X),[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
semilogy(f, fftshift(DSP), 'b');
xlabel('Fréquence (en Hz)')
ylabel('Magnitude (en dB)')
title('DSP du signal en sortie du filtre PH')
grid on
%}


%5.5.1

X = (1 - NRZbruite).*cos(2*pi*F0*Te*(1:Ns*N)+p0) + NRZbruite.*cos(2*pi*F1*Te*(1:Ns*N)+p1);
Xfb = filter(filtre_b,1,X);
%plot(Xfb)

Xfb = Xfb.^2;%Carré composante par composante
%Construction d'une matrice qui va me faire la somme par groupe de Ns:
I = eye(N);
U = ones(1, Ns);
A = kron(I, U);
S = A*Xfb';
K = 40;%Seuil choisit experimentalement
donnees = S > K;
te = (donnees' == r);
taux = 1 - mean(te);
taux


















