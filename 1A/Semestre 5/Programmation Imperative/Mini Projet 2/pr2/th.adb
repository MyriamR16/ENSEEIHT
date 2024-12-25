with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;


package body TH is

    procedure Initialiser(Tableau: out T_Tableau) is
    begin
        for I in 1..Capacite loop
            LCA_instancie.Initialiser(Tableau(I));
        end loop;
    end Initialiser;

    function Est_Vide (Tableau :in T_Tableau) return Boolean is
    begin
        for I in 1..Capacite loop
            if not (LCA_instancie.Est_Vide(Tableau(I))) then
                return False ;
            end if;
        end loop;
        return True;
    end Est_Vide;

    procedure Detruire (Tableau : in out T_Tableau) is
    begin
        for I in 1..Capacite loop
            LCA_instancie.Detruire(Tableau(I));
        end loop;
    end Detruire;

    function Cle_Presente (Tableau : in T_Tableau ; Cle : in T_Cle) return Boolean is
        Indice : Integer ;
    begin
        Indice := fonction_de_hachage(Cle) mod Capacite + 1;
        return LCA_instancie.Cle_Presente(Tableau(Indice) ,Cle);
    end Cle_Presente;


    function Taille (Tableau : in T_Tableau) return Integer is
        Compteur : Integer :=0;
    begin
        for I in 1..Capacite loop
            Compteur := Compteur + LCA_instancie.Taille(Tableau(I));
        end loop;
        return Compteur;
    end Taille;


    function La_Valeur (Tableau : in T_Tableau ; Cle : in T_Cle) return T_Valeur is
        Indice : Integer ;
    begin
        if Cle_Presente(Tableau, Cle) then
            Indice := fonction_de_hachage(Cle) mod Capacite + 1;
            return LCA_instancie.La_Valeur(Tableau(Indice) ,Cle);
        else
            raise Cle_Absente_Exception;
        end if;
    end La_Valeur;

    procedure Enregistrer (Tableau : in out T_Tableau ; Cle : in T_Cle ; Valeur : in T_Valeur) is
        Indice : Integer ;
    begin
        Indice := fonction_de_hachage(Cle) mod Capacite + 1;
        LCA_instancie.Enregistrer(Tableau(Indice), Cle, Valeur);
    end Enregistrer;


    procedure Supprimer (Tableau : in out T_Tableau ; Cle : in T_Cle) is
        Indice : Integer ;
    begin
        Indice := fonction_de_hachage(Cle) mod Capacite + 1;
        LCA_instancie.Supprimer(Tableau(Indice), Cle);
    end Supprimer;

    procedure Pour_Chaque (Tableau : in T_Tableau) is
        procedure Pour_Chaque_1 is new LCA_instancie.Pour_Chaque(Traiter => Traiter);
    begin
        for I in 1..Capacite loop
            Pour_Chaque_1(Tableau(I)) ;
        end loop;
    end Pour_Chaque;

    procedure Afficher_Debug (Tableau : in T_Tableau) is
        procedure Afficher_Debug_1 is new LCA_instancie.Afficher_Debug (Afficher_Cle=> Afficher_Cle, Afficher_Donnee => Afficher_Donnee);
    begin
        for I in 1..Capacite loop
            Put(I,1) ;
            Put(' ');
            Afficher_Debug_1(Tableau(I));
            New_Line;
        end loop;
    end Afficher_Debug;

end TH;
