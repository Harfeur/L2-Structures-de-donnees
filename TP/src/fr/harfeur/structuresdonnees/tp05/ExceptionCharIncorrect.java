package fr.harfeur.structuresdonnees.tp05;

@SuppressWarnings("serial")
public class ExceptionCharIncorrect extends Exception {
	
	public ExceptionCharIncorrect(char c) {
		super(c + " n'est pas un nombre ou un op�rateur parmi + - * /");
	}
	
}
