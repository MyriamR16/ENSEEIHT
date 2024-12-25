/**
 * Cette classe implémente l'interface utilisateur représente un prestataire dans le système.
 */

/**
 * La classe Prestataire représente un utilisateur de l'application EventFlow.
 * Un prestataire est caractérisé par son nom, ses événements, ses informations personnelles et son mot de passe.
 */

public class Prestataire implements Utilisateur {
   
    private final String type;
    private final String[] nom;
    private  Evenement[] evenements;
    private  String[] infos;
    private final String motDePasse;
    private int nbEvent;

    /**
     * Constructeur de la classe Prestataire.
     * 
     * @param nom le nom du Prestataire
     * @param evenements la liste des événements du Prestataire
     * @param infos les informations supplémentaires du Prestataire. ex: type de prestation proposé
     * @param motDePasse le mot de passe du Prestataire
     */
    public Prestataire(String[] nom, Evenement[] evenements, String[] infos, String motDePasse) {
        this.type = "Prestataire";
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

    public int getNbEvent(){
        return nbEvent;
    }

}
