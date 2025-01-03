Require Import Naturelle.
Section Session1_2019_Logique_Exercice_2.

Variable A B : Prop.

Theorem Exercice_2_Naturelle : (~A) \/ B -> (~A) \/ (A /\ B).
Proof.
I_imp H0.
E_ou(~A)(B).
Hyp H0.
I_imp H1.
I_ou_g.
Hyp H1.
I_imp H2.
E_ou(A)(~A).
TE.
I_imp H1.
I_ou_d.
I_et.
Hyp H1.
Hyp H2.
I_imp H1.
I_ou_g.
Hyp H1.
Qed.

Theorem Exercice_2_Coq : (~A) \/ B -> (~A) \/ (A /\ B).
Proof.
intros.
destruct H.
left.
exact H.
cut(A\/~A).
intro H1.
destruct H1.
right.
split.
exact H0.
exact H.
left.
exact H0.
exact (classic A).
Qed.

End Session1_2019_Logique_Exercice_2.

