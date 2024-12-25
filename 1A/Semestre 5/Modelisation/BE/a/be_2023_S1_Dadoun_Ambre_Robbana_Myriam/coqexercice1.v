Require Import Naturelle.
Section Session1_2023_Logique_Exercice_1.

Variable A B : Prop.

Theorem Exercice_1_Naturelle :  ((A \/ B) /\ (~A)) -> (B /\ (~A)).
Proof.
I_imp H0.
I_et.
E_ou(A)(B).
E_et_g(~A).
Hyp H0.
I_imp H.
E_antiT.
E_non(A).
Hyp H.
E_et_d(A\/B).
Hyp H0.
I_imp h.
Hyp h.
E_et_d(A\/B).
Hyp H0.

Qed.

Theorem Exercice_1_Coq :  (A\/B)/\(~A) ->  B/\(~A).
Proof.
intros.
cut (A\/B).
intro.
elim H0.
intros.
split.
destruct H.

absurd A.
exact H2.
exact H1.
destruct H.
exact H2.
intros.
split.
exact H1.
destruct H.
exact H2.
destruct H.
exact H.



Qed.


End Session1_2023_Logique_Exercice_1.

