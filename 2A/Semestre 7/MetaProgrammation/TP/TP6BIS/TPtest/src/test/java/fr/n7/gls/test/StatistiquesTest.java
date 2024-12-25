/**
 * StatistiquesTest, classe de test de Statistiques.
 *
 * @author	Xavier Crégut &lt;Prenom.Nom@enseeiht.fr&gt;
 */

package fr.n7.gls.test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class StatistiquesTest {

	@Test
	public void testStatistiquesNominal() {
		List<Integer> l = new ArrayList<>();
		Collections.addAll(l,1, 3, 11, 5, 7);
		Statistiques.Resultat<Integer> r = new Statistiques().statistiques(l);
		assertEquals(Integer.valueOf(1), r.min);
		assertEquals(Integer.valueOf(11), r.max);
		assertEquals(1, r.nbMin);
		assertEquals(1, r.nbMax);
	}

	@Test
	public void testStatistiquesNominal2() {
		List<Integer> l = new ArrayList<>();
		Collections.addAll(l,1, 3, 11, 5, 0, 7);
		Statistiques.Resultat<Integer> r = new Statistiques().statistiques(l);
		assertEquals(Integer.valueOf(0), r.min);
		assertEquals(Integer.valueOf(11), r.max);
		assertEquals(1, r.nbMin);
		assertEquals(1, r.nbMax);
	}
	
	@Test
	public void testStatistiquesNominal3() {
		List<Integer> l = new ArrayList<>();
		Collections.addAll(l,1,3, 11, 1, 7);
		Statistiques.Resultat<Integer> r = new Statistiques().statistiques(l);
		assertEquals(Integer.valueOf(1), r.min);
		assertEquals(Integer.valueOf(11), r.max);
		assertEquals(2, r.nbMin);
		assertEquals(1, r.nbMax);
	}
	
	@Test
	public void testStatistiquesNominal4() {
		List<Integer> l = new ArrayList<>();
		Collections.addAll(l,1, 11,3, 11, 5, 7);
		Statistiques.Resultat<Integer> r = new Statistiques().statistiques(l);
		assertEquals(Integer.valueOf(1), r.min);
		assertEquals(Integer.valueOf(11), r.max);
		assertEquals(1, r.nbMin);
		assertEquals(2, r.nbMax);
	}
	

}
