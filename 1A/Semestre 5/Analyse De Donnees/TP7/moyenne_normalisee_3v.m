% fonction moyenne_normalisee_3v (pour l'exercice 1bis)

function x = moyenne_normalisee_3v(I)
 
    I = single(I);
    [I,J] =meshgrid(size(I));


    somme_canaux = max(1,sum(I,3));
    r = I(:,:,1)./somme_canaux;
    v = I(:,:,2)./somme_canaux;
    b = I(:,:,3)./somme_canaux; 

    r_barre = mean(r(:));
    v_barre = mean(v(:));
    

    x = [r_barre v_barre ];

end
