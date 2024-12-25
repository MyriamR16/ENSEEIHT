clear all;
close all;

alpha = 0.33;
L = 15;
Fe = 24000;
Rb = 3000;%Débit binaire
Tb = 1/Rb;
Te = 1/Fe;
N = 20000;
V = 1;

%Génération de bits

r = randi([0 1],N,1)';


%%Modulateur 1:
%{
Ts = Tb;
Ns = Ts*Fe;

%Mapping

map = 2*V*r-V;

%Création du filtre (rectangle de largeur Ts)

h = ones(1, Ns);

%Filtrage
A = zeros(1, Ns - 1);
mapSe = kron(map, [1 A]);
signal = filter(h, 1, mapSe);

%DSP = pwelch(signal,[],[],[],Fe,'twosided');
%f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
%semilogy(f, fftshift(DSP), 'b');
%grid on
%axis padded
%}

%%Modulateur 2:


Ts = 2*Tb;
Ns = Ts*Fe;

%Mapping
V1 = V;
V2 = 3*V1;
r2 = reshape(r', [2, N/2])';
rd = bit2int(r2', 1);
rd = rd+1;
LUT = [V2 V1 -V2 -V1];
map = LUT(rd);
figure
plot(map)


%Création du filtre (rectangle de largeur Ts)

h = ones(1, Ns);

%Filtrage
A = zeros(1, Ns - 1);
mapSe = kron(map, [1 A]);
signal = filter(h, 1, mapSe);
%plot(signal)

DSP = pwelch(signal,[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
%semilogy(f, fftshift(DSP), 'b');
%grid on
%axis padded

%%Modulateur 3:
%{

Ts = Tb;
Ns = Ts*Fe;

%Mapping

map = 2*V*r-V;

%Création du filtre (racine de cosinus surrélevé)

h = rcosdesign(alpha, L, Ns);
n = length(h);
%h = h((n-1)/2:n);
%Z = zeros(1, (n-1)/2);
%h = [h Z];


%Filtrage
A = zeros(1, Ns - 1);
mapSe = kron(map, [1 A]);
signal = filter(h, 1, [mapSe zeros(1,(n-1)/2)]);
signal = signal(((n-1)/2)+1:end);
%plot(signal)

DSP = pwelch(signal,[],[],[],Fe,'twosided');
f=(0:(numel(DSP)-1))/numel(DSP)*Fe-Fe/2;
%semilogy(f, fftshift(DSP), 'b');

%DSP Théorique
fbis = (-Fe/2:Fe/2);

binf = (1-alpha)/(2*Ts);
bsup = (1+alpha)/(2*Ts);
cinf = floor(binf);
csup = floor(bsup);

Sxf = zeros(1,Fe+1);
Sxf(-cinf + Fe/2:cinf + Fe/2) = 1;
Sxf(-csup + Fe/2:-cinf + Fe/2) = (1/2)*(1+cos((pi*Ts/alpha)*(abs(fbis(-csup + Fe/2:-cinf + Fe/2))-binf)));
Sxf(cinf + Fe/2:csup + Fe/2) = (1/2)*(1+cos((pi*Ts/alpha)*(abs(fbis(cinf + Fe/2:csup + Fe/2))-binf)));


nm = (cinf/Fe);
%semilogy(f, fftshift(DSP)/mean(DSP(1:floor(numel(DSP)*nm))), 'b');
%hold on
%plot(fbis, Sxf, 'r.')
%grid on
%axis padded
%}

%%Canal sans propagation
%{
Ts = Tb;

%Mapping

map = 2*V*r-V;

%Création du filtre (rectangle de largeur Ts)

h = ones(1, Ns);

%Filtrage
A = zeros(1, Ns - 1);
mapSe = kron(map, [1 A]);
signalmodule = filter(h, 1, mapSe);
%plot(signalmodule)

signaldemodule = filter(h, 1, signalmodule);
%plot(signaldemodule)

g = conv(h, h);

%Diagramme de l'oeil
%plot(reshape(signaldemodule(Ns+1:end),Ns,numel(signaldemodule(Ns+1:end))/Ns))

%From demodule to bits
n0 = 3;
E = signaldemodule(n0:Ns:end);
res = (E>0);
teb = mean(abs(res-r));


%Avec canal (filtre PB sans bruit)
ord = 30;
k = (- ord : ord);
BW = 1000;
pb = 2*BW/Fe*sinc(2*BW*k/Fe);
canal = conv(g, pb);

plot((-(numel(g)-1)/2:(numel(g)-1)/2), g);
hold on
plot((-(numel(canal)-1)/2:(numel(canal)-1)/2), canal);
grid on
axis padded

%}





%{
signalmodule = [signalmodule zeros(1, ord)];
signalcanal = filter(pb, 1, signalmodule);
temp = filter(h, 1, signalcanal);
signaldemodulebis = temp(ord + 1:end);
%plot(signaldemodulebis)
%axis padded
%grid on


%Diagramme de l'oeil
%plot(reshape(signaldemodulebis(Ns+1:end),Ns,numel(signaldemodulebis(Ns+1:end))/Ns))

Nfft=512;
H = fftshift(fft(h, Nfft));
Hc = fftshift(fft(pb,Nfft));
%}
%plot((-Nfft/2+1:Nfft/2),abs(H.*H)/max(abs(H.*H)), 'r')
%hold on
%plot((-Nfft/2+1:Nfft/2),abs(Hc)/max(abs(Hc)), 'b')
%axis padded
%grid on

%{
%From demodule to bits bis
n0 = Ns;
Ebis = signaldemodulebis(n0:Ns:end);
res = (Ebis>0);
teb = mean(abs(res-r));
%}

%%%Partie 4

%Chaine 1
%{

%Mapping
signalmodule = signal;
M = 2;
rabb = 1;
Psig = mean(abs(signalmodule).^2);
sigman = sqrt(Psig*Ns/(2*(log(M)/log(2))*rabb));
bruit = sigman*randn(1,length(signalmodule));
signalmodulebruite = signalmodule + bruit;

signaldemodulebruit = filter(h, 1, signalmodulebruite);
%plot(signaldemodulebruit);
%axis padded
%grid on

%Diagramme de l'oeil
plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))
axis padded
grid on
title("Diagramme de l'oeil pour un rapport 1")

%From demodulebruit to bits
n0 = Ns;
Ebruit = signaldemodulebruit(n0:Ns:end);
res = (Ebruit>0);
teb = mean(abs(res-r));
%}

%Chaine 3
%{
%Mapping

signalmodule = signal;
M = 2;
rabb = 1000000000;
Psig = mean(abs(signalmodule).^2);
sigman = sqrt(Psig*Ns/(2*(log(M)/log(2))*rabb));
bruit = sigman*randn(1,length(signalmodule));
signalmodulebruite = signalmodule + bruit;

h = ones(1, floor(Ns/2));
signaldemodulebruit = filter(h, 1, signalmodulebruite);
%plot(signaldemodulebruit)
%axis padded
%grid on

%Diagramme de l'oeil
plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))
axis padded
grid on
title("Diagramme de l'oeil")

%From demodulebruit to bits

n0 = Ns/2;
Ebruit = signaldemodulebruit(n0:Ns:end);
res = (Ebruit>0);
teb = mean(abs(res-r));
%}

