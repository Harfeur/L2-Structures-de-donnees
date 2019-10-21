package fr.harfeur.structuresdonnees.tp04b;

@SuppressWarnings("serial")
public class ExceptionDicoPlein extends Exception {
	
	public ExceptionDicoPlein() {
		super("Dictionnaire plein");
	}
	
}
