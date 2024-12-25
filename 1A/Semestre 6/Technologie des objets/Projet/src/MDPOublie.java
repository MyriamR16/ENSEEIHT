import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MDPOublie extends JFrame {
    public MDPOublie() {
        setTitle("Mot de passe oublié");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        JTextField nomField = new JTextField();
        JTextField prenomField = new JTextField();
        JTextField identifiantField = new JTextField();
        JTextField ageField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JButton confirmButton = new JButton("Confirmer");
        JLabel cancelLabel = new JLabel("Annuler la modification du mot de passe ?");
        cancelLabel.setForeground(Color.BLUE);
        cancelLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Vérifier si tous les champs sont remplis
                if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() ||
                    identifiantField.getText().isEmpty() || ageField.getText().isEmpty() ||
                    newPasswordField.getPassword().length == 0 || confirmPasswordField.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(MDPOublie.this, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Vérifier si les deux mots de passe correspondent
                    char[] newPassword = newPasswordField.getPassword();
                    char[] confirmPassword = confirmPasswordField.getPassword();
                    boolean passwordsMatch = true;
                    if (newPassword.length != confirmPassword.length) {
                        passwordsMatch = false;
                    } else {
                        for (int i = 0; i < newPassword.length; i++) {
                            if (newPassword[i] != confirmPassword[i]) {
                                passwordsMatch = false;
                                break;
                            }
                        }
                    }
                    if (!passwordsMatch) {
                        JOptionPane.showMessageDialog(MDPOublie.this, "Les mots de passe ne correspondent pas", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Code pour confirmer la modification du mot de passe
                        String nom = nomField.getText();
                        String prenom = prenomField.getText();
                        String identifiant = identifiantField.getText();
                        String age = ageField.getText();
                        String nouveauMotDePasse = new String(newPassword);

                        boolean success = ModifMDP.verifierEtModifierMotDePasse(nom, prenom, identifiant, age, nouveauMotDePasse);

                        if (success) {
                            JOptionPane.showMessageDialog(MDPOublie.this, "Mot de passe modifié avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            Connexion connexion = new Connexion();
                            connexion.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(MDPOublie.this, "Informations incorrectes", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        cancelLabel.addMouseListener(new MouseAdapter() {
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
        panel.add(new JLabel("Date de naissance(dd-mm-yyyy):"));
        panel.add(ageField);
        panel.add(new JLabel("Nouveau mot de passe:"));
        panel.add(newPasswordField);
        panel.add(new JLabel("Confirmer le nouveau mot de passe:"));
        panel.add(confirmPasswordField);
        panel.add(confirmButton);
        panel.add(cancelLabel);

        add(panel);
    }
}
