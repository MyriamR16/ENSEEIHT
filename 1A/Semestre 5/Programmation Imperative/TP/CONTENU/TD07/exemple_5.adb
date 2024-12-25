with text_io;             use text_io;
with ada.integer_text_io; use ada.integer_text_io;

procedure Exemple_5 is

-- spécification volontairement omise !
procedure Lire_Entier (FValeur : out Integer) is
begin
	Put_Line ("Début lire_entier");
	Get (FValeur);
	Put_Line ("Fin lire_entier");
exception
	when Data_Error => 
		Put_Line ("Erreur de saisie dans lire_entier");
		Skip_Line;
		Lire_Entier (FValeur); 
end Lire_Entier;

------------------------------------------------ Programme principal ----
    Nb : Integer; -- le nombre à lire
begin
	Put_Line ("Début de Exemple_5");
	Lire_Entier (Nb);
	Put_Line ("Fin de Exemple_5");
end Exemple_5;
