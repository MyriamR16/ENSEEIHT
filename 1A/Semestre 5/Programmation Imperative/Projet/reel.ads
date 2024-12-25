with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with Ada.Text_IO;			use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;

package Reel is

    type T_Reel is digits 5;

    procedure Afficher_Reel( r: in T_Reel );

    procedure Ecrire_Reel_Fichier(Fichier: Ada.Text_IO.File_Type; r: in T_Reel );

end Reel;
