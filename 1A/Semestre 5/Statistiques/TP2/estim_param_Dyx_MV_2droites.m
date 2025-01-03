% Fonction estim_param_Dyx_MV_2droites (exercice_2.m) 

function [a_Dyx_1,b_Dyx_1,a_Dyx_2,b_Dyx_2] = ... 
         estim_param_Dyx_MV_2droites(x_donnees_bruitees,y_donnees_bruitees,sigma, ...
                                     tirages_G_1,tirages_psi_1,tirages_G_2,tirages_psi_2)    
n = length (y_donnees_bruitees); 
n_tirages = length(tirages_G_1);

y_bis1 = repmat(y_donnees_bruitees,1,n_tirages) - repmat(tirages_G_1(2,:),n,1);
x_bis1 = repmat(x_donnees_bruitees,1,n_tirages) - repmat(tirages_G_1(1,:),n,1); 

y_bis2 = repmat(y_donnees_bruitees,1,n_tirages) - repmat(tirages_G_2(2,:),n,1);
x_bis2 = repmat(x_donnees_bruitees,1,n_tirages) - repmat(tirages_G_2(1,:),n,1); 

tang_1 = repmat(tan(tirages_psi_1),n,1);
tang_2 = repmat(tan(tirages_psi_2),n,1);

residus1 = y_bis1 - tang_1.* x_bis1;
residus2 = y_bis2 - tang_2.* x_bis2;

a = exp ((-residus1.^2)/(2*(sigma^2)));
b = exp ((-residus2.^2)/(2*(sigma^2)));
c = sum(log(a+b)); 


[~,argmax_trouve]=max(c);

a_Dyx_1 = tan (tirages_psi_1(argmax_trouve)); 
b_Dyx_1 = tirages_G_1(2,argmax_trouve) - a_Dyx_1*tirages_G_1(1,argmax_trouve);

a_Dyx_2 = tan (tirages_psi_2(argmax_trouve)); 
b_Dyx_2 = tirages_G_2(2,argmax_trouve) - a_Dyx_2*tirages_G_2(1,argmax_trouve);

end