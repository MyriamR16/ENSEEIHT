package fr.n7.sn.mt.tp01;

/**
  * Op�rateur binaire.
  *
  * @author	Xavier Cr�gut
  * @version	$Revision$
  */
public interface OperateurBinaire {

	<R> R accepter(VisiteurExpression<R> visiteur);

}
