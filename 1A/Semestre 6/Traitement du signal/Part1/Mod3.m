clear all;
close all;

alpha = 0.33;
L = 15;
Fe = 24000;
Rb = 3000;%Débit binaire
Tb = 1/Rb;
Te = 1/Fe;
N = 2000;
V = 1;

%Génération de bits

r = randi([0 1],N,1)';

Ts = 2*Tb;
Ns = Ts*Fe;

%Mapping
V1 = V;
V2 = 3*V1;
r2 = reshape(r', [2, N/2])';
rd = bi2de(r2, 'left-msb');
rd = rd+1;
LUT = [V2 V1 -V2 -V1];
map = LUT(rd);



%Création du filtre (rectangle de largeur Ts)

h = ones(1, Ns);

%Filtrage
A = zeros(1, Ns - 1);
mapSe = kron(map, [1 A]);
signal = filter(h, 1, mapSe);

signalmodule = signal;
M = 4;
rabb = 50000;
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
figure
plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))

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
teb