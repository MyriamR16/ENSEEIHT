with text_io;             use text_io;
with ada.integer_text_io; use ada.integer_text_io;

procedure Exemple_2 is

-- spécification volontairement omise !
procedure Lire_Entier (FValeur : out Integer) is
begin
	Put_Line ("Début de lire_entier");
	Get (FValeur);
	Put_Line ("Fin de lire_entier");
end lire_entier;

------------------------------------------------ Programme principal ----
    Nb : Integer; -- le nombre à lire
begin
	Put_Line ("Début de Exemple_2"); 
	Lire_Entier (Nb);
	Put_Line ("Fin de Exemple_2"); 
exception
	when Data_Error =>
	   	Put_Line ("Erreur de saisie"); 
end Exemple_2;
