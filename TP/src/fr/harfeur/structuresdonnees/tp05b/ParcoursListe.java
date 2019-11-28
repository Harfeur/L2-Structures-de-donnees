package fr.harfeur.structuresdonnees.tp05b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ParcoursListe {
	
	private ArrayList<Integer> listInt;
	
	public ParcoursListe() {
		super();
		Random r = new Random();
		this.listInt = new ArrayList<Integer>();
		for (int i = 0; i < 10; ++i) {
			this.listInt.add(r.nextInt(11));
		}
	}
	
	public void supprimerPairs() {
		ArrayList<Integer> fin = new ArrayList<Integer>();
		Iterator<Integer> i = this.listInt.iterator();
		while (i.hasNext()) {
			Integer integer = (Integer) i.next();
			if (integer%2 != 0) {
				fin.add(integer);
			}
		}
		this.listInt = fin;
	}
	
	@Override
	public String toString() {
		return this.listInt.toString();
	}
	
	public static void main(String[] args) {
		ParcoursListe p = new ParcoursListe();
		System.out.println(p);
		p.supprimerPairs();
		System.out.println(p);
	}
	
}
