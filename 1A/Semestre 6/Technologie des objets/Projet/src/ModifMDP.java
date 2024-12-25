import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ModifMDP {

    public static boolean verifierEtModifierMotDePasse(String nom, String prenom, String identifiant, String age, String nouveauMotDePasse) {
        List<String> lignes;
        Path cheminFichier = Paths.get("repertoire.txt");

        try {
            lignes = Files.readAllLines(cheminFichier);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        boolean utilisateurTrouve = false;
        List<String> nouvellesLignes = new ArrayList<>();

        for (String ligne : lignes) {
            String[] details = ligne.split(",");
            if (details.length == 7 &&
                details[0].equals(identifiant) &&
                details[2].equals(nom) &&
                details[3].equals(prenom) &&
                details[5].equals(age)) {
                // Modifier le mot de passe
                details[1] = nouveauMotDePasse;
                utilisateurTrouve = true;
            }
            nouvellesLignes.add(details[0]+","+details[1]+","+details[2]+","+details[3]+","+details[4]+","+details[5]+","+details[6]);
        }

        if (utilisateurTrouve) {
            try {
                Files.write(cheminFichier, nouvellesLignes);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return utilisateurTrouve;
    }
}
