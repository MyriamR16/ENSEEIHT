/**
 * @created 04/2024
 * @project EventFlow
 * @author Simon Lécuyer
 * @version 1.0
 */

/**
 * Cette classe implémente l'interface utilisateur représente un Gerant dans le système.
 */

/**
 * La classe Gerant représente un utilisateur de type Gerant.
 * 
 * Un Gerant est un utilisateur qui possède un nom, une liste d'événements, des informations supplémentaires
 * et un mot de passe.
 */
public class Gerant implements Utilisateur{

    private final String type;
    private final String[] nom;
    private  Evenement[] evenements;
    private  String[] infos;
    private final String motDePasse;

    /**
     * Constructeur de la classe Gerant.
     * 
     * @param nom le nom du Gerant
     * @param evenements la liste des événements du Gerant
     * @param infos les informations supplémentaires du Gerant
     * @param motDePasse le mot de passe du Gerant
     */
    public Gerant(String[] nom, Evenement[] evenements, String[] infos, String motDePasse) {
        this.type = "Gerant";
        this.nom = nom;
        this.evenements = evenements;
        this.infos = infos;
        this.motDePasse = motDePasse;
    }

    @Override
    public String[] getNom() {
        return nom;
    }

    @Override
    public Evenement[] getEvenements() {
        return evenements;
    }

    @Override
    public String[] getInfos() {
        return infos;
    }

    @Override
    public String getMotDePasse() {
        return motDePasse;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPrenom() {
        return this.nom[1];
    }   

}
