package simplepdl.manip;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


import simplepdl.*;
import petrinet.*;

public class SimplePDL2PetriNet {

	public static void main(String[] args) {
		
		// Charger le package SimplePDL afin de l'enregistrer dans le registre d'Eclipse.
		SimplepdlPackage packageInstance1 = SimplepdlPackage.eINSTANCE;
		PetriNetPackage packageInstance2 = PetriNetPackage.eINSTANCE;

		
		// Enregistrer l'extension ".xmi" comme devant Ãªtre ouverte Ã 
		// l'aide d'un objet "XMIResourceFactoryImpl"
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (le modÃ¨le)
		ResourceSet resSet = new ResourceSetImpl();
		
		// Charger la ressource (notre modÃ¨le)
		URI modelURI = URI.createURI("fr.n7.simplePDL/developpement.xmi");  //A CHANGER POOUR TESTER ON PRENDS LE MODELE DE SIMPLEPDL A TRANSFORMER
		Resource resourceSimplePDL = resSet.getResource(modelURI, true);
				
		// DÃ©finir la ressource (le modÃ¨le)   LE MODELE PETRINET CREE
		URI modelURI = URI.createURI("models/SimplePDL2PetriNet.xmi");
		Resource resourcePetriNet = resSet.createResource(modelURI);
		
		// La fabrique pour fabriquer les Ã©lÃ©ments de PetriNet
	    SimplepdlFactory myFactory = PetriNetFactory.eINSTANCE;
	    
	    // RÃ©cupÃ©rer le premier Ã©lÃ©ment du modÃ¨le (Ã©lÃ©ment racine) 
	 	Process processSimplePDL = (Process) resourceSimplePDL.getContents().get(0);
	 	
		// CrÃ©er un Ã©lÃ©ment Net dans le modèle crée en Petri Net
		Net net = myFactory.createNet();
		net.setName(processSimplePDL.getName());
		
		// Ajouter le Process dans le modÃ¨le
		resourcePetriNet.getContents().add(net);
		
		// Sauver la ressource
	    //try {
	    	//resource.save(Collections.EMPTY_MAP);
		//} catch (IOException e) {
			//e.printStackTrace();
		//}
	}

}
