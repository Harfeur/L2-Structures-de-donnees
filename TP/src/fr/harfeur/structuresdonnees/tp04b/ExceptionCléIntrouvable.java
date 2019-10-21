package fr.harfeur.structuresdonnees.tp04b;

@SuppressWarnings("serial")
public class ExceptionCléIntrouvable extends Exception {
	
	public ExceptionCléIntrouvable(Object key) {
		super("La clé " + key + " est introuvable.");
	}
	
}
