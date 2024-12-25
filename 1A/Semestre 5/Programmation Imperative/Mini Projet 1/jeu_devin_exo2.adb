with Text_Io;              use Text_Io;
with Ada.Integer_Text_Io;  use Ada.Integer_Text_Io;
with Alea;

-- Auteur : Myriam

procedure Jeu_Devin_Exo2 is
    Reponse : Character ;     --La réponse de l'utilisateur pour savoir si il a choisit un nombre
    Mini : Integer := 1;      -- La borne inf pour la dichotomie
    Maxi : Integer :=999;     --La borne sup pour la dichotomie
    Compteur : Integer :=0;   --Compte le nombre de tentative avant d'avoir deviné
    Milieu : Integer ;        --Milieu des deux bornes pour la dichotomie
    Nombre_ordi : Integer;    --Nombre proposé par l'ordinateur pour essayer de deviner
    Indication : character ;  --Indication de l'utilisateur quant au nombre proposé par l'ordi

begin
    -- Faire deviner a l ordinateur un entier entre 1 et 999 choisi par l utilisateur
    Put_Line("Avez-vous choisi un nombre entre 1 et 999 (o/n) ?");
    Get(Reponse);

    -- Demander a l utilisateur si il a choisi un nombre
    While Reponse /= 'o' loop
        Put("J'attends...");
        New_Line;
        Put_Line("Avez-vous choisi un nombre entre 1 et 999 (o/n) ? ");
        Get(Reponse);
    end loop;

    -- Deviner le nombre choisi par l utilisateur entre Mini et Maxi
    loop
        
        --Proposer un Nombre_ordi
        Milieu := (Mini+Maxi)/2;
        Nombre_ordi:=Milieu;
        Put(Nombre_ordi);
        Compteur := Compteur +1 ;
        --Demander une indication a l utilisateur
        loop
            Put_Line ("Trop (g)rand, trop (p)etit, (t)rouvé ?");
            Get(Indication);
        exit when (Indication ='t') or (Indication ='T') or (Indication ='p') or (Indication ='P') or (Indication ='g') or (Indication ='G');
        end loop;

        -- Mettre à jour Mini et Maxi suivant l'indication
        if (Indication = 'p') or (Indication = 'P') then   
            Mini := Milieu + 1 ;
        elsif (Indication = 'g') or (Indication ='G') then
            Maxi := Milieu- 1;
        end if;
    exit when (Indication ='t') or (Indication='T') or (Mini>Maxi);
    end loop;

    -- Donner le resultat
    if Mini > Maxi then
        Put_Line("Vous trichez!");
        
    else
        --Afficher que le nombre est trouvé
        Put("J'ai trouvé le nombre  ");
        Put(Nombre_ordi,2);
        Put(" en ");
        Put(Compteur, 2);
        Put(" Etapes");
    end if;

end Jeu_Devin_Exo2;
