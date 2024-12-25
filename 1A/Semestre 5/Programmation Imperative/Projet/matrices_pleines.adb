with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Numerics; use Ada.Numerics;
with Reel; use Reel;


package body matrices_pleines is

    procedure Initialiser (M : in out T_Matrice ; Scalaire : in T_Reel) is 
    begin 
        for I in 1..N loop
            for J in 1..N loop
                M(I,J) := Scalaire;
            end loop; 
        end loop; 
    end Initialiser;
    
    function Nb_Elem_Ligne (M: in T_Matrice) return T_Vecteur is
        Ligne_Card : T_Vecteur ; 
    begin
        for I in 1..N loop 
            Ligne_Card(I) := 0.0 ; 
            for J in 1..N loop
                if M(I,J) /= 0.0 then 
                    Ligne_Card(I) := Ligne_Card(I) + 1.0 ; 
                end if;
            end loop;
        end loop;
        return Ligne_Card; 
    end Nb_Elem_Ligne;
    
    
    function Somme (M : in T_Matrice; N: in T_Matrice) return T_Matrice is 
        S : T_Matrice;
    begin 
        for I in 1..M'Length(1) loop 
            for J in 1..M'Length(2) loop
                S(I,J) := M(I,J) + N(I,J);
            end loop;
        end loop;
        return S; 
    end Somme ;
 
    
    procedure Multiplier_Scalaire (M:in out T_Matrice; Scalaire : in T_Reel) is 
    begin 
        for I in 1..N loop
            for J in 1..N loop 
                M(I,J) := M(I,J) * Scalaire; 
            end loop; 
        end loop; 
    end Multiplier_Scalaire ; 
    
    function Multiplier_Ligne_Matrice (M : in T_Matrice; L:in T_Vecteur) return T_Vecteur is 
        Ligne : T_Vecteur;
    begin 
        for I in 1 ..N loop
            Ligne(I):= 0.0; 
            for K in 1..N loop
                Ligne(I) := Ligne(I)+ (L(K) * M(K,I));
            end loop; 
        end loop ;
        return Ligne ; 
    end Multiplier_Ligne_Matrice;
    
    function Capacite (M : in T_Matrice) return Integer is 
    begin 
        return M'Length(1);
    end Capacite;

    procedure Modifier_Elem_Matrice (M:in out T_Matrice; I : in Integer; J : in Integer; Valeur : T_Reel) is 
    begin 
        M(I,J) := Valeur; 
    end Modifier_Elem_Matrice;
    
    procedure Modifier_Elem_Vecteur (V:in out T_Vecteur; I : in Integer; Valeur : T_Reel) is 
    begin 
        V(I) := Valeur;
    end Modifier_Elem_Vecteur;
    
    function Difference_Vecteurs (vecteur_1 : in T_Vecteur ; vecteur_2 : in T_Vecteur) return T_Vecteur is 
        V : T_Vecteur ; 
    begin 
        for I in 1..N loop
            V(I) := vecteur_1(I) - vecteur_2(I);
        end loop ; 
        return V ; 
    end Difference_Vecteurs;
    
    function Norme_Vecteur (V : in T_Vecteur) return T_Reel is
        Norme_Cal : T_Reel :=0.0 ; 
    begin 
        for I in 1..N loop
            Norme_Cal := Norme_Cal + T_Reel(V(I)*V(I)); 
        end loop;
        return  T_Reel(Sqrt(Float(Norme_Cal)));
    end Norme_Vecteur;
    
    function Acceder_elem_matrice (M : in T_Matrice; I : in Integer; J : in Integer) return T_Reel is 
    begin 
        return M(I,J);
    end Acceder_elem_matrice;
    
    function Acceder_elem_vecteur (V : in T_Vecteur; I : in Integer) return T_Reel is 
    begin 
        return V(I);
    end Acceder_elem_vecteur;
  
    procedure Afficher_Vecteur (V : in T_Vecteur) is
        Element : T_Reel;
    begin
        for i in 1..N loop
            Element := T_Reel(Acceder_elem_vecteur(V,i));
            Put(Float(Element));
        end loop; 
    end Afficher_Vecteur;
    
    procedure Afficher_Matrice (M : in T_Matrice) is
        Element: T_Reel ;
    begin
        for i in 1..N loop
            Put("Ligne");
            Put(i,2);
            Put(':');
            for j in 1..N loop 
                Element := T_Reel(Acceder_elem_matrice(M,i,j));
                Put(Float(Element));
            end loop;
            New_Line;
        end loop; 
    end Afficher_Matrice;
    
end matrices_pleines;
