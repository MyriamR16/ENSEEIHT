with Ada.Text_IO; use Ada.Text_IO;
with Reel;         use Reel;

procedure Test_Reel is

   Mon_Reel : T_Reel := 3.1447854345678544567;
   Fichier : File_Type;

begin

   -- Afficher le reel
   Afficher_Reel(Mon_Reel);

   -- Ecrire le reel dans un fichier
   Open(Fichier,Out_File, "reel.txt");
   Ecrire_Reel_Fichier(Fichier, Mon_Reel);
   Close(Fichier);

end Test_Reel;
