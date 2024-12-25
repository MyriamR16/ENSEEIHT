
module MenhirBasics = struct
  
  exception Error
  
  let _eRR =
    fun _s ->
      raise Error
  
  type token = 
    | UL_POINT
    | UL_PAROUV
    | UL_PARFER
    | UL_INT of (
# 17 "Parser.mly"
       (int)
# 18 "Parser.ml"
  )
    | UL_IDENT of (
# 18 "Parser.mly"
       (string)
# 23 "Parser.ml"
  )
    | UL_FIN
    | UL_ERREUR
  
end

include MenhirBasics

# 1 "Parser.mly"
  

(* Partie recopiee dans le fichier CaML genere. *)
(* Ouverture de modules exploites dans les actions *)
(* Declarations de types, de constantes, de fonctions, d'exceptions exploites dans les actions *)


# 40 "Parser.ml"

type ('s, 'r) _menhir_state = 
  | MenhirState00 : ('s, _menhir_box_scheme) _menhir_state
    (** State 00.
        Stack shape : .
        Start symbol: scheme. *)

  | MenhirState01 : (('s, _menhir_box_scheme) _menhir_cell1_UL_PAROUV, _menhir_box_scheme) _menhir_state
    (** State 01.
        Stack shape : UL_PAROUV.
        Start symbol: scheme. *)

  | MenhirState04 : ((('s, _menhir_box_scheme) _menhir_cell1_UL_PAROUV, _menhir_box_scheme) _menhir_cell1_expression, _menhir_box_scheme) _menhir_state
    (** State 04.
        Stack shape : UL_PAROUV expression.
        Start symbol: scheme. *)

  | MenhirState05 : (((('s, _menhir_box_scheme) _menhir_cell1_UL_PAROUV, _menhir_box_scheme) _menhir_cell1_expression, _menhir_box_scheme) _menhir_cell1_UL_POINT, _menhir_box_scheme) _menhir_state
    (** State 05.
        Stack shape : UL_PAROUV expression UL_POINT.
        Start symbol: scheme. *)

  | MenhirState08 : ((('s, _menhir_box_scheme) _menhir_cell1_expression, _menhir_box_scheme) _menhir_cell1_expression, _menhir_box_scheme) _menhir_state
    (** State 08.
        Stack shape : expression expression.
        Start symbol: scheme. *)


and ('s, 'r) _menhir_cell1_expression = 
  | MenhirCell1_expression of 's * ('s, 'r) _menhir_state * (unit)

and ('s, 'r) _menhir_cell1_UL_PAROUV = 
  | MenhirCell1_UL_PAROUV of 's * ('s, 'r) _menhir_state

and ('s, 'r) _menhir_cell1_UL_POINT = 
  | MenhirCell1_UL_POINT of 's * ('s, 'r) _menhir_state

and _menhir_box_scheme = 
  | MenhirBox_scheme of (unit) [@@unboxed]

let _menhir_action_1 =
  fun () ->
    (
# 39 "Parser.mly"
                   (())
# 86 "Parser.ml"
     : (unit))

let _menhir_action_2 =
  fun () ->
    (
# 40 "Parser.mly"
                                                 ((print_endline "S ..."))
# 94 "Parser.ml"
     : (unit))

let _menhir_action_3 =
  fun () ->
    (
# 34 "Parser.mly"
                                                                ((print_endline "(S.S)"))
# 102 "Parser.ml"
     : (unit))

let _menhir_action_4 =
  fun () ->
    (
# 35 "Parser.mly"
                                                   ((print_endline "(boucleExpression)"))
# 110 "Parser.ml"
     : (unit))

let _menhir_action_5 =
  fun () ->
    (
# 36 "Parser.mly"
                       ((print_endline "ident"))
# 118 "Parser.ml"
     : (unit))

let _menhir_action_6 =
  fun () ->
    (
# 37 "Parser.mly"
                     ((print_endline "entier"))
# 126 "Parser.ml"
     : (unit))

let _menhir_action_7 =
  fun () ->
    (
# 32 "Parser.mly"
                           ( (print_endline "scheme : expression UL_FIN ") )
# 134 "Parser.ml"
     : (unit))

let _menhir_print_token : token -> string =
  fun _tok ->
    match _tok with
    | UL_ERREUR ->
        "UL_ERREUR"
    | UL_FIN ->
        "UL_FIN"
    | UL_IDENT _ ->
        "UL_IDENT"
    | UL_INT _ ->
        "UL_INT"
    | UL_PARFER ->
        "UL_PARFER"
    | UL_PAROUV ->
        "UL_PAROUV"
    | UL_POINT ->
        "UL_POINT"

let _menhir_fail : unit -> 'a =
  fun () ->
    Printf.eprintf "Internal failure -- please contact the parser generator's developers.\n%!";
    assert false

include struct
  
  [@@@ocaml.warning "-4-37"]
  
  let _menhir_run_13 : type  ttv_stack. ttv_stack -> _ -> _menhir_box_scheme =
    fun _menhir_stack _tok ->
      match (_tok : MenhirBasics.token) with
      | UL_FIN ->
          let _v = _menhir_action_7 () in
          MenhirBox_scheme _v
      | _ ->
          _eRR ()
  
  let rec _menhir_run_01 : type  ttv_stack. ttv_stack -> _ -> _ -> (ttv_stack, _menhir_box_scheme) _menhir_state -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s ->
      let _menhir_stack = MenhirCell1_UL_PAROUV (_menhir_stack, _menhir_s) in
      let _tok = _menhir_lexer _menhir_lexbuf in
      match (_tok : MenhirBasics.token) with
      | UL_PAROUV ->
          _menhir_run_01 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState01
      | UL_INT _ ->
          _menhir_run_02 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState01
      | UL_IDENT _ ->
          _menhir_run_03 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState01
      | UL_PARFER ->
          let _ = _menhir_action_1 () in
          _menhir_run_10 _menhir_stack _menhir_lexbuf _menhir_lexer
      | _ ->
          _eRR ()
  
  and _menhir_run_02 : type  ttv_stack. ttv_stack -> _ -> _ -> (ttv_stack, _menhir_box_scheme) _menhir_state -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s ->
      let _tok = _menhir_lexer _menhir_lexbuf in
      let _v = _menhir_action_6 () in
      _menhir_goto_expression _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
  
  and _menhir_goto_expression : type  ttv_stack. ttv_stack -> _ -> _ -> _ -> (ttv_stack, _menhir_box_scheme) _menhir_state -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok ->
      match _menhir_s with
      | MenhirState00 ->
          _menhir_run_13 _menhir_stack _tok
      | MenhirState08 ->
          _menhir_run_08 _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
      | MenhirState04 ->
          _menhir_run_08 _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
      | MenhirState05 ->
          _menhir_run_06 _menhir_stack _menhir_lexbuf _menhir_lexer _tok
      | MenhirState01 ->
          _menhir_run_04 _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
  
  and _menhir_run_08 : type  ttv_stack. ((ttv_stack, _menhir_box_scheme) _menhir_cell1_expression as 'stack) -> _ -> _ -> _ -> ('stack, _menhir_box_scheme) _menhir_state -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok ->
      let _menhir_stack = MenhirCell1_expression (_menhir_stack, _menhir_s, _v) in
      match (_tok : MenhirBasics.token) with
      | UL_PAROUV ->
          _menhir_run_01 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState08
      | UL_INT _ ->
          _menhir_run_02 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState08
      | UL_IDENT _ ->
          _menhir_run_03 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState08
      | UL_PARFER ->
          let _ = _menhir_action_1 () in
          _menhir_run_09 _menhir_stack _menhir_lexbuf _menhir_lexer
      | _ ->
          _eRR ()
  
  and _menhir_run_03 : type  ttv_stack. ttv_stack -> _ -> _ -> (ttv_stack, _menhir_box_scheme) _menhir_state -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s ->
      let _tok = _menhir_lexer _menhir_lexbuf in
      let _v = _menhir_action_5 () in
      _menhir_goto_expression _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
  
  and _menhir_run_09 : type  ttv_stack. (ttv_stack, _menhir_box_scheme) _menhir_cell1_expression -> _ -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer ->
      let MenhirCell1_expression (_menhir_stack, _menhir_s, _) = _menhir_stack in
      let _ = _menhir_action_2 () in
      _menhir_goto_boucleExpression _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
  
  and _menhir_goto_boucleExpression : type  ttv_stack. ttv_stack -> _ -> _ -> (ttv_stack, _menhir_box_scheme) _menhir_state -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s ->
      match _menhir_s with
      | MenhirState01 ->
          _menhir_run_10 _menhir_stack _menhir_lexbuf _menhir_lexer
      | MenhirState04 ->
          _menhir_run_09 _menhir_stack _menhir_lexbuf _menhir_lexer
      | MenhirState08 ->
          _menhir_run_09 _menhir_stack _menhir_lexbuf _menhir_lexer
      | _ ->
          _menhir_fail ()
  
  and _menhir_run_10 : type  ttv_stack. (ttv_stack, _menhir_box_scheme) _menhir_cell1_UL_PAROUV -> _ -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer ->
      let _tok = _menhir_lexer _menhir_lexbuf in
      let MenhirCell1_UL_PAROUV (_menhir_stack, _menhir_s) = _menhir_stack in
      let _v = _menhir_action_4 () in
      _menhir_goto_expression _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
  
  and _menhir_run_06 : type  ttv_stack. (((ttv_stack, _menhir_box_scheme) _menhir_cell1_UL_PAROUV, _menhir_box_scheme) _menhir_cell1_expression, _menhir_box_scheme) _menhir_cell1_UL_POINT -> _ -> _ -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _tok ->
      match (_tok : MenhirBasics.token) with
      | UL_PARFER ->
          let _tok = _menhir_lexer _menhir_lexbuf in
          let MenhirCell1_UL_POINT (_menhir_stack, _) = _menhir_stack in
          let MenhirCell1_expression (_menhir_stack, _, _) = _menhir_stack in
          let MenhirCell1_UL_PAROUV (_menhir_stack, _menhir_s) = _menhir_stack in
          let _v = _menhir_action_3 () in
          _menhir_goto_expression _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok
      | _ ->
          _eRR ()
  
  and _menhir_run_04 : type  ttv_stack. ((ttv_stack, _menhir_box_scheme) _menhir_cell1_UL_PAROUV as 'stack) -> _ -> _ -> _ -> ('stack, _menhir_box_scheme) _menhir_state -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer _v _menhir_s _tok ->
      let _menhir_stack = MenhirCell1_expression (_menhir_stack, _menhir_s, _v) in
      match (_tok : MenhirBasics.token) with
      | UL_POINT ->
          let _menhir_stack = MenhirCell1_UL_POINT (_menhir_stack, MenhirState04) in
          let _menhir_s = MenhirState05 in
          let _tok = _menhir_lexer _menhir_lexbuf in
          (match (_tok : MenhirBasics.token) with
          | UL_PAROUV ->
              _menhir_run_01 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
          | UL_INT _ ->
              _menhir_run_02 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
          | UL_IDENT _ ->
              _menhir_run_03 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
          | _ ->
              _eRR ())
      | UL_PAROUV ->
          _menhir_run_01 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState04
      | UL_INT _ ->
          _menhir_run_02 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState04
      | UL_IDENT _ ->
          _menhir_run_03 _menhir_stack _menhir_lexbuf _menhir_lexer MenhirState04
      | UL_PARFER ->
          let _ = _menhir_action_1 () in
          _menhir_run_09 _menhir_stack _menhir_lexbuf _menhir_lexer
      | _ ->
          _eRR ()
  
  let _menhir_run_00 : type  ttv_stack. ttv_stack -> _ -> _ -> _menhir_box_scheme =
    fun _menhir_stack _menhir_lexbuf _menhir_lexer ->
      let _menhir_s = MenhirState00 in
      let _tok = _menhir_lexer _menhir_lexbuf in
      match (_tok : MenhirBasics.token) with
      | UL_PAROUV ->
          _menhir_run_01 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
      | UL_INT _ ->
          _menhir_run_02 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
      | UL_IDENT _ ->
          _menhir_run_03 _menhir_stack _menhir_lexbuf _menhir_lexer _menhir_s
      | _ ->
          _eRR ()
  
end

let scheme =
  fun _menhir_lexer _menhir_lexbuf ->
    let _menhir_stack = () in
    let MenhirBox_scheme v = _menhir_run_00 _menhir_stack _menhir_lexbuf _menhir_lexer in
    v

# 42 "Parser.mly"
  

# 324 "Parser.ml"
