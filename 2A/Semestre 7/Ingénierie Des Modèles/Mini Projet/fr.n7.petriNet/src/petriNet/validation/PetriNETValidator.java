package petriNet.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import petriNet.Arc;
import petriNet.ArcType;
import petriNet.Net;
import petriNet.Noeud;
import petriNet.PetriNetPackage;
import petriNet.Place;
import petriNet.Transition;
import petriNet.util.PetriNetSwitch;

/**
 * RÃ©alise la validation d'un EObject issu de SimplePDL (en thÃ©orie, d'un process).
 * Cet classe visite le modÃ¨le et utilise les caseXXX pour rediriger l'algo vers la
 * bonne mÃ©thode.
 * Attention, lorsqu'une classe est un parent il faut aller faire la visite des enfants
 * manuellement (cf. caseProcess typiquement).
 * 
 * La classe Switch exige un paramÃ¨tre de gÃ©nÃ©ricitÃ© (et gÃ¨re une partie de la visite Ã 
 * base de comparaison Ã  null). Ici le paramÃ¨tre est un boolÃ©en mais en rÃ©alitÃ© on ne
 * s'en sert pas...
 * 
 * @author Guillaume Dupont
 * @version 0.1
 */
public class PetriNETValidator extends PetriNetSwitch<Boolean> {
	/**
	 * Expression rÃ©guliÃ¨re qui correspond Ã  un identifiant bien formÃ©.
	 */
	private static final String IDENT_REGEX = "^[A-Za-z_][A-Za-z0-9_]*$";
	
	/**
	 * RÃ©sultat de la validation (Ã©tat interne rÃ©initialisÃ© Ã  chaque nouvelle validation).
	 */
	private ValidationResult result = null;
	
	/**
	 * Construire un validateur
	 */
	public PetriNETValidator() {}
	
	/**
	 * Lancer la validation et compiler les rÃ©sultats dans un ValidationResult.
	 * Cette mÃ©thode se charge de crÃ©er un rÃ©sultat de validation vide puis de
	 *  visiter les process prÃ©sents dans la ressource.
	 * @param resource resource Ã  valider
	 * @return rÃ©sultat de validation
	 */
	public ValidationResult validate(Resource resource) {
		this.result = new ValidationResult();
		
		for (EObject object : resource.getContents()) {
			this.doSwitch(object);
		}
		
		return this.result;
	}


	/**
	 * MÃ©thode appelÃ©e lorsque l'objet visitÃ© est un Net.
	 * Cet mÃ©thode amorce aussi la visite des Ã©lÃ©ments enfants.
	 * @param object Ã©lÃ©ment visitÃ©
	 * @return rÃ©sultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas Ã©chÃ©ant)
	 */
	
	@Override
	public Boolean caseNet(petriNet.Net object) {
		// Contraintes sur net
		this.result.recordIfFailed(
				object.getName() != null && object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom du Net ne respecte pas les conventions Java");
		
		// Visites
		for (Noeud noeud : object.getNoeud()) {
			this.doSwitch(noeud);
		}
		
		for (Arc arc : object.getArcs()) {
			this.doSwitch(arc);
		}
		return null;
	}

	/**
	 * MÃ©thode appelÃ©e lorsque l'objet visitÃ© est un Noeud (ou un sous type).
	 * @param object Ã©lÃ©ment visitÃ©
	 * @return rÃ©sultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas Ã©chÃ©ant)
	 */
	
	@Override
	public Boolean caseNoeud(Noeud object) {
		return null;
	}

	/**
	 * MÃ©thode appelÃ©e lorsque l'objet visitÃ© est une Place.
	 * @param object Ã©lÃ©ment visitÃ©
	 * @return rÃ©sultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas Ã©chÃ©ant)
	 */
	@Override
	public Boolean casePlace(Place object) {
		// Contraintes sur Place
		this.result.recordIfFailed(
				object.getName() != null || object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom de la place ne respecte pas les conventions Java");
		
		this.result.recordIfFailed(
				object.getNet().getNoeud().stream()
					.filter(p -> p.eClass().getClassifierID() == PetriNetPackage.PLACE)
					.allMatch(pe -> (pe.equals(object) || !((Place) pe).getName().contains(object.getName()))),
				object, 
				"Le nom de la place (" + object.getName() + ") n'est pas unique");
	    this.result.recordIfFailed(
	            object.getNbJetons() >= 0,
	            object,
	            "Attention, le nombre de jetons doit être positif !");
		
		return null;
	}
	
	/**
	 * MÃ©thode appelÃ©e lorsque l'objet visitÃ© est une Transition.
	 * @param object Ã©lÃ©ment visitÃ©
	 * @return rÃ©sultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas Ã©chÃ©ant)
	 */
	@Override
	public Boolean caseTransition(Transition object) {
		// Contraintes sur Transition
		this.result.recordIfFailed(
				object.getName() != null || object.getName().matches(IDENT_REGEX), 
				object, 
				"Le nom de la transition ne respecte pas les conventions Java");
		
		this.result.recordIfFailed(
				object.getNet().getNoeud().stream()
					.filter(p -> p.eClass().getClassifierID() == PetriNetPackage.TRANSITION)
					.allMatch(pe -> (pe.equals(object) || !((Transition) pe).getName().contains(object.getName()))),
				object, 
				"Le nom de la transition (" + object.getName() + ") n'est pas unique");
		
		return null;
	}

	/**
	 * MÃ©thode appelÃ©e lorsque l'objet visitÃ© est un Arc.
	 * @param object Ã©lÃ©ment visitÃ©
	 * @return rÃ©sultat de validation (null ici, ce qui permet de poursuivre la visite
	 * vers les classes parentes, le cas Ã©chÃ©ant)
	 */
	
	@Override
	public Boolean caseArc(Arc object) {
		// Contraintes sur Arc
		
		 this.result.recordIfFailed(
		            object.getPoids() >= 1,
		            object,
		            "Attention, le poids dun arc doit forcement etre superieur a 1 !");
		 
		this.result.recordIfFailed(
				object.getSource().getSortant().stream()
					.filter(p -> p.getLinkType() == object.getLinkType())
					.filter(p -> p.getDestination() == object.getDestination())
					.count() == 1,
				object, 
				"Le lien :" + object.getSource().getName() + " " + object.getLinkType().getName() + " " + object.getDestination().getName() + " existe deja !");
		
		 this.result.recordIfFailed(
		            !(object.getSource().eClass().getClassifierID() ==  object.getDestination().eClass().getClassifierID()),
		            object,
		            "Attention, un arc ne peut aller dune place vers une place, ou dune transition a une transition !");
		 	
		return null;
	}

	/**
	 * Cas par dÃ©faut, lorsque l'objet visitÃ© ne correspond pas Ã  un des autres cas.
	 * Cette mÃ©thode est aussi appelÃ©e lorsqu'une mÃ©thode renvoie null (comme une sorte de
	 * fallback).
	 * On pourrait implÃ©menter le switch diffÃ©remment, en ne renvoyant null dans les autres
	 * mÃ©thodes que si la contrainte ne sert Ã  rien, et se servir de cette mÃ©thode pour
	 * identifier les Ã©lÃ©ments Ã©trangers (qui de toute faÃ§on ne doivent pas exister).
	 * C'est aussi la mÃ©thode appelÃ©e si on ne redÃ©fini pas un des caseXXX.
	 * @param object objet visitÃ©
	 * @return rÃ©sultat, null ici
	 */
	
	@Override
	public Boolean defaultCase(EObject object) {
		return null;
	}

	
}
