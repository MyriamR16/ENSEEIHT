with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;

package Manipulation_fichiers is

   N_Non_Conforme_Exception : Exception;

   procedure Creer_Fichier ( Nom_Fichier : in out Unbounded_String; Extension : in Unbounded_String );
   procedure Nombre_Noeuds (Fichier : in Unbounded_String ; N : out Integer);

end Manipulation_fichiers;
