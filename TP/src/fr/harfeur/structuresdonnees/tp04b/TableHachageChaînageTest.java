package fr.harfeur.structuresdonnees.tp04b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableHachageChaînageTest {
	
	TableHachageChaînage<String, String> dico;
	
	@BeforeEach
	void setUp() throws Exception {
		dico = new TableHachageChaînage<String, String>();
		
		dico.ajouter("BIOS", "Basic Input-Output System");
		dico.ajouter("BYTE", "A byte is a storage unit for data");
		dico.ajouter("CPU", "Central Processing Unit");
		dico.ajouter("IP", "Internet Protocol");
		dico.ajouter("MAC", "Apple Macintosh");
		dico.ajouter("OS", "Operating System");
		dico.ajouter("PC", "Personnal Computer");
		dico.ajouter("PDF", "Portable Document Format");
		dico.ajouter("RAM", "Random Access Memory");
		dico.ajouter("ROM", "Read-Only Memory");
		dico.ajouter("RTFM", "Read The Fucking Manual");
		dico.ajouter("USB", "Universal Serial Bus");
		dico.ajouter("VGA", "Video Graphics Array");
		dico.ajouter("WYSIWYG", "What You See Is What You Get");
	}

	@Test
	void test() throws ExceptionCléIntrouvable {
		assertEquals(true, dico.estPrésent("BIOS"));
		assertEquals("Basic Input-Output System", dico.rechercher("BIOS"));
		assertEquals(false, dico.estPrésent("WIFI"));
		assertThrows(ExceptionCléIntrouvable.class, () -> {
			dico.rechercher("WIFI");
		});
		dico.supprimer("BYTE");
		dico.supprimer("WIFI");
		assertEquals(false, dico.estPrésent("BYTE"));
		assertThrows(ExceptionCléDéjàExistante.class, () -> {
			dico.ajouter("MAC", "(adress) Media Access Control");
		});
	}

}
