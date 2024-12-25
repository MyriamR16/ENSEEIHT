%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP2 - Factorisation LU
% descente.m
%---------------------------------------------------------------------------

function [err_d,err_i] = erreur(A,b,x,x_exact)
%---------------------------------------------------------------------------
% Calcul des erreurs directe err_d et inverse err_i
% x_exact tel que A x_exact=b; x solution numerique
%---------------------------------------------------------------------------
       
     % Erreur directe
     err_d=norm(x-x_exact,2)/norm(x_exact,2);
     
     % Erreur inverse
     err_i=norm((A*x - b),2)/(norm(A,2)*norm(x,2)+norm(b,2));
end
