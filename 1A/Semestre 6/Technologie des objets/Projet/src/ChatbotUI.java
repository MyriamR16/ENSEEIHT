import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class ChatbotUI extends JFrame {
    private ChatbotApp chatbotApp;

    private JTextField userInputField;
    private JTextArea chatArea;

    private JComboBox<String> faqDropdown;

    public ChatbotUI(ChatbotApp chatbotApp) {
        this.chatbotApp = chatbotApp;

        setTitle("Chatbot de Gestion d'Événements");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        initComponents();
        addComponents();

        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        setVisible(true);
    }

    private void initComponents() {
        userInputField = new JTextField(20);
        userInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        userInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        chatArea = new JTextArea(10, 30);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] faqOptions = {"Salutation", "Événements Récents", "Comment Se Connecter", "Comment Avoir une Promo"};
        faqDropdown = new JComboBox<>(faqOptions);
        faqDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) faqDropdown.getSelectedItem();
                if (selectedOption != null) {
                    userInputField.setText(selectedOption);
                    sendMessage();
                }
            }
        });
    }

    private void addComponents() {
        JPanel chatPanel = new JPanel(new BorderLayout());
        chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        chatPanel.setBorder(BorderFactory.createTitledBorder("Chatbot"));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Vous: "), BorderLayout.WEST);
        inputPanel.add(userInputField, BorderLayout.CENTER);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel faqPanel = new JPanel(new BorderLayout());
        faqPanel.add(new JLabel("Questions Fréquentes: "), BorderLayout.NORTH);
        faqPanel.add(faqDropdown, BorderLayout.CENTER);
        faqPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.NORTH);
        bottomPanel.add(faqPanel, BorderLayout.CENTER);

        add(chatPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void sendMessage() {
        String userMessage = userInputField.getText().trim();
        if (!userMessage.isEmpty()) {
            appendMessage("Vous: " + userMessage);
            String response = chatbotApp.respondTo(userMessage);
            appendMessage("Chatbot: " + response);
            userInputField.setText("");
        }
    }

    private void appendMessage(String message) {
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength()); // Fait défiler la zone de texte vers le bas
    }

}