import static org.junit.Assert.assertEquals;

import java.awt.Color;

/** Cercle modelise dans un plan équipe d un
 * repere cartesien. Un Cercle peut etre translaté.
 */
public class Cercle implements Mesurable2D {

    public final static double PI = Math.PI;
	public final static double EPSILON = 0.001;

	private Point c;		// Centre
	private double r;		// Rayon
	private Color couleur;	// couleur du cercle



	/** Construire un cercle a partir de son centre et de son rayon.
     * La couleur par defaut est le bleu 
	 * @param vc centre
	 * @param vr rayon
	 */
	public Cercle(Point vc, double vr) {
		this.c = vc;
		this.r = vr;
		this.couleur = Color.blue;
	}

	/** Construire un cercle a partir de deux points diametralement opposes.
     * La couleur par defaut est le bleu 
	 * @param C Point
	 * @param D Point
	*/

    public Cercle(Point C, Point D) {
        this.c = new Point((C.getX() + D.getX())/2 , (C.getY() + D.getY())/2 );
        this.r = C.distance(D)/2;
        this.couleur = Color.blue; 
    }


    /** Construire un cercle a partir de deux points diametralement opposes et dune couleur.
	 * @param C Point
	 * @param D Point
     * @param couleur Couleur
	*/
    
    public Cercle(Point C, Point D, Color couleur) {
        this.c = new Point((C.getX() + D.getX())/2 , (C.getY() + D.getY())/2 );
        this.r = C.distance(D)/2;
        this.couleur = couleur; 
    }

    /** Construire un cercle a partir d'un point au centre et d'un autre sur la circonference.
     * La couleur est bleue par defaut 
	 * @param A Point
	 * @param B Point
     * @return Cercle 
	*/
    
    public static Cercle creerCercle(Point A , Point B) {
        return new Cercle(A, B.distance(A));
    }

	/** Obtenir le centre du cercle
	 * @return centre du cercle
	 */
	public Point getCentre() {
		return new Point(this.c.getX(), this.c.getY());
	}

	/** Obtenir le rayon du cercle.
	 * @return rayon du cercle
	 */
	public double getRayon() {
		return this.r;
	}

	/** Obtenir le diametre du cercle.
	 * @return diametre du cercle
	*/
	public double getDiametre() {
		return 2*this.r;
	}

	/** Obtenir la couleur du cercle.
	 * @return couleur du cercle
	*/

	public Color getCouleur() {
		return this.couleur;
	}

	/** Changer le rayon du cercle.
	  * @param vr nouveau rayon
	  */
	public void setRayon(double vr) {
		this.r = vr;
	}

    /** Changer le diametre du cercle.
	  * @param vd nouveau diametre
	*/
	public void setDiametre(double vd) {
		this.r = vd/2;
	}


	/** Changer la couleur du cercle.
	  * @param nv_couleur nouvelle couleur
	  */
	public void setCouleur(Color nv_couleur) {
		this.couleur = nv_couleur;
	}

   /** Translater le cercle.
	* @param dx déplacement suivant l'axe des X
	* @param dy déplacement suivant l'axe des Y
	*/
	public void translater(double dx, double dy) {
		this.c.translater(dx, dy);
	}

    /** Verifier qu un point est a linterieur d un cercle
     * @param p point à etudier
     * @return boolean
     */

    public boolean contient(Point p){
       return this.c.distance(p) <= this.r;
    }

    /** Calculer le perimetre d un cercle
     * @return le perimetre
    */

    public double perimetre (){
        return 2 * PI * this.r;
    }

    /** Calculer l'air d un cercle
     * @return l'air
    */
    
    public double aire (){
        return PI * Math.pow(this.r, 2);
    }

    /** Afficher le cercle sous la forme Cr@(a,b)
     * @return string
    */

    public String toString() {
		return "C" + this.r + "@(" + this.c.getX() + ", " + this.c.getY() + ")";
	}

}