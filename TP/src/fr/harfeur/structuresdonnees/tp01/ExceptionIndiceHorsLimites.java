package fr.harfeur.structuresdonnees.tp01;

@SuppressWarnings("serial")
public class ExceptionIndiceHorsLimites extends RuntimeException {
	
	public ExceptionIndiceHorsLimites(int indice) {
		super(String.format("L’indice %s est en dehors des limites de la liste", indice));
	}
}
