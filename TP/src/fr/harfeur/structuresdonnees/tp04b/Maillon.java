package fr.harfeur.structuresdonnees.tp04b;

public class Maillon<Clé, Valeur> {

	Clé key;
	Valeur value;
	Maillon<Clé, Valeur> successeur;
	public Maillon(Clé key, Valeur value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
