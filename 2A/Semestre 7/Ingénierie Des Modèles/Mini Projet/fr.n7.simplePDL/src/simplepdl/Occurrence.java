/**
 */
package simplepdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Occurrence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.Occurrence#getOccurrence <em>Occurrence</em>}</li>
 *   <li>{@link simplepdl.Occurrence#getRessource <em>Ressource</em>}</li>
 *   <li>{@link simplepdl.Occurrence#getWorkDefinition <em>Work Definition</em>}</li>
 * </ul>
 *
 * @see simplepdl.SimplepdlPackage#getOccurrence()
 * @model
 * @generated
 */
public interface Occurrence extends EObject {
	/**
	 * Returns the value of the '<em><b>Occurrence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Occurrence</em>' attribute.
	 * @see #setOccurrence(int)
	 * @see simplepdl.SimplepdlPackage#getOccurrence_Occurrence()
	 * @model required="true"
	 * @generated
	 */
	int getOccurrence();

	/**
	 * Sets the value of the '{@link simplepdl.Occurrence#getOccurrence <em>Occurrence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Occurrence</em>' attribute.
	 * @see #getOccurrence()
	 * @generated
	 */
	void setOccurrence(int value);

	/**
	 * Returns the value of the '<em><b>Ressource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link simplepdl.Ressource#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ressource</em>' reference.
	 * @see #setRessource(Ressource)
	 * @see simplepdl.SimplepdlPackage#getOccurrence_Ressource()
	 * @see simplepdl.Ressource#getOccurrence
	 * @model opposite="occurrence" required="true"
	 * @generated
	 */
	Ressource getRessource();

	/**
	 * Sets the value of the '{@link simplepdl.Occurrence#getRessource <em>Ressource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ressource</em>' reference.
	 * @see #getRessource()
	 * @generated
	 */
	void setRessource(Ressource value);

	/**
	 * Returns the value of the '<em><b>Work Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link simplepdl.WorkDefinition#getOccurrence <em>Occurrence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Definition</em>' container reference.
	 * @see #setWorkDefinition(WorkDefinition)
	 * @see simplepdl.SimplepdlPackage#getOccurrence_WorkDefinition()
	 * @see simplepdl.WorkDefinition#getOccurrence
	 * @model opposite="occurrence" required="true" transient="false"
	 * @generated
	 */
	WorkDefinition getWorkDefinition();

	/**
	 * Sets the value of the '{@link simplepdl.Occurrence#getWorkDefinition <em>Work Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Definition</em>' container reference.
	 * @see #getWorkDefinition()
	 * @generated
	 */
	void setWorkDefinition(WorkDefinition value);

} // Occurrence
