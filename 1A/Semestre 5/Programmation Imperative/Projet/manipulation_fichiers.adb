with Ada.Text_IO;			use Ada.Text_IO;
with Ada.Integer_Text_IO;	use Ada.Integer_Text_IO;


package body Manipulation_fichiers is


   procedure Creer_Fichier ( Nom_Fichier : in out Unbounded_String; Extension : in Unbounded_String ) is
      File : Ada.Text_IO.File_Type;
   begin

      Append(Nom_Fichier, Extension);
      Create(File, Out_File, To_String(Nom_Fichier));
      Close(File);

   end Creer_Fichier;


    procedure Nombre_Noeuds (Fichier : in Unbounded_String ; N : out Integer) is
        File : Ada.Text_IO.File_Type;
    begin
        Open (File, In_File, To_String(Fichier));

        -- La valeur de N est donnée au début du fichier
        Get (File, N);

        -- N est le nombre de noeuds, il ne peut pas être négatif ou nul
        if N <= 0 then
            raise N_Non_Conforme_Exception;
        end if;
        Close (File);

    end Nombre_Noeuds ;


end Manipulation_fichiers;
