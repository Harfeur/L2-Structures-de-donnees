package fr.harfeur.structuresdonnees.tp06;

import java.util.HashSet;

import fr.harfeur.structuresdonnees.tp06.Objet.Couleur;
import fr.harfeur.structuresdonnees.tp06.Objet.Forme;
import fr.harfeur.structuresdonnees.tp06.Objet.Taille;

@SuppressWarnings("serial")
public class RechercheMulti extends HashSet<Objet> {

	HashSet<Objet> petits;
	HashSet<Objet> jaunes;
	HashSet<Objet> grands;
	HashSet<Objet> carr�s;
	
	public RechercheMulti() {
		super();
		this.petits = new HashSet<Objet>();
		this.jaunes = new HashSet<Objet>();
		this.grands = new HashSet<Objet>();
		this.carr�s = new HashSet<Objet>();
	}
	
	@Override
	public boolean add(Objet objet) {
		if (!super.add(objet)) return false;
		if (objet.taille == Taille.Petit)
			this.petits.add(objet);
		else
			this.grands.add(objet);
		if (objet.couleur == Couleur.Jaune)
			this.jaunes.add(objet);
		if (objet.forme == Forme.Carr�)
			this.carr�s.add(objet);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		RechercheMulti r = new RechercheMulti();
		r.add(new Objet("point", Taille.Petit, Forme.Rond, Couleur.Noir));
		r.add(new Objet("petit pois", Taille.Petit, Forme.Rond, Couleur.Vert));
		r.add(new Objet("soleil", Taille.Grand, Forme.Rond, Couleur.Jaune));
		r.add(new Objet("pr�", Taille.Grand, Forme.Carr�, Couleur.Vert));
		r.add(new Objet("post-it", Taille.Petit, Forme.Carr�, Couleur.Jaune));
		r.add(new Objet("pneu", Taille.Grand, Forme.Rond, Couleur.Noir));
		
		System.out.println("Objets petits et jaunes :");
		HashSet<Objet> pj = (HashSet<Objet>) r.petits.clone();
		pj.retainAll(r.jaunes);
		for (Objet o : pj)
			System.out.println("- " + o);
		
		System.out.println("\nObjets grands mais pas carr�s");
		HashSet<Objet> gpc = (HashSet<Objet>) r.grands.clone();
		gpc.removeAll(r.carr�s);
		for (Objet o : gpc)
			System.out.println("- " + o);
	}
}
