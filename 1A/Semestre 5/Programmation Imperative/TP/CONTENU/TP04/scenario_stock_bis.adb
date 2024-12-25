with Ada.Text_IO;          use Ada.Text_IO;
-- with Ada.Integer_Text_IO;  use Ada.Integer_Text_IO;
-- with Stocks_Materiel;      use Stocks_Materiel;

-- Auteur: 
-- Gérer un stock de matériel informatique.
--
procedure Scenario_Stock_Bis is


	------------------------------------------------------ Specification
	-- Auteur: 
	-- Gérer un stock de matériel informatique.

	package Stocks_Materiel is


		CAPACITE : constant Integer := 10;      -- nombre maximum de matériels dans un stock

		type T_Nature is (UNITE_CENTRALE, DISQUE, ECRAN, CLAVIER, IMPRIMANTE);


		type T_Stock is limited private;


		-- Créer un stock vide.
		--
		-- paramètres
		--     Stock : le stock à créer
		--
		-- Assure
		--     Nb_Materiels (Stock) = 0
		--
		procedure Creer (Stock : out T_Stock) with
			Post => Nb_Materiels (Stock) = 0;


		-- Obtenir le nombre de matériels dans le stock Stock.
		--
		-- Paramètres
		--    Stock : le stock dont ont veut obtenir la taille
		--
		-- Nécessite
		--     Vrai
		--
		-- Assure
		--     Résultat >= 0 Et Résultat <= CAPACITE
		--
		function Nb_Materiels (Stock: in T_Stock) return Integer with
			Post => Nb_Materiels'Result >= 0 and Nb_Materiels'Result <= CAPACITE;

		-- Enregistrer un nouveau métériel dans le stock.  Il est en
		-- fonctionnement.  Le stock ne doit pas être plein.
		-- 
		-- Paramètres
		--    Stock : le stock à compléter
		--    Numero_Serie : le numéro de série du nouveau matériel
		--    Nature       : la nature du nouveau matériel
		--    Annee_Achat  : l'année d'achat du nouveau matériel
		-- 
		-- Nécessite
		--    Nb_Materiels (Stock) < CAPACITE
		-- 
		-- Assure
		--    Nouveau matériel ajouté
		--    Nb_Materiels (Stock) = Nb_Materiels (Stock)'Avant + 1
		procedure Enregistrer (
				Stock        : in out T_Stock;
				Numero_Serie : in     Integer;
				Nature       : in     T_Nature;
				Annee_Achat  : in     Integer
			) with
				Pre => Nb_Materiels (Stock) < CAPACITE,
				Post => Nb_Materiels (Stock) = Nb_Materiels (Stock)'Old + 1;

	end Stocks_Materiel;



	------------------------------------------------------ Body
	-- Auteur: 
	-- Gérer un stock de matériel informatique.
	--
	package body Stocks_Materiel is

		procedure Creer (Stock : out T_Stock) is
		begin
			null;
		end Creer;


		function Nb_Materiels (Stock: in T_Stock) return Integer is
		begin
			return -1;
		end;


		procedure Enregistrer (
				Stock        : in out T_Stock;
				Numero_Serie : in     Integer;
				Nature       : in     T_Nature;
				Annee_Achat  : in     Integer
			) is
		begin
			null;
		end;


	end Stocks_Materiel;


	use Stocks_Materiel;

	------------------------------------------------------ Programme


    Mon_Stock : T_Stock;
begin
    -- Créer un stock vide
    Creer (Mon_Stock);
    pragma Assert (Nb_Materiels (Mon_Stock) = 0);

    -- Enregistrer quelques matériels
    Enregistrer (Mon_Stock, 1012, UNITE_CENTRALE, 2016);
    pragma Assert (Nb_Materiels (Mon_Stock) = 1);

    Enregistrer (Mon_Stock, 2143, ECRAN, 2016);
    pragma Assert (Nb_Materiels (Mon_Stock) = 2);

    Enregistrer (Mon_Stock, 3001, IMPRIMANTE, 2017);
    pragma Assert (Nb_Materiels (Mon_Stock) = 3);

    Enregistrer (Mon_Stock, 3012, UNITE_CENTRALE, 2017);
    pragma Assert (Nb_Materiels (Mon_Stock) = 4);

    -- Signaler la fin du test
    Put("Scénario réussi.");

end Scenario_Stock_Bis;
