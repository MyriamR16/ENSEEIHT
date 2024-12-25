with Ada.Text_IO;              use Ada.Text_IO;
with Ada.Characters.Handling;  use Ada.Characters.Handling; -- d�finit is_digit
with Piles;

package body Integer_IO is

    procedure Afficher (N : in Integer) is

        package Piles_Character is
            new Piles (Integer'Width, Character);
        use Piles_Character;

        Nombre   : Integer;       -- le nombre � afficher (copie de N)
        Unite    : Integer;       -- un chiffre de Nombre
        Chiffre  : Character;     -- le caract�re correspondant � Unite.
        Chiffres : T_Pile;        -- les chiffres de Nombre

    begin
        -- Empiler les chiffres de l'entier
        Initialiser (Chiffres);
        Nombre := N;
        loop
            -- r�cup�rer le chiffre des unit�s
            Unite := Nombre Mod 10;

            -- le convertir en un caract�re
            Chiffre := Character'Val (Character'Pos('0') + Unite);

            -- l'empiler
            pragma Assert (not Est_Pleine (Chiffres));
            Empiler (Chiffres, Chiffre);

            -- r�duire le nombre en supprimant les unit�s
            Nombre := Nombre / 10;
        exit when Nombre = 0;
        end loop;
        pragma Assert (Nombre = 0);
        pragma Assert (not Est_Vide (Chiffres));

        -- Afficher les chiffres de la pile
        loop
            -- Obtenir le chiffre en sommet de pile
            Chiffre := Sommet (Chiffres);

            -- afficher le caract�re
            Put (Chiffre);

            -- supprimer le caract�re de la pile
            Depiler (Chiffres);
        exit when Est_Vide (Chiffres);
        end loop;
    end Afficher;

    -- Consommer les carat�res blancs et indiquer le prochain caract�re sur
    -- l'entr�e standard.
    -- Assure : C /= ' '
    procedure Consommer_Blancs (Prochain_Caractere : out Character) with
        Post => Prochain_Caractere /= ' '
    is
        Fin_De_Ligne : Boolean;     -- fin de ligne atteinte ?
    begin
        Look_Ahead (Prochain_Caractere, Fin_De_Ligne); -- consulter le caract�re suivant
        while Fin_De_Ligne or else Prochain_Caractere = ' ' loop
            -- consommer le caract�re consult�
            if Fin_De_Ligne then
                Skip_Line;
            else
                Get (Prochain_Caractere);
            end if;

            -- Consulter le prochain caract�re
            Look_Ahead (Prochain_Caractere, Fin_De_Ligne);
        end loop;

        pragma Assert (not Fin_De_Ligne and Prochain_Caractere /= ' ');
    end Consommer_Blancs;

    procedure Saisir (N : out Integer) is
        C            : Character;   -- un caract�re lu au clavier
        Fin_De_Ligne : Boolean;     -- fin de ligne atteinte ?
        Chiffre      : Integer;     -- le chiffre correspondant � C

    begin
        Consommer_Blancs (C);

        if Is_Digit (C) then    --{ Un chiffre, donc un entier }--
            -- reconna�tre l'entier � partir des caract�res de l'entr�e standard
            N := 0;
            loop
                -- Mettre � jour N avec C
                Chiffre := Character'Pos (C) - Character'Pos ('0');
                N := N * 10 + Chiffre;

                -- Consulter le caract�re suivant
                Get (C);
                Look_Ahead (C, Fin_De_Ligne);
            exit when Fin_De_Ligne or else not Is_Digit (C);
            end loop;
        else --{ Pas d'entier }--
            N := -1;
        end if;
    end Saisir;

end Integer_IO;
