package fr.n7.sn.mt.tp02;

/** L'exception DeviseInvalideException indique des devises incompatibles sur
 * des op�rations entre monnaies.
 *
 * @author	Xavier Cr�gut
 * @version	$Revision: 1.1 $
 */
public class DeviseInvalideException extends Exception {

	public DeviseInvalideException(String message) {
		super(message);
	}

}