%Chaine 2


%Mapping

signalmodule = signal;
M = 4;
rabb = 50000000000000000;
Psig = mean(abs(signalmodule).^2);
sigman = sqrt(Psig*Ns/(2*(log(M)/log(2))*rabb));
bruit = sigman*randn(1,length(signalmodule));
signalmodulebruite = signalmodule + bruit;

signaldemodulebruit = filter(h, 1, signalmodulebruite);

%figure
%plot(signaldemodulebruit)
%axis padded
%grid on

%Diagramme de l'oeil
plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))
axis padded
grid on
title("Diagramme de l'oeil pour un rapport 1")

%From demodulebruit to bits
n0 = Ns;
Ebruit = signaldemodulebruit(n0:Ns:end);

seuil1 = 2*V1*Ns;
seuil2 = 0;
seuil3 = -seuil1;

Res1 = (Ebruit>seuil1);
Res2 = (Ebruit>seuil2) - Res1;
Res3 = (Ebruit<seuil3);
Res4 = (Ebruit<seuil2) - Res3;

Res = 1*Res1 + 2*Res2 + 3*Res3 + 4*Res4;

LUT_inv = [0 1 2 3];
delute = LUT_inv(Res);
resf = de2bi(delute, 'left-msb');
resf = reshape(resf', [1,N]);

teb = mean(abs(resf-r));



