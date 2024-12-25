import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class page_Client extends JFrame {

    public page_Client(Client client) {
        setTitle("Event Flow                                                         Acceuil Client");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel content = (JPanel) this.getContentPane();
        content.setLayout(null);
        Font f = new Font("f1", Font.ITALIC, 15);

        Icon home = new ImageIcon("homeicon1.png");
        JButton BoutonHome = new JButton(home);
        BoutonHome.setBounds(0, 0, 50, 50);

        BoutonHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Connexion connexion = new Connexion();
                connexion.setVisible(true);
            }
        });
        content.add(BoutonHome);

        JButton BoutonGerant = new JButton("Détails événements");
        BoutonGerant.setBounds(40, 150, 170, 170);
        BoutonGerant.setFont(f);
        content.add(BoutonGerant);

        JButton BoutonClient = new JButton("Billeterie");
        BoutonClient.setBounds(220, 150, 170, 170);
        BoutonClient.setFont(f);
        content.add(BoutonClient);

        // Nouveau bouton pour ouvrir le chatbot
        JButton BoutonChatbot = new JButton("Chatbot");
        BoutonChatbot.setBounds(40, 350, 170, 170);
        BoutonChatbot.setFont(f);
        content.add(BoutonChatbot);

        JButton BoutonPanier = new JButton("Mon panier");
        BoutonPanier.setBounds(400, 150, 170, 170);
        BoutonPanier.setFont(f);
        content.add(BoutonPanier);

        JButton BoutonSuivi = new JButton("Mes Tickets");
        BoutonSuivi.setBounds(580, 150, 170, 170);
        BoutonSuivi.setFont(f);
        content.add(BoutonSuivi);

        String[] a = {"jean", "françois"};
        Gerant gerant = new Gerant(a, null, null, "1234");
        int[] grilleTarifaire = {15, 29, 45};
        Evenement event = new Evenement("Garorock", "Festival", gerant, new java.util.Date(2024, 10, 23), "festival", new Lieu("Marmande", "extérieur", 1000),
        grilleTarifaire, 100, true, 1);
        String[] b = {"AE", "N7"};
        Gerant gerant2 = new Gerant(b, null, null, "1234567");
        int[] grilleTarifaire2 = {11, 7, 11};
        Evenement event2 = new Evenement("Hall C", "Soirée", gerant2, new Date(2024, 9, 23), "Soirée Hall C", new Lieu("N7", "Hall", 400),
                grilleTarifaire2, 400, false, 0);
        int[] grilleTarifaire3 = {0, 0, 0};
        Evenement event3 = new Evenement("LJC", "Projection", gerant2, new Date(2024, 8, 23), "Venez voir le LJC1", new Lieu("N7 BOO", "Amphi", 400),
                grilleTarifaire3, 400, false, 0);

        BoutonGerant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EvenementDetails detailsFrame = new EvenementDetails(event);
                EvenementDetails detailsFrame2 = new EvenementDetails(event2);
                EvenementDetails detailsFrame3 = new EvenementDetails(event3);
                detailsFrame.setVisible(true);
                detailsFrame2.setVisible(true);
                detailsFrame3.setVisible(true);
            }
        });

        BoutonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Billeterie billeterie = new Billeterie(client.getMonPanier());
                billeterie.ajouterEvenementBilleterie(event);
                billeterie.ajouterEvenementBilleterie(event2);
                billeterie.ajouterEvenementBilleterie(event3);
                BilleterieUI ui = new BilleterieUI(billeterie, client);
                ui.setVisible(true);
            }
        });

        BoutonPanier.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MonPanierUI monPanierUI = new MonPanierUI(client.getMonPanier());
        		monPanierUI.setVisible(true);
            }
        });

        BoutonSuivi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MesTicketsUI mesTicketsUI = new MesTicketsUI(client.getMesTickets());
                mesTicketsUI.setVisible(true);
            }
        });
        
        BoutonChatbot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChatbotApp chatbotApp = new ChatbotApp(new Billeterie(client.getMonPanier()));
                ChatbotUI chatbotUI = new ChatbotUI(chatbotApp);
                chatbotUI.setVisible(true);
            }
        });
    }
}
