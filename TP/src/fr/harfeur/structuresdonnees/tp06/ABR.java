package fr.harfeur.structuresdonnees.tp06;

import fr.harfeur.structuresdonnees.tp05a.ArbreBinaire;
import fr.harfeur.structuresdonnees.tp05a.ExceptionArbreVide;

public class ABR<E extends Comparable<E>> extends ArbreBinaire<E> {
	
	
	
	public ABR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ABR(E �tiquette, ABR<E> gauche, ABR<E> droite) {
		super(�tiquette, gauche, droite);
		// TODO Auto-generated constructor stub
	}

	public ABR(E �tiquette) {
		super(�tiquette, new ABR<E>(), new ABR<E>());
	}

	public void ins�rer(E e) {
		if (this.est_vide())
			this.�tiquette = e;
		else {
			if (e.compareTo(this.�tiquette) > 0)
				((ABR<E>) this.droite).ins�rer(e);
			else
				((ABR<E>) this.gauche).ins�rer(e);
		}
	}
	
	public void supprimer(E e) {
		if (this.est_vide()) return;
		else if (this.�tiquette.equals(e)) {
			if (this.gauche.est_vide()) {
				this.�tiquette = this.droite.�tiquette;
				this.gauche = this.droite.gauche;
				this.droite = this.droite.droite;
				return;
			}
			else if (this.droite.est_vide()) {
				this.�tiquette = this.gauche.�tiquette;
				this.droite = this.gauche.droite;
				this.gauche = this.gauche.gauche;
				return;
			}
			else {
				this.�tiquette = ((ABR<E>) this.gauche).max();
				((ABR<E>) this.gauche).supprimer(this.�tiquette);
				return;
			}
		}
		else if (this.�tiquette.compareTo(e) > 0) {
			((ABR<E>) this.gauche).supprimer(e);
			return;
		}
		else {
			((ABR<E>) this.droite).supprimer(e);
			return;
		}
	}

	public E max() {
		if (this.est_vide()) return null;
		if (this.droite.est_vide()) return this.�tiquette;
		return ((ABR<E>) this.droite).max();
	}
	
}
