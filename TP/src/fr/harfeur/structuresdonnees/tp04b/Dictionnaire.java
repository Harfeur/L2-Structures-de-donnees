package fr.harfeur.structuresdonnees.tp04b;

public interface Dictionnaire<Cl�,Valeur> {

	public void ajouter(Cl� c, Valeur v) throws ExceptionCl�D�j�Existante, ExceptionDicoPlein;
	
	public void supprimer(Cl� c);
	
	public boolean estPr�sent(Cl� c);
	
	public Valeur rechercher(Cl� c) throws ExceptionCl�Introuvable;
	
}
