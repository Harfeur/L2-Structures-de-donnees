package fr.harfeur.structuresdonnees.tp00b;

import java.util.Vector;

public class Situation {
	
	String description;
	Vector<Choix> choix;
	
	public Situation(String description) {
		super();
		this.description = description;
		this.choix = new Vector<Choix>();
	}
	
	public void ajouterChoix(Choix choix) {
		this.choix.add(choix);
	}
	
	public boolean estFinale() {
		return this.choix.size() == 0;
	}
	
	public String toString() {
		String str = this.description + "\n";
		for (int i = 0; i < this.choix.size(); i++)
			str += String.format("[%d] %s", i, this.choix.get(i).description);
		return str;
	}
}
