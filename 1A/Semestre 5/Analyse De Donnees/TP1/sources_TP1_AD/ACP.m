% function ACP (pour exercice_2.m)

function [C,bornes_C,coefficients_RVG2gris] = ACP(X)
n= size(X,1);
X_centree = X - mean(X);
Sigma = (1/n)*(X_centree' * X_centree);
[W,D] = eig(Sigma);
[~,indices_du_tri]=sort(diag(D),'descend');

    
end
