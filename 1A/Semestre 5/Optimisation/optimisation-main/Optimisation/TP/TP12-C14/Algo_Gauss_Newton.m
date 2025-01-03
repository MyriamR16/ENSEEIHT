function [beta, norm_grad_f_beta, f_beta, norm_delta, nb_it, exitflag] ...
          = Algo_Gauss_Newton(residu, J_residu, beta0, option)
%*****************************************************************
% Fichier  ~gergaud/ENS/Optim1a/TP-optim-20-21/TP-ref/GN_ref.m   *
% Novembre 2020                                                  *
% Université de Toulouse, INP-ENSEEIHT                           *
%*****************************************************************
%
% GN resout par l'algorithme de Gauss-Newton les problemes aux moindres carres
% Min 0.5||r(beta)||^2
% beta \in \IR^p
%
% Paramètres en entrés
% --------------------
% residu : fonction qui code les résidus
%          r : \IR^p --> \IR^n
% J_residu : fonction qui code la matrice jacobienne
%            Jr : \IR^p --> real(n,p)
% beta0 : point de départ
%         real(p)
% option(1) : Tol_abs, tolérance absolue
%             real
% option(2) : Tol_rel, tolérance relative
%             real
% option(3) : n_itmax, nombre d'itérations maximum
%             integer
%
% Paramètres en sortie
% --------------------
% beta      : beta
%             real(p)
% norm_gradf_beta : ||gradient f(beta)||
%                   real
% f_beta : f(beta)
%          real
% r_beta : r(beta)
%          real(n)
% norm_delta : ||delta||
%              real
% nbit : nombre d'itérations
%        integer
% exitflag   : indicateur de sortie
%              integer entre 1 et 4
% exitflag = 1 : ||gradient f(beta)|| < max(Tol_rel||gradient f(beta0)||,Tol_abs)
% exitflag = 2 : |f(beta^{k+1})-f(beta^k)| < max(Tol_rel|f(beta^k)|,Tol_abs)
% exitflag = 3 : ||delta)|| < max(Tol_rel delta^k),Tol_abs)
% exitflag = 4 : nombre maximum d'itérations atteint
%      
% ---------------------------------------------------------------------------------

% TO DO %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    Tol_abs = option(1);
    Tol_rel = option(2);
    n_itmax = option(3);

    beta = beta0; 
    grad_f_beta0 = J_residu(beta0)' * residu(beta0);
    r_beta =residu(beta);
    Jr =J_residu(beta);
    nb_it = 0;

    for nb_it = 1:n_itmax
      if nb_it ~= n_itmax
        a = (Jr' * Jr);
        b = (Jr' * r_beta);
        delta = - a\b;

        f_beta_k = 0.5 *r_beta'*r_beta;

        beta = beta +delta;
        nb_it =nb_it+1;
        grad_f_beta = Jr' * r_beta ; 
        f_beta = 0.5 * r_beta' *r_beta;
        norm_grad_f_beta =norm(grad_f_beta);
        norm_delta =norm(delta);
        if norm(grad_f_beta)<max(Tol_rel*(norm(grad_f_beta0)) , Tol_abs)
            exitflag = 1 ; 
        elseif norm(f_beta - f_beta_k)<max(Tol_rel * norm(f_beta_k), Tol_abs)
            exitflag = 2; 
        elseif norm(delta)<max(Tol_rel * delta, Tol_abs)
            exitflag = 3;  
        end

      else
          exitflag =4;
      end
    end 
end
