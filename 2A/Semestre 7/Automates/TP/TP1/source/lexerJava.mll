{

  open TokenJava
(*  open String *)
(*  open Str *)
  exception LexicalError

}

(* Macro-definitions *)
let minuscule = ['a'-'z']
let majuscule = ['A'-'Z']
let chiffre = ['0'-'9']
let alphabet = minuscule | majuscule
let alphanum = alphabet | chiffre | '_'
let commentaireBloc = (* A COMPLETER *) "/*" _* "*/" 
let commentaireLigne = "//" [^'\n']* '\n'

let integerTypeSuffix = 'l'|'L'

let nonzeroDigit = ['1' - '9']
let underscores = '_' '_'?
let digitOrUnderscore = chiffre | '_'
let digitAndUnderscores = digitOrUnderscore digitOrUnderscore?
let digits = chiffre | chiffre digitAndUnderscores* chiffre

let hexDigit = chiffre | ['A'-'F' 'a'-'f']
let hexDigitOrUnderscore = hexDigit | '_'
let hexDigitAndUnderscores = hexDigitOrUnderscore hexDigitOrUnderscore?
let hexDigits = hexDigit | hexDigit hexDigitAndUnderscores* hexDigit
let hexNumeral = "0x" hexDigits | "0X" hexDigits

let octalDigit = ['0' - '7']
let octalDigitOrUnderscore = octalDigit | '_'
let octalDigitAndUnderscores = octalDigitOrUnderscore octalDigitOrUnderscore?
let octalDigits = octalDigit | octalDigit octalDigitAndUnderscores* octalDigit

let binaryDigit = '0' | '1'
let binaryDigitOrUnderscore = binaryDigit | '_'
let binaryDigitsAndUnderscores = binaryDigitOrUnderscore binaryDigitOrUnderscore?
let binaryDigits = binaryDigit | binaryDigit binaryDigitsAndUnderscores* binaryDigit


let floatTypeSuffix = 'f' | 'F' | 'd' | 'D'

let sign = '-' | '+'
let signedInteger = sign* digits
let exponentIndicator = 'e' | 'E'
let exponentPart = exponentIndicator signedInteger
let decimalFloatPointLiteral =  digits "." digits* exponentPart* floatTypeSuffix*
                                | "." digits exponentPart* floatTypeSuffix*
                                | digits exponentPart floatTypeSuffix*
                                | digits exponentPart* floatTypeSuffix


let binaryExponentIndicator = 'p' | 'P'
let binaryExponent =  binaryExponentIndicator signedInteger
let HexSignificand =  hexNumeral "."*
                      | ("0x"|"0X") hexDigits* "." hexDigits

let hexadecimalFloatingPointLiteral = HexSignificand binaryExponent floatTypeSuffix*
let floatingPointLiteral = decimalFloatPointLiteral | hexadecimalFloatingPointLiteral

let inputElement = token | 
(* Analyseur lexical : expression reguliere { action CaML } *)
rule lexer = parse
(* Espace, tabulation, passage a ligne, etc : consommes par l'analyse lexicale *)
  | ['\n' '\t' ' ']+    { lexer lexbuf }
(* Commentaires consommes par l'analyse lexicale *)
  | commentaireBloc   { lexer lexbuf }
  | commentaireLigne  { lexer lexbuf }
(* Structures de blocs *)
  | "("                 { PAROUV }
  | ")"                 { PARFER }
  | "["                 { CROOUV }
  | "]"                 { CROFER }
  | "{"                 { ACCOUV }
  | "}"                 { ACCFER }
(* Separateurs *)
  | ","                 { VIRG }
  | ";"                 { PTVIRG }
(* Operateurs booleens *)
  | "||"                { OPOU }
  | "&&"                { OPET }
  | "!"                 { OPNON }
(* Operateurs comparaisons *)
  | "=="                { OPEG }
  | "!="                { OPNONEG }
  | "<="                { OPSUPEG }
  | "<"                 { OPSUP }
  | ">="                { OPINFEG }
  | ">"                 { OPINF }
(* Operateurs arithmetiques *)
  | "+"                 { OPPLUS }
  | "-"                 { OPMOINS }
  | "*"                 { OPMULT }
  | "/"                 { OPDIV }
  | "%"                 { OPMOD }
  | "."                 { OPPT }
  | "="                 { ASSIGN }
  | "new"               { NOUVEAU }
(* Mots cles : types *)
  | "bool"              { BOOL }
  | "char"              { CHAR }
  | "float"             { FLOAT }
  | "int"               { INT }
  | "String"            { STRING }
  | "void"              { VOID }
(* Mots cles : instructions *)
  | "while"   { TANTQUE }
  | "if"    { SI }
  | "else"    { SINON }
  | "return"    { RETOUR }
(* Mots cles : constantes *)
  | "true"    { (BOOLEEN true) }
  | "false"   { (BOOLEEN false) }
  | "null"    { VIDE }

(* Nombres entiers : A COMPLETER *)
  | ('0' | nonzeroDigit digits* | nonzeroDigit underscores digits) as texte   { (ENTIER (int_of_string texte)) }
  | hexNumeral as texte {(ENTIER(int_of_string texte))}
  | ('0' (octalDigits | underscores octalDigits)) as texte {(ENTIER(int_of_string texte))} (*octal marche pas, il pense que c un entier decimal*)
  | ("0b" binaryDigits | "0B" binaryDigits) as texte {(ENTIER(int_of_string texte))}

(* Nombres flottants : A COMPLETER *)
  | floatingPointLiteral as texte {(FLOTTANT (float_of_string texte))}

(* Caracteres : A COMPLETER *)
  | "'" _ "'" as texte                   { CARACTERE texte.[1] }

(* Chaines de caracteres : A COMPLETER *)
  | '"' _* '"' as texte                  { CHAINE texte }

(* Identificateurs *)
  | majuscule alphanum* as texte              { TYPEIDENT texte }
  | minuscule alphanum* as texte              { IDENT texte }
  | eof                                       { FIN }
  | _                                         { raise LexicalError }

{

}

