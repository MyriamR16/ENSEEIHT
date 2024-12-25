#ifndef COMPLEX_H
#define COMPLEX_H

// Type utilisateur complexe_t
struct complexe {
    double reelle;
    double imaginaire;
};

typedef struct complexe complexe_t; 


// Fonctions reelle et imaginaire
/**
 * reelle
 *
 * Cette fonction associe à un nombre complexe sa partie réelle
 * 
 * Paramètres : 
 * z le complexe dont on veut la partie reelle
 *
 *Retour : Re(z) qui est un flottant 
 *
 *Pre-condition : Pas de pré-condition
 *Post-condition : Pas de post-condition
 *
 * Cas d'erreur : aucun 
 */
double reelle (complexe_t z);

/**
 * imaginaire
 *
 * Cette fonction associe à un nombre complexe sa partie imaginaire
 * 
 * Paramètres : 
 * z le complexe dont on veut la partie imaginaire
 *
 *Retour : Im(z) qui est un flottant 
 *
 *Pre-condition : Pas de pré-condition
 *Post-condition : Pas de post-condition
 *
 * Cas d'erreur : aucun 
 */
double imaginaire (complexe_t z);

// Procédures set_reelle, set_imaginaire et init
/**
 * set_reelle
 *
 * Cette fonction modifie la partie réelle du nombre complexe donné avec le nombre réel donné.
 * 
 * Paramètres : 
 * z le pointeur du complexe dont on veut modifier la partie reelle
 * r floattant qu'on remplace dans la partie reelle de z
 *
 * Retour : z modifié
 *
 *Pre-condition :  Pas de pré-condition
 *Post-condition : Re(z) = r 
 *
 * Cas d'erreur : aucun 
 */
void set_reelle (complexe_t* z , double r);


/**
 * set_imaginaire
 *
 * Cette fonction modifie la partie imaginaire du nombre complexe donné avec le nombre réel donné.
 * 
 * Paramètres : 
 * z le pointeur du complexe dont on veut modifier la partie imaginaire
 * imaginaire floattant qu'on remplace dans la partie imaginaire de z
 *
 * Retour : z modifié
 *
 *Pre-condition :  Pas de pré-condition
 *Post-condition : Im(z) = im 
 *
 * Cas d'erreur : aucun 
 */
void set_imaginaire (complexe_t* z , double im);


/**
 * init
 *
 * Cette fonction modifie la partie réelle et la partie imaginaire du nombre complexe donné
avec les deux réels donnés (partie réelle puis imaginaire, dans cet ordre).
 * 
 * Paramètres : 
 * z le pointeur du complexe qu'on veut modifier
 * r flottant qu'on remplace dans la partie reelle de z
 * imaginaire floattant qu'on remplace dans la partie imaginaire de z
 *
 * Retour : z modifié
 *
 *Pre-condition :  Pas de pré-condition
 *Post-condition : im(z) = imaginaire && Re(z)=r
 *
 * Cas d'erreur : aucun 
 */
void init(complexe_t* z , double r , double im);

// Procédure copie
/**
 * copie
 * Copie les composantes du complexe donné en second argument dans celles du premier
 * argument
 *
 * Paramètres :
 *   resultat       [out] Complexe dans lequel copier les composantes
 *   autre          [in]  Complexe à copier
 *
 * Pré-conditions : resultat non null
 * Post-conditions : resultat et autre ont les mêmes composantes
 */
void copie(complexe_t* resultat, complexe_t autre);

// Algèbre des nombres complexes
/**
 * conjugue
 * Calcule le conjugué du nombre complexe op et le sotocke dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut le conjugué
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : reelle(*resultat) = reelle(op), complexe(*resultat) = - complexe(op)
 */
void conjugue(complexe_t* resultat, complexe_t op);

/**
 * ajouter
 * Réalise l'addition des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche + droite
 */
void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * soustraire
 * Réalise la soustraction des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche - droite
 */
void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * multiplier
 * Réalise le produit des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche * droite
 */
void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite);

/**
 * echelle
 * Calcule la mise à l'échelle d'un nombre complexe avec le nombre réel donné (multiplication
 * de op par le facteur réel facteur).
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe à mettre à l'échelle
 *   facteur        [in]  Nombre réel à multiplier
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = op * facteur
 */
void echelle(complexe_t* resultat, complexe_t op, double facteur);

/**
 * puissance
 * Calcule la puissance entière du complexe donné et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut la puissance
 *   exposant       [in]  Exposant de la puissance
 *
 * Pré-conditions : resultat non-null, exposant >= 0
 * Post-conditions : *resultat = op * op * ... * op
 *                                 { n fois }
 */

void puissance(complexe_t* resultat, complexe_t op, int exposant);

// Module et argument
/**
 * module_carre 
 * 
 * Cette fonction calcule le carré du module du complexe donné en paramètre.
 *
 * Paramètres : 
 * z le complexe dont on veut calculer le carré du module
 *
 *Pré-condtion : Pas de pré-condition.
 *Post-condition : module_carre(z)>=0
 *
 *Cas d'erreur :aucun
 */

double module_carre (complexe_t z);

/**
 * module 
 * 
 * Cette fonction calcule le module du complexe donné en paramètre.
 *
 * Paramètres : 
 * z le complexe dont on veut calculer le module
 *
 *Pré-condtion : Pas de pré-condition.
 *Post-condition : module(z)>=0
 *
 *Cas d'erreur :aucun
 */

double module (complexe_t z);

/**
 * argument 
 * 
 * Cette fonction calcule l'argument du complexe donné en paramètre.
 *
 * Paramètres : 
 * z le complexe dont on veut calculer l'argument
 *
 *Pré-condtion : Pas de pré-condition.
 *Post-condition : Pas de Post-condition
 *
 *Cas d'erreur :aucun
 */

double argument (complexe_t z);

#endif // COMPLEXE_H



