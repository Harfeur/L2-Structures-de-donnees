package fr.harfeur.structuresdonnees.tp04b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableHachageTest {

	TableHachage<String, String> dico;
	
	@BeforeEach
	void setUp() throws Exception {
		
		dico = new TableHachage<String, String>();
		
		dico.ajouter("USB", "Universal Serial Bus");
		dico.ajouter("BIOS", "Basic Input-Output System");
		dico.ajouter("IP", "Internet Protocol");
		dico.ajouter("BYTE", "A byte is a storage unit for data");
		dico.ajouter("PC", "Personnal Computer");
		dico.ajouter("MAC", "Apple Macintosh");
		dico.ajouter("ROM", "Read-Only Memory");
		dico.ajouter("CPU", "Central Processing Unit");
	}

	@Test
	void test() throws ExceptionCl�Introuvable {
		assertEquals(true, dico.estPr�sent("BIOS"));
		assertEquals("Basic Input-Output System", dico.rechercher("BIOS"));
		assertEquals(false, dico.estPr�sent("WYSIWYG"));
		assertThrows(ExceptionCl�Introuvable.class, () -> {
			dico.rechercher("WYSIWYG");
		});
		assertEquals(false, dico.estPr�sent("PDF"));
		dico.supprimer("BYTE");
		assertEquals(false, dico.estPr�sent("BYTE"));
		assertThrows(ExceptionCl�D�j�Existante.class, () -> {
			dico.ajouter("MAC", "(adress) Media Access Control");
		});
	}

}
