(*  Exercice à rendre **)
(*  TO DO : contrat *)
let rec pgcd a b = 
  if a = 0 && b=0 then failwith "wtf"
  else
    let absolue valeur = 
      if valeur > 0 then valeur
      else -valeur
    in
    if a = 0 then absolue b
    else if b = 0 then absolue a
    else if (absolue a = absolue b) then absolue a
    else if absolue a > absolue b then pgcd (absolue a - absolue b) (absolue b)
    else pgcd (absolue a) (absolue b - absolue a)

(*  TO DO : tests unitaires *)
let%test _ = pgcd 5 0 = 5
let%test _ = pgcd 0 5 = 5
let%test _ = pgcd 0 4 = 4
let%test _ = pgcd 0 (-6) = 6
let%test _ = pgcd 2 8 = 2
let%test _ = pgcd (-3) (-9) =3 


