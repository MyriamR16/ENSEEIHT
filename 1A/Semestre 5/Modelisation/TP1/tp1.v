Require Import Naturelle 
Section LogiqueProposition. 

Variable A B C E Y R : Prop. 

Theorem Thm_0 : A /\ B -> B /\ A.
I_imp HAetB.
I_et.
E_et_d A.
Hyp HAetB.
E_et_g B.
Hyp HAetB.
Qed.

Theorem Thm_1 : ((A \/ B) -> C) -> (B -> C).
(* A COMPLETER *)
I_imp HAouBiC.
I_imp HB.
E_imp(A \/ B).
Hyp HAouBiC.
I_ou_d.
Hyp HB.
Qed.

Theorem Thm_2 : A -> ~~A.
(* A COMPLETER *)
I_imp HA.
I_non H2.
I_antiT A.
Hyp HA.
Hyp H2.
Qed.

Theorem Thm_3 : (A -> B) -> (~B -> ~A).
(* A COMPLETER *)
I_imp HAiB.
I_imp HnB.
I_non HA.
I_antiT B.
E_imp A.
Hyp HAiB.
Hyp HA.
Hyp HnB.
Qed.

Theorem Thm_4 : (~~A) -> A.
(* A COMPLETER *)
I_imp HnnA.
absurde HA.
E_non (~A).
Hyp HA.
Hyp HnnA.
Qed.

Theorem Thm_5 : (~B -> ~A) -> (A -> B).
(* A COMPLETER *)
I_imp HnBinA.
I_imp HA.
absurde HB.
I_antiT A.
Hyp HA.
E_imp (~B).
Hyp (HnBinA).
Hyp HB.
Qed.

Theorem Thm_6 : ((E -> (Y \/ R)) /\ (Y -> R)) -> ~R -> ~E.
(* A COMPLETER *)
I_imp H1.
I_imp HnR.
I_non HE.
E_non R.
E_ou(Y)(R).
E_imp E.
E_et_g(Y -> R).
Hyp H1.
Hyp HE.
E_et_d(E -> Y \/ R).
Hyp H1.
I_imp HR.
Hyp HR.
Hyp HnR.
Qed.

(* Version en Coq *)

Theorem Coq_Thm_0 : A /\ B -> B /\ A.
intro H.
destruct H as (HA,HB).  (* élimination conjonction *)
split.                  (* introduction conjonction *)
exact HB.               (* hypothèse *)
exact HA.               (* hypothèse *)
Qed.


Theorem Coq_E_imp : ((A -> B) /\ A) -> B.
(* A COMPLETER *)
intro H1.
cut A
Qed.

Theorem Coq_E_et_g : (A /\ B) -> A.
(* A COMPLETER *)
Qed.

Theorem Coq_E_ou : ((A \/ B) /\ (A -> C) /\ (B -> C)) -> C.
(* A COMPLETER *)
Qed.

Theorem Coq_Thm_7 : ((E -> (Y \/ R)) /\ (Y -> R)) -> (~R -> ~E).
(* A COMPLETER *)
Qed.

End LogiqueProposition.