import java.time.LocalDate;
/**
 * @created 04/2024
 * @project EventFlow
 * @author Simon Lécuyer
 * @version 1.0
 */
 import java.time.format.DateTimeFormatter;
 import java.time.temporal.ChronoUnit;

/**
 * Cette classe implémente l'interface utilisateur représente un client dans le système.
 */

/**
 * La classe Client représente un utilisateur de l'application EventFlow.
 * Un client est caractérisé par son nom, ses événements, ses informations personnelles et son mot de passe.
 */
public class Client implements Utilisateur {
    private final String type;
    private final String[] nom;
    private  Evenement[] evenements;
    private  String[] infos;//0 genre //[1] -> date de naissance // 2 statut étudiant("oui")
    private  String motDePasse;
    private int nbEvent;
    private MesTickets mesTickets;
    private MonPanier monPanier;
    private double solde = 1000;

    /**
     * Constructeur de la classe Client.
     * @param nom le nom du client
     * @param evenements les événements auxquels le client est inscrit
     * @param infos les informations personnelles du client
     * @param motDePasse le mot de passe du client
     */
    public Client(String[] nom, Evenement[] evenements, String[] infos, String motDePasse, double solde) {
        this.type = "Client";
        this.nom = nom;
        this.evenements = evenements;
        this.infos = infos;
        this.motDePasse = motDePasse;
        this.mesTickets = new MesTickets();
        this.monPanier = new MonPanier(this);
        this.solde = solde;
    }

    @Override
    public String getType() {
        return type;
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
    
    public String GetNomComplet() {
        return this.nom[0] + " " + this.nom[1];
    }

    public String getNomdeFamille() {
        return this.nom[0];
    }

    public String getPrenom() {
        return this.nom[1];
    }

    public String getGenre() {
        return this.infos[0];
    }

    public LocalDate getDateNaissance() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(this.infos[1], formatter);
        return date;
    }

    public boolean getStatutEtudiant() {
        return (this.infos[2].equals("oui"));
    }
    
    public int getNbEvent(){
        return nbEvent;
    }

    public long ageClient(){
        LocalDate firstDate = this.getDateNaissance();
        LocalDate secondDate = LocalDate.now();
        long diff = firstDate.until(secondDate, ChronoUnit.YEARS);
        return diff;
    }

    public String getForfait() {
        long age = ageClient();
        if ((age <= 18) && (age>0)) {
            return "Enfant";
        } else if ((age < 25) && (age>18)) {
            return "Etudiant";
        } else {
            return "Adulte";
        }
    }
    
    public MesTickets getMesTickets() {
        return mesTickets;
    }

	public MonPanier getMonPanier() {
		return this.monPanier;
	}

	public double getSolde() {
		return solde;
	}
	
	protected void setSolde(double solde) {
		this.solde = solde;
	}
}
