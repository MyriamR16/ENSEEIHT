with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;
with Alea;

-- Auteur : Rahma

procedure Jeu_Devin_Exo1 is
    Compteur : Integer:=0 ;   --Va permettre de savoir en combien de tentative l'utilisateur devine
    Nombre_uti :Integer ;     --Le nombre proposé par l'utilisateur
    Nombre_ordi : Integer ;   --Le nombre à deviner
    
    package Mon_Alea is
            new Alea (1, 999);
            -- Les nombres aléatoires seront dans [1..999]
    use Mon_Alea; -- on peut alors utiliser Get_Random_Number

begin
    --Faire deviner a l'utilisateur le nombre choisi par l'ordinateur
    --Choisir un nombre aléatoire entre 1 et 999
    Get_Random_Number(Nombre_ordi);
    Put("J'ai choisi un nombre aléatoire entre 1 et 999 ");
    
    --Demander à l'utilisateur de deviner 
    loop
        --Lire le nombre choisi par l'utilisateur 
        Put("Proposition"); 
        Put(Compteur,2);
        Put(" ");
        Get(Nombre_uti);
        
        --Determiner si le nombre deviné est plus petit, plus grand ou egal au nombre choisi
        if Nombre_uti>Nombre_ordi then 
            Put("Trop grand ");           --Si "trop grand" c'est que le nombre ordi est plus petit et il faut baisser
            New_Line;
        elsif Nombre_ordi > Nombre_uti then 
            Put("Trop petit ");
            New_Line;
        elsif Nombre_uti=Nombre_ordi then 
            Put("Trouvé : ");
            New_Line;
        else 
            Put("Vous devez saisir un nombre entre 1 et 999 ");
        end if;
        Compteur := Compteur+1;
    exit when Nombre_ordi = Nombre_uti ;
    end loop;     
             
    --Afficher le nombre d'eesais réalisés par l'utilisateur après avoir deviné le nombre 
    Put("Bravo, vous avez trouvé ");
    Put(Nombre_ordi,2); 
    Put(" en "); 
    Put(Compteur,2);
    Put(" essais");

end Jeu_Devin_Exo1;
