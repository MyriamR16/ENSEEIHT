% fonction entrainement_foret (pour l'exercice 2)

function foret = entrainement_foret(X,Y,nb_arbres,proportion_individus)

n= length(X);
foret = cell(nb_arbres); 
r1 = randperm (proportion_individus);
for i = 1:nb_arbres
    foret{i}= fitctree(X,Y);
end

end
