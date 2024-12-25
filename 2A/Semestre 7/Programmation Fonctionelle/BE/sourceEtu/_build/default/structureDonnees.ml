open Chaines

(* Pour les tests *)
(* [eq_perm l l'] retourne true ssi [l] et [l']
   sont égales à à permutation près (pour (=)).
   [l'] ne doit pas contenir de doublon. *)
let eq_perm l l' =
  List.length l = List.length l' && List.for_all (fun x -> List.mem x l) l'


module type StructureDonnees =
sig

  (* Type permettant de stocker le dictionnaire *)
  type dico

  (* Dictionnaire vide *)
  val empty : dico

  (* Ajoute un mot et son encodage au dictionnaire *)
  (* premier parametre : l'encodage du mot *)
  (* deuxième paramètre : le mot *)
  (* troisième paramètre : le dictionnaire *)
  val ajouter : int list -> string -> dico -> dico

  (* Cherche tous les mots associés à un encodage dans un dictionnaire *)
  (* premier parametre : l'encodage du mot *)
  (* second paramètre : le dictionnaire *)
  val chercher : int list -> dico -> string list


  (* Calcule le nombre maximum de mots ayant le même encodage dans un
     dictionnaire *)
  (* paramètre : le dictionnaire *)
  val max_mots_code_identique : dico -> int

  (* Liste tous les mots d'un dictionnaire dont un prefixe de l'encodage est donné en paramètre *)
  (* premier paramètre : le prefixe de l'encodage *)
  (* second paramètre : le dictionnaire *)
  val prefixe : int list -> dico -> string list

end


module ListAssoc (E :StructureDonnees) =
struct

  type dico = ( int list * string list ) list

  let empty = []

  let ajouter encodage mot dico = 
    let listeMot = decompose_chaine mot in
    if (List.length listeMot) <> (List.length encodage) then 
      failwith "IL y a erreur dans l encodage"
  else (encodage, [mot]) :: dico

  let chercher encodage dic = 
    
    let rec parcoursDico dictionnaire =
      match dictionnaire with 
      | [] -> []
      | (encList, strList)::q -> if (egaliteEncodage encList encodage) then strList::(parcoursDico q)
      else (parcoursDico q)

    and egaliteEncodage encodage1 encodage2 = 
      match encodage1, encodage2 with 
      | [],[] -> true 
      | [], _ -> false 
      | _ , [] -> false 
      | t1::q1 , t2::q2 -> if t1=t2 then (egaliteEncodage q1 q2)
      else false
    in parcoursDico dic

  let rec max_mots_code_identique dico = 
    let max liste = List.fold_left (fun maximum t -> if t>maximum then t else maximum) 0 liste in
    match dico with 
    | [] -> 0
    | (encodList, _)::q  -> max ([List.length (chercher encodList dico)] @ [max_mots_code_identique q])

  let prefixe l d = failwith "pas réalise"

end


(*
let%test _ = eq_perm (ajouter [2;2] "ba" [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["ba" ; "bb";"aa";"cc"]
let%test _ = eq_perm (ajouter [] "" [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["ba" ; "bb";"aa";"cc"]
let%test _ = eq_perm (ajouter [6;6;4] "moi" [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["moi" ; "ba" ; "bb";"aa";"cc"]


let%test _ = eq_perm (chercher [2;2] [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["bb";"aa";"cc"]
let%test _ = eq_perm (chercher [3;3] [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) []
let%test _ = eq_perm (chercher [2;7;3;3] [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["bref"]
let%test _ = eq_perm (chercher [2;6;6] [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])]) ["bon"]
let%test _ = eq_perm (chercher [2;6;6] []) []


let%test _ = max_mots_code_identique [([2;2],["bb";"aa";"cc"]); ([2;7;3;3],["bref"]);([2;6;6],["bon"])] = 3
let%test _ = max_mots_code_identique [([2;7;3;3],["bref"]);([2;2],["bb";"aa";"cc"]); ([2;6;6],["bon"])] = 3
let%test _ = max_mots_code_identique [] = 0
let%test _ = max_mots_code_identique [([2;7;3;3],["bref"]);([2;2],["bb"]); ([2;6;6],["bon"])] = 1
*)

(*
module Arbe (E :StructureDonnees) =
struct
  type dico = Noeud of ( string list * (int * dico) list )

  let empty = Noeud([],[])

  let rec ajouter encodage mot (Noeud(stListe ,l)) = 
    let listeMot = decompose_chaine mot in
    if (List.length listeMot) <> (List.length encodage) then 
      failwith "Il y a erreur dans l encodage"    
    else match encodage, l with 
         | [] , _ -> Noeud(stListe,l)
         | t1::q1 , (chiffre, arbreDico)::q2 -> if (t1=chiffre) then (ajouter (recompose_chaine q1) arbreDico)
    

  let rec chercher encodage (Noeud(stListe,l)) =
      match encodage,l with 
      | [],_-> []
      | _, [] -> []
      | t1::q1, (t2, (Noeud(st2,l2)))::q2 -> if (t1=t2) then st2::(chercher q1 (Noeud(st2,l2)))
      else (chercher encodage (Noeud(st2,q2)))

  let max_mots_code_identique (Noeud(stListe,l)) = 
    let maximum liste = List.fold_left (fun maximum t -> if t>maximum then t else maximum) 0 liste in


  let  prefixe : int list -> dico -> string list

end 

*)