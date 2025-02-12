# Ecrire les tests de l'algorithme du pas de Cauchy
using Test

function tester_cauchy(cauchy::Function)

    # Tolérance utilisé dans les tests
    tol_test = 1e-3
    atol = 1e-6
	Test.@testset "Pas de Cauchy" begin

    # le cas de test 1: g=0 => s=0 (dans Rn)
    g = [0 ; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = cauchy(g,H,Δ)
    Test.@test s ≈ [0.0; 0.0] atol = tol_test

    # le cas de test 2 : a<0 => s=-t*g avec t*= Δ/norm(g)
    g = [1,2]
    tol_abs = 1e-10
    H = [-1 0 ; 0 -1]  # a = gTHg
    Δ = 1.   
    s = cauchy(g,H,Δ)
    Test.@test  s ≈ -Δ*g/norm(g) atol = tol_test

    # le cas de test 3 : a=0 => s=-t*g avec t*= Δ/norm(g)
    g = [1,2]
    H = [0 0 ; 0 0]  # a = gTHg
    Δ = 1.   
    s = cauchy(g,H,Δ)
    Test.@test  s ≈ -(Δ/norm(g))*g atol = tol_test

    # le cas de test 4 : a>0 et (norm(g)²/a) <Δ/norm(g) => s=-(norm(g)²/a) * g 
    g = [3,4]
    H = [10 0; 0 10] # a = gTHg
    Δ = 1.   
    s = cauchy(g,H,Δ)
    a =  g' * H * g
    Test.@test  s ≈ -(norm(g) ^ 2 / a)*g atol = tol_test

    # le cas de test 5 : a>0 et (norm(g)²/a)>Δ/norm(g) => s=-t*g avec t*= Δ/norm(g)
    g = [3,4]
    H = [1 0 ; 0 1]  # a = gTHg
    Δ = 0.5
    s = cauchy(g,H,Δ)
    Test.@test  s ≈ -Δ * g / norm(g) atol = tol_test

    end
end