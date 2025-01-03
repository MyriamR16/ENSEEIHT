with Ada.Text_IO;          use Ada.Text_IO;
with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;

-- Afficher le chiffre significatif d'un entier naturel.
-- 
-- Attention à ne pas provoquer des débordement de la capacité des entiers.
-- 
-- Exemples :
--
--   entier  -> chiffre significatif
--   -------------------------------
--   25         ->  2
--   8          ->  8
--   9502       ->  9
--   0          ->  0
--   2147483647 ->  2
--
procedure Chiffre_Significatif is

	Entier: Integer;  -- l'entier naturel
	Chiffre_Significatif: Integer;   -- le chiffre significatif de Entier

	Nombre: Integer;	-- un entier, copie de Entier
	Chiffre: Integer;	-- un chiffre de Nombre, et donc de Entier
begin
	-- Demander l'entier naturel
	Put ("Entier : ");
	Get (Entier);

	-- Déterminer le chiffre significatif
	Nombre := Entier;
	loop
		Chiffre := Nombre mod 10;
		Nombre := Nombre / 10;
		exit when Nombre = 0;
	end loop;
	Chiffre_Significatif := Chiffre;

	-- Afficher le tarif
	Put ("Chiffre significatif : ");
	Put (Chiffre_Significatif, 1);
	New_Line;

end Chiffre_Significatif;
