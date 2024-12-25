import java.lang.reflect.*;
import java.util.*;

/** L'objectif est de faire un lanceur simple sans utiliser toutes les clases
  * de notre architecture JUnit.   Il permet juste de valider la compr�hension
  * de l'introspection en Java.
  */
public class LanceurIndependant {
	private int nbTestsLances;
	private int nbErreurs;
	private int nbEchecs;
	private List<Throwable> erreurs = new ArrayList<>();

	public LanceurIndependant(String... nomsClasses) {
	    System.out.println();

		// Lancer les tests pour chaque classe
		for (String nom : nomsClasses) {
			try {
				System.out.print(nom + " : ");
				this.testerUneClasse(nom);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println(" Classe inconnue !");
			} catch (Exception e) {
				System.out.println(" Probleme : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			System.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lances dont %d echecs et %d erreurs.\n",
				nbTestsLances, nbEchecs, nbErreurs);
	}


	public int getNbTests() {
		return this.nbTestsLances;
	}


	public int getNbErreurs() {
		return this.nbErreurs;
	}


	public int getNbEchecs() {
		return this.nbEchecs;
	}

	static private Method getMethode(Class<?> c, String nom) {
		try {
			return c.getMethod(nom);
		} catch (NoSuchMethodException e) { // méthode non trouvée !
			return null;
		}
	}

	private void executerUnTest(Object recepteur, Method preparer, Method nettoyer,
	Method tester) throws IllegalAccessException, InvocationTargetException
	{
	try {
		if (preparer != null) {
			preparer.invoke(recepteur);
		}
		tester.invoke(recepteur);
	} finally {
		if (nettoyer != null) {
			nettoyer.invoke(recepteur);
		}
	}

// XXX : Si une exception se produit lors de l'exécution des méthodes
// preparer(), tester() ou nettoyer() sont encaptsulée dans
// InvocationTargetException.  On pourrait la récupérer dans e et faire
// un throw e.getCause().  Mais il faurait alors dans la signature
// mettre un throws Throwable.
} 

	
	private void testerUneClasse(String nomClasse)
		throws ClassNotFoundException, InstantiationException,
						  IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		// Récupérer la classe
		Class<?> classe = Class.forName(nomClasse);

		// Récupérer les méthodes "preparer" et "nettoyer"
		Method preparer = getMethode(classe, "preparer");
		Method nettoyer = getMethode(classe, "nettoyer");

		// Instancier l'objet qui sera le récepteur des tests
		Object objet = classe.getConstructor().newInstance();
			// On sait qu'il doit y avoir un constucteur par défaut.
			// Sinon, il faudrait récupérer un constructeur et appliquer
			// newInstance dessus. 

		// Exécuter les méthods de test
		for (Method m : classe.getMethods()) {
			if (m.getName().startsWith("test")
					&& m.getParameterTypes().length == 0
					&& ! Modifier.isStatic(m.getModifiers()))
			{
				boolean echec = true;
				try {
					nbTestsLances++;
					executerUnTest(objet, preparer, nettoyer, m);
					echec = false;
				} catch (InvocationTargetException e) {
					// L'exception qui s'est vraiment produite lors de l'appel
					// des méthodes preparer(), tester() ou nettoyer() est
					// associée à InvocationTargetException.  On la retrouve en
					// faisant getCause().
					if (e.getCause() instanceof Echec) {
						nbEchecs++;
					} else {
						nbErreurs++;
					}
					erreurs.add(e.getCause());
				} catch (Throwable e) {
					nbErreurs++;
					erreurs.add(e.getCause());
				} finally {
					if (echec) {
						System.out.print('F');
					} else {
						System.out.print('.');
					}
				}
			}
		}
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
