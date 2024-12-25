% Fonction RANSAC_2droites (exercice_2.m)

function [rho_F_estime,theta_F_estime] = RANSAC_2droites(rho,theta,parametres)

    % Parametres de l'algorithme RANSAC :
    S_ecart = parametres(1); % seuil pour l'ecart
    S_prop = parametres(2); % seuil pour la proportion
    k_max = parametres(3); % nombre d'iterations
    n_donnees = length(rho);
    ecart_moyen_min = Inf;

    rho_F_estime = rho(1);
    theta_F_estime = theta(1);

    for k = 1:k_max 
        M=randperm(n_donnees,2); 
        rhodt = rho(M); 
        thetadt = theta(M);

        [rho_F1,theta_F1] = estim_param_F(rhodt,thetadt);
        distance = abs(rho - rho_F1*cos(theta - theta_F1))<S_ecart;
        c = sum(distance)/n_donnees;

        if c>S_prop 
            [rho_F2,theta_F2,ecart_moyen2] = estim_param_F(rho(distance),theta(distance));
            if ecart_moyen2 < ecart_moyen_min
               rho_F_estime = rho_F2;
               theta_F_estime = theta_F2;
               ecart_moyen_min = ecart_moyen2;
            end
        end
    end 

end