package fr.harfeur.structuresdonnees.tp09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TasTest {
	
	Tas<Character> tas;

	@BeforeEach
	void setUp() throws Exception {
		this.tas = new Tas<Character>();
	}

	@Test
	void testProf() {
		String ch = "helloworld";
		for (int i = 0; i < ch.length(); i++) {
			Character c = ch.charAt(i);
			this.tas.insérer(c);
		}
		String chRes = "";
		while (this.tas.indiceMax >= 0) {
			Character c = (Character) this.tas.valeurs[0];
			chRes += c;
			this.tas.supprimer();
		}
		assertEquals("wroolllhed", chRes);
	}

}
