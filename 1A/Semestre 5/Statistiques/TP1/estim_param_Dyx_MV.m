 % Fonction estim_param_Dyx_MV (exercice_1.m)

function [a_Dyx,b_Dyx,residus_Dyx] = ...
           estim_param_Dyx_MV(x_donnees_bruitees,y_donnees_bruitees,tirages_psi)

[x_G, y_G, x_donnees_bruitees_centrees, y_donnees_bruitees_centrees] = centrage_des_donnees(x_donnees_bruitees,y_donnees_bruitees);
C = sum( (y_donnees_bruitees_centrees - x_donnees_bruitees_centrees*tan(tirages_psi)) .^ 2);
[~ , psi] = min(C);
elem_psi = tirages_psi(psi);
a_Dyx = tan(elem_psi);
b_Dyx =  y_G - a_Dyx*x_G;
residus_Dyx = y_donnees_bruitees - (a_Dyx .* x_donnees_bruitees) - b_Dyx;

end