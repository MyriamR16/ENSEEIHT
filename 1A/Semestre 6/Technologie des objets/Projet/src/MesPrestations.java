import java.util.ArrayList;
import java.util.List;

public class MesPrestations {
    private List<Prestation> prestations;

    /** Le client auquel appartiennent les tickets. */

    private Prestataire prestataire;

    public MesPrestations(Prestataire prestataire) {
        this.prestations = new ArrayList<>();
        this.prestataire = prestataire;

    }

    public void ajouterPrestation(Prestation prestation) {
        prestations.add(prestation);
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    @Override
    public String toString() {
        int cpt = 1 ;
        String chaine = "";
        for (Prestation prestation : prestations){
            chaine += "Prestation n°" + cpt + " {" +
                    "nomEvenement = " + prestation.getNomEvenement() + '\'' +
                    ", dateEvenement =" + prestation.getDateEvenement() +
                    ", lieu =" + prestation.getLieu() +
                    ", prixPrestation =" + prestation.getPrixPrestation() +
                    '}';
            cpt++;
        }
        return chaine;
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }
}
