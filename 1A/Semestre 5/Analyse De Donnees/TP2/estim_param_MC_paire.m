% fonction estim_param_MC_paire (pour exercice_2.m)

function parametres = estim_param_MC_paire(d,x,y_inf,y_sup)
p = length(x); 
A_inf = zeros(d-1 , p);
A_sup = zeros(d-1 , p);

for i= 1 :d
    A(:,i) = vecteur_bernstein(x,d,i);
end
A_inf = y_inf - y_inf(1) .* vecteur_bernstein(x,d,0);

parametres = A\B ; 
end
end
