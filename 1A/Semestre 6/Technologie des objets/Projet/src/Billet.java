import java.util.Date;

public class Billet {
    private String nomEvenement;
    private Date dateEvenement;
    private Lieu lieu;
    private int numeroSiege;
    private float prixBillet;
    private Evenement event;

    public Billet(Evenement event, int numeroSiege, float prixBillet) {
        this.event = event;
        this.nomEvenement = event.getNom();
        this.dateEvenement = event.getDate();
        this.lieu = event.getLieu();
        this.numeroSiege = numeroSiege;
        this.prixBillet = prixBillet;
    }
    

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public int getNumeroSiege() {
        return numeroSiege;
    }

    public void setNumeroSiege(int numeroSiege) {
        this.numeroSiege = numeroSiege;
    }

    public float getPrixBillet(){
        return this.prixBillet;
    }



	public Evenement getEvent() {
		return event;
	}


}
