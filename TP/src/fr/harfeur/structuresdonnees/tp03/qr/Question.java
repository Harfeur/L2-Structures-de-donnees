package fr.harfeur.structuresdonnees.tp03.qr;

import java.util.Vector;

public class Question {
	
	private String libelle;
	Vector<Reponse> listeReponses;
	
	public Question(String libelle) {
		super();
		this.libelle = libelle;
		this.listeReponses = new Vector<Reponse>();
	}

	public void ajouterReponse(Reponse r) {
		this.listeReponses.add(r);
	}
	
	@Override
	public String toString() {
		String str = libelle;
		for (int i = 0; i < this.listeReponses.size(); i++) {
			Reponse reponse = this.listeReponses.get(i);
			str += String.format("\n%s) %s", i, reponse.libelle);
			if (reponse.correct) str += "*";
		}
		return str;
	}
	
	public boolean estBonneReponse(int i) {
		return this.listeReponses.get(i).correct;
	}
}
