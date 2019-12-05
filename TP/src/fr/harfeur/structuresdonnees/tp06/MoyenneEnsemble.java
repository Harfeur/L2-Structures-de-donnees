package fr.harfeur.structuresdonnees.tp06;

import java.util.Random;
import java.util.TreeSet;

public class MoyenneEnsemble {
	
	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<Integer>();
		Random r = new Random();
		
		for (int i = 0; i < 15; i++) { // Boucle 15 fois
			t.add(r.nextInt(101));	// Ajout d'un entier entre 0 et 101 (exclus)
		}
		
		int somme = 0; // Init de somme
		for (Integer valeur : t) {
			somme += valeur;
		}
		int m = somme / t.size();
		
		String into = "Contenue dans l'ensemble";
		
		if (!t.contains(m)) {
			into = "Valeur la plus proche = ";
			Integer maxi = t.ceiling(m);
			Integer mini = t.floor(m);
			if (mini == null)
				into += maxi;
			else if (maxi == null)
				into += mini;
			else {
				if (m-mini <= maxi-m)
					into += mini;
				else
					into += maxi;
			}
		}
		
		
		System.out.println(t);
		System.out.println(String.format("Moyenne = %s. %s", m, into));
	}
	
}
