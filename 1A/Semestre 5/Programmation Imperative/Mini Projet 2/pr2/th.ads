with LCA;

generic
    type T_Cle is private;
    type T_Valeur is private;
    Capacite : Integer ;
    with function fonction_de_hachage (Cle : in T_Cle) return Integer;

package TH is
	type T_Tableau is limited private;

	-- Initialiser une Tableau.  La Tableau est vide.
	procedure Initialiser(Tableau: out T_Tableau) with
		Post => Est_Vide (Tableau);


	-- Détruire une Tableau.  Elle ne devra plus être utilisée.
	procedure Detruire (Tableau : in out T_Tableau);


	-- Est-ce qu'une Tableau est vide ?
	function Est_Vide (Tableau :in T_Tableau) return Boolean;


	-- Obtenir le nombre d'éléments d'une  Tableau.
	function Taille (Tableau : in T_Tableau) return Integer with
		Post => Taille'Result >= 0
			and (Taille'Result = 0) = Est_Vide (Tableau);


	-- Enregistrer une valeur associée à une Clé dans une Tableau.
	-- Si la clé est déjà présente dans la Tableau, sa valeur est changée.
	procedure Enregistrer (Tableau : in out T_Tableau ; Cle : in T_Cle ; Valeur : in T_Valeur) with
		Post => Cle_Presente (Tableau, Cle) and (La_Valeur (Tableau, Cle) = Valeur)   -- valeur insérée
				and (not (Cle_Presente (Tableau, Cle)'Old) or Taille (Tableau) = Taille (Tableau)'Old)
				and (Cle_Presente (Tableau, Cle)'Old or Taille (Tableau) = Taille (Tableau)'Old + 1);

	-- Supprimer la valeur associée à une Clé dans une Tableau.
	-- Exception : Cle_Absente_Exception si Clé n'est pas utilisée dans la Tableau
	procedure Supprimer (Tableau : in out T_Tableau ; Cle : in T_Cle) with
		Post =>  Taille (Tableau) = Taille (Tableau)'Old - 1 -- un élément de moins
			and not Cle_Presente (Tableau, Cle);         -- la clé a été supprimée


	-- Savoir si une Clé est présente dans une Tableau.
	function Cle_Presente (Tableau : in T_Tableau ; Cle : in T_Cle) return Boolean;


	-- Obtenir la valeur associée à une Cle dans la Tableau.
	-- Exception : Cle_Absente_Exception si Clé n'est pas utilisée dans l'Tableau
	function La_Valeur (Tableau : in T_Tableau ; Cle : in T_Cle) return T_Valeur;


	-- Appliquer un traitement (Traiter) pour chaque couple d'une Tableau.
	generic
		with procedure Traiter (Cle : in T_Cle; Valeur: in T_Valeur);
	procedure Pour_Chaque (Tableau : in T_Tableau);


	-- Afficher la Tableau en révélant sa structure interne.
	-- Voici un exemple d'affichage.
	-- -->["un" : 1]-->["deux" : 2]-->["trois" : 3]-->["quatre" : 4]--E

    generic
		with procedure Afficher_Cle (Cle : in T_Cle);
		with procedure Afficher_Donnee (Valeur : in T_Valeur);
	procedure Afficher_Debug (Tableau : in T_Tableau);

private
    package LCA_instancie is new LCA (T_Cle => T_Cle, T_Valeur => T_Valeur);
    use LCA_instancie;

    type T_Tableau is array(1..Capacite) of T_LCA;


end TH;
