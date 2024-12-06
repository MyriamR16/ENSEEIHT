import java.util.concurrent.Semaphore;
import Synchro.Simulateur;

public class StrategiePhiloPremiereApprocheSansInterblocage2 implements StrategiePhilo {

    private Semaphore[] fourchettes;
    private Semaphore mutex; 
    
    public StrategiePhiloPremiereApprocheSansInterblocage2(int nbPhilosophes) {
        this.fourchettes = new Semaphore[nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++) {
            this.fourchettes[i] = new Semaphore(1);
        }
        this.mutex = new Semaphore(1); // Initialiser le sémaphore pour un accès exclusif
    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes(int no) throws InterruptedException {
        int fg = Main.FourchetteGauche(no);
        int fd = Main.FourchetteDroite(no);

        mutex.acquire();

        try {
            this.fourchettes[fg].acquire(); 
            IHMPhilo.poser(fg, EtatFourchette.AssietteDroite);
            Thread.sleep(400); 
            this.fourchettes[fd].acquire(); 
            IHMPhilo.poser(fd, EtatFourchette.AssietteGauche);
        } finally {
            mutex.release(); 
        }
    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes(int no) {
        int fg = Main.FourchetteGauche(no);
        int fd = Main.FourchetteDroite(no);                   
        this.fourchettes[fg].release();
        IHMPhilo.poser(fg, EtatFourchette.Table);
        this.fourchettes[fd].release();
        IHMPhilo.poser(fd, EtatFourchette.Table);
    }

    /** Nom de cette stratégie (pour la fenêtre d'affichage). */
    public String nom() {
        return "Implantation Sémaphores, stratégie : limiter le nombre de philosophes qui mangent simultanément.";
    }
}
