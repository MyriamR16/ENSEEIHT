import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class page_Gerant extends JFrame {
    

    public page_Gerant() {
        
        this.setTitle("Event Flow                                                         Acceuil Gérant");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);

        JPanel content = (JPanel) this.getContentPane();
        
        content.setLayout(null);
        Font f = new Font("f1", Font.ITALIC,15);
        //Font f1 = new  Font(Font.ITALIC, Font.BOLD , 15);

        Icon home = new ImageIcon("homeicon1.png");
        JButton BoutonHome = new JButton(home);
        BoutonHome.setBounds(0,0,50,50);
        
        BoutonHome.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                dispose();
                Connexion connexion = new Connexion();
                connexion.setVisible(true);
            }
        } );
         content.add(BoutonHome);

        JButton BoutonGerant = new JButton("Création EVENEMENTS");
        BoutonGerant.setBounds(40,150,170,170);
        BoutonGerant.setFont(f);
        content.add(BoutonGerant );
        JButton BoutonClient = new JButton("Gestion PARTICIPANTS");
        BoutonClient.setBounds(220,150,170,170);
        BoutonClient.setFont(f);
        content.add( BoutonClient);
        JButton BoutonPrestataire = new JButton("Gestion DES SALLES");
        BoutonPrestataire.setBounds(400,150,170,170);
        BoutonPrestataire.setFont(f);
        content.add( BoutonPrestataire);
        JButton BoutonSuivi = new JButton("Suivi des ventes et revenus");
        BoutonSuivi.setBounds(580,150,170,170);
        BoutonSuivi.setFont(f);
        content.add( BoutonSuivi);
        } 
    
}
