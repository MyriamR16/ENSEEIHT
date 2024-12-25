import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MesTicketsUI extends JFrame {

    private MesTickets mesTickets;

    public MesTicketsUI(MesTickets mesTickets) {
        this.mesTickets = mesTickets;

        setTitle("Mes Tickets");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel ticketsPanel = new JPanel();
        ticketsPanel.setLayout(new BoxLayout(ticketsPanel, BoxLayout.Y_AXIS));

        List<Billet> billets = mesTickets.getBillets();
        for (Billet billet : billets) {
            JPanel billetPanel = new JPanel(new GridLayout(1, 3));
            billetPanel.add(new JLabel("Événement: " + billet.getEvent().getNom()));
            billetPanel.add(new JLabel("Date: " + billet.getEvent().getDate()));
            billetPanel.add(new JLabel("Prix: " + billet.getPrixBillet()));
            AffichageSalle affichagesalle = new AffichageSalle();
            JButton BoutonSalle = new JButton("salle");
            billetPanel.add(BoutonSalle);
            BoutonSalle.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    affichagesalle.setVisible(true);
                }
            });
            ticketsPanel.add(billetPanel);

        }

        content.add(new JScrollPane(ticketsPanel), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre actuelle et retourne à la fenêtre précédente
            }
        });
        buttonPanel.add(retourButton);

        content.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(content);
    }
}
