clear all;
close all;

alpha = 0.33;
L = 15;
Fe = 24000;
Rb = 3000;%Débit binaire
Tb = 1/Rb;
Te = 1/Fe;
N = 500000;
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


%Mapping
signalmodule = signal;
M = 2;

Nrab = 8;
Pas = 0.5;
tebtab = zeros(Nrab/Pas - 1, 1);
rabbtab = (Pas:Pas:Nrab);
for i = rabbtab

rabb = i;
Psig = mean(abs(signalmodule).^2);
sigman = sqrt(Psig*Ns/(2*(log(M)/log(2))*10.^(rabb/10)));
bruit = sigman*randn(1,length(signalmodule));
signalmodulebruite = signalmodule + bruit;

signaldemodulebruit = filter(h, 1, signalmodulebruite);

n0 = Ns;
Ebruit = signaldemodulebruit(n0:Ns:end);
res = (Ebruit>0);
teb = mean(abs(res-r));
tebtab(floor(i/Pas)) = teb;

end


semilogy(rabbtab, tebtab, 'o');
hold on
Qtab1 = qfunc(sqrt(2*(10.^(rabbtab/10))));
semilogy(rabbtab, Qtab1,'o');
grid on;
axis padded;
%Diagramme de l'oeil
%plot(reshape(signaldemodulebruit,2*Ns,numel(signaldemodulebruit)/Ns/2))

