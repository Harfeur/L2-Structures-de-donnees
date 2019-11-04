package fr.harfeur.structuresdonnees.synthese1;

import java.util.Objects;

public class Objet {
	
	String taille, forme, couleur;
	public static String[] tailles = {"petit", "grand"};
	public static String[] formes = {"rond", "carré"};
	public static String[] couleurs = {"jaune", "vert", "noir"};
	
	public Objet(String taille, String forme, String couleur) {
		super();
		this.taille = taille;
		this.forme = forme;
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return String.format("Un objet %s, %s, et %s", this.taille, this.forme, this.couleur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(couleur, forme, taille);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objet other = (Objet) obj;
		return Objects.equals(couleur, other.couleur) && Objects.equals(forme, other.forme)
				&& Objects.equals(taille, other.taille);
	}
}
