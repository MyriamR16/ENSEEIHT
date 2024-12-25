% Fonction estim_param_F (exercice_1.m)

function [rho_F,theta_F,ecart_moyen] = estim_param_F(rho,theta)

n = length (theta);

B = rho;
A = [cos(theta) sin(theta)];
X = A\B; 
xf = X(1);
yf = X(2); 

rho_F = (xf^2 + yf^2)^(0.5);
theta_F = atan2(yf,xf);

ecart_moyen = (1/n) * sum( abs(rho - rho_F*cos(theta -theta_F)));

end