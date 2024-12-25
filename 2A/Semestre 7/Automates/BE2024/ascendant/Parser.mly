%{

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)

%}

/* Declaration des unites lexicales et de leur type si une valeur particuliere leur est associee */

(* A COMPLETER *)

%token UL_PARFER UL_PAROUV UL_POINT
/* Defini le type des donnees associees a l'unite lexicale */

(* A COMPLETER *)
%token <int> UL_INT
%token <string> UL_IDENT

/* Unite lexicale particuliere qui represente la fin du fichier */
%token UL_ERREUR
%token UL_FIN

/* Type renvoye pour le nom terminal document */
%type <unit> scheme

/* Le non terminal document est l'axiome */
%start scheme

%% /* Regles de productions */

scheme : expression UL_FIN { (print_endline "scheme : expression UL_FIN ") }

expression : UL_PAROUV expression UL_POINT expression UL_PARFER {(print_endline "(S.S)")}
            | UL_PAROUV boucleExpression UL_PARFER {(print_endline "(boucleExpression)")}
            | UL_IDENT {(print_endline "ident")}
            | UL_INT {(print_endline "entier")}

boucleExpression : {()}
                    |expression boucleExpression {(print_endline "S ...")}

%%
