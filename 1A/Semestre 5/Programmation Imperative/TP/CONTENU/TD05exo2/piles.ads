-- Sp�cification du module Piles.

generic
    Capacite : Integer;   -- Nombre maximal d'�l�ments qu'une pile peut contenir
    type T_Element is private;  -- Type des �l�ments de la pile

package Piles is

    type T_Pile is private;

    -- Initilaiser une pile.  La pile est vide.
    procedure Initialiser (Pile : out T_Pile) with
        Post => Est_Vide (Pile);

    -- Est-ce que la pile est vide ?
    function Est_Vide (Pile : in T_Pile) return Boolean;

    -- Est-ce que la pile est pleine ?
    function Est_Pleine (Pile : in T_Pile) return Boolean;

    -- L'�l�ment en sommet de la pile.
    function Sommet (Pile : in T_Pile) return T_Element with
        Pre => not Est_Vide (Pile);

    -- Empiler l'�l�ment en somment de la pile.
    procedure Empiler (Pile : in out T_Pile; Element : in T_Element) with
        Pre => not Est_Pleine (Pile),
        Post => Sommet (Pile) = Element;

    -- Supprimer l'�l�ment en sommet de pile
    procedure Depiler (Pile : in out T_Pile) with
        Pre => not Est_Vide (Pile);

private

    type T_Tab_Elements is array (1..Capacite) of T_Element;

    type T_Pile is 
        record
            Elements : T_Tab_Elements;  -- les �l�ments de la pile
            Taille: Integer;        -- Nombre d'�l�ments dans la pile
        end record;

end Piles;
