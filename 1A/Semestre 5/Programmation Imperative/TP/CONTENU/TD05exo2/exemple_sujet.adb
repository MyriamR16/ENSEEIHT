with Piles;

-- Programme de "test" du module Pile.
procedure Exemple_Sujet is

    package Pile_Caractere is
        new Piles (Capacite => 20, T_Element => Character);
    use Pile_Caractere;

    Une_Pile: T_Pile;
begin
    -- Initialiser une pile
    Initialiser (Une_Pile);

    -- empiler successivement les caract�res 'o', 'k', puis ' ?'
    Empiler (Une_Pile, 'o');
    Empiler (Une_Pile, 'k');
    Empiler (Une_Pile, '?');

    -- v�rifier que le sommet est '?'
    pragma Assert ('?' = Sommet (Une_Pile));
    
    -- d�piler 3 fois
    for I in 1..3 loop
        Depiler (Une_Pile);
    end loop;

    -- v�rifier que la pile est vide
    pragma Assert (Est_Vide (Une_Pile));

end Exemple_Sujet;
