package fr.harfeur.structuresdonnees.tp01;

public interface Liste<E> {
	
	int longueur();
	
	E ieme(int indice) throws ExceptionIndiceHorsLimites;
	
	void inserer(int indice, E element) throws ExceptionIndiceHorsLimites;
	
	void supprimer(int indice) throws ExceptionIndiceHorsLimites;
}
