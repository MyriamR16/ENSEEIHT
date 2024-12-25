/**
 */
package petriNet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import petriNet.Arc;
import petriNet.Net;
import petriNet.Noeud;
import petriNet.PetriNetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Noeud</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link petriNet.impl.NoeudImpl#getName <em>Name</em>}</li>
 *   <li>{@link petriNet.impl.NoeudImpl#getEntrant <em>Entrant</em>}</li>
 *   <li>{@link petriNet.impl.NoeudImpl#getSortant <em>Sortant</em>}</li>
 *   <li>{@link petriNet.impl.NoeudImpl#getNet <em>Net</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NoeudImpl extends MinimalEObjectImpl.Container implements Noeud {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntrant() <em>Entrant</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntrant()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> entrant;

	/**
	 * The cached value of the '{@link #getSortant() <em>Sortant</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortant()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> sortant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NoeudImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.NOEUD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.NOEUD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arc> getEntrant() {
		if (entrant == null) {
			entrant = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, PetriNetPackage.NOEUD__ENTRANT, PetriNetPackage.ARC__DESTINATION);
		}
		return entrant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arc> getSortant() {
		if (sortant == null) {
			sortant = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, PetriNetPackage.NOEUD__SORTANT, PetriNetPackage.ARC__SOURCE);
		}
		return sortant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Net getNet() {
		if (eContainerFeatureID() != PetriNetPackage.NOEUD__NET) return null;
		return (Net)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNet(Net newNet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNet, PetriNetPackage.NOEUD__NET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNet(Net newNet) {
		if (newNet != eInternalContainer() || (eContainerFeatureID() != PetriNetPackage.NOEUD__NET && newNet != null)) {
			if (EcoreUtil.isAncestor(this, newNet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNet != null)
				msgs = ((InternalEObject)newNet).eInverseAdd(this, PetriNetPackage.NET__NOEUD, Net.class, msgs);
			msgs = basicSetNet(newNet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.NOEUD__NET, newNet, newNet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__ENTRANT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntrant()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.NOEUD__SORTANT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSortant()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.NOEUD__NET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNet((Net)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__ENTRANT:
				return ((InternalEList<?>)getEntrant()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.NOEUD__SORTANT:
				return ((InternalEList<?>)getSortant()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.NOEUD__NET:
				return basicSetNet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PetriNetPackage.NOEUD__NET:
				return eInternalContainer().eInverseRemove(this, PetriNetPackage.NET__NOEUD, Net.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__NAME:
				return getName();
			case PetriNetPackage.NOEUD__ENTRANT:
				return getEntrant();
			case PetriNetPackage.NOEUD__SORTANT:
				return getSortant();
			case PetriNetPackage.NOEUD__NET:
				return getNet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__NAME:
				setName((String)newValue);
				return;
			case PetriNetPackage.NOEUD__ENTRANT:
				getEntrant().clear();
				getEntrant().addAll((Collection<? extends Arc>)newValue);
				return;
			case PetriNetPackage.NOEUD__SORTANT:
				getSortant().clear();
				getSortant().addAll((Collection<? extends Arc>)newValue);
				return;
			case PetriNetPackage.NOEUD__NET:
				setNet((Net)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PetriNetPackage.NOEUD__ENTRANT:
				getEntrant().clear();
				return;
			case PetriNetPackage.NOEUD__SORTANT:
				getSortant().clear();
				return;
			case PetriNetPackage.NOEUD__NET:
				setNet((Net)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetriNetPackage.NOEUD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PetriNetPackage.NOEUD__ENTRANT:
				return entrant != null && !entrant.isEmpty();
			case PetriNetPackage.NOEUD__SORTANT:
				return sortant != null && !sortant.isEmpty();
			case PetriNetPackage.NOEUD__NET:
				return getNet() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NoeudImpl
