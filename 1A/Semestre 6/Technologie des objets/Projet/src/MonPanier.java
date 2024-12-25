import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonPanier {

    private MesTickets mesTickets;
    private Client client;
    private Map<Evenement, Integer> compteurBillets;

    public MonPanier(Client client) {
        this.mesTickets = new MesTickets();
        this.client = client;
        this.compteurBillets = new HashMap<>();
    }

    public void ajouterBillet(Billet billet, int quantite) {
        Evenement evenement = billet.getEvent();
        compteurBillets.put(evenement, compteurBillets.getOrDefault(evenement, 0) + quantite);
        for (int i = 0; i < quantite; i++) {
            mesTickets.ajouterBillet(billet);  // Ajoute les billets à mesTickets
        }
    }

    public List<Billet> getBillets() {
        return mesTickets.getBillets();
    }

    public double calculTotal() {
        int pourcentage = 0;
        double prixIntermediaire;
        double prixTotal = 0.0;
        List<Billet> billets = getBillets();

        for (Billet billet : billets) {
            prixIntermediaire = billet.getPrixBillet();
            if (billet.getEvent().getCodePromo()) {
                pourcentage = 100 - billet.getEvent().getReduction();
                prixIntermediaire = (prixIntermediaire * pourcentage) / 100.0;
            }
            prixTotal += prixIntermediaire;
        }
        return prixTotal;
    }

    public void soldeValide() throws SoldeInvalide {
        double total = calculTotal();
        double solde = client.getSolde();
        if (solde < total) {
            throw new SoldeInvalide("Le solde est insuffisant !\n");
        }
    }

    public Map<Evenement, Integer> getCompteurBillets() {
        return compteurBillets;
    }

    public void validerMonPanier() throws SoldeInvalide {
        soldeValide();
        double total = calculTotal();
        double solde = client.getSolde();

        // Mise à jour du solde du client
        solde -= total;
        client.setSolde(solde);

        // Transférer les billets du panier au client
        for (Billet billet : mesTickets.getBillets()) {
            client.getMesTickets().ajouterBillet(billet);
        }

        // Vider le panier après l'achat
        mesTickets.getBillets().clear();
        compteurBillets.clear();
    }

    public MesTickets getMesTickets() {
        return mesTickets;
    }

    public Client getClient() {
        return client;
    }
}
