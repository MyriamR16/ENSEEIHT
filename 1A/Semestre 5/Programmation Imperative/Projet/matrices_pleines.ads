with Reel;use Reel;

generic
    
    N : Integer;

package Matrices_Pleines is

    type T_Matrice is private;
    type T_Vecteur is private;
    
    procedure Initialiser (M : in out T_Matrice ; Scalaire : in T_Reel); 
    function Nb_Elem_Ligne (M: in T_Matrice) return T_Vecteur; 
    function Somme (M : in T_Matrice; N: in T_Matrice) return T_Matrice; 
    procedure Multiplier_Scalaire (M:in out T_Matrice; Scalaire : in T_Reel); 
    function Multiplier_Ligne_Matrice (M : in T_Matrice; L:in T_Vecteur) return T_Vecteur; 
    function Capacite (M : in T_Matrice) return Integer with 
            post => Capacite'Result > 0 ;
    procedure Modifier_Elem_Matrice (M:in out T_Matrice; I : in Integer; J : in Integer; Valeur : T_Reel) ; 
    procedure Modifier_Elem_Vecteur (V:in out T_Vecteur; I : in Integer; Valeur : T_Reel); 

    function Difference_Vecteurs (vecteur_1 : in T_Vecteur ; vecteur_2 : in T_Vecteur) return T_Vecteur ; 
    function Norme_Vecteur (V : in T_Vecteur) return T_Reel ;  
    function Acceder_elem_matrice (M : in T_Matrice; I : in Integer; J : in Integer) return T_Reel ;  
    function Acceder_elem_vecteur (V : in T_Vecteur; I : in Integer) return T_Reel ;  
    procedure Afficher_Vecteur (V : in T_Vecteur) ;
    procedure Afficher_Matrice (M : in T_Matrice) ;


private
    type T_Matrice is array (1..N, 1..N) of T_Reel;
    type T_Vecteur is array (1..N) of T_Reel;
end Matrices_Pleines;
