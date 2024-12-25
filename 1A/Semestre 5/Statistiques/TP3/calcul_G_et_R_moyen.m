% Fonction calcul_G_et_R_moyen (exercice_3.m)

function [G, R_moyen, distances] = ...
         calcul_G_et_R_moyen(x_donnees_bruitees,y_donnees_bruitees)
%Determination du barycentre G : 
x_moyen=mean(x_donnees_bruitees)
y_moyen = mean(y_donnees_bruitees)
G = [x_moyen; y_moyen]

%Determination de la moyenne R_moyen du rayon R : 
x_centre = x_donnees_bruitees - repmat(x_moyen ,length(x_donnees_bruitees),1);
y_centre = y_donnees_bruitees - repmat(y_moyen ,length(y_donnees_bruitees),1);
distances = sqrt(x_centre.*x_centre + y_centre.*y_centre)

R_moyen = mean(distances);
end