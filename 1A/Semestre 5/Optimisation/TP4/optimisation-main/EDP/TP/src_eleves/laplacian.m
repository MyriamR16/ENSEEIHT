function L = laplacian(nu,dx1,dx2,N1,N2)
%
%  Cette fonction construit la matrice de l'opérateur Laplacien 2D anisotrope
%
%  Inputs
%  ------
%
%  nu : nu=[nu1;nu2], coefficients de diffusivité dans les dierctions x1 et x2. 
%
%  dx1 : pas d'espace dans la direction x1.
%
%  dx2 : pas d'espace dans la direction x2.
%
%  N1 : nombre de points de grille dans la direction x1.
%
%  N2 : nombre de points de grilles dans la direction x2.
%
%  Outputs:
%  -------
%
%  L      : Matrice de l'opérateur Laplacien (dimension N1N2 x N1N2)
%
% 

% Initialisation
alpha = (2*nu[1]/(dx1 * dx1)) + (2*nu[2]/(dx2 * dx2));
beta = -nu[2]/(dx2 * dx2);
gamma = -nu[1]/(dx1 * dx1); 
e = ones(N2,1);

b_beta = beta* e ; 
b_alpha = alpha *e; 
b_gamma = gamma *e ; 

A = spdiags ([beta*e alpha*e beta*e],-1:1,N2,N2);
B = spdiag ([gamma*e],0,N2,N2);

L = spediag([b_gamma b_beta b_alpha b_beta], -N2 )

L=sparse();


end    
