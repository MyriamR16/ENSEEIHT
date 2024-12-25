import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


public class Allocateur_petitsDemandeurs implements Allocateur {

    // Nombre de ressources actuellement disponibles
    // invariant 0 <= nbLibres <= nbRessources
    private int nbLibres;

    // Protection des variables partagées
    private Lock moniteur;

    // Une condition de blocage commune à tous
    private Condition acces; 

    private Condition[] classe;

    /** Initilialise un nouveau gestionnaire de ressources pour nbRessources. */
    public Allocateur_petitsDemandeurs(int nbRessources) {
        this.nbLibres = nbRessources;
        this.moniteur = new ReentrantLock();
        this.acces = moniteur.newCondition();
    }

    /** Demande à obtenir `demande' ressources. */
    public void allouer(int demande) throws InterruptedException {
        moniteur.lock();
        while (demande > nbLibres) { // while nécessaire : pas de contrôle de l'utilité du réveil.
            acces.await();
        }
        nbLibres -= demande;
        moniteur.unlock();
    }

    /** Libère `rendu' ressources. */
    public void liberer(int rendu) {
        moniteur.lock();
        nbLibres += rendu;
        acces.signalAll(); // réveille TOUS les demandeurs, beurk !
        moniteur.unlock();
    }

    /** Chaîne décrivant la stratégie d'allocation. */
    public String nomStrategie() {
        return "Vraiment n'importe comment";
    }

}
