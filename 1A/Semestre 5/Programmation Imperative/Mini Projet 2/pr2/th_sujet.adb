with Ada.Text_IO;           use Ada.Text_IO;
with Ada.Integer_Text_IO;   use Ada.Integer_Text_IO;
with Ada.Strings.Unbounded; use Ada.Strings.Unbounded;
with TH;

procedure th_sujet  is

    function fonction_de_hachage (Cle : in Unbounded_String) return Integer is
    begin
        return Length(Cle);
    end fonction_de_hachage;

    package TH_instancie is new TH (T_Cle => Unbounded_String, T_Valeur => Integer, Capacite=>11, fonction_de_hachage=>fonction_de_hachage);
    use TH_instancie ;

    procedure Afficher_Cle (Cle : in Unbounded_String) is
    begin
        Put(To_String(Cle));
    end Afficher_Cle;

    procedure Afficher_Donnee (Valeur : in Integer) is
    begin
        Put(Valeur,1);
    end Afficher_Donnee;

    procedure Afficher_Debug_1 is new Afficher_Debug(Afficher_Cle => Afficher_Cle , Afficher_Donnee=>Afficher_Donnee);
    Tableau : T_Tableau ;

begin
    Initialiser(Tableau);
    Enregistrer(Tableau , To_Unbounded_String("un"), 1);
    Enregistrer(Tableau , To_Unbounded_String("deux"), 2);
    Enregistrer(Tableau , To_Unbounded_String("trois"), 3);
    Enregistrer(Tableau , To_Unbounded_String("quatre"), 4);
    Enregistrer(Tableau , To_Unbounded_String("cinq"), 5);
    Enregistrer(Tableau , To_Unbounded_String("quatre-vingt-dix-neuf"), 99);
    Enregistrer(Tableau , To_Unbounded_String("vingt-et-un"), 21);
    Afficher_Debug_1(Tableau);
end th_sujet;
