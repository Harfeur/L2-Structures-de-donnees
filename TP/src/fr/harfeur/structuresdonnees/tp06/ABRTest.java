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
		this.arbre.ins�rer(10);
		assertEquals(this.arbre.racine(), new Integer(10));
		this.arbre.supprimer(10);
		assertEquals(this.arbre.est_vide(), true);
	}

	@Test
	public void test2() throws ExceptionArbreVide {
		this.arbre.ins�rer(10);
		this.arbre.ins�rer(5);
		this.arbre.ins�rer(15);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(5));
	}

	@Test
	public void test3() throws ExceptionArbreVide {
		this.arbre.ins�rer(10);
		this.arbre.ins�rer(25);
		this.arbre.ins�rer(15);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(25));
	}

	@Test
	public void test4() throws ExceptionArbreVide {
		this.arbre.ins�rer(10);
		this.arbre.ins�rer(15);
		this.arbre.ins�rer(25);
		this.arbre.supprimer(10);
		assertEquals(this.arbre.racine(), new Integer(15));
	}
	
	@Test
	public void test5() {
		this.arbre.ins�rer(1);
		this.arbre.ins�rer(15);
		this.arbre.ins�rer(8);
		this.arbre.ins�rer(9);
		this.arbre.ins�rer(21);
		this.arbre.ins�rer(2);
		this.arbre.ins�rer(7);
		this.arbre.ins�rer(11);
		this.arbre.ins�rer(0);
		this.arbre.ins�rer(6);

		assertEquals("((0)1(((2((6)7))8(9(11)))15(21)))", this.arbre.toString());
				
		this.arbre.supprimer(8);
		
		assertEquals("((0)1(((2(6))7(9(11)))15(21)))", this.arbre.toString());
	}
	
	
}
