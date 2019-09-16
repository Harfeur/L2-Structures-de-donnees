package fr.harfeur.structuresdonnees.tp00.commandes;

public class Commande {
	
	int identifiant, codeStatus;
	static String[] status = {"En cours", "Validée", "Livrée", "Payée"};
	
	public Commande(int identifiant, int codeStatus) {
		super();
		this.identifiant = identifiant;
		this.codeStatus = codeStatus;
	}
	
	public String toString() {
		String str = String.format("Commande n°%s - %s", this.identifiant, Commande.status[this.codeStatus]);
		return str;
	}
}
