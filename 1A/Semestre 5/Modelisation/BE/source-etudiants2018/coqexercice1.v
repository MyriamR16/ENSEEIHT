Require Import Naturelle.
Section Session1_2018_Logique_Exercice_1.

Variable A B : Prop.



Theorem Exercice_1_Naturelle : ~(A \/ B) -> (~A /\ ~B).
Proof.
I_imp H.
I_et.
I_non HA.
I_antiT (A \/B).
I_ou_g.
Hyp HA.
Hyp H.
I_non HB.
I_antiT (A \/B).
I_ou_d.
Hyp HB.
Hyp H.


Qed.

Theorem Exercice_1_Coq : ~(A \/ B) -> (~A /\ ~B).
Proof.
intros.
split.
unfold not.
intro HA.
absurd (A\/B).
exact H.
left.
exact HA.
unfold not.
intro HB.
absurd (A\/B).
exact H.
right.
exact HB.

Qed.

End Session1_2018_Logique_Exercice_1.

