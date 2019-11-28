package fr.harfeur.structuresdonnees.tp05a;

@SuppressWarnings("serial")
public class ExceptionCharIncorrect extends Exception {
	
	public ExceptionCharIncorrect(char c) {
		super(c + " n'est pas un nombre ou un opérateur parmi + - * /");
	}
	
}
