package fr.harfeur.structuresdonnees.tp05;

public class Noeud {
	
	String énoncé;
	Noeud siOui, siNon;
	
	public Noeud(String énoncé, Noeud siOui, Noeud siNon) {
		super();
		this.énoncé = énoncé;
		this.siOui = siOui;
		this.siNon = siNon;
	}

	public Noeud(String string) {
		super();
		this.énoncé = string;
		this.siNon = null;
		this.siOui = null;
	}
	
}
