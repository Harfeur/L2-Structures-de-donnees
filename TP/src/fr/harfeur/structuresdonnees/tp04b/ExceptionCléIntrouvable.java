package fr.harfeur.structuresdonnees.tp04b;

@SuppressWarnings("serial")
public class ExceptionCl�Introuvable extends Exception {
	
	public ExceptionCl�Introuvable(Object key) {
		super("La cl� " + key + " est introuvable.");
	}
	
}
