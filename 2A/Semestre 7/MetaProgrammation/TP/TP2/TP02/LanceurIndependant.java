import java.lang.reflect.*;
import java.util.*;

/** L'objectif est de faire un lanceur simple sans utiliser toutes les clases
  * de notre architecture JUnit.   Il permet juste de valider la comprehension
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
				System.out.println(" Problme : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			SysteLanceurIndependantm.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lanc�s dont %d �checs et %d erreurs.\n",
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


	static private Method getMethode (Class<?> c, String nom) {
		try{
			return c.getMethod(nom);
		}catch (NoSuchMethodException e) {
			return null;
		}
	} 


	private void executerUnTest(Object recepteur, Method preparer, Method nettoyer, Method tester) throws InvocationTargetException, IllegalAccessException {
		try {
			if (preparer != null){
				preparer.invoke(recepteur); 
				tester.invoke(recepteur);
			}
		}finally{
			if (nettoyer != null){
				nettoyer.invoke(recepteur);
			}
		}
	} 


	private void testerUneClasse(String nomClasse)
		throws ClassNotFoundException, InstantiationException,
						  IllegalAccessException
	{
		// Recuperer la classe
        Class<?> classe = Class.forName(nomClasse);

		// Recuperer les methodes "preparer" et "nettoyer"
		Method preparer = getMethode(classe, "preparer");
		Method nettoyer = getMethode(classe, "nettoyer");

		// Instancier l'objet qui sera le recepteur des tests
		Object objet = null;

		// Executer les methods de test
		for (Method methode : classe.getMethods()) {
			if (methode.getName().startsWith("tester")) {
				nbTestsLances++;
				try{
					executerUnTest(objet, preparer, nettoyer, methode);
				}catch(InvocationTargetException e){
                    Throwable cause = e.getCause();
                    erreurs.add(cause);
                    if (cause instanceof AssertionError) {
                        nbEchecs++;
                        System.out.println("Échec du test : " + methode.getName());
                    } else {
                        nbErreurs++;
                        System.out.println("Erreur lors du test : " + methode.getName());
                    }				
				}
			}
		}
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant(args);
	}

}
