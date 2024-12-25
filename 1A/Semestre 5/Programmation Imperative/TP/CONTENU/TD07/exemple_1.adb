with text_io;             use text_io;
with ada.integer_text_io; use ada.integer_text_io;

procedure Exemple_1 is

-- spécification volontairement omise !
procedure Lire_Entier (FValeur : out Integer) is
begin
	Put_Line ("Début lire_entier");
	Get (FValeur);
	Put_Line ("Fin lire_entier");
exception
	when Data_Error =>
		Put_Line ("Erreur de saisie dans lire_entier");
end Lire_Entier;

------------------------------------------------ Programme principal ----
	Nb : Integer; -- le nombre à lire
begin
	Put_Line ("Début instructions du programme Exemple 1"); 
	Lire_Entier (Nb);
	Put_Line ("Fin instructions du programme Exemple 1");
end Exemple_1;
