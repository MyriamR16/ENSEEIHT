% function correlation_contraste (pour exercice_1.m)

function [correlation,contraste] = correlation_contraste(X)
n = size(X,1);
X_cent =X-mean(X);
sigma = (X_cent' *X_cent)/n ; 

Var_R = sigma(1,1) ;
Var_V = sigma(2,2) ;
Var_B = sigma(3,3); 

cov_R_V = sigma(1,2);
cov_R_B = sigma(1,3);
cov_V_B = sigma(2,3);

corr_R_V =  (cov_R_V) / ( sqrt(Var_R)*sqrt(Var_V) ) ;
corr_R_B =  (cov_R_B) / ( sqrt(Var_R)*sqrt(Var_B) ) ;
corr_V_B = (cov_V_B) / ( sqrt(Var_V)*sqrt(Var_B) ) ;

c_R = Var_R/(Var_R + Var_V +Var_B);
c_V = Var_V/(Var_R + Var_V +Var_B);
c_B = Var_B/(Var_R + Var_V +Var_B);

correlation = [corr_R_V corr_R_B corr_V_B];
contraste = [c_R c_V c_B];
end
