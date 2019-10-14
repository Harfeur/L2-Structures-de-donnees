package fr.harfeur.structuresdonnees.tp03;

public class FileChainee<E> implements File<E> {

	Maillon<E> premier;
	Maillon<E> dernier;
	
	public FileChainee() {
		super();
		this.premier = null;
	}
	
	@Override
	public boolean estVide() {
		return this.premier == null;
	}

	@Override
	public E premier() throws ExceptionFileVide {
		if (this.premier == null) throw new ExceptionFileVide();
		return this.premier.valeur;
	}

	@Override
	public void enfiler(E e) {
		Maillon<E> m = new Maillon<E>();
		m.valeur = e;
		m.successeur = null;
		if (this.estVide()) this.premier = m;
		else this.dernier.successeur = m;
		this.dernier = m;
	}

	@Override
	public void defiler() throws ExceptionFileVide {
		if (this.premier == null) throw new ExceptionFileVide();
		this.premier = this.premier.successeur;
	}

}
