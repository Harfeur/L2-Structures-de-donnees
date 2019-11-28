package fr.harfeur.structuresdonnees.tp05b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp03.FileContigue;
import fr.harfeur.structuresdonnees.tp05a.ArbreBinaire;

public class ArbreBinaireAm�lior�<E> extends ArbreBinaire<E> implements Iterable<E> {

	public ArbreBinaireAm�lior�() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArbreBinaireAm�lior�(E �tiquette, ArbreBinaireAm�lior�<E> gauche, ArbreBinaireAm�lior�<E> droite) {
		super(�tiquette, gauche, droite);
		// TODO Auto-generated constructor stub
	}

	public ArbreBinaireAm�lior�(E �tiquette) {
		super();
		this.droite = new ArbreBinaireAm�lior�<E>();
		this.�tiquette = �tiquette;
		this.gauche = new ArbreBinaireAm�lior�<E>();
	}
	
	
	public void parcoursProfondeurInfixe() {
		if (this.�tiquette == null) {
			return;
		}
		((ArbreBinaireAm�lior�<E>) this.gauche).parcoursProfondeurInfixe();
		System.out.print(this.�tiquette);
		((ArbreBinaireAm�lior�<E>) this.droite).parcoursProfondeurInfixe();
	}
	
	public ArrayList<E> parcoursLargeur() {
		ArrayList<E> f = new ArrayList<E>();
		FileContigue<ArbreBinaireAm�lior�<E>> file = new FileContigue<ArbreBinaireAm�lior�<E>>();
		file.enfiler(this);
		while (!file.estVide()) {
			ArbreBinaireAm�lior�<E> ab;
			try {
				ab = file.premier();
				file.defiler();
				if (ab.�tiquette != null) {
					f.add(ab.�tiquette);
					file.enfiler((ArbreBinaireAm�lior�<E>) ab.gauche);
					file.enfiler((ArbreBinaireAm�lior�<E>) ab.droite);
				}
			} catch (ExceptionFileVide e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return f;
	}

	@Override
	public Iterator<E> iterator() {
		return new ABIterator(this);
	}
	
	public class ABIterator implements Iterator<E> {
		
		ArrayList<E> liste;
		int current;
		
		public ABIterator(ArbreBinaireAm�lior�<E> ab) {
			super();
			this.liste = ab.parcoursLargeur();
			this.current = 0;
		}
		
		@Override
		public boolean hasNext() {
			return this.current < this.liste.size();
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			return this.liste.get(this.current++);
		}
			
	}
}
