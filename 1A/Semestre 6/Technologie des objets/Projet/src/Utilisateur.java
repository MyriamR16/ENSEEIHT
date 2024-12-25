import java.util.*;
/**
 * @created 03/2024
 * @project EventFlow
 * @author Simon Lécuyer
 * @version 1.1
 */

/**
 * Cette interface représente un utilisateur dans le système.
 */
public interface Utilisateur {
    /**
     * Méthodes de l'inteface Utilisateur.
     */

    /**
     * Renvoie le type de l'utilisateur.
     *
     * @return le type de l'utilisateur
     */
    public String getType(); 

    /**
     * Renvoie le nom de l'utilisateur.
     *
     * @return le nom de l'utilisateur
     */
    public String[] getNom();

    /**
     * Renvoie le prénom de l'utilisateur.
     *
     * @return le prénom de l'utilisateur
     */
    public String getPrenom();

    /**
     * Renvoie la liste des événements auxquels l'utilisateur participe.
     *
     * @return la liste des événements auxquels l'utilisateur participe
     */
    public Evenement[] getEvenements();

    /**
     * Renvoie les informations supplémentaires sur l'utilisateur.
     *
     * @return les informations supplémentaires sur l'utilisateur
     */
    public String[] getInfos();

    /**
     * Renvoie le mot de passe de l'utilisateur.
     *
     * @return le mot de passe de l'utilisateur
     */
    public String getMotDePasse();
}
