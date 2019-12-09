package fr.harfeur.structuresdonnees.tp09;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp03.File;

public class FilePriorit�<E extends Comparable<E>> extends Tas<E> implements File<E> {

	public FilePriorit�() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E premier() throws ExceptionFileVide {
		if (this.estVide()) throw new ExceptionFileVide();
		return (E) this.valeurs[0];
	}

	@Override
	public void enfiler(E e) {
		this.ins�rer(e);
	}

	@Override
	public void defiler() throws ExceptionFileVide {
		if (this.estVide()) throw new ExceptionFileVide();
		this.supprimer();
	}

}
