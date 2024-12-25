with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;

--Importation des différents modules crées

with manipulation_fichiers; use Manipulation_fichiers;
with Lecture_commande; use Lecture_commande;
with Page_Rank_Matrices_Pleines; use Page_Rank_Matrices_Pleines;
with Page_Rank_Matrices_creuses; use Page_Rank_Matrices_creuses;
with Reel; use Reel;

procedure Page_Rank is

    --Definir les valeurs par defaut de certains parametres
    alpha          : T_Reel     := 0.85;
    epsilon        : T_Reel     := 0.0 ;
    Nb_iterations  : Integer   := 150 ;
    Genre_matrice  : Character := 'C' ;
    Nb_Noeuds : Integer;
    Nom_Fichier : Unbounded_String ;
    Nom_Fichiers_Produits : Unbounded_String := To_Unbounded_String("Resultats");

begin

    --Lire les paramètres de la ligne de commande

    Lire_Parametres(Nom_Fichier, Nom_Fichiers_Produits, alpha, Nb_Iterations, epsilon, Genre_matrice);


    Nombre_Noeuds (Nom_Fichier, Nb_Noeuds);

    if Genre_matrice = 'P' then
        Page_Rank_pleine(Nom_Fichier, Nom_Fichiers_Produits, alpha, Nb_Iterations, Epsilon, Nb_Noeuds);
    else
        Page_Rank_creuse(Nom_Fichier, Nom_Fichiers_Produits, alpha, Nb_Iterations, Epsilon, Nb_Noeuds);
    end if ;

end Page_Rank;
