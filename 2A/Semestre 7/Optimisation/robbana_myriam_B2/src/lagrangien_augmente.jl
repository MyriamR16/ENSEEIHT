using LinearAlgebra
include("../src/newton.jl")
include("../src/regions_de_confiance.jl")
"""

Approximation d'une solution au problème 

    min f(x), x ∈ Rⁿ, sous la c c(x) = 0,

par l'algorithme du lagrangien augmenté.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, μs, λs = lagrangien_augmente(f, gradf, hessf, c, gradc, hessc, x0; kwargs...)

# Entrées

    - f      : (Function) la ftion à minimiser
    - gradf  : (Function) le gradient de f
    - hessf  : (Function) la hessienne de f
    - c      : (Function) la c à valeur dans R
    - gradc  : (Function) le gradient de c
    - hessc  : (Function) la hessienne de c
    - x0     : (Vector{<:Real}) itéré initial
    - kwargs : les options sous formes d'arguments "keywords"
        • max_iter  : (Integer) le nombre maximal d'iterations (optionnel, par défaut 1000)
        • tol_abs   : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel   : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • λ0        : (Real) le multiplicateur de lagrange associé à c initial (optionnel, par défaut 2)
        • μ0        : (Real) le facteur initial de pénalité de la c (optionnel, par défaut 10)
        • τ         : (Real) le facteur d'accroissement de μ (optionnel, par défaut 2)
        • algo_noc  : (String) l'algorithme sans c à utiliser (optionnel, par défaut "rc-gct")
            * "newton"    : pour l'algorithme de Newton
            * "rc-cauchy" : pour les régions de confiance avec pas de Cauchy
            * "rc-gct"    : pour les régions de confiance avec gradient conjugué tronqué

# Sorties

    - x_sol    : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol    : (Real) f(x_sol)
    - flag     : (Integer) indique le critère sur lequel le programme s'est arrêté
        • 0 : convergence
        • 1 : nombre maximal d'itération dépassé
    - nb_iters : (Integer) le nombre d'itérations faites par le programme
    - μs       : (Vector{<:Real}) tableau des valeurs prises par μk au cours de l'exécution
    - λs       : (Vector{<:Real}) tableau des valeurs prises par λk au cours de l'exécution

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    gradf(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    hessf(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    c(x) =  x[1]^2 + x[2]^2 - 1.5
    gradc(x) = 2*x
    hessc(x) = [2 0; 0 2]
    x0 = [1; 0]
    x_sol, _ = lagrangien_augmente(f, gradf, hessf, c, gradc, hessc, x0, algo_noc="rc-gct")

"""
function lagrangien_augmente(f::Function, gradf::Function, hessf::Function, 
        c::Function, gradc::Function, hessc::Function, x0::Vector{<:Real}; 
        max_iter::Integer=100, tol_abs::Real=1e-10, tol_rel::Real=1e-8,
        λ0::Real=2, μ0::Real=10, τ::Real=2, algo_noc::String="rc-gct")

    
    x_sol = x0
    f_sol = f(x_sol)
    flag  = -1
    nb_iters = 0
    μs = [μ0] # vous pouvez faire μs = vcat(μs, μk) pour concaténer les valeurs
    λs = [λ0]

    k=0
    beta = 0.9
    n = 0.1258925
    alpha = 0.1
    epsilon0 = 1/μ0
    epsilonk = epsilon0

    no = n/(μ0 ^ alpha)
    NonArret = true

    x_k = x_sol
    λ_k = λ0
    μ_k = μ0

    while NonArret 

        LA(x) = f(x) + λ_k*c(x) + μ_k*(norm(c(x)) ^ 2)/2
        ∇LA(x) = gradf(x) + λ_k*gradc(x) + μ_k*c(x)*gradc(x)
        ∇2LA(x) = hessf(x) + λ_k*hessc(x) + μ_k*(gradc(x)*transpose(gradc(x)) + c(x)*hessc(x))


        if (algo_noc == "rc-gct")
            x_k, ~ = regions_de_confiance(LA, ∇LA , ∇2LA, x_k ; tol_abs = epsilonk, tol_rel=0, epsilon = 0)
        elseif (algo_noc == "rc-cauchy")
            x_k, ~ = regions_de_confiance(LA, ∇LA , ∇2LA, x_k ; tol_abs = epsilonk, tol_rel=0 , epsilon = 0, algo_pas = "cauchy")
        elseif (algo_noc == "newton")
            x_k, ~ = newton(LA, ∇LA , ∇2LA, x_k ; tol_abs=epsilonk , tol_rel=0,epsilon = 0 )
        end 


        ∇L(x) = gradf(x) + λ_k*gradc(x)

        if norm(c(x_k))<=no
            λ_k = λ_k + μ_k*c(x_k)
            μ_k = μ_k
            epsilonk = epsilonk/μ_k
            no = no/(μ_k ^ beta)
        else
            λ_k = λ_k
            μ_k = τ * μ_k
            epsilonk = epsilon0/μ_k
            no = n/(μ_k ^ alpha)

        end

        # ∇L(x) = gradf(x) + λ_k*gradc(x)
        # println(norm(∇L(x_k)))

        if ((norm(∇L(x_k))) <= max(tol_rel * norm(∇L(x0)) , tol_abs)) && ((norm(c(x_k))) <= max(tol_rel * norm(c(x0)) , tol_abs))
            flag = 0 
            NonArret = false
        end 

        nb_iters = nb_iters+1 

        if (nb_iters == max_iter) 
            flag = 3
            NonArret = false
                
        end 

        println("La valeur de μ_k est $μ_k")
        println("La valeur de λ_k est $λ_k")

        μs = vcat(μs, μ_k)
        λs = vcat(λs, λ_k)

    end
    x_sol = x_k
    f_sol = f(x_sol)


    return x_sol, f_sol, flag, nb_iters, μs, λs

end
