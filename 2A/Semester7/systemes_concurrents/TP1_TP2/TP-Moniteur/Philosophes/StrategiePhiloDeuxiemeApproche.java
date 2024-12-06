import java.util.concurrent.Semaphore;
import Synchro.Simulateur;

public class StrategiePhiloDeuxiemeApproche implements StrategiePhilo {

    private Semaphore[] fourchettes; 
    private Semaphore mutex; 
    private EtatPhilosophe[] etat;

    /****************************************************************/

    public StrategiePhiloDeuxiemeApproche(int nbPhilosophes) {
        this.etat = new EtatPhilosophe[nbPhilosophes];
        this.fourchettes = new Semaphore[nbPhilosophes];
        this.mutex = new Semaphore(1); 

        for (int i = 0; i < nbPhilosophes; i++) {
            etat[i] = EtatPhilosophe.Pense;
            fourchettes[i] = new Semaphore(1); 
        }
    }

    /** Le philosophe no demande les fourchettes.
     *  Précondition : il n'en possède aucune.
     *  Postcondition : quand cette méthode retourne, il possède les deux fourchettes adjacentes à son assiette. */
    public void demanderFourchettes(int no) throws InterruptedException {
        mutex.acquire(); 

        etat[no] = EtatPhilosophe.Demande;
        int philoGauche = Main.PhiloGauche(no);
        int philoDroite = Main.PhiloDroite(no);

        while (etat[philoGauche] == EtatPhilosophe.Mange || etat[philoDroite] == EtatPhilosophe.Mange) {
            mutex.release(); 
            Thread.sleep(100); 
            mutex.acquire(); 
        }

        etat[no] = EtatPhilosophe.Mange;

        fourchettes[Main.FourchetteGauche(no)].acquire();
        IHMPhilo.poser(Main.FourchetteGauche(no), EtatFourchette.AssietteDroite);
        fourchettes[Main.FourchetteDroite(no)].acquire();
        IHMPhilo.poser(Main.FourchetteDroite(no), EtatFourchette.AssietteGauche);

        mutex.release(); 
    }

    /** Le philosophe no rend les fourchettes.
     *  Précondition : il possède les deux fourchettes adjacentes à son assiette.
     *  Postcondition : il n'en possède aucune. Les fourchettes peuvent être libres ou réattribuées à un autre philosophe. */
    public void libererFourchettes(int no) throws InterruptedException{
        mutex.acquire(); 

        fourchettes[Main.FourchetteGauche(no)].release(); 
        IHMPhilo.poser(Main.FourchetteGauche(no), EtatFourchette.Table); 
        fourchettes[Main.FourchetteDroite(no)].release();
        IHMPhilo.poser(Main.FourchetteDroite(no), EtatFourchette.Table); 

        etat[no] = EtatPhilosophe.Pense; 
        
        mutex.release(); 
    }

    public String nom() {
        return "Implantation Sémaphores, stratégie : Deuxième approche.";
    }
}
