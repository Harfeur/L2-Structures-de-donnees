package fr.harfeur.structuresdonnees.tp05;

public class ArbreBinaire<E> {

	private ArbreBinaire<E> gauche, droite;
	private E étiquette;
	
	public ArbreBinaire() {
		super();
		this.étiquette = null;
	}
	
	public ArbreBinaire(E étiquette) {
		super();
		this.droite = new ArbreBinaire<E>();
		this.étiquette = étiquette;
		this.gauche = new ArbreBinaire<E>();
	}
	
	public ArbreBinaire(E étiquette, ArbreBinaire<E> gauche, ArbreBinaire<E> droite) {
		super();
		this.droite = droite;
		this.étiquette = étiquette;
		this.gauche = gauche;
	}
	
	public boolean est_vide() {
		return this.étiquette == null;
	}
	
	public E racine() throws ExceptionArbreVide {
		if (this.étiquette == null) throw new ExceptionArbreVide();
		return this.étiquette;
	}
	
	public ArbreBinaire<E> sag() throws ExceptionArbreVide {
		if (this.étiquette == null) throw new ExceptionArbreVide();
		return this.gauche;
	}
	
	public ArbreBinaire<E> sad() throws ExceptionArbreVide {
		if (this.étiquette == null) throw new ExceptionArbreVide();
		return this.droite;
	}
	
	public int taille(){
		if (this.étiquette == null) return 0;
		return 1 + this.gauche.taille() + this.droite.taille();
	}
	
	public int hauteur() {
		if (this.étiquette == null) return 0;
		return 1 + Math.max(this.gauche.hauteur(), this.droite.hauteur());
	}
	
}
