% fonction vecteur_bernstein (pour exercice_1.m)

function resultat = vecteur_bernstein(x,d,k)
coeff = nchoosek(d,k);
e = (1-x).^(d-k);
c = x.^k; 
resultat= coeff * (c .* e); 
end