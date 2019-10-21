package fr.harfeur.structuresdonnees.tp04b;

public interface Dictionnaire<Clé,Valeur> {

	public void ajouter(Clé c, Valeur v) throws ExceptionCléDéjàExistante, ExceptionDicoPlein;
	
	public void supprimer(Clé c);
	
	public boolean estPrésent(Clé c);
	
	public Valeur rechercher(Clé c) throws ExceptionCléIntrouvable;
	
}
