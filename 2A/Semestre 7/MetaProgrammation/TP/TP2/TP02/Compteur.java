public class Compteur {
    static public int nbPreparer = 0; 
    static public int nbNettoyer = 0; 
    static public int nbTest = 0; 
    
    public static void reset() {
        nbTest = 0 ; 
        nbNettoyer = 0;
        nbPreparer = 0;
    }
}

