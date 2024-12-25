Require Import Naturelle.
Section Session1_2018_Logique_Exercice_2.

Variable A B : Prop.

Theorem Exercice_2_Naturelle : ~(A /\ B) -> (~A \/ ~B).
Proof.
I_imp h.
E_ou (A) (~A).
TE.
I_imp H.
I_ou_d.
I_non H1.
I_antiT(A/\B).
I_et.
exact H.
exact H1.
exact h.
I_imp H.
I_ou_g.
exact H.


Qed.

Theorem Exercice_2_Coq : ~(A /\ B) -> (~A \/ ~B).
Proof.
intros.
cut (A \/~A).
intro.
destruct H0 as [HA|HnonA].
right.
intro HB.
absurd (A/\B).
exact H.
split.
exact HA.
exact HB.
left.
exact HnonA.
apply (classic A).


Qed.

End Session1_2018_Logique_Exercice_2.

