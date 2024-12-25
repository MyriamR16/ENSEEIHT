import java.util.Arrays;

public class Salle extends Lieu {

    private String nom;
    private String type;
    private String description;
    private int capacite;
    private boolean[] disponibilites;
    private int[] prixDeLocation;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
    public static String[] placesPrises;

    public Salle(String nom, String type, int capacite) {
        super(nom,type,capacite);
        this.placesPrises = new String[72];
        this.placesPrises[1] = "michel3568424";
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public void setDisponibilites(boolean[] disponibilites) {
        this.disponibilites = disponibilites;
    }

    @Override
    public void setPrixdeLocation(int[] prixdeLocation) {
        this.prixDeLocation = prixdeLocation;
    }

    @Override
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCapacite() {
        return capacite;
    }

    @Override
    public boolean[] getDisponibilites() {
        return disponibilites;
    }

    @Override
    public int[] getPrixdeLocation() {
        return prixDeLocation;
    }

    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public String getVille() {
        return ville;
    }

    @Override
    public String getCodePostal() {
        return codePostal;
    }

    @Override
    public String getPays() {
        return pays;
    }

    @Override
    public void modifierDisponibilites(int index, boolean disponibilite) {
        if (index >= 0 && index < disponibilites.length) {
            disponibilites[index] = disponibilite;
        } else {
            throw new IndexOutOfBoundsException("Index invalide");
        }
    }

    public void placesPrisesEnPlus(String identifiant, int numeroSiege){
        this.placesPrises[numeroSiege]=identifiant;
    }
}
