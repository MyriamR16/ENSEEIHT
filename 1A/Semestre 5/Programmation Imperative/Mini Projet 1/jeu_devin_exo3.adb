with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;
with Alea;
with Jeu_Devin_Exo1;
with Jeu_Devin_Exo2;

-- Auteur : Rahma

procedure Jeu_Devin_Exo3 is
    Mode_choisi : Integer ;   --Le mode de jeu auquel veut jouer l'utilisateur
begin
    --Afficher le menu du jeu
    Put("Choisissez votre mode de jeu : 1 si l'ordinateur choisit le nombre et vous devinez, 2 si c'est l'inverse et 0 si vous voulez quitter le jeu ");
    Get(Mode_choisi);
    
    --Appliquer le mode de jeu choisi par l'utilisateur
    While Mode_choisi /= 0 loop
        if Mode_choisi = 1 then
            
            --Faire deviner à l'utilisateur le nombre choisi par l'ordinateur
            Jeu_Devin_Exo1;
            New_Line;
            Put("Choisissez votre mode de jeu : 1 si l'ordinateur choisit le nombre et vous devinez, 2 si c'est l'inverse et 0 si vous voulez quitter le jeu ");
            Get(Mode_choisi);
            
        elsif Mode_choisi = 2 then
            --Deviner le nombre choisit par l'utilisateur
            Jeu_Devin_Exo2;
            New_Line;
            Put("Choisissez votre mode de jeu : 1 si l'ordinateur choisit le nombre et vous devinez, 2 si c'est l'inverse et 0 si vous voulez quitter le jeu ");
            Get(Mode_choisi);
        end if;
    end loop;
    
    --Quitter
    null;
end Jeu_Devin_Exo3;
