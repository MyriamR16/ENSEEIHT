import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPrestation {

    private Prestation prestation;
    private String nomEvenement;
    private Date dateEvenement;
    private Lieu lieu;
    private float prixPrestation;

    @BeforeEach
    public void initialisationDePrestation() {
        nomEvenement = "Concert";
        dateEvenement = new Date();
        lieu = new Lieu("Paris", "Extérieur", 200);
        prixPrestation = 50.0f;
        prestation = new Prestation(nomEvenement, dateEvenement, lieu, prixPrestation);
    }

    @Test
    public void testGetNomEvenement() {
        assertEquals(nomEvenement, prestation.getNomEvenement());
    }

    @Test
    public void testSetNomEvenement() {
        String newNomEvenement = "Festival";
        prestation.setNomEvenement(newNomEvenement);
        assertEquals(newNomEvenement, prestation.getNomEvenement());
    }

    @Test
    public void testGetDateEvenement() {
        assertEquals(dateEvenement, prestation.getDateEvenement());
    }

    @Test
    public void testSetDateEvenement() {
        Date newDateEvenement = new Date();
        prestation.setDateEvenement(newDateEvenement);
        assertEquals(newDateEvenement, prestation.getDateEvenement());
    }

    @Test
    public void testGetLieu() {
        assertEquals(lieu, prestation.getLieu());
    }

    @Test
    public void testSetLieu() {
        Lieu newLieu = new Lieu("Lyon","Extérieur",50);
        prestation.setLieu(newLieu);
        assertEquals(newLieu, prestation.getLieu());
    }

    @Test
    public void testGetPrixPrestation() {
        assertEquals(prixPrestation, prestation.getPrixPrestation());
    }
}
