generic
	type T_Element is private;

package Listes is

	type T_Liste is limited private;

	Indice_Error: Exception;	-- Un indice est invalide
	Element_Absent_Error: Exception;	-- �l�ment non trouv�


	-- Initialiser une liste.
	procedure Initialiser (Liste: out T_Liste) with
		Post => Taille (Liste) = 0;


	-- D�truire une liste et lib�rer toutes les ressources qu'elle utilise.
	-- Une liste d�truite ne doit plus �tre utilis�e.
	procedure Detruire (Liste: in out T_Liste);


	-- Ajouter un nouvel �l�ment au d�but d'une liste.
	procedure Ajouter_Debut (Liste: in out T_Liste; Element: T_Element) with
		Post => Taille (Liste) > 0 and then Ieme (Liste, 0) = Element;


	-- Retourner le premier �l�ment d'une liste.
	-- Exception : Element_Absent_Error si la liste est vide
	function Premier (Liste: in T_Liste) return T_Element;


	-- Retourner la taille d'une liste.
	function Taille (Liste: in T_Liste) return Integer;


	-- Afficher les �l�ments d'une liste en r�v�lant la structure interne.
	-- Par exemple : -->[1]-->[3]-->[1]-->[2]--E
	--! Cette op�ration serait plut�t utilis�e � des fin de mise au point et
	--! pourrait rester locale au module.  Pour l'utilisateur du module
	--! une proc�dure qui affiche [1, 3, 1, 2] serait plus utile.
	generic
		with procedure Afficher_Element (Element: in T_Element);
	procedure Afficher (Liste: in T_Liste);


	-- Retourner vrai ssi Element est dans Liste.
	function Est_Present (Liste: in T_Liste; Element: in T_Element) return Boolean;


	-- Suppprimer la premi�re occurrence de Element dans Liste.
	-- Exception : Element_Absent_Error si l'�l�ment n'est pas trouv�.
	procedure Supprimer (Liste: in out T_Liste; Element: in T_Element);


	-- Ins�rer un nouvel �l�ment (Nouveau) dans la liste (Liste) apr�s un
	-- �l�ment existant (Element).
	-- Exception : Element_Absent_Error si Element n'est pas dans la liste
	procedure Inserer_Apres (Liste: in out T_Liste; Nouveau, Element: in T_Element);


	-- Retourner l'�l�ment � la position Indice dans la Liste.
	-- Le premier �l�ment est � l'indice 0.
	-- Exception : Indice_Error si l'indice n'est pas valide
	function Ieme (Liste: in T_Liste; Indice: in Integer) return T_Element;


	-- Supprimer l'�l�ment � la position Indice dans la Liste.
	-- Le premier �l�ment est � l'indice 0.
	-- Exception : Indice_Error si l'indice n'est pas valide
	procedure Supprimer_Ieme (Liste: in out T_Liste; Indice: in Integer);


	-- Proc�dure de test de la liste.
	generic
		Un, Deux, Trois : T_Element;	-- Trois �l�ments diff�rents
		with procedure Afficher_Element (Element: in T_Element);
	procedure Tester;


private

	type T_Cellule;

	type T_Liste is access T_Cellule;

	type T_Cellule is
		record
			Element: T_Element;
			Suivante: T_Liste;
		end record;

	function Cellule_Contenant (Element: T_Element; Liste: in T_Liste) return T_Liste with
		Post => Cellule_Contenant'Result /= null
				and then Cellule_Contenant'Result.all.Element = Element;

		--! Sp�cifier ici, dans la partie private, ce sous-programme n'est
		--! pas accessible des utilisateurs du module mais le sera de tous
		--! sous-programme du corps du module.

end Listes;
