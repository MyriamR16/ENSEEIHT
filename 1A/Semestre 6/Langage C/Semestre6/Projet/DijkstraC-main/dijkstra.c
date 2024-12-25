#include "dijkstra.h"
#include <stdlib.h>

/**
 * construire_chemin_vers - Construit le chemin depuis le noeud de départ donné vers le
 * noeud donné. On passe un chemin en entrée-sortie de la fonction, qui est mis à jour
 * par celle-ci.
 *
 * Le noeud de départ est caractérisé par un prédécesseur qui vaut `NO_ID`.
 *
 * Ce sous-programme fonctionne récursivement :
 *  1. Si le noeud a pour précédent `NO_ID`, on a fini (c'est le noeud de départ, le chemin de
 *     départ à départ se compose du simple noeud départ)
 *  2. Sinon, on construit le chemin du départ au noeud précédent (appel récursif)
 *  3. Dans tous les cas, on ajoute le noeud au chemin, avec les caractéristiques associées dans visites
 *
 * @param chemin [in/out] chemin dans lequel enregistrer les étapes depuis le départ vers noeud
 * @param visites [in] liste des noeuds visités créée par l'algorithme de Dijkstra
 * @param noeud noeud vers lequel on veut construire le chemin depuis le départ
 */
void construire_chemin_vers(liste_noeud_t** chemin, liste_noeud_t* visites, noeud_id_t noeud){
    if (precedent_noeud_liste(visites, noeud) == NO_ID) {
        inserer_noeud_liste(*chemin, noeud, NO_ID, 0.0);
    } else {
        noeud_id_t precedent = precedent_noeud_liste(visites, noeud);

        construire_chemin_vers(chemin,visites,precedent);

        double distance = distance_noeud_liste(visites, noeud); 
        inserer_noeud_liste(*chemin, noeud, precedent, distance);
    }
}


float dijkstra(
    const struct graphe_t* graphe, 
    noeud_id_t source, noeud_id_t destination, 
    liste_noeud_t** chemin) {
    
    liste_noeud_t* AVisiter = creer_liste(); 
    liste_noeud_t* Visites = creer_liste();
    //D-1 
    inserer_noeud_liste(AVisiter,  source, NO_ID, 0.0);
    //D-2
    while (!est_vide_liste(AVisiter)){
        //D-2.1
        noeud_id_t nc = min_noeud_liste(AVisiter);
        //D-2.2
        inserer_noeud_liste(Visites, nc, precedent_noeud_liste(AVisiter, nc), distance_noeud_liste(AVisiter, nc));
        //D-2.3
        supprimer_noeud_liste(AVisiter, nc);
        //D-2.4
        size_t nb = nombre_voisins(graphe, nc);
        noeud_id_t* voisins = (noeud_id_t*)malloc(nb * sizeof(noeud_id_t));
        noeuds_voisins(graphe, nc, voisins);
        for (int i=0 ; i<(int)nb ; i++){
            noeud_id_t nv = voisins[i];
            if (!contient_noeud_liste(Visites, nv)){
                //D-2.4.1
                float delta_prime = distance_noeud_liste(Visites, nc) + noeud_distance(graphe, nc, nv);
                //D-2.4.2
                float delta = distance_noeud_liste(AVisiter, nv);
                //D-2.4.3
                if (delta_prime < delta) {
                    if (contient_noeud_liste(AVisiter, nv)) {
                        changer_noeud_liste(AVisiter, nv, nc, delta_prime);
                    } else {
                        inserer_noeud_liste(AVisiter, nv, nc, delta_prime);
                    }
                }
            }
        }
        free(voisins);

    }

    if (chemin != NULL){
        *chemin =creer_liste();
        construire_chemin_vers(chemin, Visites, destination);

    }  
    
    float distance = (float)distance_noeud_liste(Visites, destination);
    detruire_liste(&AVisiter);
    detruire_liste(&Visites);
    return distance;
}