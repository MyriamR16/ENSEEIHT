with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Matrices_Pleines;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Reel;use Reel;

procedure Test_Matrices_Pleines is
    package Matrices_Pleines_instancie is new Matrices_Pleines (N => 3);
    use Matrices_Pleines_instancie;

    M1,M2,M3,M4: T_Matrice;
    V1,V2,V3: T_Vecteur;
    Valeur : T_Reel ;

begin
    -- Test de Initialiser
    New_Line;
    Put_Line("Matrice M1 après initialisation :");
    Initialiser(M1, 1.0);
    Afficher_Matrice(M1);
    New_Line;
    Put_Line("Matrice M2 après initialisation :");
    Initialiser(M2, 0.0);
    Afficher_Matrice(M2);
    New_Line;

    --Test Modifier_Elem_Matrice
    for i in 1..3 loop
        Modifier_Elem_Matrice (M2,i,2,1.0);
    end loop;
    Modifier_Elem_Matrice(M2,1,1,1.0);
    Put_Line("Matrice M2 après Modification :");
    Afficher_Matrice(M2);
    New_Line;

    --Test Nb_Elem_Ligne
    New_Line;
    V1 := Nb_Elem_Ligne(M2);
    Put_Line("Le vecteur avec le cardinal de chaque ligne ");
    Afficher_Vecteur(V1);
    New_Line;

    --Test Somme
    New_Line;
    M3 := Somme(M1,M2);
    Put_Line("La somme de M1 + M2 vaut");
    Afficher_Matrice(M3);
    New_Line;

    --Test Modifier_Elem_Vecteur
    New_Line;
    Modifier_Elem_Vecteur (V1, 3, 5.0);
    Put_Line("Voici le vecteur V1 après modification");
    Afficher_Vecteur(V1);
    New_Line;

    --Test Multiplier_Scalaire
    New_Line;
    Multiplier_Scalaire (M1, 3.5);
    Put_Line("Voici la matrice M1 après multiplication par un scalaire");
    Afficher_Matrice(M1);
    New_Line;

    --Test Multiplier_Ligne_Matrice
    Initialiser(M4, 1.0);
    New_Line;
    V2 := Multiplier_Ligne_Matrice (M4 , V1);
    V3 := Multiplier_Ligne_Matrice (M2, V1);
    Put_Line("Voici le vecteur V2 après multiplication de M4 par V1");
    Afficher_Vecteur(V2);
    New_Line;
    Put_Line("Voici le vecteur V2 après multiplication de M2 par V1");
    Afficher_Vecteur(V3);
    New_Line;

    --Test Difference_Vecteurs
    New_Line;
    V2 := Difference_Vecteurs (V2,V3);
    Put_Line("Voici le vecteur V2 après soustraction de V2 par V3");
    Afficher_Vecteur(V2);
    New_Line;

    --Test function Norme_Vecteur
    New_Line ;
    Valeur := Norme_Vecteur (V2);
    Put_Line("Voici la norme du vecteur V2");
    Afficher_Reel(Valeur);
    New_Line;

    --Test Acceder_elem_matrice
    New_Line;
    Valeur := Acceder_elem_matrice (M3,1,2);
    Put_Line("Voici la valeur de M3(1,2)");
    Afficher_Reel(Valeur);
    New_Line;

    --Test Acceder_elem_matrice
    New_Line;
    Valeur := Acceder_elem_vecteur (V2,3);
    Put_Line("Voici la valeur de V2(3)");
    Afficher_Reel(Valeur);
    New_Line;

    --Fin du test
    Put_Line("OK ! ");
end Test_Matrices_Pleines;
