package fr.harfeur.structuresdonnees.tp04b;

@SuppressWarnings("serial")
public class ExceptionCl�D�j�Existante extends Exception {
	
	public ExceptionCl�D�j�Existante(Object key) {
		super("La cl� " + key + " est d�j� existante.");
	}
	
}
