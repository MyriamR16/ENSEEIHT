
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class page_acceuil extends JFrame {
    
    page_Gerant gerant = new page_Gerant();
    page_Client client = new page_Client(client);
    public page_acceuil() {
        //super("Page d'acceuil");
        this.setTitle("Event Flow                                                         Page d'acceuil");
        
        this.setSize(800,600);
        this.setLocationRelativeTo(null);

        JPanel content = (JPanel) this.getContentPane();
        
        content.setLayout(null);
        Font f = new Font("f1", Font.ITALIC,30);
        
        // bouton gerant
        JButton BoutonGerant = new JButton("Gérant");
        BoutonGerant.setBounds(80,150,200,200);
        BoutonGerant.setFont(f);
        BoutonGerant.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
                    gerant.setVisible(true);
           }  
        });
        content.add(BoutonGerant );

        // bouton client
        JButton BoutonClient = new JButton("Client");
        BoutonClient.setBounds(300,150,200,200);
        BoutonClient.setFont(f);
        BoutonClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                     client.setVisible(true);
            }  
         });
        content.add( BoutonClient);

        // bouton prestataire
        JButton BoutonPrestataire = new JButton("Prestataire");
        BoutonPrestataire.setBounds(520,150,200,200);
        BoutonPrestataire.setFont(f);
        content.add( BoutonPrestataire);
        } 


    public static void main(String[] args) throws Exception {
         // changer le design
         UIManager.setLookAndFeel( new NimbusLookAndFeel());


         // fenetre
         page_acceuil my_page_acceuil = new page_acceuil();
         my_page_acceuil.setVisible(true);
    } 
}
