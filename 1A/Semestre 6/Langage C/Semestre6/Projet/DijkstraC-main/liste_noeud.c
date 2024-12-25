#define _GNU_SOURCE
#include "liste_noeud.h"
#include <stdlib.h>
#include <math.h>

typedef struct cellule {
    noeud_id_t noeud;
    double distance;
    noeud_id_t precedent;
    struct cellule *suivant;
} cellule;

struct liste_noeud_t {
    struct cellule *debut;
    struct cellule *fin;
};

/**
 * creer_liste : crée une liste de noeuds, initialement vide
 */

liste_noeud_t* creer_liste() {
    liste_noeud_t *liste;
    liste = (liste_noeud_t*)malloc(sizeof(liste_noeud_t)); 
    if (liste != NULL) {
        liste->debut = NULL; 
        liste->fin = NULL;
    }
    return liste;
}

/**
 * detruire_liste : détruit la liste passée en paramètre
 */
void detruire_liste(liste_noeud_t** liste_ptr){
   if (liste_ptr != NULL && (*liste_ptr)!=NULL) {
        while ((*liste_ptr)->debut != NULL) {
            cellule* A_detruire = (*liste_ptr)->debut;
            (*liste_ptr)->debut = (*liste_ptr)->debut->suivant;
            free(A_detruire);
        }
        free(*liste_ptr);
        *liste_ptr =NULL;
   }
}

/**
 * est_vide_liste : test si la liste passée en paramètre est vide
 */
bool est_vide_liste(const liste_noeud_t* liste){
    return (liste==NULL) || (liste->debut == NULL);
}

/**
 * contient_noeud_liste : test si le noeud donné appartient à la liste donnée.
 */
bool contient_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud){
    if (est_vide_liste(liste)){
        return false;
    } 
    
    cellule* curseur = liste->debut; 
    while (curseur != NULL){
        if (curseur->noeud == noeud){
            return true;
        }
        curseur = curseur->suivant;
    }
    return false;
}

/**
 * contient_arrete_liste : test si l'arrête donnée appartient à la liste donnée.
 * L'arrête (source, destination) appartient à la liste ssi destination appartient à liste
 * et si prec(destination) == source.
 */
bool contient_arrete_liste(const liste_noeud_t* liste, noeud_id_t source, noeud_id_t destination){
    if (est_vide_liste(liste)){
        return false;
    }
    cellule* curseur = liste->debut; 
    while (curseur != NULL){
        if ((curseur->noeud == destination) && (curseur->precedent == source)){
            return true;
        }
        curseur = curseur->suivant;
    }
    return false;
}

/**
 * distance_noeud_liste : récupère la distance associée au noeud donné dans la liste donnée.
 * Si le noeud n'existe pas dans la liste, retourne `INFINITY`.
 */
double distance_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud){
    if (est_vide_liste(liste)){
        return INFINITY;
    }
    cellule* curseur = liste->debut;
    while (curseur != NULL){
        if (curseur->noeud == noeud){
            return curseur->distance;
        }
        curseur = curseur->suivant;
    }
    return INFINITY;
}

/**
 * precedent_noeud_liste : récupère le noeud précédent associé au noeud donné dans la liste donnée.
 * Si le noeud n'existe pas, retourne `NO_ID`.
 */
noeud_id_t precedent_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud){
    if (est_vide_liste(liste)){
        return NO_ID;
    }
    cellule* curseur = liste->debut; 
    while (curseur != NULL){
        if (curseur->noeud == noeud){
            return curseur->precedent;
        }
        curseur = curseur->suivant;
    }
    return NO_ID;
}

/**
 * min_noeud_liste : trouve le (un) noeud de la liste dont la distance associée est la plus petite,
 * ou renvoie `NO_ID` si la liste est vide.
 */
noeud_id_t min_noeud_liste(const liste_noeud_t* liste){
    if (est_vide_liste(liste)){
        return NO_ID;
    }
    noeud_id_t noeud_min = NO_ID;
    double distance_min = INFINITY;
    cellule* curseur = liste->debut; 
    while (curseur != NULL){
        if (curseur->distance < distance_min){
            distance_min = curseur->distance;
            noeud_min = curseur->noeud;
        }
        curseur = curseur->suivant;
    }
    return noeud_min;

}

/**
 * inserer_noeud_liste : insère le noeud donné dans la liste
 */
 void inserer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, double distance){
    cellule* cellule_ajoutee = (cellule*)malloc(sizeof(cellule)); 
    cellule_ajoutee->noeud = noeud; 
    cellule_ajoutee->precedent = precedent;
    cellule_ajoutee->distance = distance;
    cellule_ajoutee->suivant = NULL;

    if ((liste == NULL) || (cellule_ajoutee == NULL)){
        return;
    }
    if (liste->debut == NULL){
        liste->debut = cellule_ajoutee;
        liste->fin = cellule_ajoutee;
    } else {
        liste->fin->suivant = cellule_ajoutee;
        liste->fin = cellule_ajoutee;
    }
 }

/**
 * changer_noeud_liste : modifie les valeurs associées au noeud donné dans la liste donnée.
 * Si le noeud n'est pas dans la liste, il est ajouté.
 */
void changer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, double distance){
    if (contient_noeud_liste(liste, noeud) == false){
        inserer_noeud_liste(liste,noeud,precedent,distance);
    }else{
        //Si la liste contient le noeud, c'est qu'elle est non vide, donc pas 
        //la peine de traiter le cas liste vide à part ! 
        cellule* curseur = liste->debut;
        while (curseur != NULL){
            if (curseur->noeud == noeud){
                curseur->precedent = precedent;
                curseur->distance = distance;
            }
            curseur = curseur->suivant;
        }       
    }
}

/**
 * supprimer_noeud_liste : supprime le noeud donné de la liste. Si le noeud n'est pas dans la liste,
 * ne fait rien.
 */
void supprimer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud){
    if (contient_noeud_liste(liste,noeud)==true){
        //la liste est non vide
        cellule* avant = NULL;
        cellule* curseur = liste->debut; 
        
        if (curseur->noeud==noeud){
            //Cas où le noeud est en premiere position de la liste
            liste->debut = curseur->suivant;
            free(curseur);
        }else{
            while (curseur != NULL && curseur->noeud != noeud) {
                avant = curseur;
                curseur = curseur->suivant;
            }
            
            if (curseur != NULL) {
                avant->suivant = curseur->suivant;
                if (curseur == liste->fin) {
                    liste->fin = avant; 
                }
                free(curseur);
            }
        }
    }
}