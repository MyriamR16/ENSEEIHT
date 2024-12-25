% fonction calcul_bon_partitionnement (pour l'exercice 1)

function meilleur_pourcentage_partitionnement = calcul_bon_partitionnement(Y_pred,Y)
liste_score = []
permutations =perms(1:3);

for i = 1: length(permutations)
    Y_permutation = zeros(length(Y_pred),1)
    for s = 1:3 
       Y_permutation = Y_permutation + permutations(i,s)*(Y_pred==s);
    end 
    score = sum(Y_permutation==Y)
    liste_score = [liste_score score]
end
meilleur_pourcentage_partitionnement = 100*max(liste_score)/length(Y);
end