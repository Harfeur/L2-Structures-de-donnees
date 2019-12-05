package fr.harfeur.structuresdonnees.tp06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.harfeur.structuresdonnees.tp05a.ExceptionArbreVide;

/**
 * Tests unitaires permettant de valider le fonctionnement d'un arbre binaire de recherche.
 * @author David Panzoli
 *
 */

public class ABRTest {

	ABR<Integer> arbre;
	
	@Before
	public void setUp() throws Exception {
		this.arbre = new ABR<Integer>();
	}

	@Test
	public void test() throws ExceptionArbreVide {
		this.arbre.insérer(10);
		assertEquals(this.arbre.racine(), new Integer(10));
		this.arbre.supprimer(10);
		assertEquals(this.arbre.est_vide(), true);
	}

	@Test
	public void test2() throws ExceptionArbreVide {
		this.arbre.insérer(10);
		this.arbre.insérer(5);
		this.arbre.insérer(15);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(5));
	}

	@Test
	public void test3() throws ExceptionArbreVide {
		this.arbre.insérer(10);
		this.arbre.insérer(25);
		this.arbre.insérer(15);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(25));
	}

	@Test
	public void test4() throws ExceptionArbreVide {
		this.arbre.insérer(10);
		this.arbre.insérer(15);
		this.arbre.insérer(25);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(15));
	}
	
	@Test
	public void test5() {
		this.arbre.insérer(1);
		this.arbre.insérer(15);
		this.arbre.insérer(8);
		this.arbre.insérer(9);
		this.arbre.insérer(21);
		this.arbre.insérer(2);
		this.arbre.insérer(7);
		this.arbre.insérer(11);
		this.arbre.insérer(0);
		this.arbre.insérer(6);

		assertEquals("((0)1(((2((6)7))8(9(11)))15(21)))", this.arbre.toString());
				
		this.arbre.supprimer(8);
		
		assertEquals("((0)1(((2(6))7(9(11)))15(21)))", this.arbre.toString());
	}
	
	
}
