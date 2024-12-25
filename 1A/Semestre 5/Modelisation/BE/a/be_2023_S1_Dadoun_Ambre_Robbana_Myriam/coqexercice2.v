Require Import Naturelle.
Section Session1_2023_Logique_Exercice_2.

Variable A B : Prop.

Theorem Exercice_2_Naturelle : ((A -> B) -> A) -> A.
Proof.
I_imp H.
absurde H1.
I_antiT(A).
E_imp(A->B).
Hyp H.
I_imp H2.
E_antiT.
I_antiT(A).
Hyp H2.
Hyp H1.
Hyp H1.
Qed.

Theorem Exercice_2_Coq : ((A -> B) -> A) -> A.
Proof.
intros.
cut (A->B).
exact H.
intros.
absurd A.
cut(A\/~A).
intros.


Qed.

End Session1_2023_Logique_Exercice_2.

