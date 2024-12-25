with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Reel; use Reel;
   
package Lecture_commande is 
    procedure Lire_Parametres(Nom_Fichier : out Unbounded_String; Nom_Fichier_produit : out Unbounded_String; alpha :in out T_Reel; Nb_Iterations : in out Integer; Epsilon : in out T_Reel; Creuse_Ou_Pleine : in out Character);
    function Fichier_non_conforme (Nom_Fichier: in Unbounded_String) return Boolean; 
    procedure lecture_fichier_non_conforme (Nom_Fichier: in Unbounded_String) ; 
end Lecture_commande;
