/**
 * @created 04/2024
 * @project EventFlow
 * @author Simon Lécuyer
 * @version 1.2
 */

/**
 * Cette classe représente un lieu dans le système.
 */
public class Lieu {
    // Caractéristiques d'un lieu
    private String nom;
    private String type;
    private String description;
    private int capacite;
    private boolean[] disponibilites;
    private int[] prixdeLocation;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;

    public Lieu(String nom, String type, int capacite) {
        this.nom = nom;
        this.type = type;
        this.capacite = capacite;
    }

    // Méthodes Set
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDisponibilites(boolean[] disponibilites) {
        this.disponibilites = disponibilites;
    }

    public void setPrixdeLocation(int[] prixdeLocation) {
        this.prixdeLocation = prixdeLocation;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    // Méthodes Get
    public String getNom() {
        return this.nom;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public boolean[] getDisponibilites() {
        return this.disponibilites;
    }

    public int[] getPrixdeLocation() {
        return this.prixdeLocation;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public String getPays() {
        return this.pays;
    }

    // Méthode pour modifier les disponibilités
    public void modifierDisponibilites(int index, boolean disponibilite) {
        this.disponibilites[index] = disponibilite;
    }
}