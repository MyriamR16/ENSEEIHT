-- Sp�cification du module Piles.

generic
    Capacite : Integer;   -- Nombre maximal d'�l�ments qu'une pile peut contenir
    type T_Element is private;  -- Type des �l�ments de la pile

package Piles is

    type T_Pile is limited private; --! "tr�s priv�" en Algorithmique !
        --! Sur un type priv�, on a droit � l'affectation (:=) et l'�galit� (=).
        --! On perd ces op�rations avec un type "limited private" (tr�s priv�).


    Pile_Vide_Error: Exception; -- en cas d'op�ration sur une pile vide
    Pile_Pleine_Error: Exception;   -- d�passement de la capacit� d'une pile


    -- Initilaiser une pile.  La pile est vide.
    procedure Initialiser (Pile : out T_Pile) with
        Post => Est_Vide (Pile);


    -- Est-ce que la pile est vide ?
    function Est_Vide (Pile : in T_Pile) return Boolean;


    -- Est-ce que la pile est pleine ?
    function Est_Pleine (Pile : in T_Pile) return Boolean;


    -- L'�l�ment en sommet de la pile.
    -- Exception : Pile_Vide_Error si la pile est vide.
    function Sommet (Pile : in T_Pile) return T_Element;


    -- Empiler l'�l�ment en somment de la pile.
    procedure Empiler (Pile : in out T_Pile; Element : in T_Element) with
        Post => Sommet (Pile) = Element;


    -- Supprimer l'�l�ment en sommet de pile
    -- Exception : Pile_Vide_Error si la pile est vide.
    procedure Depiler (Pile : in out T_Pile);


private

    type T_Tab_Elements is array (1..Capacite) of T_Element;

    type T_Pile is 
        record
            Elements : T_Tab_Elements;  -- les �l�ments de la pile
            Taille: Integer;        -- Nombre d'�l�ments dans la pile
        end record;

end Piles;