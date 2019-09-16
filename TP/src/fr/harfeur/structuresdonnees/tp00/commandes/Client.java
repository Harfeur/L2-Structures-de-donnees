package fr.harfeur.structuresdonnees.tp00.commandes;

import java.util.Vector;

public class Client {
	
	String nom, pr�nom, ville;
	Vector<Commande> historique;
	
	public Client(String nom, String pr�nom, String ville) {
		super();
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.ville = ville;
		this.historique = new Vector<Commande>();
	}
	
	public void ajouterCommande(Commande commande) {
		this.historique.add(commande);
	}
	
	public String toString() {
		String str = String.format("%s %s (%s)", this.pr�nom, this.nom, this.ville);
		return str;
	}
}
