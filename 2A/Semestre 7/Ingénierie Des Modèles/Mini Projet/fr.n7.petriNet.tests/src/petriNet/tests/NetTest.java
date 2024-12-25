/**
 */
package petriNet.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import petriNet.Net;
import petriNet.PetriNetFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Net</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetTest extends TestCase {

	/**
	 * The fixture for this Net test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Net fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NetTest.class);
	}

	/**
	 * Constructs a new Net test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Net test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Net fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Net test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Net getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PetriNetFactory.eINSTANCE.createNet());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //NetTest
