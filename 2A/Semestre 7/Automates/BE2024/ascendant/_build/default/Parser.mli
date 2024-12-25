
(* The type of tokens. *)

type token = 
  | UL_POINT
  | UL_PAROUV
  | UL_PARFER
  | UL_INT of (int)
  | UL_IDENT of (string)
  | UL_FIN
  | UL_ERREUR

(* This exception is raised by the monolithic API functions. *)

exception Error

(* The monolithic API. *)

val scheme: (Lexing.lexbuf -> token) -> Lexing.lexbuf -> (unit)
