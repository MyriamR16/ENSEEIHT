/**
 */
package petriNet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link petriNet.Arc#getPoids <em>Poids</em>}</li>
 *   <li>{@link petriNet.Arc#getDestination <em>Destination</em>}</li>
 *   <li>{@link petriNet.Arc#getSource <em>Source</em>}</li>
 *   <li>{@link petriNet.Arc#getLinkType <em>Link Type</em>}</li>
 *   <li>{@link petriNet.Arc#getNet <em>Net</em>}</li>
 * </ul>
 *
 * @see petriNet.PetriNetPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Poids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Poids</em>' attribute.
	 * @see #setPoids(int)
	 * @see petriNet.PetriNetPackage#getArc_Poids()
	 * @model required="true"
	 * @generated
	 */
	int getPoids();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getPoids <em>Poids</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Poids</em>' attribute.
	 * @see #getPoids()
	 * @generated
	 */
	void setPoids(int value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Noeud#getEntrant <em>Entrant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(Noeud)
	 * @see petriNet.PetriNetPackage#getArc_Destination()
	 * @see petriNet.Noeud#getEntrant
	 * @model opposite="entrant" required="true"
	 * @generated
	 */
	Noeud getDestination();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(Noeud value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Noeud#getSortant <em>Sortant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Noeud)
	 * @see petriNet.PetriNetPackage#getArc_Source()
	 * @see petriNet.Noeud#getSortant
	 * @model opposite="sortant" required="true"
	 * @generated
	 */
	Noeud getSource();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Noeud value);

	/**
	 * Returns the value of the '<em><b>Link Type</b></em>' attribute.
	 * The literals are from the enumeration {@link petriNet.ArcType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Type</em>' attribute.
	 * @see petriNet.ArcType
	 * @see #setLinkType(ArcType)
	 * @see petriNet.PetriNetPackage#getArc_LinkType()
	 * @model required="true"
	 * @generated
	 */
	ArcType getLinkType();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getLinkType <em>Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Type</em>' attribute.
	 * @see petriNet.ArcType
	 * @see #getLinkType()
	 * @generated
	 */
	void setLinkType(ArcType value);

	/**
	 * Returns the value of the '<em><b>Net</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link petriNet.Net#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net</em>' container reference.
	 * @see #setNet(Net)
	 * @see petriNet.PetriNetPackage#getArc_Net()
	 * @see petriNet.Net#getArcs
	 * @model opposite="arcs" required="true" transient="false"
	 * @generated
	 */
	Net getNet();

	/**
	 * Sets the value of the '{@link petriNet.Arc#getNet <em>Net</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net</em>' container reference.
	 * @see #getNet()
	 * @generated
	 */
	void setNet(Net value);

} // Arc
