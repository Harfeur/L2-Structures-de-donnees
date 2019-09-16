package fr.harfeur.structuresdonnees.tp00.commandes;

import java.util.Vector;

public class Client {
	
	String nom, prénom, ville;
	Vector<Commande> historique;
	
	public Client(String nom, String prénom, String ville) {
		super();
		this.nom = nom;
		this.prénom = prénom;
		this.ville = ville;
		this.historique = new Vector<Commande>();
	}
	
	public void ajouterCommande(Commande commande) {
		this.historique.add(commande);
	}
	
	public String toString() {
		String str = String.format("%s %s (%s)", this.prénom, this.nom, this.ville);
		return str;
	}
}
