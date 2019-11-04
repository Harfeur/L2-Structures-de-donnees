package fr.harfeur.structuresdonnees.synthese1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StructureMyst�reTest {

	StructureMyst�re struct;
	
	@Before
	public void setUp() throws Exception {
		struct = new StructureMyst�re();
	}
	
	@Test
	public void testDispo() {
		assertEquals(7, struct.dispo());
	}

	@Test
	public void testSoumettre() {
		struct.soumettre(2);
		struct.soumettre(3);
		struct.soumettre(4);
		assertEquals(4, struct.dispo());
	}
	
	@Test
	public void _testSoumettre() {
		struct.soumettre(6);
		struct.soumettre(7);
		struct.soumettre(8);
		struct.soumettre(12);
		assertEquals(3, struct.dispo());
	}
	
	@Test
	public void __testSoumettre() {
		struct.soumettre(6);
		struct.soumettre(12);
	}
	
	@Test(expected=ExceptionDonn�eRefus�e.class)
	public void testSoumettreIncorrect() {
		struct.soumettre(6);
		struct.soumettre(4);	
	}
	
	@Test(expected=ExceptionDonn�eRefus�e.class)
	public void _testSoumettreIncorrect() {
		struct.soumettre(6);
		struct.soumettre(13);	
	}

	@Test(expected=ExceptionDonn�eRefus�e.class)
	public void __testSoumettreIncorrect() {
		struct.soumettre(6);
		struct.soumettre(12);	
		struct.soumettre(13);
	}
	
	@Test(expected=ExceptionDonn�eRefus�e.class)
	public void ___testSoumettreIncorrect() {
		struct.soumettre(6);
		struct.soumettre(8);	
		struct.soumettre(12);
		struct.soumettre(7);
	}
	
	@Test
	public void testOublier() {
		struct.soumettre(6);
		struct.soumettre(10);
		struct.oublier();
		struct.soumettre(16);
		struct.soumettre(19);
		assertEquals(4, struct.dispo());
	}
	
	@Test
	public void _testOublier() {
		struct.oublier();
		assertEquals(7, struct.dispo());
	}
	
	@Test
	public void __testOublier() {
		struct.soumettre(1);
		struct.soumettre(2);
		struct.oublier();
		struct.soumettre(4);
		struct.oublier();
		struct.soumettre(7);
		struct.soumettre(8);
		struct.oublier();
		struct.soumettre(11);
		struct.soumettre(14);
		struct.oublier();
		struct.soumettre(15);
		struct.soumettre(16);
		struct.oublier();
		struct.soumettre(18);
		struct.soumettre(19);
		struct.soumettre(22);
		assertEquals(0, struct.dispo());
	}
	
	@Test(expected=ExceptionDonn�eRefus�e.class)
	public void ___testOublier() {
		struct.soumettre(1);
		struct.soumettre(2);
		struct.oublier();
		struct.soumettre(4);
		struct.soumettre(5);
	}

	
}
