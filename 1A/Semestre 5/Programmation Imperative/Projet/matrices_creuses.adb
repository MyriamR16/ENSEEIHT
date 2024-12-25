with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Numerics; use Ada.Numerics;
with Ada.Unchecked_Deallocation;
with Reel; use Reel;


package body matrices_creuses is
   Dimensions_non_respectees : Exception ;

   procedure Free is
     new Ada.Unchecked_Deallocation (T_Cellule_Vecteur, T_Vecteur);

   procedure Detruire (V: in out T_Vecteur) is
   begin
      if V /= Null then
         Detruire (V.all.Suivant_elem);
         Free (V);
      else
         Null;
      end if;
   end Detruire;

   procedure Initialiser (M : in out T_Matrice ; Scalaire : in T_Reel) is
      V :  array (1..N) of T_Vecteur ;
   begin
      M := Null;
      if Scalaire /= 0.0 then
         --V := Null;
         for k in 1..N loop
            V(k):=null;
            for i in 1..N loop
               V(k) := new T_Cellule_Vecteur' (Scalaire, N-i+1, V(k));
            end loop;
         end loop;
         for j in 1..N loop
            M := new T_Cellule_Matrice' (V(N-j+1), N-j+1, M);
         end loop;
      end if;
   end Initialiser;

   function Nb_Elem_Ligne (M: in T_Matrice) return T_Vecteur_bis is
      Cardinal : T_Vecteur_bis ;
      Curseur_Matrice : T_Matrice := M ;
      Curseur_Colonne : T_Vecteur ;
   begin
      --On initialise le vecteur cardinal avec des 0
      for I in 1..N loop
         Cardinal(I) := 0 ;
      end loop;
      while Curseur_Matrice /= null loop
         Curseur_Colonne := Curseur_Matrice.all.Colonne ;
         while Curseur_Colonne /= null loop
            Cardinal(Curseur_Colonne.all.Indice_elem) := Cardinal(Curseur_Colonne.all.Indice_elem) + 1 ;
            Curseur_Colonne := Curseur_Colonne.all.Suivant_elem;
         end loop;
         Curseur_Matrice := Curseur_Matrice.all.Suivant_Colonne;
      end loop ;
      return Cardinal;
   end Nb_Elem_Ligne;

   procedure Somme_vecteur (V1 : in out T_Vecteur; V2 : in T_Vecteur) is
      A_Detruire : T_Vecteur;
   begin
      if V2 = null then
            Null;	 -- Rien à faire

      elsif (V1 = Null) or else (V1.all.Indice_elem > V2.all.Indice_elem) then
         V1 := new T_Cellule_Vecteur'(V2.all.Valeur, V2.all.Indice_elem, V1);
         Somme_vecteur(V1.all.Suivant_elem, V2.all.Suivant_elem);

      elsif V1.all.Indice_elem = V2.all.Indice_elem then
         V1.all.Valeur := V1.all.Valeur + V2.all.Valeur;
         if V1.all.Valeur = 0.0 then
            A_Detruire := V1;
            V1 := V1.Suivant_elem;
            Free (A_Detruire);
            Somme_vecteur (V1, V2.all.Suivant_elem);
         else
            Somme_vecteur (V1.all.Suivant_elem, V2.all.Suivant_elem);
         end if;
      else
         Somme_vecteur (V1.all.Suivant_elem, V2);
      end if;
   end Somme_vecteur;

   function Produit_Scalaire (V1 : in T_Vecteur ; V2: in T_Vecteur) return T_Reel is
   begin
      if V1 = Null Or V2 = Null then
         return 0.0;
      elsif V1.all.Indice_elem = V2.all.Indice_elem then
         return V1.all.Valeur * V2.all.Valeur + Produit_Scalaire (V1.all.Suivant_elem, V2.all.Suivant_elem);
      elsif V1.all.Indice_elem < V2.all.Indice_elem then
         return Produit_Scalaire (V1.all.Suivant_elem, V2);
      else
         return Produit_Scalaire (V1, V2.all.Suivant_elem);
      end if;
   end Produit_Scalaire;

    procedure Multiplier_Vecteur_Par_Scalaire (V: in out T_Vecteur; Scalaire : in T_Reel) is
      Curseur_Vecteur : T_Vecteur := V;
   begin
      if Scalaire = 0.0 then
         Curseur_Vecteur:= Null;
      else
         while Curseur_Vecteur /= Null loop
            Modifier_Elem_Vecteur(Curseur_Vecteur, Curseur_Vecteur.all.Indice_elem, Curseur_Vecteur.all.Valeur * Scalaire);
            Curseur_Vecteur := Curseur_Vecteur.all.Suivant_elem;
         end loop;
      end if;
   end Multiplier_Vecteur_Par_Scalaire;

   procedure Multiplier_Matrice_Par_Scalaire (M:in out T_Matrice; Scalaire : in T_Reel) is
      Curseur_Matrice : T_Matrice := M ;
      Curseur_Colonne : T_Vecteur;
   begin
      if Scalaire = 0.0 then
         M := null;
      else
         while Curseur_Matrice /= null loop
            Curseur_Colonne := Curseur_Matrice.all.Colonne;
            while Curseur_Colonne /= null loop
               Curseur_Colonne.all.Valeur := Curseur_Colonne.all.Valeur * Scalaire ;
               Curseur_Colonne:= Curseur_Colonne.all.Suivant_elem;
            end loop;
            Curseur_Matrice := Curseur_Matrice.all.Suivant_Colonne ;
         end loop;
      end if;
   end Multiplier_Matrice_Par_Scalaire ;

   function calcul_vecteur_poids (H : in T_Matrice; alpha : in T_Reel; E : in T_Matrice ; L:in T_Vecteur) return T_Vecteur is
      P : T_Vecteur := null;
      Curseur_H: T_Matrice := H ;
      Curseur_P : T_Vecteur := null ;
      V: T_Vecteur ;
      VE : T_Vecteur ;
      Resultat :T_Reel ;
      Nb_Elem_Par_Ligne_de_H : T_Vecteur_bis ;
      V_S : T_Vecteur := null;
   begin
      VE :=  E.all.Colonne;
      Nb_Elem_Par_Ligne_de_H := Nb_Elem_Ligne(H);
      for i in 1..N loop
         if Nb_Elem_Par_Ligne_de_H(i) = 0 then
            Modifier_Elem_Vecteur(V_S, i, T_Reel(1/N) );
         end if;
      end loop;
      while (Curseur_H/=null) loop
         V := Curseur_H.all.Colonne;
         Somme_vecteur(V, V_S);
         Multiplier_Vecteur_Par_Scalaire (V,alpha);
         Multiplier_Vecteur_Par_Scalaire (VE,(1.0-alpha)/T_Reel(N));
         Somme_vecteur(V,VE);
         Resultat := Produit_Scalaire (L,V);
         if P = null then
            Curseur_P  := new T_Cellule_Vecteur'(Resultat, Curseur_H.all.Indice_Colonne, null);
            P := Curseur_P ;
         else
            Curseur_P.all.Suivant_elem := new T_Cellule_Vecteur'(Resultat, Curseur_H.all.Indice_Colonne, null);
            Curseur_P := Curseur_P.all.Suivant_elem;
         end if;
         Curseur_H := Curseur_H.all.Suivant_Colonne;
      end loop;
      return P;
   end calcul_vecteur_poids;


   procedure diviser_H_card_ligne(H: in out T_Matrice) is
      Nb_elem : T_Vecteur_bis;
      Curseur_H : T_Matrice := H;
      Colonne_courante : T_Vecteur;
      valeur : T_Reel;
   begin
      Nb_elem := Nb_Elem_Ligne(H);
      while Curseur_H /= null loop
         Colonne_courante := Curseur_H.all.Colonne;
         while Colonne_courante /= null loop
            if Nb_elem(Colonne_courante.all.Indice_elem) /= 0 then
               valeur := Colonne_courante.all.Valeur / T_Reel(Nb_elem(Colonne_courante.all.Indice_elem));
               Modifier_Elem_Vecteur(Colonne_courante , Colonne_courante.all.Indice_elem, valeur);
            end if;
            Colonne_courante := Colonne_courante.all.Suivant_elem;
         end loop;
         Curseur_H := Curseur_H.all.Suivant_Colonne;
      end loop;
   end diviser_H_card_ligne;


   procedure Modifier_Elem_Matrice (M:in out T_Matrice; I : in Integer; J : in Integer; Valeur : T_Reel) is
      Vecteur_Colonne : T_Vecteur := null;
   begin
      if I<=N and I>=1 and J<=N and J>=1 then
         if M = null then
            Vecteur_Colonne := new T_cellule_vecteur'(Valeur, I, Vecteur_Colonne);
            M := new T_Cellule_Matrice'(Vecteur_Colonne, J, M);
         elsif M.all.Indice_Colonne = J then
            Modifier_Elem_Vecteur(M.all.Colonne, I, Valeur);
         elsif M.all.Indice_Colonne < J then
            Modifier_Elem_Matrice(M.all.Suivant_Colonne, I, J, Valeur);
         else
            Vecteur_Colonne := new T_cellule_vecteur'(Valeur, I, Vecteur_Colonne);
            M := new T_Cellule_Matrice'(Vecteur_Colonne, J, M);
         end if;
      else
         raise Dimensions_non_respectees with "Attention, il y a un probleme de dimensions";
      end if;
   end Modifier_Elem_Matrice;


   procedure Modifier_Elem_Vecteur (V:in out T_Vecteur; I : in Integer; Valeur : T_Reel) is
      Vecteur_A_Detruire : T_Vecteur;
   begin
      if V = Null or else V.all.Indice_elem > I then
         if Valeur /= 0.0 then
            V := new T_Cellule_Vecteur' (Valeur, I, V);
         end if;
      elsif V.all.Indice_elem = I then
         if Valeur = 0.0 then
            Vecteur_A_Detruire := V;
            V := V.all.Suivant_elem;
            Free(Vecteur_A_Detruire);
         else
            V.all.Valeur := Valeur;
         end if;
      else
         Modifier_Elem_Vecteur( V.all.Suivant_elem, I, Valeur);
      end if;
   end Modifier_Elem_Vecteur;

   function Difference_Vecteurs (vecteur_1 : in T_Vecteur ; vecteur_2 : in T_Vecteur) return T_Vecteur is
      Vecteur_Difference : T_Vecteur := vecteur_1;
      Moins_Vecteur_2 : T_Vecteur := vecteur_2;
   begin
      Multiplier_Vecteur_Par_Scalaire(Moins_Vecteur_2, -1.0);
      Somme_vecteur(Vecteur_Difference, Moins_Vecteur_2);
      return Vecteur_Difference;
   end Difference_Vecteurs;

   function Norme_Vecteur (V : in T_Vecteur) return T_Reel is
      Norme : T_Reel := Produit_Scalaire(V, V);
   begin
      return T_Reel(Sqrt(Float(Norme)));
   end Norme_Vecteur;


   function Acceder_elem_vecteur_bis (V : in T_Vecteur_bis; I : in Integer) return Integer is
   begin
      return (V(I));
   end Acceder_elem_vecteur_bis;

   function Acceder_elem_vecteur (V : in T_Vecteur; I : in Integer) return T_Reel is
      Curseur : T_Vecteur := V;
      Element : T_Reel;
   begin
      if V = Null then
         return 0.0;
      end if;
      if V.all.Indice_elem = I then
         return V.all.Valeur;
      elsif V.all.Indice_elem > I then
         return 0.0;
      else
         Element := Acceder_elem_vecteur( V.all.Suivant_elem, I);
         return Element;
      end if;
   end Acceder_elem_vecteur;

   function Acceder_elem_matrice (M : in T_Matrice; I : in Integer; J : in Integer) return T_Reel is
      Colonne_J : T_Vecteur;
      Element : T_Reel;
   begin
      if M = Null then
         return 0.0;
      end if;
      if M.all.Indice_Colonne = J then
         Colonne_J := M.all.Colonne;
         Element := Acceder_elem_vecteur(Colonne_J, I);
         return Element;
      elsif M.all.Indice_Colonne > J then
         return 0.0;
      else
         Element := Acceder_elem_matrice(M.all.Suivant_Colonne, I, J);
         return Element;
      end if;
   end Acceder_elem_matrice;

   procedure Afficher_Vecteur (V : in T_Vecteur) is
      Element : Float;
   begin
      for i in 1..N loop
         Element := Float( Acceder_elem_vecteur(V, i) );
         Put(Element);
      end loop;
   end Afficher_Vecteur;

   procedure Afficher_Vecteur_bis (U : in T_Vecteur_bis) is
      val :  Integer;
   begin
      for i in 1..N loop
         Val:= Acceder_elem_vecteur_bis (U,i);
         Put(val,2);
      end loop;
   end Afficher_Vecteur_bis;

   procedure Afficher_Matrice (M : in T_Matrice) is
      Element: Float;
   begin
      for i in 1..N loop
         Put("Ligne");
         Put(i,2);
         Put(':');
         for j in 1..N loop
            Element := Float(Acceder_elem_matrice(M,i,j));
            Put(Element);
         end loop;
         New_Line;
      end loop;
   end Afficher_Matrice;

end matrices_creuses;
