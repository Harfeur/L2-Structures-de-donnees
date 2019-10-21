package fr.harfeur.structuresdonnees.tp04b;

@SuppressWarnings("serial")
public class ExceptionCléDéjàExistante extends Exception {
	
	public ExceptionCléDéjàExistante(Object key) {
		super("La clé " + key + " est déjà existante.");
	}
	
}
