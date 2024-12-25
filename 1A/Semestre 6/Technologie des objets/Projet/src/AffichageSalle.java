import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class AffichageSalle extends JFrame {
    private JTextField SiegeSelectionneField; 
    private Set<String> SiegeSelectionne = new LinkedHashSet<>(); // Ensemble pour stocker les sièges sélectionnés, en gardant l'ordre
    private JLabel Ecran1;
    private JLabel Ecran2;
    private JLabel EcranText;
    private Salle salle;

    public AffichageSalle() {

        // Initialisation de la salle.
        salle = new Salle("Salle1","Cinema",72);
        
        setTitle("Réservation de Sièges");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel contentPanel = new JPanel(new BorderLayout(1, 1)); // un Jpanel pour la partie interieure de la fenetre
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //configuration de l'ecran de la salle 
        JPanel NorthPanel = new JPanel(new GridLayout(3,1));
        Ecran1 = new JLabel("/-----------------------------------------------\\", SwingConstants.CENTER);
        Ecran2 = new JLabel("/-------------------------------------------------\\", SwingConstants.CENTER);
        
        EcranText = new JLabel("Scène", SwingConstants.CENTER);

        NorthPanel.add(Ecran1);
        NorthPanel.add(Ecran2);
        NorthPanel.add(EcranText);
        contentPanel.add(NorthPanel, BorderLayout.NORTH);
        
        
        // Configuration du panneau des sièges
        JPanel seatPanel = new JPanel(new GridLayout(6, 12, 10, 10)); // Uniformiser la grille pour tous les sièges
        contentPanel.add(seatPanel, BorderLayout.CENTER);
        InitialiserSiege(seatPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        SiegeSelectionneField = new JTextField(25);
        SiegeSelectionneField.setEditable(false);
        SiegeSelectionneField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        SiegeSelectionneField.setFont(new Font("Arial", Font.BOLD, 14));

        JButton confirmButton = new JButton("Confirmer");
        confirmButton.addActionListener(this::ConfirmerSelection);
        bottomPanel.add(SiegeSelectionneField);
        bottomPanel.add(confirmButton);

        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void InitialiserSiege(JPanel seatPanel) {
        int s = 0;
        for (int ligne = 0; ligne < 6; ligne++) {
            
            for (int colonne = 1; colonne <= 12; colonne++) {
                //if (salle.placesPrises[colonne+s-1] != null ){
                  //  JButton seat = new JButton("Ocuppé");
              //  } else {
                JButton seat = new JButton("" + (colonne+s));
                seat.setPreferredSize(new Dimension(50, 50)); // Uniformiser la taille des sièges
                seat.addActionListener(this::seatClicked);
                if (colonne == 4 || colonne == 9) { // Espaces pour simuler les allées
                    seatPanel.add(new JLabel(""));

                } else {
                    seatPanel.add(seat);
                }
                }
            s +=12;
            }
        //}

    }
    

    private void seatClicked(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String seatLabel = button.getText();
        Color initialColor = UIManager.getColor("Button.background");
        if (button.getBackground().equals(Color.RED)) {
            button.setBackground(initialColor);
            SiegeSelectionne.remove(seatLabel);
        } else {
            button.setBackground(Color.RED);
            SiegeSelectionne.add(seatLabel);
        }
        SiegeSelectionneField.setText(String.join(", ", SiegeSelectionne));
    }

    private void ConfirmerSelection(ActionEvent e) {
        if (SiegeSelectionne.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun siège sélectionné");
        } else {
            JOptionPane.showMessageDialog(this, "Sièges sélectionnés : " + SiegeSelectionneField.getText());
        }
    }

 

    ;


    public static void main(String[] args) {
        
            AffichageSalle frame = new AffichageSalle();
            frame.setVisible(true);
    ;
    }
}
