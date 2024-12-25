% fonction classification_MV (pour l'exercice 2)

function Y_pred_MV = classification_MV(X,mu_1,Sigma_1,mu_2,Sigma_2)
    V1 = modelisation_vraisemblance(X,mu_1,Sigma_1); 
    V2 = modelisation_vraisemblance(X,mu_2,Sigma_2); 
    [~,Y_pred_MV] = max ([V1 V2],[],2);
end
