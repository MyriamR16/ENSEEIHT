% Fonction estim_param_Dorth_MV (exercice_3.m)

function [theta_Dorth,rho_Dorth] = ...
         estim_param_Dorth_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_theta)

xG = mean(x_donnees_bruitees);
yG = mean(y_donnees_bruitees); 

x_utile  = x_donnees_bruitees - xG ; 
y_utile  = y_donnees_bruitees - yG ; 

C = sum((x_utile* cos(tirages_theta) + y_utile* sin(tirages_theta)) .^2 );
[~,teta_indice_min] = min(C);

theta_Dorth = tirages_theta(teta_indice_min);
rho_Dorth = (xG * cos(theta_Dorth)) + (yG * sin(theta_Dorth));

end