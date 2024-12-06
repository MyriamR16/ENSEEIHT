import java.util.concurrent.Semaphore;
import Synchro.Simulateur;

public class StrategiePhiloPremiereApprocheSansInterblocage1 implements StrategiePhilo {

    private Semaphore[] fourchettes;

    public StrategiePhiloPremiereApprocheSansInterblocage1 (int nbPhilosophes) {
        this.fourchettes = new Semaphore[nbPhilosophes];
        for (int i=0; i<nbPhilosophes; i++){
            this.fourchettes[i] = new Semaphore(1);
        }
    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes (int no) throws InterruptedException
    {
        int fg = Main.FourchetteGauche(no);
        int fd = Main.FourchetteDroite(no);   

        //le premier philosphie demande la fourchette de gauche d'abord et les autres demandent celle de droite d'abord
        if (no == 0) {
            this.fourchettes[fg].acquire();
            IHMPhilo.poser(fg, EtatFourchette.AssietteDroite);
            Thread.sleep(400);
            this.fourchettes[fd].acquire();
            IHMPhilo.poser(fd, EtatFourchette.AssietteGauche);
        } else {
            this.fourchettes[fd].acquire();
            IHMPhilo.poser(fd, EtatFourchette.AssietteGauche);
            Thread.sleep(400);
            this.fourchettes[fg].acquire();
            IHMPhilo.poser(fg, EtatFourchette.AssietteDroite);
        }
    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes (int no)
    {
        int fg = Main.FourchetteGauche(no);
        int fd = Main.FourchetteDroite(no);                   
        this.fourchettes[fd].release();
        IHMPhilo.poser(fd, EtatFourchette.Table);
        this.fourchettes[fg].release();
        IHMPhilo.poser(fg, EtatFourchette.Table);

    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Implantation Sémaphores, stratégie : les fourchettes sont des ressources critiques.";
    }

}