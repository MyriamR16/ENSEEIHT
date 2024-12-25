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

%%Modulateur 1:

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



signalmodule = signal;
M = 2;
rabb = 100;
Psig = mean(abs(signalmodule).^2);
sigman = sqrt(Psig*Ns/(2*(log(M)/log(2))*rabb));
bruit = sigman*randn(1,length(signalmodule));
signalmodulebruite = signalmodule + bruit;

h = ones(1, floor(Ns/2));
signaldemodulebruit = filter(h, 1, signalmodulebruite);

n0 = Ns/2;%L'opti est 3/4*Ns
Ebruit = signaldemodulebruit(n0:Ns:end);
res = (Ebruit>0);
teb = mean(abs(res-r));

%Diagramme de l'oeil
plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))