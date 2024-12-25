with Ada.IO_Exceptions;
with Ada.Text_IO;			use Ada.Text_IO;
with Ada.Float_Text_IO;		use Ada.Float_Text_IO;
with Ada.Integer_Text_IO;	use Ada.Integer_Text_IO;

with manipulation_fichiers; use Manipulation_fichiers;
with Matrices_Pleines;
with Reel; use Reel;

package body Page_Rank_Matrices_Pleines is

    procedure Page_Rank_pleine(Nom_Fichier : in Unbounded_String; Nom_Fichiers_Produits : in Unbounded_String; alpha :in T_Reel; Nb_Iterations : in Integer; Epsilon : in T_Reel; Nb_Noeuds :in Integer) is

        package Matrices_Pleines_Instanciee is new Matrices_Pleines (N => Nb_Noeuds);
        use Matrices_Pleines_Instanciee;

        --Variables utilisees tout au long du programme
        k              : Integer;
        Indice_max     : Integer;
        Valeur_Gauche : Integer;
        Valeur_Droite : Integer;
        j             : Integer;

        Norme_Difference: T_Reel;
        provisoire     : T_Reel ;
        --Alpha_bis : T_Reel := alpha ;

        H              : T_Matrice;
        S              : T_Matrice;
        G              : T_Matrice;
        E              : T_Matrice;

        Liste_card     : T_Vecteur;
        V_pi           : T_Vecteur;
        V_pi_0         : T_Vecteur;
        Vecteur_Difference: T_Vecteur;
        Vecteur        : T_Vecteur;
        Noeuds_tri : array (1..Nb_Noeuds) of Integer;

        Fichier_prw    : Unbounded_String := Nom_Fichiers_Produits;
        Fichier_pr     : Unbounded_String := Nom_Fichiers_Produits;

        File : Ada.Text_IO.File_Type;

    begin
        Initialiser( H, 0.0 );

        Open (File, In_File, To_String(Nom_Fichier));

        -- on parcourt le fichier entièrement pour détecter les hyperliens entre les noeuds
        Get (File, Valeur_Gauche);
        while not End_Of_File (File) loop
            Get (File, Valeur_Gauche);
            Get (File, Valeur_Droite);
            Modifier_Elem_Matrice( H, Valeur_Gauche+1, Valeur_Droite+1, 1.0 );
        end loop;

        Close (File);

        --Calculer la matrice S : qui est H sans cul de sac

        S := H;
        Liste_card := Nb_Elem_Ligne(S);
        for i in 1..Nb_Noeuds loop

            if Acceder_elem_vecteur(Liste_card,i) = 0.0 then
                --Remplacer les éléments de la ième ligne par 1/N
                for j in 1..Nb_Noeuds loop
                    Modifier_Elem_Matrice(S, i, j, 1.0/T_Reel(Nb_Noeuds));
                end loop;

            else
                --Diviser les éléments de la ième ligne par Liste_card(i)
                for j in 1..Nb_Noeuds loop
                    Modifier_Elem_Matrice( S, i, j, Acceder_elem_matrice(S,i,j)/Acceder_elem_vecteur(Liste_card,i) );
                end loop;

            end if;
        end loop;

        Initialiser (E,1.0);

        --Calculer la matrice de google G
        Multiplier_Scalaire(S,alpha);
        Multiplier_Scalaire(E,T_Reel(1.0-alpha) / T_Reel(Nb_Noeuds));
        G := Somme(S, E);

        k := 0 ;
        --Initialiser les vecteur V_pi et V_pi_0
        for i in 1..Nb_Noeuds loop
            Modifier_Elem_Vecteur( V_pi, i, 1.0/T_Reel(Nb_Noeuds));
            Modifier_Elem_Vecteur( V_pi_0, i, 1.0/T_Reel(Nb_Noeuds));
        end loop;

        loop

            --Calculer le nouveau vecteur poids V_pi
            V_pi_0 := V_pi;
            V_pi := Multiplier_Ligne_Matrice( G, V_pi );

            --Calculer la norme du vecteur résultant de la différence entre V_pi et V_pi_0
            Vecteur_Difference := Difference_Vecteurs( V_pi , V_pi_0 );
            Norme_Difference := Norme_Vecteur( Vecteur_Difference );
            k := k+1;
            exit when ( k >= Nb_iterations  or ( float(Norme_Difference) <= float(epsilon) and k /= 0 ) );
        end loop;

        -- Trier par ordre décroissant le vecteur poids des noeuds et leurs noeuds correspondants
        Vecteur := V_pi;

        for i in 1..Nb_Noeuds loop
            Noeuds_tri(i) := 0;
        end loop;


        for i in 1..(Nb_Noeuds-1) loop

            --Trouver l'indice du maximum
            Indice_max := i;
            for j in (i+1)..Nb_Noeuds loop
                if Acceder_elem_vecteur(Vecteur,j) > Acceder_elem_vecteur(Vecteur,Indice_max) then
                   Indice_max := j;
                end if;
            end loop;

            if Indice_max /= i then
                --Permuter les elements d'indices respectifs i et Indice_max
                provisoire := Acceder_elem_vecteur(Vecteur, Indice_max );
                Modifier_Elem_Vecteur( Vecteur, Indice_max, Acceder_elem_vecteur(Vecteur,i) );
                Modifier_Elem_Vecteur( Vecteur, i, provisoire );
            end if;
        end loop;


        for i in 1..Nb_Noeuds loop
            provisoire := Acceder_elem_vecteur(Vecteur, i);
            j := 1;
            while Acceder_elem_vecteur(V_pi, j) /= provisoire loop
                j := j + 1;
            end loop;
            Noeuds_tri(i) := j-1;
        end loop;



        -- Creer un fichier poids contenant le resultat du tri
        Creer_Fichier(Fichier_prw, To_Unbounded_String(".prw") );
        --Append(Fichier_prw, ".prw" );
        Create (File, Out_File, To_String (Fichier_prw));

        --Remplir le fichier poids contenant le resultat du tri

        Put ( File, Nb_Noeuds );
        Put ( File, ' ' );
        Ecrire_Reel_Fichier(File, alpha);
        Put ( File, ' ' );
        Put ( File, Nb_iterations );
        New_Line ( File );

        for i in 1..Nb_Noeuds loop
            Ecrire_Reel_Fichier(File, Acceder_elem_vecteur(Vecteur,i));
            New_Line( File );
        end loop;

        Close( File );

        -- Creer un fichier PageRank contenant le resultat du tri
        Creer_Fichier(Fichier_pr, To_Unbounded_String(".pr"));

        --Append(Fichier_pr, ".pr" );
        Create( File, Out_File, To_String(Fichier_pr) );



        -- remplir le fichier PageRank contenant le resultat du tri

        for i in 1..Nb_Noeuds loop
            --Put( File, Acceder_elem_vecteur(Noeuds_tri, i) );
            Put(File,Noeuds_tri(i));
            New_Line( File );
        end loop;
        Close( File );
    end Page_Rank_pleine;
end Page_Rank_Matrices_Pleines;
