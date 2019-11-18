package fr.harfeur.structuresdonnees.tp05;

public class ArbreBinaire<E> {

	private ArbreBinaire<E> gauche, droite;
	private E �tiquette;
	
	public ArbreBinaire() {
		super();
		this.�tiquette = null;
	}
	
	public ArbreBinaire(E �tiquette) {
		super();
		this.droite = new ArbreBinaire<E>();
		this.�tiquette = �tiquette;
		this.gauche = new ArbreBinaire<E>();
	}
	
	public ArbreBinaire(E �tiquette, ArbreBinaire<E> gauche, ArbreBinaire<E> droite) {
		super();
		this.droite = droite;
		this.�tiquette = �tiquette;
		this.gauche = gauche;
	}
	
	public boolean est_vide() {
		return this.�tiquette == null;
	}
	
	public E racine() throws ExceptionArbreVide {
		if (this.�tiquette == null) throw new ExceptionArbreVide();
		return this.�tiquette;
	}
	
	public ArbreBinaire<E> sag() throws ExceptionArbreVide {
		if (this.�tiquette == null) throw new ExceptionArbreVide();
		return this.gauche;
	}
	
	public ArbreBinaire<E> sad() throws ExceptionArbreVide {
		if (this.�tiquette == null) throw new ExceptionArbreVide();
		return this.droite;
	}
	
	public int taille(){
		if (this.�tiquette == null) return 0;
		return 1 + this.gauche.taille() + this.droite.taille();
	}
	
	public int hauteur() {
		if (this.�tiquette == null) return 0;
		return 1 + Math.max(this.gauche.hauteur(), this.droite.hauteur());
	}
	
}
