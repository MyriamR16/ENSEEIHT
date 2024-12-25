% fonction modelisation_vraisemblance (pour l'exercice 1)

function modele_V = modelisation_vraisemblance(X,mu,Sigma)
n = length (X); 
modele_V = zeros(n,1);
for i=1:n 
    d = (X(i,:)-mu) * inv(Sigma)*(X(i,:)-mu)';
    c = 1/(2*pi*sqrt(det(Sigma)))*exp(-(1/2)*d);
    modele_V(i) = c ; 
end
end