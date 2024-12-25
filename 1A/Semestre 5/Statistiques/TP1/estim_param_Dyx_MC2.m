% Fonction estim_param_Dyx_MC2 (exercice_2bis.m)

function [a_Dyx,b_Dyx,coeff_r2] = ...
                   estim_param_Dyx_MC2(x_donnees_bruitees,y_donnees_bruitees)
n= length(x_donnees_bruitees); 
x_G = mean (x_donnees_bruitees);
y_G = mean (y_donnees_bruitees);

cov_x_y = (1/n) * sum((x_donnees_bruitees-x_G) .* (y_donnees_bruitees-y_G));
Var_X = (1/n) * sum ((x_donnees_bruitees-x_G) .^ 2);
Var_Y = (1/n) * sum ((y_donnees_bruitees-y_G) .^ 2);

r = cov_x_y / sqrt(Var_X*Var_Y);
coeff_r2 = r*r;
a_Dyx = r * sqrt(Var_Y/Var_X); 
b_Dyx = y_G - a_Dyx*x_G;
    
end