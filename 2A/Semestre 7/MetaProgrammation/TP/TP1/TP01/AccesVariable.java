/**
  * AccesVariable reprsente l'accs  une variable.
  *
  * @author	Xavier Crgut
  * @version	$Revision$
  */
public class AccesVariable implements Expression {
	private String nom;

	public AccesVariable(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return this.nom;
	}

	public <R> R accepter(VisiteurExpression<R> visiteur) {
		return visiteur.visiterAccesVariable(this);
	}

}
