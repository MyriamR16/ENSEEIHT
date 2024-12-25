with SDA_Exceptions;         use SDA_Exceptions;
with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Unchecked_Deallocation;

package body LCA is

	procedure Free is
		new Ada.Unchecked_Deallocation (Object => T_Cellule, Name => T_LCA);


	procedure Initialiser(Sda: out T_LCA) is
    begin
        Sda := Null;
	end Initialiser;


	procedure Detruire (Sda : in out T_LCA) is
	begin
        if Sda/= Null then
            Detruire(Sda.all.Suivant);
            Free(Sda);
        else
            Null;
        end if;
	end Detruire;


    procedure Afficher_Debug (Sda : in T_LCA) is
        Courant : T_LCA := Sda ;
	begin
        if Sda = Null then
            Put("--E");
        else
            While Courant /= Null loop
                Put("--> [");
                Afficher_Cle(Courant.all.Cle);
                Put(":");
                Afficher_Donnee(Courant.all.Valeur);
                Put("]");
                Courant := Courant.all.Suivant;
            end loop ;
            Put("--E");
        end if;
	end Afficher_Debug;

	function Est_Vide (Sda : T_LCA) return Boolean is
	begin
		return Sda = Null;
	end Est_Vide;


    function Taille (Sda : in T_LCA) return Integer is
        Compteur : Integer :=0 ;
        Courant : T_LCA := Sda;
    begin
        while Courant /= Null loop
            Compteur := Compteur + 1 ;
            Courant := Courant.all.Suivant;
        end loop;
        return Compteur;
    end Taille;


    procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) is
        Trouve : Boolean := False ;
        Courant : T_LCA := Sda ;
        Nouveau : T_LCA := Null ;

    begin
        while (Trouve=False) and (Courant/=Null) loop
            if Courant.all.Cle = Cle then
                Courant.all.Valeur := Valeur;
                Trouve := True ;
            else
                Courant := Courant.all.Suivant;
            end if;
        end loop;
        if not Trouve then
            Nouveau := new T_Cellule ;
            Nouveau.all.Cle := Cle ;
            Nouveau.all.Valeur := Valeur ;
            Nouveau.all.Suivant := Sda;
            Sda := Nouveau;
        end if;
	end Enregistrer;


    function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean is
        Courant : T_LCA := Sda ;
    begin
        While Courant /= Null loop
            if Courant.all.Cle = Cle then
                return True ;
            else
                Courant := Courant.all.Suivant;
            end if;
        end loop;
        return False;
	end Cle_Presente;


    function La_Valeur (Sda : in T_LCA ; Cle : in T_Cle) return T_Valeur is
        Courant : T_LCA := Sda ;
    begin
        if Cle_Presente(Sda,Cle) then
            While Courant /= Null loop
                if Courant.all.Cle = Cle then
                    return Courant.all.Valeur ;
                else
                    Courant := Courant.all.Suivant;
                end if;
            end loop;
        else
            raise Cle_Absente_Exception;
        end if;
    end La_Valeur;


    procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) is
        Courant : T_LCA := Sda;
        Efface : T_LCA ;
        Trouve : Boolean:=False;
    begin
        if Courant = Null then
            null;

        elsif Courant.all.Cle = Cle then
            Sda := Sda.all.Suivant;
            Free(Courant);
        else
            Efface := Courant.all.Suivant;
            while (Efface /= null) and (not Trouve) loop
                if Efface.all.Cle = Cle then
                    Courant.all.Suivant := Efface.all.Suivant;
                    Free(Efface);
                    Trouve := True ;
                else
                    Courant := Courant.all.Suivant ;
                    Efface := Efface.all.Suivant;
                end if;
            end loop;

            if not Trouve then
                raise Cle_Absente_Exception;
            end if;
        end if;
	end Supprimer;


    procedure Pour_Chaque (Sda : in T_LCA) is
        Courant : T_LCA := Sda ;
	begin
        While Courant/=Null loop
            begin
                Traiter(Courant.all.Cle , Courant.all.Valeur);
                Courant := Courant.all.Suivant;
            exception
                when others => Courant := Courant.all.Suivant;
            end ;
        end loop;
    end Pour_Chaque;

end LCA;
