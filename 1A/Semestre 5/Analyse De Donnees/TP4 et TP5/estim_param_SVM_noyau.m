% fonction estim_param_SVM_noyau (pour l'exercice 2)

function [X_VS,Y_VS,Alpha_VS,c,code_retour] = estim_param_SVM_noyau(X,Y,sigma)
n = length(X):
G = zeros(n,n);
c =0 ; 
eps = 1e-6;

% Calcul de la matrice de Gram G
for i =1: n
  for j = 1:n
      V =sum((X(i,:)-X(j,:)).^2);
      G(i,j)=exp(-V/ (2*(sigma^2)));
  end 
end 

% Calcul du code retour et de Alpha_VS
f = ones(size(Y));
H = diag(Y)* X * (X') * diag(Y);
lb = zeros(size(Y)); 
Aeq = Y'; 
beq = 0;
[alpha, ~, code_retour] = quadprog(H,-f,[],[],Aeq,beq,lb, []);

indice_VS= (alpha>eps);
X_VS = X(indice_VS,:);
Y_VS = Y(indice_VS);
Alpha_VS = alpha(indice_VS);

% Calcul de c 
for j =1:n
    c = c + Alpha_VS(j)*Y(j)*G(j,1);
end 
c = c - Y(1); 

end
