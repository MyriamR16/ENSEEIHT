with Ada.Text_IO;         use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Unchecked_Deallocation;

package body Listes is

	--! Les sous-programmes pour lesquels on demande une version itérative et
	--! récursive apparaissent trois fois :
	--! - avec le suffixe _Recursive : pour la version récursive
	--! - avec le suffixe _Iterative : pour la version itérative
	--! - sans suffixe : c'est le corps du sous-programme de l'interface qui
	--!   appelle la version récursive.  Inutile de le changer (sauf pour
	--!   Afficher où on pourra le changer pour essayer l'autre version).
	--!
	--! Un trait horizontal sépare les différents groupes de sous-programmes.


	----------------------------------------------------------------------------


	procedure Free is
		new Ada.Unchecked_Deallocation (T_Cellule, T_Liste);

	----------------------------------------------------------------------------

	-- Initialiser START DELETE
	procedure Initialiser (Liste: out T_Liste) is
	begin
		Liste := null;
	end Initialiser;
	-- Initialiser STOP DELETE

	----------------------------------------------------------------------------

	-- Detruire_Recursive START DELETE
	procedure Detruire_Recursive (Liste: out T_Liste) is
	begin
		if Liste = null then
			null;
		else
			Detruire_Recursive (Liste.all.Suivante);
			Free (Liste);
		end if;
	end Detruire_Recursive;
	-- Detruire_Recursive STOP DELETE


	-- Detruire_Iterative START DELETE
	procedure Detruire_Iterative (Liste: in out T_Liste) is
		Curseur: T_Liste;			-- pour parcourir les cellules
		A_Detruire: T_Liste;		-- pointeur sur la cellule à détruire
	begin
		Curseur := Liste;
		while Curseur /= null loop
			A_Detruire := Curseur;
			Curseur := Curseur.all.Suivante;
			Free (A_Detruire);
		end loop;
		Liste := null;
	end Detruire_Iterative;
	-- Detruire_Iterative STOP DELETE


	-- Detruire START DELETE
	procedure Detruire (Liste: in out T_Liste) is
	begin
		Detruire_Recursive (Liste);
	end Detruire;
	-- Detruire STOP DELETE

	----------------------------------------------------------------------------

	-- Ajouter_Debut START DELETE
	procedure Ajouter_Debut (Liste: in out T_Liste; Element: T_Element) is
	begin
		Liste := new T_Cellule'(Element, Liste);
	end Ajouter_Debut;
	-- Ajouter_Debut STOP DELETE

	----------------------------------------------------------------------------

	-- Premier START DELETE
	-- Premier START DELETE
	function Premier (Liste: in T_Liste) return T_Element is
	begin
		if Liste = null then
			raise Element_Absent_Error;
		end if;

		return Liste.all.Element;
	end Premier;
	-- Premier STOP DELETE

	----------------------------------------------------------------------------

	-- Taille_Recursive START DELETE
	function Taille_Recursive (Liste: in T_Liste) return Integer is
	begin
		if Liste = null then
			return 0;
		else
			return 1 + Taille_Recursive (Liste.all.Suivante);
		end if;
	end Taille_Recursive;
	-- Taille_Recursive STOP DELETE


	-- Taille_Iterative START DELETE
	function Taille_Iterative (Liste: in T_Liste) return Integer is
		Curseur: T_Liste;			-- pour parcourir les cellules
		Nombre_Cellules: Integer;	-- nombre de cellules parcourues
	begin
		Nombre_Cellules := 0;
		Curseur := Liste;
		while Curseur /= null loop
			Nombre_Cellules := Nombre_Cellules + 1;
			Curseur := Curseur.all.Suivante;
		end loop;
		return Nombre_Cellules;
	end Taille_Iterative;
	-- Taille_Iterative STOP DELETE


	-- Taille START DELETE
	function Taille (Liste: in T_Liste) return Integer is
	begin
		return Taille_Recursive (Liste);
	end Taille;
	-- Taille STOP DELETE

	----------------------------------------------------------------------------

	-- Afficher_Recursive START DELETE
	generic
		with procedure Afficher_Element (Element: in T_Element);
	procedure Afficher_Recursive (Liste: in T_Liste);


	procedure Afficher_Recursive (Liste: in T_Liste) is
	begin
		if Liste = null then
			Put ("--E");
		else
			-- Afficher le premier élément
			Put ("-->[");
			Afficher_Element (Liste.all.Element);
			Put ("]");

			-- Afficher les autres éléments
			Afficher_Recursive (Liste.all.Suivante);
		end if;
	end Afficher_Recursive;
	-- Afficher_Recursive STOP DELETE


	-- Afficher_Iterative START DELETE
	generic
		with procedure Afficher_Element (Element: in T_Element);
	procedure Afficher_Iterative (Liste: in T_Liste);


	procedure Afficher_Iterative (Liste: in T_Liste) is
		Curseur: T_Liste;
	begin
		Curseur := Liste;
		while Curseur /= null loop
			Put ("-->[");
			Afficher_Element (Curseur.all.Element);
			Put ("]");
			Curseur := Curseur.all.Suivante;
		end loop;
		Put ("--E");
	end Afficher_Iterative;
	-- Afficher_Iterative STOP DELETE


	procedure Afficher (Liste: in T_Liste) is
		procedure Afficher_Recursive_Instanciee is
			new Afficher_Recursive (Afficher_Element);
	begin
		Afficher_Recursive_Instanciee (Liste);
	end Afficher;

	----------------------------------------------------------------------------

	-- Est_Present_Recursive START DELETE
	function Est_Present_Recursive (Liste: in T_Liste; Element: in T_Element) return Boolean is
	begin
		if Liste = Null then
			return False;
		elsif Liste.all.Element = Element then
			return True;
		else
			return Est_Present_Recursive (Liste.all.Suivante, Element);
		end if;
	end Est_Present_Recursive;
	-- Est_Present_Recursive STOP DELETE


	-- Est_Present_Recursive_Bis START DELETE
	function Est_Present_Recursive_Bis (Liste: in T_Liste; Element: in T_Element) return Boolean is
	begin
		return Liste /= Null and then (Liste.all.Element = Element
			or else Est_Present_Recursive_Bis (Liste.all.Suivante, Element));
	end Est_Present_Recursive_Bis;
	-- Est_Present_Recursive_Bis STOP DELETE



	-- Est_Present_Iterative START DELETE
	function Est_Present_Iterative (Liste: in T_Liste; Element: in T_Element) return Boolean is
		Curseur: T_Liste;
	begin
		Curseur := Liste;
		while Curseur /= Null and then Curseur.all.Element /= Element loop
			Curseur := Curseur.all.Suivante;
		end loop;
		return Curseur /= null;
	end Est_Present_Iterative;
	-- Est_Present_Iterative STOP DELETE


	-- Est_Present_Avec_Cellule START DELETE
	function Est_Present_Avec_Cellule (Liste: in T_Liste; Element: in T_Element) return Boolean is
	begin
		return Cellule_Contenant (Element, Liste) /= null;
			--! S'il n'y a pas d'exception, on a forcément cette condition vraie
	exception
		when Element_Absent_Error =>
			return False;
	end Est_Present_Avec_Cellule;
	-- Est_Present_Avec_Cellule STOP DELETE


	-- Est_Present START DELETE
	function Est_Present (Liste: in T_Liste; Element: in T_Element) return Boolean is
	begin
		return Est_Present_Recursive (Liste, Element);
	end Est_Present;
	-- Est_Present STOP DELETE

	----------------------------------------------------------------------------

	-- Supprimer_Recursive START DELETE
	procedure Supprimer_Recursive (Liste: in out T_Liste; Element: in T_Element) is
		A_Detruire: T_Liste;
	begin
		if Liste = null then
			raise Element_Absent_Error;
		elsif Liste.all.Element = Element then
			A_Detruire := Liste;
			Liste := Liste.all.Suivante;
			Free (A_Detruire);
		else
			Supprimer_Recursive (Liste.all.Suivante, Element);
		end if;
	end Supprimer_Recursive;
	-- Supprimer_Recursive STOP DELETE


	-- Supprimer_Iterative START DELETE
	-- SI START DELETE
	procedure Supprimer_Iterative (Liste: in out T_Liste; Element: in T_Element) is
		A_Detruire: T_Liste;
		Curseur: T_Liste;
		Precedent: T_Liste;	-- la cellule qui précède Curseur
	begin
		if Liste = null then
			raise Element_Absent_Error;
		elsif Liste.all.Element = Element then
			-- supprimer le premier élément
			A_Detruire := Liste;
			Liste := Liste.all.Suivante;
			Free (A_Detruire);
		else
			-- Trouver l"élément qui précède celui à supprimer
			Curseur := Liste;
			loop
				Precedent := Curseur;
				Curseur := Curseur.all.Suivante;
				exit when Curseur = null or else Curseur.all.Element = Element;
			end loop;

			if Curseur /= null then
				-- supprimer la Cellule Curseur
				Precedent.all.Suivante := Curseur.all.Suivante;
				Free (Curseur);
			else
				raise Element_Absent_Error;
			end if;
		end if;
	end Supprimer_Iterative;
	-- SI STOP DELETE
	-- Supprimer_Iterative STOP DELETE


	-- Supprimer START DELETE
	procedure Supprimer (Liste: in out T_Liste; Element: in T_Element) is
	begin
		Supprimer_Recursive (Liste, Element);
	end Supprimer;
	-- Supprimer STOP DELETE

	----------------------------------------------------------------------------

	-- Cellule_Contenant_Recursive START DELETE
	function Cellule_Contenant_Recursive (Element: T_Element; Liste: in T_Liste) return T_Liste is
	begin
		if Liste = null then
			raise Element_Absent_Error;
		elsif Liste.all.Element = Element then
			return Liste;
		else
			return Cellule_Contenant_Recursive (Element, Liste.all.Suivante);
		end if;
	end Cellule_Contenant_Recursive;
	-- Cellule_Contenant_Recursive STOP DELETE
	

	-- Cellule_Contenant_Iterative START DELETE
	function Cellule_Contenant_Iterative (Element: T_Element; Liste: in T_Liste) return T_Liste is
		Curseur: T_Liste;
	begin
		Curseur := Liste;
		while Curseur /= null and then Curseur.all.Element /= Element loop
			Curseur := Curseur.all.Suivante;
		end loop;
		if Curseur = null then
			raise Element_Absent_Error;
		else
			return Curseur;
		end if;
	end Cellule_Contenant_Iterative;
	-- Cellule_Contenant_Iterative STOP DELETE
	

	-- Cellule_Contenant START DELETE
	function Cellule_Contenant (Element: T_Element; Liste: in T_Liste) return T_Liste is
	begin
		return Cellule_Contenant_Recursive (Element, Liste);
	end Cellule_Contenant;
	-- Cellule_Contenant STOP DELETE
	
	----------------------------------------------------------------------------

	-- Inserer_Apres START DELETE
	procedure Inserer_Apres (Liste: in out T_Liste ; Nouveau, Element: in T_Element) is
		Reference: T_Liste;
	begin
		Reference := Cellule_Contenant (Element, Liste);
			--! peut lever Element_Absent_Error que l'on laisse se propager.
		Reference.all.Suivante := new T_Cellule'(Nouveau, Reference.all.Suivante);
	end Inserer_Apres;
	-- Inserer_Apres STOP DELETE

	----------------------------------------------------------------------------

	-- Ieme_Recursive START DELETE
	function Ieme_Recursive (Liste: in T_Liste; Indice: in Integer) return T_Element is
	begin
		if Liste = null or Indice < 0 then
			raise Indice_Error;
		elsif Indice = 0 then
			return Liste.all.Element;
		else
			return Ieme_Recursive (Liste.all.Suivante, Indice - 1);
		end if;
	end Ieme_Recursive;
	-- Ieme_Recursive STOP DELETE


	-- Ieme_Iterative START DELETE
	function Ieme_Iterative (Liste: in T_Liste; Indice: in Integer) return T_Element is
		Curseur: T_Liste;
		Index: Integer;
	begin
		Curseur := Liste;
		Index := Indice;
		while Curseur /= null and Index > 0 loop
			Curseur := Curseur.all.Suivante;
			Index := Index - 1;
		end loop;
		if Curseur = null or Index < 0 then
			raise Indice_Error;
		else
			return Curseur.all.Element;
		end if;
	end Ieme_Iterative;
	-- Ieme_Iterative STOP DELETE


	-- Ieme START DELETE
	function Ieme (Liste: in T_Liste; Indice: in Integer) return T_Element is
	begin
		return Ieme_Recursive (Liste, Indice);
	end Ieme;
	-- Ieme STOP DELETE

	----------------------------------------------------------------------------

	-- Supprimer_Ieme_Recursive START DELETE
	procedure Supprimer_Ieme_Recursive (Liste: in out T_Liste; Indice: in Integer) is
		A_Detruire: T_Liste;
	begin
		if Liste = null or Indice < 0 then
			raise Indice_Error;
		elsif Indice = 0 then
			A_Detruire := Liste;
			Liste := Liste.all.Suivante;
			Free (A_Detruire);
		else
			Supprimer_Ieme_Recursive (Liste.all.Suivante, Indice - 1);
		end if;
	end Supprimer_Ieme_Recursive;
	-- Supprimer_Ieme_Recursive STOP DELETE


	-- Supprimer_Ieme_Iterative START DELETE
	procedure Supprimer_Ieme_Iterative (Liste: in out T_Liste; Indice: in Integer) is
		A_Detruire: T_Liste;
		Curseur: T_Liste;
	begin
		if Indice <= 0 then		-- suppression au début ?
			if Indice < 0 or Liste = null then
				raise Indice_Error;
			else
				A_Detruire := Liste;
				Liste := Liste.all.Suivante;
				Free (A_Detruire);
			end if;
		else
			-- Trouver le (I-1)eme élément
			Curseur := Liste;
			for I in 1..Indice - 1 loop
				if Curseur = null then
					raise Indice_Error;
				else
					Curseur := Curseur.all.Suivante;
				end if;
			end loop;

			-- Supprimer l"élément
			if Curseur = null or else Curseur.all.Suivante = null then
				raise Indice_Error;
			else
				A_Detruire := Curseur.all.Suivante;
				Curseur.all.Suivante := A_Detruire.all.Suivante;
				Free (A_Detruire);
			end if;
			
		end if;
	end Supprimer_Ieme_Iterative;
	-- Supprimer_Ieme_Iterative STOP DELETE


	-- Supprimer_Ieme_Iterative_While START DELETE
	procedure Supprimer_Ieme_Iterative_While (Liste: in out T_Liste; Indice: in Integer) is
		A_Detruire: T_Liste;
		Curseur: T_Liste;
		Index: Integer;
	begin
		if Indice <= 0 then		-- suppression au début ?
			if Indice < 0 or Liste = null then
				raise Indice_Error;
			else
				A_Detruire := Liste;
				Liste := Liste.all.Suivante;
				Free (A_Detruire);
			end if;
		else
			-- Trouver le (I-1)eme élément
			Index := 0;
			Curseur := Liste;
			while Curseur /= null and then Index < Indice - 1 loop
				Curseur := Curseur.all.Suivante;
				Index := Index + 1;
			end loop;

			-- Supprimer l"élément
			if Curseur = null or else Curseur.all.Suivante = null then
				raise Indice_Error;
			else
				A_Detruire := Curseur.all.Suivante;
				Curseur.all.Suivante := A_Detruire.all.Suivante;
				Free (A_Detruire);
			end if;
			
		end if;
	end Supprimer_Ieme_Iterative_While;
	-- Supprimer_Ieme_Iterative_While STOP DELETE


	-- Supprimer_Ieme START DELETE
	procedure Supprimer_Ieme (Liste: in out T_Liste; Indice: in Integer) is
	begin
		Supprimer_Ieme_Recursive (Liste, Indice);
	end Supprimer_Ieme;
	-- Supprimer_Ieme STOP DELETE


	---| les tests |------------------------------------------------------------


	procedure Tester is

		-- XXX
		procedure Put is new Afficher (Afficher_Element);


		-- Initialiser une liste [ Un, Trois, Un, Deux].
		-- Elle devra être détruite.
		procedure Initialiser_Liste1312 (Liste: out T_Liste) is
		begin
			Initialiser (Liste);
			Ajouter_Debut (Liste, Deux);
			Ajouter_Debut (Liste, Un);
			Ajouter_Debut (Liste, Trois);
			Ajouter_Debut (Liste, Un);
		end;


		procedure Tester_Initialiser is
			Vide: T_Liste;
		begin
			Initialiser (Vide);
			pragma Assert (Vide = null);
		end Tester_Initialiser;


		procedure Tester_Ajouter_Debut is
			Liste: T_Liste;
		begin
			Initialiser (Liste);

			-- ajouter un premier élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Liste /= null);
			pragma Assert (Liste.all.Suivante = null);
			pragma Assert (Liste.all.Element = Un);

			-- ajouter un deuxième élémnet
			Ajouter_Debut (Liste, Deux);
			pragma Assert (Liste /= null);
			pragma Assert (Liste.all.Element = Deux);
			pragma Assert (Liste.all.Suivante /= null);
			pragma Assert (Liste.all.Suivante.all.Element = Un);
			pragma Assert (Liste.all.Suivante.all.Suivante = null);

			Detruire (Liste);
		end Tester_Ajouter_Debut;


		procedure Tester_Premier is
			Liste: T_Liste;
		begin
			Initialiser (Liste);

			-- ajouter un premier élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Premier (Liste) = Un);

			-- ajouter un deuxième élémnet
			Ajouter_Debut (Liste, Deux);
			pragma Assert (Premier (Liste) = Deux);

			-- ajouter un troisième élémnet
			Ajouter_Debut (Liste, Trois);
			pragma Assert (Premier (Liste) = Trois);

			Detruire (Liste);

		end Tester_Premier;


		generic
			with function Taille (Liste: in T_Liste) return Integer;
		procedure Tester_Taille;

		procedure Tester_Taille is
			Liste: T_Liste;
		begin
			Initialiser (Liste);
			pragma Assert (Taille (Liste) = 0);

			-- ajouter un premier élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Taille (Liste) = 1);

			-- ajouter un deuxième élémnet
			Ajouter_Debut (Liste, Deux);
			pragma Assert (Taille (Liste) = 2);

			-- ajouter un troisième élémnet
			Ajouter_Debut (Liste, Trois);
			pragma Assert (Taille (Liste) = 3);

			-- ajouter un quatirème élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Taille (Liste) = 4);

			Detruire (Liste);
		end Tester_Taille;

		procedure Tester_Taille_Recursive is
			new Tester_Taille (Taille_Recursive);
		procedure Tester_Taille_Iterative is
			new Tester_Taille (Taille_Iterative);


		generic
			with function Est_Present (Liste: in T_Liste; Element: in T_Element) return Boolean;
		procedure Tester_Est_Present;

		procedure Tester_Est_Present is
			Liste: T_Liste;
		begin
			Initialiser (Liste);
			pragma Assert (not Est_Present (Liste, Un));

			-- ajouter un premier élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Est_Present (Liste, Un));
			pragma Assert (not Est_Present (Liste, Deux));

			-- ajouter un deuxième élémnet
			Ajouter_Debut (Liste, Deux);
			pragma Assert (Est_Present (Liste, Un));
			pragma Assert (Est_Present (Liste, Deux));
			pragma Assert (not Est_Present (Liste, Trois));

			-- ajouter un troisième élémnet
			Ajouter_Debut (Liste, Un);
			pragma Assert (Est_Present (Liste, Un));
			pragma Assert (Est_Present (Liste, Deux));
			pragma Assert (not Est_Present (Liste, Trois));

			Detruire (Liste);
		end Tester_Est_Present;

		procedure Tester_Est_Present_Recursive is
			new Tester_Est_Present (Est_Present_Recursive);
		procedure Tester_Est_Present_Recursive_Bis is
			new Tester_Est_Present (Est_Present_Recursive_Bis);
		procedure Tester_Est_Present_Iterative is
			new Tester_Est_Present (Est_Present_Iterative);
		procedure Tester_Est_Present_Avec_Cellule is
			new Tester_Est_Present (Est_Present_Avec_Cellule);



		generic
			with function Cellule_Contenant (Element: in T_Element; Liste: in T_Liste) return T_Liste;
		procedure Tester_Cellule_Contenant;

		procedure Tester_Cellule_Contenant is

			procedure Tester_Existants is
				Liste: T_Liste;
			begin
				Initialiser_Liste1312 (Liste);
				pragma Assert (Cellule_Contenant (Un, Liste) = Liste);
				pragma Assert (Cellule_Contenant (Trois, Liste) = Liste.all.Suivante);
				pragma Assert (Cellule_Contenant (Deux, Liste) = Liste.all.Suivante.all.Suivante.all.Suivante);
				Detruire (Liste);
			end Tester_Existants;

			procedure Tester_Absent (Liste: in T_Liste; Element: in T_Element) is
				Ptr: T_Liste;
			begin
				Ptr := Cellule_Contenant (Element, Liste);
				pragma Assert (False);
				pragma Assert (Ptr = null);	--! pour éviter l'avertissement
			exception
				when Element_Absent_Error =>
					null;
				when others =>
					pragma Assert (False);
			end;

			Liste: T_Liste;
		begin
			Tester_Existants;

			-- tester les cas où l'élément n'est pas présent
			Initialiser (Liste);
			Tester_Absent (Liste, Un);

			Ajouter_Debut (Liste, Deux);
			Tester_Absent (Liste, Un);

			Ajouter_Debut (Liste, Trois);
			Tester_Absent (Liste, Un);

			Detruire (Liste);
		end Tester_Cellule_Contenant;

		procedure Tester_Cellule_Contenant_Recursive is
			new Tester_Cellule_Contenant (Cellule_Contenant_Recursive);
		procedure Tester_Cellule_Contenant_Iterative is
			new Tester_Cellule_Contenant (Cellule_Contenant_Iterative);




		generic
			with procedure Supprimer (Liste: in out T_Liste; Element: in T_Element);
		procedure Tester_Supprimer;

		procedure Tester_Supprimer is 

			procedure Supprimer_Trace (Liste: in out T_Liste; Element: in T_Element) is
			begin
				-- Tracer l'instruction qui va être exécutée
				Put ("> Supprimer (..., ");
				Afficher_Element (Element);
				Put (");");
				New_Line;

				Supprimer (Liste, Element);

				-- Afficher la liste
				Put (Liste);
				New_Line;
				New_Line;
			end Supprimer_Trace;

			procedure Supprimer_Extremites is
				Liste: T_Liste;
			begin
				Initialiser_Liste1312 (Liste);

				New_Line;
				Put_Line ("## Supprimer_Extremites");
				New_Line;
				Put (Liste);
				New_Line;
				New_Line;

				-- supprimer le premier élément
				Supprimer_Trace (Liste, Un);
				pragma Assert (Premier (Liste) = Trois);
				pragma Assert (Taille (Liste) = 3);

				-- supprimer le dernier élément
				Supprimer_Trace (Liste, Deux);
				pragma Assert (Taille (Liste) = 2);

				-- supprimer le dernier élément
				Supprimer_Trace (Liste, Un);
				pragma Assert (Taille (Liste) = 1);

				-- supprimer le seul élément
				Supprimer_Trace (Liste, Trois);
				pragma Assert (Taille (Liste) = 0);

				Detruire (Liste);
			end Supprimer_Extremites;


			procedure Supprimer_Milieu is
				Liste: T_Liste;
			begin
				Initialiser_Liste1312 (Liste);

				New_Line;
				Put_Line ("## Supprimer_Milieu");
				New_Line;
				Put (Liste);
				New_Line;
				New_Line;


				-- supprimer le premier élément
				Supprimer_Trace (Liste, Un);
				pragma Assert (Premier (Liste) = Trois);
				pragma Assert (Taille (Liste) = 3);
				pragma Assert (Est_Present (Liste, Un));
				pragma Assert (Est_Present (Liste, Deux));

				-- supprimer un élément au milieu
				Supprimer_Trace (Liste, Un);
				pragma Assert (Taille (Liste) = 2);
				pragma Assert (Premier (Liste) = Trois);
				pragma Assert (Est_Present (Liste, Deux));

				Detruire (Liste);
			end Supprimer_Milieu;


			procedure Supprimer_Liste_Vide is
				Vide: T_Liste;
			begin
				Initialiser (Vide);
				Supprimer (Vide, Un);
				pragma Assert (False);
			exception
				when Element_Absent_Error =>
					null;
					Detruire (Vide);
				when others =>
					pragma Assert (False);
			end Supprimer_Liste_Vide;


			procedure Supprimer_Liste1_Un_Element_Present is
				Liste: T_Liste;
			begin
				Initialiser (Liste);
				Ajouter_Debut (Liste, Un);
				Supprimer (Liste, Un);
				pragma Assert (Taille(Liste) = 0);
				Detruire (Liste);
			end Supprimer_Liste1_Un_Element_Present;


			procedure Supprimer_Liste1_Un_Element_Absent is
				Liste: T_Liste;
			begin
				Initialiser (Liste);
				Ajouter_Debut (Liste, Un);
				Supprimer (Liste, Deux);
				pragma Assert (False);
			exception
				when Element_Absent_Error =>
					null;
					Detruire (Liste);
				when others =>
					pragma Assert (False);
			end Supprimer_Liste1_Un_Element_Absent;

		begin
			pragma Assert (Un /= Deux);
			pragma Assert (Un /= Trois);
			pragma Assert (Deux /= Trois);

			Supprimer_Liste_Vide;
			Supprimer_Liste1_Un_Element_Present;
			Supprimer_Liste1_Un_Element_Absent;
			Supprimer_Extremites;
			Supprimer_Milieu;
		end;

		procedure Tester_Supprimer_Recursive is
			new Tester_Supprimer(Supprimer_Recursive);
		procedure Tester_Supprimer_Iterative is
			new Tester_Supprimer(Supprimer_Iterative);


		generic
			with function Ieme (Liste: in T_Liste; Indice: in Integer) return T_Element;
		procedure Tester_Ieme;

		procedure Tester_Ieme is

			procedure Tester_Nominal is
				Liste: T_Liste;
			begin
				Initialiser_Liste1312 (Liste);
				pragma Assert (Ieme (Liste, 0) = Un);
				pragma Assert (Ieme (Liste, 1) = Trois);
				pragma Assert (Ieme (Liste, 2) = Un);
				pragma Assert (Ieme (Liste, 3) = Deux);
				Detruire (Liste);
			end Tester_Nominal;

			procedure Tester_Indice_Invalide (Liste: in T_Liste; Indice: in Integer) is
				Element: T_Element;
			begin
				Element := Ieme (Liste, Indice);
				pragma Assert (False);
				pragma Assert (Element = Un);	-- pour eviter le warning
			exception
				when Indice_Error =>
					null;
				when others =>
					pragma Assert (False);
			end Tester_Indice_Invalide;


			Vide: T_Liste;
			Liste: T_Liste;
		begin
			Tester_Nominal;


			Initialiser (Vide);
			Tester_Indice_Invalide (Vide, 0);
			Tester_Indice_Invalide (Vide, -1);
			Tester_Indice_Invalide (Vide, 1);
			Detruire (Vide);

			Initialiser_Liste1312 (Liste);
			Tester_Indice_Invalide (Vide, 4);
			Tester_Indice_Invalide (Vide, 10);
			Tester_Indice_Invalide (Vide, -1);
			Tester_Indice_Invalide (Vide, -10);
			Detruire (Liste);

		end Tester_Ieme;

		procedure Tester_Ieme_Recursive is
			new Tester_Ieme (Ieme_Recursive);
		procedure Tester_Ieme_Iterative is
			new Tester_Ieme (Ieme_Iterative);



		procedure Tester_Inserer_Apres is

			procedure Test_Nominal is
				Liste: T_Liste;
			begin
				Initialiser (Liste);

				Ajouter_Debut (Liste, Un);
				Inserer_Apres (Liste, Deux, Un);

				pragma Assert (Taille (Liste) = 2);
				pragma Assert (Premier (Liste) = Un);
				pragma Assert (Liste.all.Suivante.all.Element = Deux);

				Inserer_Apres (Liste, Un, Deux);
				pragma Assert (Taille (Liste) = 3);
				pragma Assert (Premier (Liste) = Un);
				pragma Assert (Liste.all.Suivante.all.Element = Deux);
				pragma Assert (Liste.all.Suivante.all.Suivante.all.Element = Un);

				Inserer_Apres (Liste, Trois, Un);

				pragma Assert (Taille (Liste) = 4);
				pragma Assert (Premier (Liste) = Un);
				pragma Assert (Liste.all.Suivante.all.Element = Trois);
				pragma Assert (Liste.all.Suivante.all.Suivante.all.Element = Deux);

				Detruire (Liste);
			end Test_Nominal;

			procedure Test_Erreur (Liste: in out T_Liste; Element: in T_Element) is
			begin
				Inserer_Apres (Liste, Un, Element);
				pragma Assert (False);
			exception
				when Element_Absent_Error =>
					null;
				when others =>
					pragma Assert (False);
			end Test_Erreur;

			Liste: T_Liste;
		begin
			Test_Nominal;

			-- Tests erreurs
			Initialiser (Liste);

			for I in 1..10 loop
				Test_Erreur (Liste, Deux);
				Ajouter_Debut (Liste, Un);
			end loop;
			Detruire (Liste);
		end Tester_Inserer_Apres;


		generic
			with procedure Supprimer_Ieme (Liste: in out T_Liste; Indice: in Integer);
		procedure Tester_Supprimer_Ieme;

		procedure Tester_Supprimer_Ieme is 

			procedure Supprimer_Ieme_Trace (Liste: in out T_Liste; Indice: in Integer) is
			begin
				-- Tracer l'instruction qui va être exécutée
				Put ("> Supprimer_Ieme (..., ");
				Put (Indice, 1);
				Put (");");
				New_Line;

				Supprimer_Ieme (Liste, Indice);

				-- Afficher la liste
				Put (Liste);
				New_Line;
				New_Line;
			end Supprimer_Ieme_Trace;

			procedure Supprimer_Ieme_Nominal is
				Liste: T_Liste;
			begin
				Initialiser_Liste1312 (Liste);

				New_Line;
				Put_Line ("## Supprimer_Ieme_Nominal");
				New_Line;
				Put (Liste);
				New_Line;
				New_Line;

				-- supprimer au milieu
				Supprimer_Ieme_Trace (Liste, 2);
				pragma Assert (Taille (Liste) = 3);
				pragma Assert (Est_Present (Liste, Un));
				pragma Assert (Est_Present (Liste, Deux));
				pragma Assert (Est_Present (Liste, Trois));

				-- supprimer le dernier élément
				Supprimer_Ieme_Trace (Liste, 2);
				pragma Assert (Taille (Liste) = 2);
				pragma Assert (Est_Present (Liste, Un));
				pragma Assert (not Est_Present (Liste, Deux));
				pragma Assert (Est_Present (Liste, Trois));

				-- supprimer le premier élément
				Supprimer_Ieme_Trace (Liste, 0);
				pragma Assert (Taille (Liste) = 1);
				pragma Assert (Premier (Liste) = Trois);

				-- supprimer le seul élément
				Supprimer_Ieme_Trace (Liste, 0);
				pragma Assert (Taille (Liste) = 0);

				Detruire (Liste);
			end Supprimer_Ieme_Nominal;


			procedure Supprimer_Ieme_Erreur (Liste: in out T_Liste; Indice: in Integer) is
			begin
				Supprimer_Ieme (Liste, Indice);
				pragma Assert (False);
			exception
				when Indice_Error =>
					null;
				when others =>
					pragma Assert (False);
			end Supprimer_Ieme_Erreur;

			Liste: T_Liste;
		begin
			Supprimer_Ieme_Nominal;

			Initialiser (Liste);
			Supprimer_Ieme_Erreur (Liste, 0);
			Supprimer_Ieme_Erreur (Liste, -1);
			Supprimer_Ieme_Erreur (Liste, 1);
			Detruire (Liste);

			Initialiser_Liste1312 (Liste);
			Supprimer_Ieme_Erreur (Liste, Taille (Liste));
			Supprimer_Ieme_Erreur (Liste, -1);
			Detruire (Liste);

		end Tester_Supprimer_Ieme;

		procedure Tester_Supprimer_Ieme_Recursive is
			new Tester_Supprimer_Ieme(Supprimer_Ieme_Recursive);
		procedure Tester_Supprimer_Ieme_Iterative is
			new Tester_Supprimer_Ieme(Supprimer_Ieme_Iterative);
		procedure Tester_Supprimer_Ieme_Iterative_While is
			new Tester_Supprimer_Ieme(Supprimer_Ieme_Iterative_While);



	begin
		pragma Assert (Un /= Deux);
		pragma Assert (Un /= Trois);
		pragma Assert (Deux /= Trois);

		Tester_Initialiser;
		Tester_Ajouter_Debut;
		Tester_Premier;

		Tester_Taille_Recursive;
		Tester_Taille_Iterative;

		Tester_Est_Present_Recursive;
		Tester_Est_Present_Recursive_Bis;
		Tester_Est_Present_Iterative;
		Tester_Est_Present_Avec_Cellule;

		Tester_Supprimer_Recursive;
		Tester_Supprimer_Iterative;

		Tester_Cellule_Contenant_Recursive;
		Tester_Cellule_Contenant_Iterative;

		Tester_Inserer_Apres;

		Tester_Ieme_Recursive;
		Tester_Ieme_Iterative;

		Tester_Supprimer_Ieme_Recursive;
		Tester_Supprimer_Ieme_Iterative;
		Tester_Supprimer_Ieme_Iterative_While;
	end Tester;

end Listes;
