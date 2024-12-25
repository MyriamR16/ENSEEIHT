import java.util.ArrayList;
import java.util.List;

public class Billeterie {
    private List<Evenement> evenements;
    private MonPanier panier;

    public Billeterie(MonPanier panier) {
        this.evenements = new ArrayList<>();
        this.panier = panier;
    }

    //Ajouter un évènement à la billeterie.
    public void ajouterEvenementBilleterie(Evenement evenement){
        if (!evenement.estComplet()){
            evenements.add(evenement);
        }
    }

    //Trouver un évènement par son nom.
    public Evenement trouverEvenementParNom(String nomEvent){
        for (Evenement evenement : evenements){
            if (evenement.getNom().equals(nomEvent)){
                return evenement;
            }
        }
        throw new IllegalArgumentException("Il n'y a pas l'évènement que vous cherchez " +
                ": "+ nomEvent);
    }

    //Prix du billet pour un évènement avec un forfait donné.
    public float prixEvenement(Evenement evenement, String forfait){
        if (forfait.equals("Enfant")){
            return evenement.getGrilleTarifaire()[0];
        } else if (forfait.equals("Etudiant")){
            return evenement.getGrilleTarifaire()[1];
        } else {
            return evenement.getGrilleTarifaire()[2];
        }
    }

    //Acheter un billet pour un évènement donné.

    public void acheter(String nomEvent, Client client, int nombreBillets) throws NombreBilletsInvalideException, AgeInvalideException {
        Evenement evenement = trouverEvenementParNom(nomEvent);
        if (nombreBillets <= 0){
            throw new NombreBilletsInvalideException("Le nombre de billets doit " +
                    "être positif !");
        } else if (nombreBillets > evenement.getNbPlacesRestantes()) {
            throw new NombreBilletsInvalideException(("Il n'y a pas assez de place !"));
        } else {
            float prixTotal = prixEvenement(evenement, client.getForfait())* nombreBillets;
            evenement.placePrise(nombreBillets);
            if (nombreBillets == 1) {
                System.out.println("Vous avez acheté " + nombreBillets + " billet pour " +
                        "l'évènement " + nomEvent + " au prix total de " + prixTotal +
                        " euros.");
            } else {
                System.out.println("Vous avez acheté " + nombreBillets + " billets pour "
                        + "l'évènement " + nomEvent + " au prix total de " + prixTotal +
                        " euros.");
                }
        }
    }

    //Afficher les évènements disponibles dans la billeterie
    public void afficherEvenementsDisponibles(){
        System.out.println("Les évènements disponibles dans la billeterie sont les " +
                "suivants :");
        for (Evenement evenement : evenements){
            System.out.println("- " + evenement.getNom() + ":" +
                    evenement.getNbPlacesRestantes() + " places disponibles");
        }
    }

    public List<Evenement> getEvenements(){
        return this.evenements;
    }

}