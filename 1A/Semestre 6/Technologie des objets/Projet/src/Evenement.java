import java.util.*;
/**
 * @created 04/2024
 * @project EventFlow
 * @author Simon Lécuyer
 * @version 1.0
 */
public class Evenement {
    // Caractéristiques d'un événement
    
    /**
     * Le nom de l'événement.
     */
    public String nom;
    
    /**
     * Le type de l'événement.
     */
    public String type;
    
    /**
     * Le Gerant de l'événement.
     */
    public Gerant gerant;
    
    /**
     * La date de l'événement.
     */
    public Date date;
    
    /**
     * La description de l'événement.
     */
    public String description;
    
    /**
     * Le lieu de l'événement.
     */
    public Lieu lieu;
    
    /**
     * La grille tarifaire de l'événement.
     * 0 pour enfant, 1 pour etudiant, 2 pour adulte
     */
    public int[] grilleTarifaire;
    
    /**
     * Les clients de l'événement.
     */
    public Client[] clients;
    
    /**
     * Les prestataires de l'événement.
     */
    public Prestataire[] prestataires;

    /**
     * Existance de code promo de l'événement.
     */
    public boolean promoExiste;

    /**
     * Pourcentage de code promo de l'événement.
     */
    public int promo;

    /**
     * Les prestataires de l'événement.
     */
    public Prestataire[] Prestataires;

    public int nbPrestataires;

     /**
     * Les clients de l'événement.
     */
    public Client[] Clients;

    public int nbClients;

    public int nbPlacesInitiales;
    public int nbPlacesRestantes;



     /**
     * Constructeur de l'événement.
     */

     public Evenement(String nom, String type, Gerant gerant, java.util.Date date, String description, Lieu lieu,
     int[] grilleTarifaire, int placeInitiales, boolean promoExiste, int promo) {
        this.nom = nom;
        this.type = type;
        this.gerant = gerant;
        this.date = date;
        this.description = description;
        this.lieu = lieu;
        this.grilleTarifaire = grilleTarifaire;
        this.clients = new Client[lieu.getCapacite()];
        nbClients = 0;
        prestataires = new Prestataire[25];
        nbPrestataires = 0;
        this.nbPlacesInitiales= placeInitiales;
        this.nbPlacesRestantes = placeInitiales;
        this.promoExiste=promoExiste;
        this.promo=promo;
        }


    /**
     * Retourne le nom de l'événement.
     * 
     * @return Le nom de l'événement.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le type de l'événement.
     * 
     * @return Le type de l'événement.
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne le Gerant de l'événement.
     * 
     * @return Le Gerant de l'événement.
     */
    public Gerant getGerant() {
        return gerant;
    }

    /**
     * Retourne la date de l'événement.
     * 
     * @return La date de l'événement.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retourne la description de l'événement.
     * 
     * @return La description de l'événement.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retourne le lieu de l'événement.
     * 
     * @return Le lieu de l'événement.
     */
    public Lieu getLieu() {
        return lieu;
    }

    /**
     * Retourne la grille tarifaire de l'événement.
     * 
     * @return La grille tarifaire de l'événement.
     */
    public int[] getGrilleTarifaire() {
        return grilleTarifaire;
    }

    /**
     * Retourne les clients de l'événement.
     * 
     * @return Les clients de l'événement.
     */
    public Client[] getClients() {
        return clients;
    }

    /**
     * Retourne les prestataires de l'événement.
     * 
     * @return Les prestataires de l'événement.
     */
    public Prestataire[] getPrestataires() {
        return prestataires;
    }

    public int getNbPlacesRestantes(){
        return this.nbPlacesRestantes;
    }

    public int getNbPlacesInitiales(){
        return this.nbPlacesInitiales;
    }    

    /**
     * Modifie le type de l'événement.
     * 
     * @param type Le nouveau type de l'événement.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Modifie le Gerant de l'événement.
     * 
     * @param gerant Le nouveau Gerant de l'événement.
     */
    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    /**
     * Modifie la date de l'événement.
     * 
     * @param date La nouvelle date de l'événement.
     */ 
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Modifie la description de l'événement.
     * 
     * @param description La nouvelle description de l'événement.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Modifie le lieu de l'événement.
     * 
     * @param lieu Le nouveau lieu de l'événement.
     */
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    /**
     * Modifie la grille tarifaire de l'événement.
     * 
     * @param grilleTarifaire La nouvelle grille tarifaire de l'événement.
     */
    public void setGrilleTarifaire(int[] grilleTarifaire) {
        this.grilleTarifaire = grilleTarifaire;
    }

    /**
     * Ajoute un client à l'événement.
     * 
     * @param client Le client à ajouter.
     */
    public void ajouterClient(Client client) {
        this.Clients[this.nbClients] = client;
        this.nbClients++;
    }
    
    /**
     * Ajoute un prestataire à l'événement.
     * 
     * @param prestataire Le prestataire à ajouter.
     */
    public void ajouterPrestataire(Prestataire prestataire) {
        this.Prestataires[this.nbPrestataires] = prestataire;
        this.nbPrestataires++;
        }

    /**
     * Supprime un client de l'événement.
     * 
     * @param client Le client à supprimer.
     */
    public void supprimerClient(Client client) {
        this.Clients[this.nbClients] = null;
        this.nbClients--;
    }
    
    /**
     * Supprime un prestataire de l'événement.
     * 
     * @param prestataire Le prestataire à supprimer.
     */
    public void supprimerPrestataire(Prestataire prestataire) {
        this.Prestataires[this.nbPrestataires] = null;
        this.nbPrestataires--;
    }

    public boolean getCodePromo(){
        return promoExiste;
    }

    public int getReduction(){
        if (getCodePromo()){
            return promo;
        }
        else {
           return 0;
        }
    }

    /**
     *Retourne si l'événement est complet. 
     */
    public boolean estComplet() {
        return (this.nbClients == this.lieu.getCapacite());
    }

    public void placePrise(int nombreBillets){
        this.nbPlacesRestantes = this.nbPlacesRestantes - nombreBillets;
    }
    
    /**
     *Retourne le prix du forfait d'un client 
     *en fonction de son statut
     *
     *@param client Le client dont-on souhaite le forfait.
     */
    public int getForfaitPrix(Client client) {
    	if (client.getStatutEtudiant()) {
            return this.getGrilleTarifaire()[1];
        } else if (client.ageClient() < 18) {
            return this.getGrilleTarifaire()[0];
        } else {
            return this.getGrilleTarifaire()[2];
        }
    }

}
