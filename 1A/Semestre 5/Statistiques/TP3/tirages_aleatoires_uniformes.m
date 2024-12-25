% Fonction tirages_aleatoires (exercice_3.m)

function [tirages_C,tirages_R] = tirages_aleatoires_uniformes(n_tirages,G,R_moyen)
    
tirages_C = repmat(G,1,n_tirages) + 2*R_moyen*(rand(2,n_tirages) -0.5)

tirages_R = repmat(R_moyen,1,n_tirages) + R_moyen*(rand(1,n_tirages) -0.5)

end