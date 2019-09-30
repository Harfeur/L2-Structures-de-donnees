package fr.harfeur.structuresdonnees.tp02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PileContigueTest {
	
	PileContigue<Character> p;

	@BeforeEach
	void setUp() throws Exception {
		p = new PileContigue<Character>();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void sommet_vide() {
		assertThrows(ExceptionPileVide.class, () -> p.sommet());
	}
	
	@Test
	void sommet() throws ExceptionPileVide {
		p.empiler('a');
		assertEquals('a', p.sommet());
	}
	
	@Test
	void sommet_vide_empiler_depiler() throws ExceptionPileVide {
		p.empiler('A');
		p.depiler();
		assertThrows(ExceptionPileVide.class, () -> p.sommet());
	}
	
	@Test
	void depiler_vide() {
		assertThrows(ExceptionPileVide.class, () -> p.depiler());
	}

}
