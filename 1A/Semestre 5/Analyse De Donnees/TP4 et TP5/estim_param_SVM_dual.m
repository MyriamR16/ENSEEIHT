% fonction estim_param_SVM_dual (pour l'exercice 1)

function [X_VS,w,c,code_retour] = estim_param_SVM_dual(X,Y)

f = ones(size(Y));
H = diag(Y)* X * (X') * diag(Y);
lb = zeros(size(Y)); 
Aeq = Y'; 
beq = 0;
eps = 1e-6;
[alpha, ~, code_retour] = quadprog(H,-f,[],[],Aeq,beq,lb, []);

indice_VS= (alpha>eps);
X_VS = X(indice_VS,:);
Y_VS = Y(indice_VS);
alpha_VS = alpha(indice_VS);

w = X_VS' * diag(Y_VS) * alpha_VS;

c = w' * X_VS(1,:)' - Y_VS(1);

end
