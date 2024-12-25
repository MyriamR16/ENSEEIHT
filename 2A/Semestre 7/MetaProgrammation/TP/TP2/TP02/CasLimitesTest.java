/** Tester quelques cas limites.
  * @author	Xavier Cregut
  * @version	$Revision$
  */
public class CasLimitesTest {

	public void testOK() {
		// OK.
	}

	private void testMethodePrivee() {
		throw new RuntimeException("Une m�thode priv�e n'est pas un test !");
	}

	protected void testMethodeProtegee() {
		throw new RuntimeException("Une m�thode protected n'est pas un test !");
	}

	void testMethodePaquetage() {
		throw new RuntimeException("Une m�thode de droit d'acc�s paquetage n'est pas un test !");
	}

	public static void testMethodeDeClasse() {
		throw new RuntimeException("Une m�thode de classe n'est pas un test !");
	}

	public void testAvecParametre(int a) {
		throw new RuntimeException("Une m�thode avec des param�tres n'est pas un test !");
	}

	public void testAvecParametre2(int a) {
		throw new RuntimeException("Une m�thode avec des param�tres n'est pas un test !");
	}

}
