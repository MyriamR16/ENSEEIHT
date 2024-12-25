% fonction estim_param_vraisemblance (pour l'exercice 1)

function [mu,Sigma] = estim_param_vraisemblance(X)
mu = mean(X); 
n = length(X);
Xc =X-mu;
B = (Xc') *Xc; 
Sigma = (1/n) * B; 
end