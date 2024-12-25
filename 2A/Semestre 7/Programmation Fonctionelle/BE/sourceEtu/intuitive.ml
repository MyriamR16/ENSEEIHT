open Encodage
open Chaines
open StructureDonnees


module Intuitive (E : Encodage) (S : StructureDonnees)=
struct

  (************)
  (* Encodage *)
  (************)

  (* encoder_lettre : char -> int *)
  (* Encode une lettre, c'est-à-dire indique la touche qu'il faut
     appuyer pour saisir la lettre *)
  (* Le paramètre est la lettre à encoder *)
  (* Renvoie la touche à utiliser si c'est une lettre minuscule,
     0 pour les autres caractères *)
  let encoder_lettre lettre = 
    if lettre<='c' && lettre>='a' then 2
    else if lettre<='f' && lettre>='d' then 3
    else if lettre<='i' && lettre>='g' then 4
    else if lettre<='l' && lettre>='j' then 5
    else if lettre<='o' && lettre>='m' then 6
    else if lettre<='s' && lettre>='p' then 7
    else if lettre<='v' && lettre>='t' then 8
    else if lettre<='z' && lettre>='w' then 9
    else 0

let%test _ = encoder_lettre 'a' = 2 
let%test _ = encoder_lettre 'z' = 9 
let%test _ = encoder_lettre 'A' = 0 
let%test _ = encoder_lettre '.' = 0 


  (* encoder_mot : string -> int list *)
  (* Encode un mot, c'est-à-dire indique la suite de touches à appuyer
     pour saisir le mot *)
  (* Le paramètre est le mot à encoder *)
  (* Renvoie la liste des touches à composer *)

  let rec encoder_mot mot = 
    let listMot = decompose_chaine mot in 
    match listMot with 
    | [] -> []
    | t::q -> [encoder_lettre t]@(encoder_mot (recompose_chaine q))


let%test _ = encoder_mot "bon" = [2;6;6] 
let%test _ = encoder_mot "ok" = [6;5] 
let%test _ = encoder_mot "alors" = [2;5;6;7;7] 

  (***************************************************************************)
  (* Décodage                                                                *)
  (* Nécessite un dictionnaire car un même code est associé à plusieurs mots *)
  (***************************************************************************)


  (* ajouter : dico -> string -> dico *)
  (* Ajoute un mot à un dictionnaire *)
  (* Le premier paramètre est le dictionnaire dans lequel le mot doit
     être ajouté *)
  (* Le second paramètre est le mot à ajouter *)
  (* Renvoie le nouveau dictionnaire *)
  let ajouter dictionnaire mot = 
    let encodage = encoder_mot mot in 
    S.ajouter encodage mot dictionnaire


  (* decoder_mot -> dico -> int list -> string list *)
  (* Identifie l'ensemble des mots potentiellement saisis à partir d'une suite de touches  *)
  (* Le premier paramètre est la liste des touches appuyées *)
  (* Le second paramètre est le dictionnaire *)
  (* Renvoie l'ensemble des mots du dictionnaire correspondants aux touches appuyées *)

  let decoder_mot encodage dictionnaire = 
    S.chercher encodage dictionnaire

  (* Pour les tests combinés de ajoute et decoder_mot *)
  (* Doivent passer, car ne dépendent pas de l'ordre dans les listes *)

  let creer_dico file =
    let channel = open_in file in
    try
      let rec read_lines acc =
        try
          let line = input_line channel in
          read_lines (ajouter acc line)
        with End_of_file ->
          acc
      in
      let lines = read_lines S.empty in
      close_in channel;
      lines
    with e ->
      close_in channel;
      raise e

  (* max_mots_code_identique : dico -> int *)
  (* Calcule le nombre maximum de mots associés à un même code dans un
     dictionnaire *)
  let max_mots_code_identique dictionnaire = 
    S.max_mots_code_identique dictionnaire

  (* prefixe : int list -> dico -> string list *)
  (* Liste tous les mots dont le préfix est la liste de touches passée en paramètre *)
  (* Lorsque le prefixe est vide, liste l'ensemble des mots du dictionnaire *)
  let prefixe listeMot dictionnaire =
    S.prefixe listeMot dictionnaire

end
