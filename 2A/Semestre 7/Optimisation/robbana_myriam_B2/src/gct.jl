using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s, sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe

    s = gct(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Matrix{<:Real}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • max_iter : le nombre maximal d'iterations (optionnel, par défaut 100)
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel  : la tolérence relative (optionnel, par défaut 1e-8)

# Sorties

    - s : (Vector{<:Real}) une approximation de la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = gct(g, H, Δ)

"""
function gct(g::Vector{<:Real}, H::Matrix{<:Real}, Δ::Real; 
    max_iter::Integer = 100, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8)

    s = zeros(length(g))
    j = 0 
    g0 = g 
    p = -g
    gj = g0

    while (j<=max_iter) && (norm(gj)>max(norm(g0)*tol_rel, tol_abs))
        kj = transpose(p)*H*p
        if kj<=0 
            delta = 4*(dot(s,p) ^ 2) - 4*(norm(p) ^ 2)*(norm(s) ^ 2 - Δ ^ 2)
            a = norm(p) ^ 2
            b = 2*dot(s,p)
            
            sigma1 = (-b - delta ^ (0.5) )/(2*a)
            sigma2 = (-b + delta ^ (0.5)) /(2*a)

            q1 = transpose(g)*(s+(sigma1*p)) + 0.5*transpose(s+(sigma1*p))*H*(s+(sigma1*p))
            q2 = transpose(g)*(s+(sigma2*p)) + 0.5*transpose(s+(sigma2*p))*H*(s+(sigma2*p))
            
            if q1 <= q2 
                sigma = sigma1
            else 
                sigma = sigma2
            end

            return s+sigma*p
        end 

        alpha = transpose(gj)*gj/kj
        
        if norm(s + alpha*p) >= Δ 
            delta = 4*(dot(s,p) ^ 2) - 4*((norm(p)) ^ 2)*(((norm(s)) ^ 2) - (Δ ^ 2))
            a = norm(p) ^ 2
            b = 2*dot(s,p)
            
            sigma = (-b + delta ^ (0.5))/(2*a)

            return s+sigma*p
        end 

        s = s + alpha*p
        gjbis= gj + alpha*H*p
        beta = (transpose(gjbis)*gjbis)/(transpose(gj)*gj)
        gj = gjbis 
        p = - gj + beta*p 
        j= j +1 
    end 
    return s
end
