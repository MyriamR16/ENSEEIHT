package simplepdl.manip;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import petriNet.*;
import simplepdl.*;

public class SimplePDL2PetriNet {

	public static void main(String[] args) {
		
		// Charger les packages SimplePDL et PetriNet afin de les enregistrer dans le registre d'Eclipse.
		SimplepdlPackage packageInstance1 = SimplepdlPackage.eINSTANCE;
		PetriNetPackage packageInstance2 = PetriNetPackage.eINSTANCE;

		
		// Enregistrer l'extension ".xmi" comme devant Ãªtre ouverte Ã 
		// l'aide d'un objet "XMIResourceFactoryImpl"
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (le modÃ¨le)
		ResourceSet resGet = new ResourceSetImpl();
		
		// Charger la ressource (notre modÃ¨le)
		URI modelURISimplepdl = URI.createURI("pdl-sujet.xmi");
		Resource resourceSimplePDL = resGet.getResource(modelURISimplepdl, true);
		
		// CrÃ©er un objet resourceSetImpl qui contiendra une ressource EMF (le modÃ¨le)
		ResourceSet resSet = new ResourceSetImpl();
		
		// DÃ©finir la ressource (le modÃ¨le)   LE MODELE PETRINET CREE
		URI modelURIPetriNet = URI.createURI("models/pdl-netsujet.xmi");
		Resource resourcePetriNet = resSet.createResource(modelURIPetriNet);
		
		// La fabrique pour fabriquer les Ã©lÃ©ments de PetriNet
		PetriNetFactory myFactory = PetriNetFactory.eINSTANCE;
	    
	    //---------------------------TRANSFORMER LE PROCESS---------------------------------------------------
	    
	    //Recuperer le process (premier element du modele, element racine)
	 	simplepdl.Process processSimplePDL = (simplepdl.Process) resourceSimplePDL.getContents().get(0);
	 	
	 	//Transformer et ajouter le process dans le modele conforme a PetriNet
		Net net = myFactory.createNet();
		net.setName(processSimplePDL.getName());
		resourcePetriNet.getContents().add(net);
		
		//On parcours les processElements pour rajouter d'abord uniquement les ressources, pour
		// ne pas rencontrer de problemes lorsqu'on cree les occurrences
		for(simplepdl.ProcessElement pe : processSimplePDL.getProcessElements()) {
			if (pe instanceof Ressource) {
				Ressource ress = (Ressource) pe;
			    // TRANSFORMER LES RESSOURCES
				//Transformer et ajouter les ressources dans le modèle conforme à PetriNet
				Place placeRessource = myFactory.createPlace();
				placeRessource.setName(ress.getName());
				placeRessource.setNbJetons(ress.getQuantite());
				net.getNoeud().add(placeRessource);
			}
		}

		//PARCOURIR TOUS LES PROCESSELEMENTS DU PROCESS (WD, WS)
		
		for(simplepdl.ProcessElement pe : processSimplePDL.getProcessElements()) {
			if (pe instanceof WorkDefinition) {
			    // TRANSFORMER LES WORKDEFINTION
				//Transformer et ajouter les workDefinitions dans le modèle conforme à PetriNet
				WorkDefinition wd = (WorkDefinition) pe;
				
				Place placeReady = myFactory.createPlace();
				placeReady.setName(wd.getName() + "_ready");
				placeReady.setNbJetons(0);
				net.getNoeud().add(placeReady);
				
				Place placeStarted = myFactory.createPlace();
				placeStarted.setName(wd.getName() + "_started");
				placeStarted.setNbJetons(0);
				net.getNoeud().add(placeStarted);
				
				Place placeRunning = myFactory.createPlace();
				placeRunning.setName(wd.getName() + "_running");
				placeRunning.setNbJetons(0);
				net.getNoeud().add(placeRunning);
				
				Place placeFinished = myFactory.createPlace();
				placeFinished.setName(wd.getName() + "_finished");
				placeFinished.setNbJetons(0);
				net.getNoeud().add(placeFinished);
				
				Transition transition1 =  myFactory.createTransition();
				transition1.setName(wd.getName() + "_start");
				net.getNoeud().add(transition1);
				
				Transition transition2 =  myFactory.createTransition();
				transition2.setName(wd.getName() + "_finish");
				net.getNoeud().add(transition2);
				
				Arc arcReadyStart = myFactory.createArc();
				arcReadyStart.setPoids(1);
				arcReadyStart.setSource(placeReady);
				arcReadyStart.setDestination(transition1);
				net.getArcs().add(arcReadyStart);
				
				Arc arcStartStarted = myFactory.createArc();
				arcStartStarted.setPoids(1);
				arcStartStarted.setSource(transition1);
				arcStartStarted.setDestination(placeStarted);
				net.getArcs().add(arcStartStarted);
				
				Arc arcStartRunning = myFactory.createArc();
				arcStartRunning.setPoids(1);
				arcStartRunning.setSource(transition1);
				arcStartRunning.setDestination(placeRunning);
				net.getArcs().add(arcStartRunning);
				
				Arc arcRunningFinish = myFactory.createArc();
				arcRunningFinish.setPoids(1);
				arcRunningFinish.setSource(placeRunning);
				arcRunningFinish.setDestination(transition2);
				net.getArcs().add(arcRunningFinish);
				
				Arc arcFinishFinished = myFactory.createArc();
				arcFinishFinished.setPoids(1);
				arcFinishFinished.setSource(transition2);
				arcFinishFinished.setDestination(placeFinished);
				net.getArcs().add(arcFinishFinished);
				
				// Parcours de la liste des occurrences
				for(simplepdl.Occurrence occ : wd.getOccurrence()) {
					Arc occurrence_arc_demande = myFactory.createArc();
					occurrence_arc_demande.setPoids(occ.getOccurrence());
					occurrence_arc_demande.setDestination(transition1);	
					
					Arc occurrence_arc_libere = myFactory.createArc();
					occurrence_arc_libere.setPoids(occ.getOccurrence());
					occurrence_arc_libere.setSource(transition2);
					
					for(Noeud noeud : net.getNoeud()) {
						if (noeud.getName().equals(occ.getRessource().getName())) {
							occurrence_arc_demande.setSource(noeud);
							occurrence_arc_libere.setDestination(noeud);
						}
					}
					
					net.getArcs().add(occurrence_arc_demande);
					net.getArcs().add(occurrence_arc_libere);					
				}
				
					
			}else {
				//Guidance ou les ressources deja rajoutees
			}
		}
		
		for(simplepdl.ProcessElement pe : processSimplePDL.getProcessElements()) {
			if (pe instanceof WorkSequence) {
				// TRANSFORMER LES WORKSEQUENCE
				//Transformer et ajouter les workSequences dans le modèle conforme à PetriNet
				WorkSequence ws = (WorkSequence) pe;
				Arc arc = myFactory.createArc();
				arc.setLinkType(ArcType.READ_ARC);
				arc.setPoids(1);
				if ((ws.getLinkType() == WorkSequenceType.FINISH_TO_FINISH) || (ws.getLinkType() == WorkSequenceType.FINISH_TO_START)) {
					for(Noeud noeud : net.getNoeud()) {
						if (noeud.getName().equals(ws.getPredecessor().getName()+"_finished")) {
							arc.setSource(noeud);
						}
					}	
				} else {
					for(Noeud noeud : net.getNoeud()) {
						if (noeud.getName().equals(ws.getPredecessor().getName()+"_started")) {
							arc.setSource(noeud);
						}
					}					
				}
				
				if ((ws.getLinkType() == WorkSequenceType.FINISH_TO_START) || (ws.getLinkType() == WorkSequenceType.START_TO_START)) {
					for(Noeud noeud : net.getNoeud()) {
						if (noeud.getName().equals(ws.getSuccessor().getName()+"_start")) {
							arc.setDestination(noeud);
						}
					}	
				} else {
					for(Noeud noeud : net.getNoeud()) {
						if (noeud.getName().equals(ws.getSuccessor().getName()+"_finish")) {
							arc.setDestination(noeud);
						}
					}					
				}
			
				net.getArcs().add(arc);	
				
			}
		}
		// Sauver la ressource
	    try {
	    	resourcePetriNet.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}