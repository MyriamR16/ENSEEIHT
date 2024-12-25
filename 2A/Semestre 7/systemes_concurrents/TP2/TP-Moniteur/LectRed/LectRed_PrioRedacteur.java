// Time-stamp: <28 oct 2022 09:24 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioRedacteur implements LectRed
{
    private boolean EC;
    private int nblect; 
    private int nbRatt;
    private ReentrantLock mon_moniteur;
    private Condition EcrireOK;
    private Condition LireOK;

    public LectRed_PrioRedacteur() {
        this.EC = false; 
        this.nblect = 0;
        this.nbRatt = 0;
        this.mon_moniteur = new ReentrantLock();
        this.EcrireOK = this.mon_moniteur.newCondition();
        this.LireOK = this.mon_moniteur.newCondition();
    }

    public void demanderLecture() throws InterruptedException {
        this.mon_moniteur.lock();
        while (!((this.nbRatt==0)&&(!this.EC))) {
            this.LireOK.await();
        }
        this.nblect++;
        this.LireOK.signal();
        this.mon_moniteur.unlock();
    }

    public void terminerLecture() throws InterruptedException {
        this.mon_moniteur.lock();
        this.nblect--;
        if (this.nblect == 0){
            this.EcrireOK.signal();
        }
        this.mon_moniteur.unlock();
    }

    public void demanderEcriture() throws InterruptedException {
        this.mon_moniteur.lock();
        while (!((!this.EC) && (this.nblect==0))){
            this.nbRatt++;
            this.EcrireOK.await();
        }
        this.EC =true;
        this.nbRatt--;
        this.mon_moniteur.unlock();
    }

    public void terminerEcriture() throws InterruptedException {
        this.mon_moniteur.lock();
        this.EC =false; 
        if (this.nbRatt==0){
            this.LireOK.signal();
        } else {
            this.EcrireOK.signal();
        }
        this.mon_moniteur.unlock();
    }

    public String nomStrategie() {
        return "Stratégie: Priorité Rédacteurs.";
    }
}
