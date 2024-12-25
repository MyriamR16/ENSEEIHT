import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EvenementDetails extends JFrame {

    private Evenement evenement;

    public EvenementDetails(Evenement evenement) {
        this.evenement = evenement;

        setTitle("Détails de l'événement");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(10, 2, 10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font f = new Font("Arial", Font.PLAIN, 14);

        // Labels and values
        content.add(createLabel("Nom: ", f));
        content.add(createValueLabel(evenement.getNom(), f));

        content.add(createLabel("Type: ", f));
        content.add(createValueLabel(evenement.getType(), f));

        content.add(createLabel("Gérant: ", f));
        content.add(createValueLabel(formatGerantNames(evenement.getGerant().getNom()), f));

        content.add(createLabel("Date: ", f));
        content.add(createValueLabel(evenement.getDate().toString(), f));

        content.add(createLabel("Description: ", f));
        JTextArea descriptionArea = new JTextArea(evenement.getDescription());
        descriptionArea.setFont(f);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        content.add(new JScrollPane(descriptionArea));

        content.add(createLabel("Lieu: ", f));
        content.add(createValueLabel(evenement.getLieu().getNom(), f));

        content.add(createLabel("Places Initiales: ", f));
        content.add(createValueLabel(String.valueOf(evenement.getNbPlacesInitiales()), f));

        content.add(createLabel("Places Restantes: ", f));
        content.add(createValueLabel(String.valueOf(evenement.getNbPlacesRestantes()), f));

        content.add(createLabel("Grille Tarifaire: ", f));
        content.add(createValueLabel(formatTarifaire(evenement.getGrilleTarifaire()), f));

        JButton closeButton = new JButton("Fermer");
        closeButton.setFont(f);
        closeButton.addActionListener(e -> dispose());
        content.add(closeButton);

        setContentPane(content);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JLabel createValueLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private String formatGerantNames(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (Object name : strings) {
            sb.append(name.toString()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private String formatTarifaire(int[] grilleTarifaire) {
        StringBuilder sb = new StringBuilder();
        for (int tarif : grilleTarifaire) {
            sb.append(tarif).append(" ");
        }
        return sb.toString().trim();
    }
}
