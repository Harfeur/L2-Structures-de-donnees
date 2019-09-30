package fr.harfeur.structuresdonnees.tp01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListeContigueTest {

	Liste<Character> l;
	
	
	@BeforeEach
	void setUp() throws Exception {
		l = new ListeContigue<Character>(5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void test1() {
		l.inserer(0, 'b');
		System.out.println("Liste : "+l.toString());
		l.inserer(1, 'c');
		l.inserer(2, 'd');	
		l.inserer(0, 'a');
		System.out.println("Liste : "+l.toString());
		System.out.println("1er element : "+l.ieme(1));
		System.out.println("3eme element : "+l.ieme(3));
		System.out.println("Longueur de la liste : "+l.longueur());
		l.supprimer(2);
		l.supprimer(0);
		l.inserer(1, 'e');
		System.out.println("Liste : "+l.toString());
	}
	
	@Test
	public void test2() {
		assertThrows(ExceptionIndiceHorsLimites.class, () -> l.inserer(1, 'a'));
	}

	public void test3() {

		l.inserer(15, 'a');
	}

	public void test4() {

		l.inserer(0, 'a');
		l.inserer(1, 'b');
		l.inserer(2, 'c');
		System.out.println("4eme element : "+l.ieme(3));
	}

	public void test5() {

		l.inserer(0, 'a');
		l.inserer(1, 'b');
		l.inserer(2, 'c');
		l.supprimer(4);
	}

	public void test6() {

		l.supprimer(-1);
	}

}
