package fr.harfeur.structuresdonnees.tp00;

public class Cycles {

	public static void main(String[] args) {
		String[] libell�s = {"er", "nd", "�me"};
		int[] dur�es = {3,2,3};
		
		
		for (int i = 0; i < dur�es.length; i++) {
			
			String texte = String.format("Le %d%s cycle universitaire dure %d ans", i+1, libell�s[i], dur�es[i]);
			System.out.println(texte);
		}
	}
	
}
