package fr.harfeur.structuresdonnees.tp04b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableHachageSondageTest {

	TableHachageSondage<String, String> dico;
	
	@BeforeEach
	void setUp() throws Exception {
		dico = new TableHachageSondage<String, String>();

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
	void test() throws ExceptionCléDéjàExistante, ExceptionDicoPlein {
		dico.supprimer("PC");
		dico.supprimer("ROM");
		assertEquals(true, dico.estPrésent("RTFM"));
		dico.ajouter("GPU", "Graphics Processing Unit");
		dico.ajouter("GIF", "Graphics Interchange Format");
	}

}
