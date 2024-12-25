with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Float_Text_IO;   use Ada.Float_Text_IO;
with Ada.Numerics.Elementary_Functions; use Ada.Numerics.Elementary_Functions;
with Ada.Numerics; use Ada.Numerics;
with Ada.Unchecked_Deallocation;


package body Reel is

    procedure Afficher_Reel( r: in T_Reel ) is
    begin
        Put(T_Reel'Image(r));
    end Afficher_Reel;

    procedure Ecrire_Reel_Fichier(Fichier: Ada.Text_IO.File_Type; r: in T_Reel ) is
    begin
        Put ( Fichier, T_Reel'Image(r));
    end Ecrire_Reel_Fichier;


end Reel;
