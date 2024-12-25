with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Matrices_Creuses;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with reel; use reel;

procedure test_matrice_creuse is
   package Matrices_Creuses_instancie is new Matrices_Creuses (N => 3);  
   use Matrices_Creuses_instancie;
   
   M1,M2,M3,M4,E,H: T_Matrice;
   V1,V2,V3,V4: T_Vecteur ; 
   Valeur, a : T_Reel ; 
   alpha : T_Reel := 0.85; 
   epsilon : T_Reel := 0.0 ;
   
begin
   
   --Initialiser 
   New_Line;
   Put("Test de Initialiser");
   New_Line;
   Put_Line("Voici la matrice M1 apres initialisation par des 0.0:");
   Initialiser(M1, 0.0);
   Afficher_Matrice(M1);
   New_Line;
   Put_Line("Voici la Matrice M2 apres initialisation par des 1.0 :");
   Initialiser(M2, 1.0);
   Afficher_Matrice(M2);
   New_Line;
   
   --Modifier_Eleme_Matrice
   New_Line;
   Initialiser(M3, 2.0);
   Put("Voici M3 apres initialisation par des 2 :");
   Afficher_Matrice(M3);
   New_Line;
   
   New_Line;
   Modifier_Elem_Matrice(M3, 1, 2, 5.0);
   Modifier_Elem_Matrice(M3, 2, 2, 9.0);
   Modifier_Elem_Matrice(M3,1,1,8.0);
   Put("Voici M3 apres diverses modifications :");
   Afficher_Matrice(M3);  
   
   --Put("Un message d'exception devrait s'afficher");
   --Modifier_Elem_Matrice(M3, 5, 6, 3.0);
   --Afficher_Matrice(M3);
   New_Line; 
   
   --Test Modifier_Elem_Vecteur 
   New_Line;
   Put("Test Modifier_Elem_Vecteur");
   New_Line;
   Modifier_Elem_Vecteur (V1, 1, 1.0);  
   Modifier_Elem_Vecteur (V1, 2, 2.0);     
   Modifier_Elem_Vecteur (V1, 3, 8.0); 
   Put("Voici V1 apres ajout de differents elements : ");
  
   New_Line;
   Afficher_Vecteur(V1);
   New_Line; 
   Modifier_Elem_Vecteur(V1, 2, 20.0);
   Put("Voici V1 apres modification du deuxieme element par 20.0 : ");
   New_Line; 
   Afficher_Vecteur(V1);
   New_Line;    
   Modifier_Elem_Vecteur(V1,1,0.0);
   Put("Voici V1 apres avoir modifier l'element 1 par 0 : ");   
   New_Line; 
   Afficher_Vecteur(V1);
   New_Line; 
   
   --Test_Somme_vecteur
   New_Line;
   Modifier_Elem_Vecteur (V2, 2, 1.0);    
   Modifier_Elem_Vecteur (V2, 3, 2.0); 
   Put("Voici V2");
   New_Line;
   Afficher_Vecteur(V2);   
   New_Line; 
   Put("Voici V1 + V2 : ");
   New_Line;
   Somme_vecteur(V1, V2);
   Afficher_Vecteur(V1);
   New_Line;
   
   Modifier_Elem_Vecteur(V3, 1,1.0);
   Somme_vecteur(V1,V3); 
   Put("Voici V1 + V3:");
   New_Line;
   Afficher_Vecteur(V1); 
   New_Line;
  
   --Multiplication matrice_scalaire 
   New_Line;
   Put("Voici M2");
   New_Line;
   Afficher_Matrice(M2); 
   New_Line; 
   New_Line;
   Put("Voici M2 multipliée par -1");
   New_Line; 
   Multiplier_Matrice_Par_Scalaire(M2,-1.0);
   Afficher_Matrice(M2); 
   New_Line;
   
   --Multiplication vecteur_scalaire 
   New_Line;  
   Put("Voici V1");
   New_Line; 
   Afficher_Vecteur(V1); 
   New_Line; 
   Put("Voici V1 multiplié par -1");
   New_Line; 
   Multiplier_Vecteur_Par_Scalaire(V1,-1.0);
   Afficher_Vecteur(V1); 
   New_Line;
   Multiplier_Vecteur_Par_Scalaire(V1,-1.0);
   
   -- Difference_vecteurs 
   New_Line;
   Put("Voici V1"); 
   New_Line;
   Afficher_Vecteur(V1); 
   New_Line; 
   Put("Voci V2");
   New_Line;
   Afficher_Vecteur(V2); 
   V4 := Difference_Vecteurs(V1,V2); 
   New_Line;
   Put("Voici V1 - V2 : ");
   New_Line;
   Afficher_Vecteur(V4);
   New_Line;

   --Produit_scalaire 
   New_Line; 
   Put("Voici V1");
   New_Line;
   Afficher_Vecteur(V1); 
   New_Line; 
   Put("Voici V2");
   New_Line;
   Afficher_Vecteur(V2); 
   New_Line;
   
   Valeur := Produit_Scalaire(V1,V2); 
   New_Line; 
   Put("Le produit scalaire entre V1 et V2 donne :"); 
   Afficher_Reel(Valeur);
   New_Line; 
   
   --Norme_Vecteurs 
   New_Line; 
   Put("Voici V2");
   New_Line;
   Afficher_Vecteur(V2); 
   New_Line;
   Valeur := T_Reel(Norme_Vecteur(V2));
   Put("Voici la norme de V2 : ");
   New_Line; 
   Afficher_Reel(Valeur);
   New_Line;
    
   --Test Acceder_Elem_Vecteur
   New_Line;
   Put("Voici V1");
   New_Line;
   Afficher_Vecteur(V1);
   New_Line;
   a := Acceder_elem_vecteur(V1,1);
   Put("Le premier element de V1 est");
   Afficher_Reel(a); 
   New_Line; 
   
   -- Test Acceder_elem_matrice
   New_Line; 
   Put("Matrice M1 :");
   New_line;
   Modifier_Elem_Matrice(M1,1,1,18.0);
   Afficher_Matrice(M1);
   New_Line;
   Put("Voici l'Element (2,3) de M1");
   Valeur := Acceder_elem_matrice(M1,2,3); 
   Afficher_Reel(Valeur); 
   New_Line; 
   Put("Voici l'Element (1,1) de M1 ");
   Valeur := Acceder_elem_matrice(M1,1,1); 
   Afficher_Reel(Valeur); 
   New_Line; 
   
   -- Test Nb_Elem_Ligne
   New_Line; 
   Put("Matrice M1 :");
   New_line;
   Afficher_Matrice(M1);
   New_Line;
   Put("Nombre elements non nuls par ligne de M1 :");
   New_Line; 
   Afficher_Vecteur_bis (Nb_Elem_Ligne(M1));
   New_Line;
   New_Line; 
   Put("Matrice M2 :");
   New_Line;
   Afficher_Matrice(M2);
   New_Line; 
   Put("Nombre elements par ligne de M2 :");
   New_Line;
   Afficher_Vecteur_bis (Nb_Elem_Ligne(M2));
   New_Line;
   Modifier_Elem_Matrice(M2,1,2,0.0);
   New_Line; 
   Put("Voici M2");
   New_Line; 
   Afficher_Matrice(M2);
   New_Line;
   Put("Nombre elements par ligne de M2 :");
   New_Line;
   Afficher_Vecteur_bis(Nb_Elem_Ligne(M2));
   New_Line;
   
    --Fin du test
    Put_Line("OK ! ");
end test_matrice_creuse;
