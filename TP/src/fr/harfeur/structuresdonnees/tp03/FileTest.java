package fr.harfeur.structuresdonnees.tp03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTest {
	
	FileContigue<Character> file1;
	FileChainee<Character> file2;

	@BeforeEach
	void setUp() throws Exception {
		this.file1 = new FileContigue<Character>();
		this.file2 = new FileChainee<Character>();
	}

	@Test
	void test11() throws ExceptionFileVide {
		file1.enfiler('a');
		file1.defiler();
		assertEquals(true, file1.estVide());
	}
	
	@Test
	void test12() {
		assertThrows(ExceptionFileVide.class, () -> file1.premier());
	}
	
	@Test
	void test13() {
		assertThrows(ExceptionFileVide.class, () -> file1.defiler());
	}

	@Test
	void test14() throws ExceptionFileVide {
		file1.enfiler('a');
		file1.enfiler('b');
		file1.enfiler('c');
		assertEquals('a', file1.premier());
		file1.defiler();
		assertEquals('b', file1.premier());
		file1.defiler();
		assertEquals('c', file1.premier());
		file1.defiler();
	}

	@Test
	void test21() throws ExceptionFileVide {
		file2.enfiler('a');
		file2.defiler();
		assertEquals(true, file2.estVide());
	}
	
	@Test
	void test22() {
		assertThrows(ExceptionFileVide.class, () -> file2.premier());
	}
	
	@Test
	void test23() {
		assertThrows(ExceptionFileVide.class, () -> file2.defiler());
	}

	@Test
	void test24() throws ExceptionFileVide {
		file2.enfiler('a');
		file2.enfiler('b');
		file2.enfiler('c');
		assertEquals('a', file2.premier());
		file2.defiler();
		assertEquals('b', file2.premier());
		file2.defiler();
		assertEquals('c', file2.premier());
		file2.defiler();
	}
	
	@Test
	void vitesseContigue() throws ExceptionFileVide {
		Random r = new Random();
		for (int i = 0; i < 500000; i++) {
			file1.enfiler((char) (r.nextInt(26) + 'a'));
		}
		for (int i = 0; i < 500000; i++) {
			file1.defiler();
		}
		assertEquals(true, file1.estVide());
	}
	
	@Test
	void vitesseChainee() throws ExceptionFileVide {
		Random r = new Random();
		for (int i = 0; i < 500000; i++) {
			file2.enfiler((char) (r.nextInt(26) + 'a'));
		}
		for (int i = 0; i < 500000; i++) {
			file2.defiler();
		}
		assertEquals(true, file2.estVide());
	}
}
