import java.io.*;

public class Ecriture {
    public static void ajouterInfosUtilisateur(String identifiant, String motDePasse, String nom, String prenom, String soldeBancaire, String age, String statutEtudiant) {
        // Chemin vers le fichier repertoire.txt
        String cheminFichier = "repertoire.txt";

        try {
            // Ouvrir le fichier en mode append (ajout)
            FileWriter fileWriter = new FileWriter(cheminFichier, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Écrire les informations de l'utilisateur dans le fichier
            bufferedWriter.write(identifiant + "," + motDePasse + "," + nom + "," + prenom + "," + soldeBancaire + "," + age + "," + statutEtudiant);
            bufferedWriter.newLine(); // Ajouter une nouvelle ligne

            // Fermer le flux de sortie
            bufferedWriter.close();
            System.out.println("Informations utilisateur ajoutées avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

}
