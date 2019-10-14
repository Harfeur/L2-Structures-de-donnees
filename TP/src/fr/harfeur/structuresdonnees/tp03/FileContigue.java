package fr.harfeur.structuresdonnees.tp03;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FileContigue<E> extends ArrayList<E> implements File<E> {
	
	public FileContigue() {
		super();
	}
	
	@Override
	public boolean estVide() {
		return this.size() == 0;
	}

	@Override
	public E premier() throws ExceptionFileVide {
		if (this.size() == 0) throw new ExceptionFileVide();
		return this.get(0);
	}

	@Override
	public void enfiler(E e) {
		this.add(e);
	}

	@Override
	public void defiler() throws ExceptionFileVide {
		if (this.size() == 0) throw new ExceptionFileVide();
		this.remove(0);
	}

}
