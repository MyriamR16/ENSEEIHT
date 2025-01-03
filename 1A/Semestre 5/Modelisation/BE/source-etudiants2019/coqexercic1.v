Require Import Naturelle.
Section Session1_2019_Logique_Exercice_1.

Variable A B C : Prop.

Theorem Exercice_1_Naturelle :  (A -> B -> C) -> ((A /\ B) -> C).
Proof.
I_imp H. 
I_imp h1.
E_imp B.
E_imp A.
Hyp H.
E_et_g(B).
Hyp h1.
E_et_d(A).
Hyp h1.
Qed.

Theorem Exercice_1_Coq :  (A -> B -> C) -> ((A /\ B) -> C).
Proof.
intros.
cut B.
cut A.
exact H.
cut (A/\B).
intros.
elim H1.
intros HA HB.
exact HA.
exact H0.
cut (A/\B).
intros.
elim H1.
intros HA HB.
exact HB.
exact H0.

Qed.

End Session1_2019_Logique_Exercice_1.

