package fr.harfeur.structuresdonnees.tp06;

public class Objet {
	
	String nom;
	/*
	 * Variable qui prend que certaines valeurs
	 * Enumération
	 */
	enum Taille {Petit, Grand};
	enum Forme {Carré, Rond};
	enum Couleur {Jaune, Vert, Noir};
	
	Taille taille;
	Forme forme;
	Couleur couleur;
	
	public Objet(String nom, Taille taille, Forme forme, Couleur couleur) {
		super();
		this.nom = nom;
		this.taille = taille;
		this.forme = forme;
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
	
}
