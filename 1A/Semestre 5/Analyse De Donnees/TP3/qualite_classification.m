% fonction qualite_classification (pour l'exercice 2)

function [pourcentage_bonnes_classifications_total ,pourcentage_bonnes_classifications_fibrome, ...
          pourcentage_bonnes_classifications_melanome] = qualite_classification(Y_pred,Y)

nb_ok_fibromes = sum(Y==1 & Y_pred==1);
nb_tot_fibromes = sum(Y==1);

nb_ok_melanomes = sum(Y~=1 & Y_pred==1);
nb_tot_melanomes = sum(Y~=1);

nb_ok_total = nb_ok_fibromes + nb_ok_melanomes; 
nb_total = nb_tot_fibromes + nb_tot_melanomes; 

pourcentage_bonnes_classifications_total = (nb_ok_total/nb_total)*100;
pourcentage_bonnes_classifications_fibrome = (nb_ok_fibromes / nb_tot_fibromes)*100
pourcentage_bonnes_classifications_melanome = (nb_ok_melanomes / nb_tot_melanomes)*100
end