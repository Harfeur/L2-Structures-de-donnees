package fr.harfeur.structuresdonnees.tp05;

public class Noeud {
	
	String �nonc�;
	Noeud siOui, siNon;
	
	public Noeud(String �nonc�, Noeud siOui, Noeud siNon) {
		super();
		this.�nonc� = �nonc�;
		this.siOui = siOui;
		this.siNon = siNon;
	}

	public Noeud(String string) {
		super();
		this.�nonc� = string;
		this.siNon = null;
		this.siOui = null;
	}
	
}
