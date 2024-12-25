%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP1 - Orthogonalisation de Gram-Schmidt
% cgs.m
%--------------------------------------------------------------------------

function Q = cgs(A)

    % Recuperation du nombre de colonnes de A
    [~, m] = size(A);
    
    % Initialisation de la matrice Q avec la matrice A
    Q = A;
    
    %------------------------------------------------
    % Algorithme de Gram-Schmidt classique
    Q(:,1) = Q(:,1)/norm(Q(:,1))
    for j=2:m
        y = A(:,j)
        for k=1:j-1
            y = y - Q(:,k)'*A(:,j)*Q(:,k) 
        end
        Q(:,j) = y / norm(y)
    end  
    %------------------------------------------------

end