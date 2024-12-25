% Fonction tirages_aleatoires_uniformes (exercice_1.m)

function [tirages_angles,tirages_G] = tirages_aleatoires_uniformes(n_tirages,taille)
    tirages_angles = (rand(1,n_tirages) - 0.5) * pi ;
    tirages_G = 2* taille *(rand(2,n_tirages) - 0.5) ; 
end