with Ada.Text_IO;
use  Ada.Text_IO;
with Ada.Integer_Text_IO;
use  Ada.Integer_Text_IO;


procedure Exemple_Dates_Bis is

	-- Spécification d'un module Dates très simplifié.
	--
	-- Attention : Bien gérer les dates est compliqué. Les dates et opérations
	-- associées sont disponibles dans les bibliothèques des langages de
	-- programmation. Par exemple dans le paquetage Ada.Calendar pour Ada.

	package Dates is

		type T_Mois is (JANVIER, FEVRIER, MARS, AVRIL, MAI, JUIN, JUILLET,
						AOUT, SEPTEMBRE, OCTOBRE, NOVEMBRE, DECEMBRE);

		type T_Date is private;

		-- Initialiser une date à partir du jour, du mois et de l'année.
		--
		-- Paramètres :
		--     Date : la date à initialiser
		--     Jour : la valeur du jour
		--     Mois : la valeur du mois
		--     Annee : la valeur de l'année
		--
		--  Nécessite :
		--     Jour/Mois/Annee constituent une date valide
		--
		--  Assure
		--     Le_Jour (Date) = Jour
		--     Le_Mois (Date) = Mois
		--     L_Annee (Date) = Annee
		--
		procedure Initialiser ( Date  : out T_Date  ;
								Jour  : in  Integer ;
								Mois  : in  T_Mois  ;
								Annee : in  Integer )
		with
			Pre => Annee >= 0 and Jour >= 1 and Jour <= 31, -- simplifiée !
			Post => Le_Jour (Date) = Jour and Le_Mois (Date) = Mois and L_Annee (Date) = Annee;

		-- Afficher une date sous la forme jj/mm/aaaa
		procedure Afficher (Date : in T_Date);

		-- Obtenir le mois d'une date.
		-- Paramètres
		--     Date : la date dont on veut obtenir le moi
		function Le_Mois (Date : in T_Date) return T_Mois;

		-- Obtenir le jour d'une date.
		-- Paramètres
		--     Date : la date dont on veut obtenir le jour
		function Le_Jour (Date : in T_Date) return Integer;

		-- Obtenir l'année d'une date.
		-- Paramètres
		--     Date : la date dont on veut obtenir l'année
		function L_Annee (Date : in T_Date) return Integer;


	private

		type T_Date is
			record
				Jour : Integer;
				Mois : T_Mois;
				Annee : Integer;
				-- Invariant
				--    Annee > 0
				--    Jour >= 1
				--    Jour <= Nombre_Jours (Mois, Annee)
			end record;

	end Dates;


	-- Implantation d'un module Dates très simplifié.

	package body Dates is

		procedure Initialiser ( Date  : out T_Date  ;
								Jour  : in  Integer ;
								Mois  : in  T_Mois  ;
								Annee : in  Integer ) is
		begin
			Date.Jour := Jour;
			Date.Mois := Mois;
			Date.Annee := Annee;
		end Initialiser;

		-- Afficher un entier sur 2 positons au moins (avec des zéros
		-- supplémentaires si nécessaires)
		--
		-- Paramètres :
		--     Nombre : le nombre à afficher
		--
		-- Nécessite :
		--     Nombre >= 0
		--
		procedure Afficher_Deux_Positions (Nombre : in Integer) with
			Pre => Nombre >= 0
		is
		begin
			Put (Nombre / 10, 1);
			Put (Nombre mod 10, 1);
		end Afficher_Deux_Positions;

		procedure Afficher (Date : in T_Date) is
		begin
			Afficher_Deux_Positions (Date.Jour);
			Put ('/');
			Afficher_Deux_Positions (T_Mois'pos (Date.Mois) + 1);
			Put ('/');
			Afficher_Deux_Positions (Date.Annee / 100);
			Afficher_Deux_Positions (Date.Annee mod 100);
		end Afficher;


		function Le_Jour (Date : in T_Date) return Integer is
		begin
			return Date.Jour;
		end Le_Jour;


		function Le_Mois(Date : in T_Date) return T_Mois is
		begin
			return Date.Mois;
		end Le_Mois;


		function L_Annee (Date : in T_Date) return Integer is
		begin
			return Date.Annee;
		end L_Annee;


	end Dates;

	use Dates;

    Une_Date : T_Date;
begin
    -- Initialiser une date
    Initialiser (Une_Date, 1, OCTOBRE, 2018);

    -- L'afficher
    Afficher (Une_Date);
    New_Line;
end Exemple_Dates_Bis;
