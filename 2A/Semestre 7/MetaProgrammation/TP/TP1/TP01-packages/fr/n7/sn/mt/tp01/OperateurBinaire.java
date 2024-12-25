package fr.n7.sn.mt.tp01;

/**
  * Opérateur binaire.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public interface OperateurBinaire {

	<R> R accepter(VisiteurExpression<R> visiteur);

}
