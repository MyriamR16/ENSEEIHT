import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/** Classe de tests complementaires de la classe Cercle
  */
public class ComplementsCercleTest {
    
    // précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point A, B, C, D, E;

	// Les cercles du sujet
	private Cercle C1, C2,C3;

	@Before public void setUp() {
		// Construire les points
		A = new Point(1, 2);
		B = new Point(2, 1);
		C = new Point(4, 1);
		D = new Point(8, 1);
		E = new Point(8, 4);

		// Construire les cercles
		C1 = new Cercle(A, 2.5);
		C2 = new Cercle(new Point(6, 1), 2);
		C2.setCouleur(Color.yellow);
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

	@Test public void testerE2() {
        memesCoordonnees("E2 sur C3", D, C3.getCentre()); 
	}


    @Test public void testerE3() {
		assertEquals("E3 sur C3", 3.0, C3.getRayon(), EPSILON);
-	}

	@Test public void testerE4() {
		assertEquals("E4 sur C3", 6.0, C3.getDiametre(), EPSILON);
	}
	@Test public void testerE5() {
        assertTrue("E5", C2.contient(C));
        assertTrue("E5", C2.contient(D));
        assertTrue("E5", C3.contient(D));
        assertTrue("E5", C3.contient(E));

        assertFalse("E5", C2.contient(E));
        assertFalse("E5", C2.contient(A));
        assertFalse("E5", C2.contient(B));

        assertFalse("E5", C3.contient(A));
        assertFalse("E5", C3.contient(B));
        assertFalse("E5", C3.contient(C));
	}
 
	@Test public void testerE6() {
		assertEquals("E6", 6*Math.PI, C3.perimetre(), EPSILON);
		assertEquals("E6", 9*Math.PI, C3.aire(), EPSILON);
	}

    //TEST E8?
    
	@Test public void testerE9() {
		assertEquals("E9", Color.blue, C3.getCouleur());
	}

    @Test public void testerE10() {
		C3.setCouleur(Color.orange);
		assertEquals("E10", Color.orange, C3.getCouleur());
	}
//
    @Test public void testerToString() {
		assertEquals("E15: toString() redéfinie ? Correctement ?",
				"C2.5@(1.0, 2.0)", C1.toString());
	}

	@Test public void testerE16() {
		C1.setRayon(10);
		assertEquals(10, C1.getRayon(), EPSILON);
		C1.setRayon(20);
		assertEquals(20, C1.getRayon(), EPSILON);
	}

	@Test public void testerE17() {
		C1.setDiametre(10);
		assertEquals(5, C1.getRayon(), EPSILON);
		C1.setDiametre(20);
		assertEquals(10, C1.getRayon(), EPSILON);
	}

	@Test public void testerE18() {
		C1.getCentre().translater(10, 20);
		memesCoordonnees("E18 : erreur si translation du centre",
				new Point(1, 2), C1.getCentre());
		A.translater(10, 20);
		memesCoordonnees("E18 : erreur si translation de A",
				new Point(1, 2), C1.getCentre());
	}
}