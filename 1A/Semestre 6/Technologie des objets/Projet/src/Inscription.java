import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inscription extends JFrame {
    public Inscription() {
        setTitle("Inscription");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1));

        JTextField nomField = new JTextField();
        JTextField prenomField = new JTextField();
        JTextField identifiantField = new JTextField();
        JTextField soldeField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField etudiantField = new JTextField();
        //JComboBox<String> statutComboBox = new JComboBox<>(new String[]{"Client", "Gestionnaire", "Prestataire"});
        JPasswordField passwordField = new JPasswordField();
        JButton inscriptionButton = new JButton("S'inscrire");
        JLabel haveAccountLabel = new JLabel("Vous avez déjà un compte ?");
        haveAccountLabel.setForeground(Color.BLUE);
        haveAccountLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        inscriptionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifier si tous les champs sont remplis
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String identifiant = identifiantField.getText();
                String solde = soldeField.getText();
                String age = ageField.getText();
                String statutEtudiant = etudiantField.getText();
                char[] motDePasse = passwordField.getPassword();
                if (nom.isEmpty() || prenom.isEmpty() ||
                    identifiant.isEmpty() || solde.isEmpty() ||
                    age.isEmpty() || motDePasse.length == 0) {
                    JOptionPane.showMessageDialog(Inscription.this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (identifierExisteDeja(identifiant)) {
                        JOptionPane.showMessageDialog(Inscription.this, "L'identifiant existe déjà. Veuillez en choisir un autre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Ajouter les informations de l'utilisateur à repertoire.txt
                        Ecriture.ajouterInfosUtilisateur(identifiant, new String(motDePasse), nom, prenom, solde, age, statutEtudiant);
                        // Afficher un message de succès
                        JOptionPane.showMessageDialog(Inscription.this, "Inscription réussie ! Vous pouvez vous connecter maintenant.");
                        // Fermer la fenêtre d'inscription
                        dispose();
                        // Ouvrir la fenêtre de connexion
                        Connexion connexion = new Connexion();
                        connexion.setVisible(true);
                    }
                }
            }
        });

        haveAccountLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                Connexion connexion = new Connexion();
                connexion.setVisible(true);
            }
        });

        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Prénom:"));
        panel.add(prenomField);
        panel.add(new JLabel("Identifiant:"));
        panel.add(identifiantField);
        panel.add(new JLabel("Solde bancaire:"));
        panel.add(soldeField);
        panel.add(new JLabel("Date de naissance(dd-mm-yyyy):"));
        panel.add(ageField);
        panel.add(new JLabel("Etes vous étudiant? (oui/non):"));
        panel.add(etudiantField);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(passwordField);
        panel.add(inscriptionButton);
        panel.add(haveAccountLabel);

        add(panel);
    }

    private boolean identifierExisteDeja(String identifiant) {
        // Utiliser la classe Lecture pour vérifier si l'identifiant existe déjà dans repertoire.txt
        String[] infosUtilisateur = Lecture.recupererInfosUtilisateur(identifiant, "");
        return infosUtilisateur != null;
    }
}

