with Ada.Command_line;		use Ada.Command_line;
with Reel; use Reel;

package body Lecture_commande is
    Fichier_Non_Conforme_exception : Exception ;
    No_Argument_Error : Exception ;
    Alpha_non_conforme_exception : Exception ; 
    
    function Fichier_non_conforme (Nom_Fichier : in Unbounded_String) return Boolean is
        Non_Conforme : Boolean := False;
        Caractere : Character;
    begin
        for I in 1..Length(Nom_Fichier) loop
            Caractere := Element(Nom_Fichier, i);
            if not( ('a'<=Caractere and Caractere<='z') or ('A'<=Caractere and Caractere<='Z') or ('0' <=Caractere and Caractere<='9') or (Caractere='-') or (Caractere='_') ) then
                Non_Conforme := True;
            end if;
        end loop;
        return Non_Conforme;
    end fichier_non_conforme; 
    
    procedure lecture_fichier_non_conforme (Nom_Fichier: in Unbounded_String) is 
        Taille : constant Integer := length (Nom_Fichier) ; 
        Fichier_bis : constant Unbounded_String := to_unbounded_string(to_string(Nom_Fichier)(1..Taille-4));
        Derniers_4_Caracteres : constant Unbounded_String := to_unbounded_string(to_string(Nom_Fichier)(Taille-3..Taille));

    begin 

        if Taille < 4 then 
            raise Fichier_Non_Conforme_exception;
        else 
            if Fichier_non_conforme(Fichier_bis) then
                raise Fichier_Non_Conforme_Exception with "Le nom du fichier entre n est pas conforme !" ; 
            elsif not ((To_String(Derniers_4_Caracteres) = ".net") or (To_String(Derniers_4_Caracteres) = ".txt")) then 
                raise Fichier_Non_Conforme_exception with  "Le nom du fichier entre n est pas conforme !"; 
            end if; 
        end if; 
    end lecture_fichier_non_conforme;

    
    procedure Lire_Parametres(Nom_Fichier : out Unbounded_String; Nom_Fichier_produit : out Unbounded_String; alpha :in out T_Reel; Nb_Iterations : in out Integer; Epsilon : in out T_Reel; Creuse_Ou_Pleine : in out Character) is
        I : Integer := 1 ;
        Nom_Fichier_produit_Donne : Boolean := False ; 
        Taille : Integer ;
    begin 
        While I<= Argument_Count loop
            --Analyser Argument(I)
            if (Argument(I) = "-A") then 
                --Lire la valeur de alpha 
                if (I=Argument_Count) then 
                    raise No_Argument_Error with "Vous n avez pas associe votre valeur de alpha a A et vous n avez pas rentre de nom de fichier"; 
                else 
                    I := I +1 ;
                    --Lire la valeur de alpha dans Argument(I)
                    alpha := T_Reel'Value(Argument(I));
                    if not (alpha>=0.0 and alpha<=1.0) then 
                        raise Alpha_non_conforme_exception with "La valeur de alpha choisie n est pas comprise entre 0 et 1";
                    end if; 
                end if; 
                
            elsif (Argument(I) = "-K") then 
                --Lire la valeur du nombre d'iterations
                if (I=Argument_Count) then 
                    raise No_Argument_Error with "Vous n avez pas associe votre valeur du nombre d iterations a K et vous n avez pas rentre de nom de fichier" ; 
                else 
                    I := I +1 ;
                    Nb_Iterations :=  Integer'Value(Argument(I));  
                end if; 
                
            elsif (Argument(I) = "-E") then 
                --Lire la valeur d'epsilon
                if (I=Argument_Count) then 
                    raise No_Argument_Error with "Vous n avez pas associe votre valeur de epsilon a E et vous n avez pas rentre de nom de fichier" ; 
                else 
                    I := I +1 ;
                    Epsilon :=  T_Reel'Value(Argument(I));  
                end if; 
                
            elsif (Argument(I) = "-P") then
                Creuse_Ou_Pleine := 'P' ; 
                
            elsif (Argument(I) = "-C") then 
                Creuse_Ou_Pleine := 'C' ; 
                
            elsif (Argument(I) = "-R") then 
                I := I+1;
                --Lire le Nom du Fichier Produit
                Nom_Fichier_produit := To_Unbounded_String(Argument(I));
                --Lever exception si Nom_Fichier n est pas conforme
                if Fichier_non_conforme(Nom_Fichier_produit) then
                    raise Fichier_Non_Conforme_Exception with "Le nom du fichier produit entre n est pas conforme ! ";
                end if;
                Nom_Fichier_produit_Donne := True;
                         
            else
                --Lire le fichier
                Nom_Fichier := To_Unbounded_String(Argument(I)) ;
                lecture_fichier_non_conforme(Nom_Fichier);
            end if;
            
            I := I+1;
        end loop; 
        
        Taille := length (Nom_Fichier);
        if not(Nom_Fichier_produit_Donne) then 
            Nom_Fichier_produit := to_unbounded_string(to_string(Nom_Fichier)(1..Taille-4));
        end if;
    end Lire_Parametres ;    
    
end Lecture_commande;
