package fr.harfeur.structuresdonnees.tp06;

import fr.harfeur.structuresdonnees.tp05a.ArbreBinaire;
import fr.harfeur.structuresdonnees.tp05a.ExceptionArbreVide;

public class ABR<E extends Comparable<E>> extends ArbreBinaire<E> {
	
	
	
	public ABR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ABR(E étiquette, ABR<E> gauche, ABR<E> droite) {
		super(étiquette, gauche, droite);
		// TODO Auto-generated constructor stub
	}

	public ABR(E étiquette) {
		super(étiquette, new ABR<E>(), new ABR<E>());
	}

	public void insérer(E e) {
		if (this.est_vide())
			this.étiquette = e;
		else {
			if (e.compareTo(this.étiquette) > 0)
				((ABR<E>) this.droite).insérer(e);
			else
				((ABR<E>) this.gauche).insérer(e);
		}
	}
	
	public void supprimer(E e) {
		if (this.est_vide()) return;
		else if (this.étiquette.equals(e)) {
			if (this.gauche.est_vide()) {
				this.étiquette = this.droite.étiquette;
				this.gauche = this.droite.gauche;
				this.droite = this.droite.droite;
				return;
			}
			else if (this.droite.est_vide()) {
				this.étiquette = this.gauche.étiquette;
				this.droite = this.gauche.droite;
				this.gauche = this.gauche.gauche;
				return;
			}
			else {
				this.étiquette = ((ABR<E>) this.gauche).max();
				((ABR<E>) this.gauche).supprimer(this.étiquette);
				return;
			}
		}
		else if (this.étiquette.compareTo(e) > 0) {
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
		if (this.droite.est_vide()) return this.étiquette;
		return ((ABR<E>) this.droite).max();
	}
	
}
