import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/** Classe de test de la classe Cercle pour les exigences E12, E13 et E14
  */
public class CercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point  C, D, E;

	// Les cercles du sujet
	private Cercle C1, C2,C3;

	@Before public void setUp() {
		// Construire les points
		C = new Point(4, 1);
		D = new Point(8, 1);
		E = new Point(8, 4);

		// E12
		C1 = new Cercle(C, D);
        
        //E13
		C2 = new Cercle(C, D, Color.green);

        //E14
		C3.creerCercle(D, E);
	}

    /** Vérifier si deux points ont mêmes coordonnées.
	  * @param p1 le premier point
	  * @param p2 le deuxième point
	*/

	static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}

	@Test public void testerE12() {
		memesCoordonnees("Centre de C1", C1.getCentre(), new Point(6, 1));
		assertEquals("Rayon de C1", C1.getRayon, 2.0, EPSILON);
        assertEquals("Couleur de C1", Color.blue, C1.getCouleur());
	}

    @Test public void testerE13() {
		memesCoordonnees("Centre de C2", C2.getCentre(), new Point(6, 1));
		assertEquals("Rayon de C2", C2.getRayon, 2.0, EPSILON);
        assertEquals("Couleur de C2", Color.green, C2.getCouleur());
	}

    @Test public void testerE14() {
		memesCoordonnees("Centre de C3", C3.getCentre(), D);
		assertEquals("Rayon de C3", C3.getRayon, 3.0, EPSILON);
        assertEquals("Couleur de C3", Color.blue, C3.getCouleur());
	}

}