/**
 */
package petriNet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.Net#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.Net#getArcs <em>Arcs</em>}</li>
 *   <li>{@link petriNet.Net#getNoeud <em>Noeud</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getNet()
 * @model
 * @generated
 */
public interface Net extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see petriNet.PetriNetPackage#getNet_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link petriNet.Net#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Arcs</b></em>' containment reference list.
	 * The list contents are of type {@link petriNet.Arc}.
	 * It is bidirectional and its opposite is '{@link petriNet.Arc#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs</em>' containment reference list.
	 * @see petriNet.PetriNetPackage#getNet_Arcs()
	 * @see petriNet.Arc#getNet
	 * @model opposite="net" containment="true"
	 * @generated
	 */
	EList<Arc> getArcs();

	/**
	 * Returns the value of the '<em><b>Noeud</b></em>' containment reference list.
	 * The list contents are of type {@link petriNet.Noeud}.
	 * It is bidirectional and its opposite is '{@link petriNet.Noeud#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Noeud</em>' containment reference list.
	 * @see petriNet.PetriNetPackage#getNet_Noeud()
	 * @see petriNet.Noeud#getNet
	 * @model opposite="net" containment="true"
	 * @generated
	 */
	EList<Noeud> getNoeud();

} // Net
