import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChatbotAppTest {
	private Billeterie billeterie;
	private ChatbotApp chatbotApp;
	
	@Before
	public void Initialisation() {
		billeterie = new Billeterie();
	    // Ajout d'événements de démonstration
		billeterie.ajouterEvenementBilleterie(new Evenement("Concert", 100, 20, 15, 10));
		
	    billeterie.ajouterEvenementBilleterie(new Evenement("Théâtre", 50, 30, 25, 20));
        chatbotApp = new ChatbotApp(billeterie);
	}

    @Test
    public void testRespondToSalutation() {
        String response = chatbotApp.respondTo("Bonjour !");
        assertTrue(response.contains("Bonjour"));
    }

    @Test
    public void testRespondToDemandeEvenements() {
        String response = chatbotApp.respondTo("Montre-moi les événements récents.");
        assertTrue(response.contains("Voici les 2 derniers événements :\n" + 
        		"- Concert\n" + 
        		"- Théâtre"));
    }

    @Test
    public void testRespondToDemandeConnexion() {
        String response = chatbotApp.respondTo("Comment se connecter ?");
        assertTrue(response.contains("Pour vous connecter, veuillez utiliser la page de connexion"));
    }

    @Test
    public void testRespondToDemandePromo() {
        String response = chatbotApp.respondTo("Comment utiliser une promo ?");
        assertTrue(response.contains("Pour appliquer les promotions"));
    }

    @Test
    public void testRespondToDefault() {
        String response = chatbotApp.respondTo("Ceci est un message aléatoire.");
        assertTrue(response.contains("Je suis un chatbot de gestion d'événements"));
    }
}
