-- DÃ©finition de structures de donnÃ©es associatives sous forme d'une liste
-- chaÃ®nÃ©e associative (LCA).
generic
	type T_Cle is private;
	type T_Valeur is private;

package LCA is

	type T_LCA is limited private;

	-- Initialiser une Sda.  La Sda est vide.
	procedure Initialiser(Sda: out T_LCA) with
		Post => Est_Vide (Sda);


	-- DÃ©truire une Sda.  Elle ne devra plus Ãªtre utilisÃ©e.
	procedure Detruire (Sda : in out T_LCA);


	-- Est-ce qu'une Sda est vide ?
	function Est_Vide (Sda : T_LCA) return Boolean;


	-- Obtenir le nombre d'Ã©lÃ©ments d'une  Sda. 
	function Taille (Sda : in T_LCA) return Integer with
		Post => Taille'Result >= 0
			and (Taille'Result = 0) = Est_Vide (Sda);


	-- Enregistrer une valeur associÃ©e Ã  une ClÃ© dans une Sda.
	-- Si la clÃ© est dÃ©jÃ  prÃ©sente dans la Sda, sa valeur est changÃ©e.
	procedure Enregistrer (Sda : in out T_LCA ; Cle : in T_Cle ; Valeur : in T_Valeur) with
		Post => Cle_Presente (Sda, Cle) and (La_Valeur (Sda, Cle) = Valeur)   -- valeur insÃ©rÃ©e
				and (not (Cle_Presente (Sda, Cle)'Old) or Taille (Sda) = Taille (Sda)'Old)
				and (Cle_Presente (Sda, Cle)'Old or Taille (Sda) = Taille (Sda)'Old + 1);

	-- Supprimer la valeur associÃ©e Ã  une ClÃ© dans une Sda.
	-- Exception : Cle_Absente_Exception si ClÃ© n'est pas utilisÃ©e dans la Sda
	procedure Supprimer (Sda : in out T_LCA ; Cle : in T_Cle) with
		Post =>  Taille (Sda) = Taille (Sda)'Old - 1 -- un Ã©lÃ©ment de moins
			and not Cle_Presente (Sda, Cle);         -- la clÃ© a Ã©tÃ© supprimÃ©e


	-- Savoir si une ClÃ© est prÃ©sente dans une Sda.
	function Cle_Presente (Sda : in T_LCA ; Cle : in T_Cle) return Boolean;


	-- Obtenir la valeur associÃ©e Ã  une Cle dans la Sda.
	-- Exception : Cle_Absente_Exception si ClÃ© n'est pas utilisÃ©e dans l'Sda
	function La_Valeur (Sda : in T_LCA ; Cle : in T_Cle) return T_Valeur;


	-- Appliquer un traitement (Traiter) pour chaque couple d'une Sda.
	generic
		with procedure Traiter (Cle : in T_Cle; Valeur: in T_Valeur);
	procedure Pour_Chaque (Sda : in T_LCA);


	-- Afficher la Sda en rÃ©vÃ©lant sa structure interne.
	-- Voici un exemple d'affichage.
	-- -->["un" : 1]-->["deux" : 2]-->["trois" : 3]-->["quatre" : 4]--E
	
    generic
		with procedure Afficher_Cle (Cle : in T_Cle);
		with procedure Afficher_Donnee (Valeur : in T_Valeur);
	procedure Afficher_Debug (Sda : in T_LCA);

    
private
	type T_Cellule;

	type T_LCA is access T_Cellule;

	type T_Cellule is
		record
			Cle : T_Cle;
			Valeur : T_Valeur;
			Suivant : T_LCA;
		end record;
end LCA;
