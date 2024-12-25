import java.util.ArrayList;
import java.util.List;

public class MesTickets {
    private List<Billet> billets;

    
    public MesTickets() {
        this.billets = new ArrayList<>();
    }
        
    public void ajouterBillet(Billet billet) {
        billets.add(billet);
    }

    public List<Billet> getBillets() {
        return billets;
    }

    @Override
    public String toString() {
        int cpt = 1 ;
        String chaine = "";
        for (Billet billet : billets){
            chaine += "Billet n°" + cpt + " {" +
                    "nomEvenement= " + billet.getNomEvenement() + '\'' +
                    ", dateEvenement=" + billet.getDateEvenement() +
                    ", lieu=" + billet.getLieu() +
                    ", numeroSiege=" + billet.getNumeroSiege() +
                    ", prixBillet=" + billet.getPrixBillet() +
                    '}';
            cpt++;
        }
        return chaine;
    }


}
