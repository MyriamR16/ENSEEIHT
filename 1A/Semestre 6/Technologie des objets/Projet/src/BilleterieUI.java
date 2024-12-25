import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BilleterieUI extends JFrame {
    private Billeterie billeterie;
    private Client client;
    private MonPanier panier;
    private JComboBox<String> forfaitCombo;

    public BilleterieUI(Billeterie billeterie, Client client) {
        this.billeterie = billeterie;
        this.client = client;
        this.panier = client.getMonPanier();

        setTitle("Billeterie");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JList<String> eventList = new JList<>(billeterie.getEvenements().stream().map(Evenement::getNom).toArray(String[]::new));
        panel.add(new JScrollPane(eventList), BorderLayout.CENTER);

        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(new GridLayout(0, 2));

        // Utilisation directe du forfait du client
        String[] forfaits = {client.getForfait()};
        forfaitCombo = new JComboBox<>(forfaits);
        JTextField quantityField = new JTextField();
        JButton addButton = new JButton("Ajouter au panier");

        ticketPanel.add(new JLabel("Forfait:"));
        ticketPanel.add(forfaitCombo);
        ticketPanel.add(new JLabel("Quantité:"));
        ticketPanel.add(quantityField);
        ticketPanel.add(addButton);

        panel.add(ticketPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEventName = eventList.getSelectedValue();
                if (selectedEventName == null) {
                    JOptionPane.showMessageDialog(BilleterieUI.this, "Veuillez sélectionner un événement.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String forfait = (String) forfaitCombo.getSelectedItem();
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BilleterieUI.this, "Veuillez entrer une quantité valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Evenement selectedEvent = billeterie.getEvenements().stream()
                            .filter(event -> event.getNom().equals(selectedEventName))
                            .findFirst()
                            .orElse(null);
                    if (selectedEvent != null) {
                        int numeroSiege = 1;
                        int prixBillet = selectedEvent.getForfaitPrix(client);
                        Billet billet = new Billet(selectedEvent, numeroSiege, prixBillet);
                        panier.ajouterBillet(billet, quantity);
                        JOptionPane.showMessageDialog(BilleterieUI.this, "Billet(s) ajouté(s) au panier.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(BilleterieUI.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(panel);
    }
}
