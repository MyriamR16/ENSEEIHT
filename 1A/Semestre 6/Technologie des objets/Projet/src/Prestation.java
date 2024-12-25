import java.util.Date;

public class Prestation {
    private String nomEvenement;
    private Date dateEvenement;
    private Lieu lieu;
    private float prixPrestation;

    public Prestation(String nomEvenement, Date dateEvenement, Lieu lieu, int prixPrestation) {
        this.nomEvenement = nomEvenement;
        this.dateEvenement = dateEvenement;
        this.lieu = lieu;
        this.prixPrestation = prixPrestation;
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

    public float getPrixPrestation(){
        return this.prixPrestation;
    }
}
