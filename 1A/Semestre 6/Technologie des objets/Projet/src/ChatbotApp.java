import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatbotApp {
    private Billeterie billeterie;
    private List<String> salutations;
    private List<String> demandesEvenements;
    private List<String> demandesConnexion;
    private List<String> demandesPromo;

    public ChatbotApp(Billeterie billeterie) {
        this.billeterie = billeterie;

        // Initialisation des listes de mots clés
        initSalutations();
        initDemandesEvenements();
        initDemandesConnexion();
        initDemandesPromo();
    }

    private void initSalutations() {
        salutations = new ArrayList<>();
        salutations.add("salut");
        salutations.add("bonjour");
        salutations.add("hey");
    }

    private void initDemandesEvenements() {
        demandesEvenements = new ArrayList<>();
        demandesEvenements.add("événements récents");
        demandesEvenements.add("derniers événements");
    }

    private void initDemandesConnexion() {
        demandesConnexion = new ArrayList<>();
        demandesConnexion.add("comment se connecter");
    }

    private void initDemandesPromo() {
        demandesPromo = new ArrayList<>();
        demandesPromo.add("promo");
    }

    public String respondTo(String message) {
        message = message.toLowerCase(); // Convertir le message en minuscules

        if (isSalutation(message)) {
            return "Bonjour ! Je suis un chatbot de gestion d'événements.";
        } else if (isDemandeEvenements(message)) {
            return getLastEvents(5); // Renvoie les 5 derniers événements
        } else if (isDemandeConnexion(message)) {
            return "Pour vous connecter, veuillez utiliser la page de connexion";
        } else if (isDemandePromo(message)) {
            return "Pour appliquer les promotions, veuillez ...";
        } else {
            return "Je suis un chatbot de gestion d'événements. Posez-moi des questions sur les événements!";
        }
    }

    private boolean isSalutation(String message) {
        for (String word : salutations) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDemandeEvenements(String message) {
        for (String word : demandesEvenements) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDemandeConnexion(String message) {
        for (String word : demandesConnexion) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDemandePromo(String message) {
        for (String word : demandesPromo) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private String getLastEvents(int numEvents) {
        StringBuilder response = new StringBuilder();
        List<Evenement> events = billeterie.getEvenements();
        int totalEvents = events.size();
        if (totalEvents == 0) {
            response.append("Il n'y a pas d'événements disponibles.");
        } else {
            int eventsToDisplay = Math.min(totalEvents, numEvents);
            response.append("Voici les ").append(eventsToDisplay).append(" derniers événements :\n");
            for (int i = 0; i < eventsToDisplay; i++) {
                Evenement event = events.get(i);
                response.append("- ").append(event.getNom()).append("\n");
            }
        }
        return response.toString();
    }
}