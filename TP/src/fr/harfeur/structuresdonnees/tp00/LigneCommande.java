package fr.harfeur.structuresdonnees.tp00;

public class LigneCommande {
	
	String article;
	double prixUnitaire;
	int quantit�;
	
	public LigneCommande(String article, double prixUnitaire, int quantit�) {
		super();
		this.article = article;
		this.prixUnitaire = prixUnitaire;
		this.quantit� = quantit�;
	}

	public static void main(String[] args) {
		LigneCommande[] lignes = {
				new LigneCommande("Bac 16L tri-mati�re renforc�", 86.80, 1),
				new LigneCommande("Protection ThermaQuiet aluminium noir", 14.90, 1),
				new LigneCommande("Fixation `a clip 1/8� 6.5mm", 4.35, 5)};
		
		double prix = 0;
		for (LigneCommande commande : lignes) {
			prix += commande.prixUnitaire * commande.quantit�;
		}
		System.out.printf("Le prix � payer est de %s�", prix);
	}
}
