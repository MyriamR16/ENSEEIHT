-- Entr�es/Sorties sur les entiers.
-- Remarque : on refait, de mani�re simplifi�e, le Put et le Get de
-- Integer_Text_IO.
package Integer_IO is

    -- Afficher un entier naturel sur la sortie standard.
    procedure Afficher (N : in Integer) with
        Pre => N >= 0
;

    -- Saisir un entier naturel au clavier. Sa valeur est mise dans N.
    -- Il peut y avoir des caract�res blancs (ignor�s) devant l'entier.
    -- N vaut -1 si les caract�res de l'entr�e ne correspondent pas � un entier.
    procedure Saisir (N : out Integer) with
        Post => N = -1 or else N >= 0;

end Integer_IO;
