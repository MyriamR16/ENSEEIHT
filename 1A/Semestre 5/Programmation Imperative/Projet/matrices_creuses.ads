with Reel; use Reel;

generic

   N : Integer;

package Matrices_Creuses is
   type T_Vecteur is  private;
   type T_Matrice is  private ;
   type T_Vecteur_bis is  private ;

   procedure Detruire (V: in out T_Vecteur);
   procedure Initialiser (M : in out T_Matrice ; Scalaire : in T_Reel);
   function Nb_Elem_Ligne (M: in T_Matrice) return T_Vecteur_bis;
   procedure Somme_vecteur (V1 : in out T_Vecteur ; V2 : in T_Vecteur);
   function Produit_Scalaire (V1, V2: in T_Vecteur) return T_Reel ;
   procedure Multiplier_Vecteur_Par_Scalaire (V: in out T_Vecteur; Scalaire : in T_Reel);
   procedure Multiplier_Matrice_Par_Scalaire (M:in out T_Matrice; Scalaire : in T_Reel);
   function calcul_vecteur_poids(H : in T_Matrice; alpha : in T_Reel ; E : in T_Matrice ; L:in T_Vecteur) return T_Vecteur;
   procedure diviser_H_card_ligne(H : in out T_Matrice);
   procedure Modifier_Elem_Matrice (M:in out T_Matrice; I : in Integer; J : in Integer; Valeur : T_Reel) ;
   procedure Modifier_Elem_Vecteur (V:in out T_Vecteur; I : in Integer; Valeur : T_Reel);
   function Difference_Vecteurs (vecteur_1 : in T_Vecteur ; vecteur_2 : in T_Vecteur) return T_Vecteur ;
   function Norme_Vecteur (V : in T_Vecteur) return T_Reel ;
   function Acceder_elem_vecteur (V : in T_Vecteur; I : in Integer) return T_Reel ;
   function Acceder_elem_vecteur_bis (V : in T_Vecteur_bis; I : in Integer) return Integer;
   function Acceder_elem_matrice (M : in T_Matrice; I : in Integer; J : in Integer) return T_Reel ;
   procedure Afficher_Vecteur (V : in T_Vecteur) ;
   procedure Afficher_Vecteur_bis (U : in T_Vecteur_bis);
   procedure Afficher_Matrice (M : in T_Matrice) ;


private
   --T_Vecteur_bis
   type T_Vecteur_bis is array (1..N) of Integer ;
   --T_Vecteur

   type T_Cellule_Vecteur;

   type T_Vecteur is access T_Cellule_Vecteur;

   type T_Cellule_Vecteur is
      record
         Valeur : T_Reel;
         Indice_elem : Integer;
         Suivant_elem : T_Vecteur;
      end record;


   --T_Matrice

   type T_Cellule_Matrice;

   type T_Matrice is access T_Cellule_Matrice;

   type T_Cellule_Matrice is
      record
         Colonne : T_Vecteur;
         Indice_Colonne : Integer;
         Suivant_Colonne : T_Matrice;
      end record;

end Matrices_Creuses;
