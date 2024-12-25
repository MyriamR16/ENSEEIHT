import java.io.*;

public class Lecture {
    public static String[] recupererInfosUtilisateur(String identifiant, String motDePasse) {
        // Chemin vers le fichier repertoire.txt
        String cheminFichier = "repertoire.txt";

        try {
            // Ouvrir le fichier en mode lecture
            FileReader fileReader = new FileReader(cheminFichier);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String ligne;
            // Lire chaque ligne du fichier
            while ((ligne = bufferedReader.readLine()) != null) {
                String[] infos = ligne.split(",");
                if (infos[0].equals(identifiant) && infos[1].equals(motDePasse)) {
                    return new String[]{infos[2], infos[3], infos[4], infos[5], infos[6]};
                }
            }

            // Fermer le flux d'entrée
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }

        // Retourner null si aucun utilisateur correspondant n'a été trouvé
        return null;
    }

}
