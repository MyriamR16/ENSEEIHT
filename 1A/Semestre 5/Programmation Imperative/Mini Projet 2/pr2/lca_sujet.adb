with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with LCA;

procedure lca_sujet  is
    package LCA_instancie is new LCA (T_Cle => Unbounded_String, T_Valeur => Integer);
    use LCA_instancie ;
    
    procedure Afficher ( Cle : in Unbounded_String; Valeur: in Integer) is
    begin
        Put("--> [ ");
        Put(To_String(Cle));
        Put(":");
        Put(Valeur,2);
        Put("] ");
    end Afficher ;
    procedure Pour_Chaque_instancie is new Pour_Chaque (Afficher);
    Sda : T_LCA ;

begin
    Initialiser(Sda);
    Enregistrer(Sda , To_Unbounded_String("un"), 1);
    Enregistrer(Sda, To_Unbounded_String("deux") , 2);
    Pour_Chaque_instancie(Sda);
    Put("--E");
end lca_sujet;
