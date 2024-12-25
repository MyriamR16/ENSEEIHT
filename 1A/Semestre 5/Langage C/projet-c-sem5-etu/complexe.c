#include "complexe.h"
#include <math.h>           // Pour certaines fonctions trigo notamment

// Implantations de reelle et imaginaire
double reelle (complexe_t z){
    return z.reelle ; 
}

double imaginaire (complexe_t z){
    return z.imaginaire ; 
}

// Implantations de set_reelle et set_imaginaire
void set_reelle (complexe_t* z , double r){
    z->reelle = r ; 
}

void set_imaginaire (complexe_t* z , double im){
    z->imaginaire = im ; 
}

void init (complexe_t* z , double r, double im){ 
    z->imaginaire = im ; 
    z->reelle = r ; 
}

// Implantation de copie
void copie(complexe_t* resultat, complexe_t autre){
    resultat->reelle = autre.reelle ; 
    resultat->imaginaire = autre.imaginaire ; 
}


// Implantations des fonctions algébriques sur les complexes
void conjugue(complexe_t* resultat, complexe_t op){
    resultat->reelle = op.reelle ; 
    resultat->imaginaire = -op.imaginaire ; 
}

void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->reelle = gauche.reelle + droite.reelle; 
    resultat->imaginaire = gauche.imaginaire + droite.imaginaire ; 
}

void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->reelle = gauche.reelle - droite.reelle; 
    resultat->imaginaire = gauche.imaginaire - droite.imaginaire ; 
}

void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->reelle = (gauche.reelle * droite.reelle) - (gauche.imaginaire * droite.imaginaire); 
    resultat->imaginaire = (gauche.reelle * droite.imaginaire) + (gauche.imaginaire * droite.reelle); 
}

void echelle(complexe_t* resultat, complexe_t op, double facteur){
    resultat->reelle = op.reelle * facteur; 
    resultat->imaginaire = op.imaginaire * facteur; 
}

void puissance(complexe_t* resultat, complexe_t op, int exposant){
    if (exposant==0){
        resultat-> reelle = 1 ;
        resultat -> imaginaire = 0 ; 
    }

    else {
          *resultat = op ;
          for (int i=1; i<exposant ; i++){
            multiplier(resultat, op, *resultat); 
          }
    }   
}

// Implantations du module et de l'argument
double module_carre (complexe_t z){
    double resultat ; 
    resultat = (z.reelle * z.reelle) + (z.imaginaire * z.imaginaire);
    return resultat;
}

double module (complexe_t z){
    double resultat ; 
    resultat = sqrt(module_carre(z));
    return resultat; 
}


double argument (complexe_t z){
    double argument;
    argument = 2* atan (z.imaginaire/(z.reelle + module(z))); 
    return argument; 
}


