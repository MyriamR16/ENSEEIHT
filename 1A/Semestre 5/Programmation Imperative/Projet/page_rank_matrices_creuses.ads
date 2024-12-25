with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Matrices_Creuses;
with Reel; use Reel;


package Page_Rank_Matrices_creuses is
    procedure Page_Rank_creuse(Nom_Fichier : in Unbounded_String; Nom_Fichiers_Produits : in Unbounded_String; alpha :in T_Reel; Nb_Iterations : in Integer; Epsilon : in T_Reel; Nb_Noeuds :in Integer);
end Page_Rank_Matrices_creuses;
