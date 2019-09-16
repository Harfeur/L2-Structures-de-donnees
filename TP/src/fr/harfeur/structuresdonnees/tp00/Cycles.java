package fr.harfeur.structuresdonnees.tp00;

public class Cycles {

	public static void main(String[] args) {
		String[] libellés = {"er", "nd", "ème"};
		int[] durées = {3,2,3};
		
		
		for (int i = 0; i < durées.length; i++) {
			
			String texte = String.format("Le %d%s cycle universitaire dure %d ans", i+1, libellés[i], durées[i]);
			System.out.println(texte);
		}
	}
	
}
