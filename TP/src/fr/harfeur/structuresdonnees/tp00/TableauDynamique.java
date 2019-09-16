package fr.harfeur.structuresdonnees.tp00;

import java.util.Random;
import java.util.Vector;

public class TableauDynamique {
	public static void main(String[] args) {
		Vector<Character> caracteres = new Vector<Character>();
		Character[] ajout = {'a', 'b', 'c', 'd', 'e'};
		
		for (int i = 0; i < 500; i++) {
			Random r = new Random();
			caracteres.add(ajout[r.nextInt(5)]);
			System.out.println(String.format("Taille : %s Capacité : %s",caracteres.size(), caracteres.capacity()));
		}
		
		for (int i = 0; i < 300; i++) {
			caracteres.remove(0);
		}
		System.out.println(String.format("Taille : %s Capacité : %s",caracteres.size(), caracteres.capacity()));

		caracteres.trimToSize();
		System.out.println(String.format("Taille : %s Capacité : %s",caracteres.size(), caracteres.capacity()));

	}
}
