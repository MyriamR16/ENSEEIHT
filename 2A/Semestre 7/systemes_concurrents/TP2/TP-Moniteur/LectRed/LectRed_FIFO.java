import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: FIFO,
 * implantation: avec un moniteur. */
public class LectRed_FIFO implements LectRed
{
    private boolean EC;
    private int nblect; 
    private int taille_File;
    private ReentrantLock mon_moniteur;
    private LinkedList<Condition> File;
    private Condition sas;
    private boolean sasempty;

    public LectRed_FIFO() {
        this.EC = false; 
        this.nblect = 0;
        this.taille_File = 0;
        this.mon_moniteur = new ReentrantLock();
        this.File = new LinkedList<Condition>();
        this.sas = this.mon_moniteur.newCondition();
        this.sasempty=true;
    }

    public void demanderLecture() throws InterruptedException {
        this.mon_moniteur.lock();
        if (!((!this.EC) && (this.taille_File==0) && (this.sasempty))){
            this.taille_File++;
            Condition nouveau = this.mon_moniteur.newCondition();
            this.File.add(nouveau);
            nouveau.await();
            this.taille_File--;
        }
        this.nblect++;
        if (!this.File.isEmpty()){
            this.File.remove().signal();
        }
        this.mon_moniteur.unlock();
    }

    public void terminerLecture() throws InterruptedException {
        this.mon_moniteur.lock();
        this.nblect--;
        if (this.nblect==0){
            if (!this.sasempty){
                this.sas.signal();
            }else{
                if (!this.File.isEmpty()){
                    this.File.remove().signal();
                }           
            }
        }
        this.mon_moniteur.unlock();
    }

    public void demanderEcriture() throws InterruptedException {
        this.mon_moniteur.lock();
        if (!((!this.EC)&&(this.nblect==0)&&(this.taille_File==0))){
            this.taille_File++;
            Condition nouveauRedacteur = this.mon_moniteur.newCondition();
            this.File.add(nouveauRedacteur);
            nouveauRedacteur.await();
            this.taille_File--;
        }
        if (this.nblect>0){
            this.sasempty =false;
            this.sas.await();
            this.sasempty = true;
        }
        this.EC=true;
        this.mon_moniteur.unlock();
    }

    public void terminerEcriture() throws InterruptedException {
        this.mon_moniteur.lock();
        this.EC = false;
        if (!this.File.isEmpty()){ 
            this.File.remove().signal();
        }
        this.mon_moniteur.unlock();
    }

    public String nomStrategie() {
        return "Stratégie: FIFO.";
    }
}
