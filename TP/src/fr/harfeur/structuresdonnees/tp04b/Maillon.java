package fr.harfeur.structuresdonnees.tp04b;

public class Maillon<Cl�, Valeur> {

	Cl� key;
	Valeur value;
	Maillon<Cl�, Valeur> successeur;
	public Maillon(Cl� key, Valeur value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
