package fr.harfeur.structuresdonnees.tp05b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp03.FileContigue;
import fr.harfeur.structuresdonnees.tp05a.ArbreBinaire;

public class ArbreBinaireAmélioré<E> extends ArbreBinaire<E> implements Iterable<E> {

	public ArbreBinaireAmélioré() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArbreBinaireAmélioré(E étiquette, ArbreBinaireAmélioré<E> gauche, ArbreBinaireAmélioré<E> droite) {
		super(étiquette, gauche, droite);
		// TODO Auto-generated constructor stub
	}

	public ArbreBinaireAmélioré(E étiquette) {
		super();
		this.droite = new ArbreBinaireAmélioré<E>();
		this.étiquette = étiquette;
		this.gauche = new ArbreBinaireAmélioré<E>();
	}
	
	
	public void parcoursProfondeurInfixe() {
		if (this.étiquette == null) {
			return;
		}
		((ArbreBinaireAmélioré<E>) this.gauche).parcoursProfondeurInfixe();
		System.out.print(this.étiquette);
		((ArbreBinaireAmélioré<E>) this.droite).parcoursProfondeurInfixe();
	}
	
	public ArrayList<E> parcoursLargeur() {
		ArrayList<E> f = new ArrayList<E>();
		FileContigue<ArbreBinaireAmélioré<E>> file = new FileContigue<ArbreBinaireAmélioré<E>>();
		file.enfiler(this);
		while (!file.estVide()) {
			ArbreBinaireAmélioré<E> ab;
			try {
				ab = file.premier();
				file.defiler();
				if (ab.étiquette != null) {
					f.add(ab.étiquette);
					file.enfiler((ArbreBinaireAmélioré<E>) ab.gauche);
					file.enfiler((ArbreBinaireAmélioré<E>) ab.droite);
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
		
		public ABIterator(ArbreBinaireAmélioré<E> ab) {
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
