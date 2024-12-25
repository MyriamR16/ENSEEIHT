with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Matrices_Creuses;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with reel; use reel;


procedure test_matrices_creuses_vecteur_poids is
   package Matrices_Creuses_instancie is new Matrices_Creuses (N => 6);  
   use Matrices_Creuses_instancie;
   
   E,H,M: T_Matrice;
    L,P: T_Vecteur ; 
    P_prime : T_Vecteur;
   alpha : T_Reel := 0.85; 
   epsilon : T_Reel := 0.0 ;

begin
   New_Line;  
   Initialiser(E,1.0); 
   Put("Voici la matrice E ou eeT"); 
   New_Line; 
   Afficher_Matrice(E);
   New_Line; 
   
   New_Line;  
   Initialiser(H,0.0);

   Modifier_Elem_Matrice(H,1,2,1.0);
   Modifier_Elem_Matrice(H,1,3,1.0);
   Modifier_Elem_Matrice(H,3,1,1.0);
   Modifier_Elem_Matrice(H,3,2,1.0);
   Modifier_Elem_Matrice(H,3,5,1.0);
   Modifier_Elem_Matrice(H,4,5,1.0);
   Modifier_Elem_Matrice(H,4,6,1.0);
   Modifier_Elem_Matrice(H,5,4,1.0);
   Modifier_Elem_Matrice(H,5,6,1.0);
   Modifier_Elem_Matrice(H,6,4,1.0);
   diviser_H_card_ligne(H);
   Put("Voici la matrice H "); 
   New_Line;
   Afficher_Matrice(H); 
   New_Line;
   
   --On initialiser L à PI0
   New_Line; 
   Modifier_Elem_Vecteur(L,1,0.166); 
   Modifier_Elem_Vecteur(L,2,0.166); 
   Modifier_Elem_Vecteur(L,3,0.166); 
   Modifier_Elem_Vecteur(L,4,0.166); 
   Modifier_Elem_Vecteur(L,5,0.166); 
   Modifier_Elem_Vecteur(L,6,0.166); 
   Put("Voici le vecteur pi0");
   New_Line;
   Afficher_Vecteur(L); 
   New_Line;
   P := calcul_vecteur_poids(H, alpha, E , L); 
   New_Line;  
   Put("Voici le résultat de la première itération du vecteur poids pi");
   New_Line;
   Afficher_Vecteur(P); 
   New_Line;
   New_Line;  
    
    
   Put("Test etudier les limites de nos iterations");
   New_Line;  
    for i in 1..2 loop
        P_prime := P;
        Detruire(P);
        P := calcul_vecteur_poids(H, alpha, E , P_prime);
        Detruire(P_prime);
        Afficher_Vecteur(P);
    end loop;
   
end test_matrices_creuses_vecteur_poids;
