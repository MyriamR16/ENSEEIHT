with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;
with Piles;

procedure Saisir_Pile_Robuste is


    -- Lire un entier de mani�re cconviviale et robuste.
    -- Param�tres :
    --   Nombre : le nombre � saisir
    --   Consigne : la consigne � afficher � l'utilisateur avant chaque saisie
    procedure Lire_Entier_Robuste ( Nombre: out Integer ; Consigne: in String) is
        Saisie_OK: Boolean;     -- Est-ce que la saisie a r�ussi ?
    begin
        Saisie_OK := False;
        loop
            begin
                Put (Consigne);
                Get (Nombre);
                Saisie_OK := True;
            exception
                when Constraint_Error =>
                    Put ("Il faut saisir un entier.");
            end;
        exit when Saisie_OK;
        end loop;
    end Lire_Entier_Robuste;


    -- Lire un entier strictement positif de mani�re cconviviale et robuste.
    -- Param�tres :
    --   Nombre : le nombre � saisir, il sera strictement positif
    --   Consigne : la consigne � afficher � l'utilisateur avant chaque saisie
    procedure Lire_Entier_Naturel_Strict (
            Nombre: out Integer ;
            Consigne: in String) with
        Post => Nombre > 0
    is
        Nombre_Lu: Integer;
                -- pour ne pas modifier Nombre avant d'avoir r�ussi � saisir
                -- un entier strictement positif.
    begin
        loop
            Lire_Entier_Robuste(Nombre_Lu, Consigne);
            if Nombre_Lu <= 0 then
                Put_Line ("Le nombre doit �tre strictement positif.");
            else
                null;
            end if;
        exit when Nombre_Lu > 0;
        end loop;
        Nombre := Nombre_Lu;
    end Lire_Entier_Naturel_Strict;


    package Piles_Entiers is
        new Piles (Capacite => 5, T_Element => Integer);
    use Piles_Entiers;

    Entiers : T_Pile;   -- les entiers lus au clavier
    Valeur: Integer;    -- une valeur lue au clavier
    Quantite: integer;  -- nombre d'�l�ments � d�piler
begin
    -- Saisir la pile
    Initialiser (Entiers);
    Lire_Entier_Robuste (Valeur, "Une valeur : ");
    while Valeur > 0 loop
        begin
            Empiler (Entiers, Valeur);
        exception
            when Pile_Pleine_Error =>
                Put_Line ("La pile est pleine.  Il faut suppprimer des �l�ments.");

                -- Supprimer quelques �l�ments
                Lire_Entier_Naturel_Strict (Quantite, "Nombre d'�l�ments � supprimer : ");
                --    d�piler les �l�ments
                begin
                    for I in 1..Quantite loop
                        Depiler (Entiers);
                    end loop;
                exception
                    when Pile_Vide_Error =>
                        null;   -- Pas assez d'�l�ments dans la pile
                end;

                -- Empiler l'�l�ment
                Empiler (Entiers, Valeur);
        end;
        Lire_Entier_Robuste (Valeur, "Une valeur : ");
    end loop;

    -- Afficher la pile (attention, on vide la pile)
    Put_Line ("La pile contient (le sommet en haut) : ");
    while not Est_Vide (Entiers) loop
        Put (Sommet (Entiers));
        New_Line;
        Depiler (Entiers);
    end loop;
    Put_Line ("----------- fond de pile");


end Saisir_Pile_Robuste;
