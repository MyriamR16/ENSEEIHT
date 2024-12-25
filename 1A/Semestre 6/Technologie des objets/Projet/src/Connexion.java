import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Connexion extends JFrame {
    public Connexion() {
        setTitle("Connexion");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JTextField identifiantField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> statutComboBox = new JComboBox<>(new String[]{"Client", "Gestionnaire", "Prestataire"});
        JButton connectButton = new JButton("Se connecter");
        JLabel forgotPasswordLabel = new JLabel("Mot de passe oublié ?");
        JButton inscriptionButton = new JButton("INSCRIPTION");
        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (identifiantField.getText().isEmpty() || passwordField.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(Connexion.this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Code pour la connexion
                    // Rediriger vers la fenêtre d'accueil après connexion
                    String identifiant = identifiantField.getText();
                    char[] motDePasse = passwordField.getPassword();
                    String statut = (String) statutComboBox.getSelectedItem();

                    // Vérifier si l'identifiant et le mot de passe existent dans le répertoire
                    if (identifiantExiste(identifiant, new String(motDePasse))) {
                    	String[] infos = Lecture.recupererInfosUtilisateur(identifiant, new String(motDePasse));
                        // Si oui, connexion réussie
                        if (statut.equals("Client")) {
                            dispose();
                            //String[] nom = {infos[0]};
                            String[] info_client = {null, infos[3], infos[4]};
                            String[] info_nom = {infos[0], infos[1]};
                            double solde = Double.parseDouble(infos[2]);
                            System.out.println(solde);
                            Client client = new Client(info_nom, null, info_client, new String(motDePasse), solde);
                            // evenements[] null => il faut une bdd pour les evenements
                            page_Client page_Client = new page_Client(client);
                            page_Client.setVisible(true);
                        } else if (statut.equals("Gestionnaire")) {
                            dispose();
                            page_Gerant page_Gerant = new page_Gerant();
                            page_Gerant.setVisible(true);
                        } else {
                            dispose();
                            page_Prestataire page_Prestataire = new page_Prestataire();
                            page_Prestataire.setVisible(true);
                        }
                        
                    } else {
                        // Sinon, afficher un message d'erreur
                        JOptionPane.showMessageDialog(Connexion.this, "Identifiant ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        inscriptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Inscription inscription = new Inscription();
                inscription.setVisible(true);
            }
        });

        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                MDPOublie mdpOublie = new MDPOublie();
                mdpOublie.setVisible(true);
            }
        });

        panel.add(new JLabel("Identifiant:"));
        panel.add(identifiantField);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(passwordField);
        panel.add(new JLabel("Statut:"));
        panel.add(statutComboBox);
        panel.add(connectButton);
        panel.add(forgotPasswordLabel);
        panel.add(inscriptionButton);

        add(panel);
    }

    private boolean identifiantExiste(String identifiant, String motDePasse) {
        // Utiliser la classe Lecture pour vérifier si l'identifiant et le mot de passe existent dans le répertoire
        String[] infosUtilisateur = Lecture.recupererInfosUtilisateur(identifiant, motDePasse);
        return infosUtilisateur != null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Connexion connexion = new Connexion();
                connexion.setVisible(true);
            }
        });
    }
}
