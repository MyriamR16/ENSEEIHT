
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonPanierUI extends JFrame {

    private MonPanier panier;
    private JLabel totalLabel;
    private JLabel soldeLabel; // Label pour afficher le solde

    public MonPanierUI(MonPanier panier) {
        this.panier = panier;

        setTitle("Mon Panier");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel panierPanel = new JPanel();
        panierPanel.setLayout(new BoxLayout(panierPanel, BoxLayout.Y_AXIS));

        updatePanierPanel(panierPanel);

        content.add(new JScrollPane(panierPanel), BorderLayout.CENTER);

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        totalLabel = new JLabel("Total: " + String.format("%.2f", panier.calculTotal()));
        soldeLabel = new JLabel("Solde: " + String.format("%.2f", panier.getClient().getSolde())); // Initialisation du solde
        totalPanel.add(totalLabel);
        totalPanel.add(soldeLabel); // Ajout du label solde au panneau
        content.add(totalPanel, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton validerButton = new JButton("Valider");
        validerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (panier.getBillets().isEmpty()) {
                    JOptionPane.showMessageDialog(MonPanierUI.this, "Le panier est vide !", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        panier.validerMonPanier();
                        JOptionPane.showMessageDialog(MonPanierUI.this, "Achat validé !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                        updateTotal();
                        updateSolde(); // Mise à jour du solde après validation
                        updatePanierPanel(panierPanel); // Met à jour l'affichage des billets
                    } catch (SoldeInvalide ex) {
                        JOptionPane.showMessageDialog(MonPanierUI.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        buttonPanel.add(validerButton);

        JButton viderButton = new JButton("Vider le Panier");
        viderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panier.getBillets().clear();
                panier.getCompteurBillets().clear();
                updateTotal();
                updateSolde(); // Mise à jour du solde après vidage du panier
                updatePanierPanel(panierPanel); // Met à jour l'affichage des billets
            }
        });
        buttonPanel.add(viderButton);

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(retourButton);

        content.add(buttonPanel, BorderLayout.NORTH);

        this.setContentPane(content);
    }

    private void updateTotal() {
        totalLabel.setText("Total: " + String.format("%.2f", panier.calculTotal()));
        this.repaint();
        this.revalidate();
    }

    private void updateSolde() {
        soldeLabel.setText("Solde: " + String.format("%.2f", panier.getClient().getSolde()));
        this.repaint();
        this.revalidate();
    }

    private void updatePanierPanel(JPanel panierPanel) {
        panierPanel.removeAll(); // Nettoie le panneau avant de le remplir à nouveau

        // Utilisez une carte pour regrouper les billets par événement
        Map<Evenement, Integer> eventBillets = new HashMap<>();
        for (Billet billet : panier.getBillets()) {
            Evenement event = billet.getEvent();
            // Ajoutez simplement 1 à la quantité pour chaque billet trouvé
            eventBillets.put(event, eventBillets.getOrDefault(event, 0) + 1);
        }

        // Ajoutez les événements et leurs quantités au panneau
        for (Map.Entry<Evenement, Integer> entry : eventBillets.entrySet()) {
            Evenement event = entry.getKey();
            int quantity = entry.getValue();
            Billet billet = panier.getBillets().stream().filter(b -> b.getEvent().equals(event)).findFirst().orElse(null);

            if (billet != null) {
                JPanel billetPanel = new JPanel(new GridLayout(1, 3));
                billetPanel.add(new JLabel("Événement: " + event.getNom()));
                billetPanel.add(new JLabel("Prix: " + String.format("%.2f", billet.getPrixBillet() * quantity)));
                billetPanel.add(new JLabel("Quantité: " + quantity));
                panierPanel.add(billetPanel);
            }
        }

        panierPanel.revalidate();
        panierPanel.repaint();
    }
}