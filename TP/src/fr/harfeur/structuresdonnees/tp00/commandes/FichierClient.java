package fr.harfeur.structuresdonnees.tp00.commandes;

import java.util.Vector;

public class FichierClient {
	
	Vector<Client> catalogue;
	
	public FichierClient() {
		super();
		this.catalogue = new Vector<Client>();
		Client martin = new Client("Martin", "Valérie", "Albi");
		Client ndiaye = new Client("Ndiaye", "Marie", "Dakar");
		Client smith = new Client("Smith", "Peter", "New-York");
		martin.ajouterCommande(new Commande(12897, 0));
		martin.ajouterCommande(new Commande(86416, 1));
		martin.ajouterCommande(new Commande(98716, 2));
		ndiaye.ajouterCommande(new Commande(61573, 0));
		ndiaye.ajouterCommande(new Commande(36475, 2));
		this.catalogue.add(martin);
		this.catalogue.add(ndiaye);
		this.catalogue.add(smith);
	}
	
	public Vector<Client> clientsVierges() {
		Vector<Client> subVector = new Vector<Client>();
		for (Client client : this.catalogue) {
			if (client.historique.size() == 0) subVector.add(client);
		}
		return subVector;
	}
	
	public Vector<Commande> listerCommandes(int codeStatus) {
		Vector<Commande> subVector = new Vector<Commande>();
		for (Client client : this.catalogue) {
			for (Commande commande : client.historique) {
				if (commande.codeStatus == codeStatus) subVector.add(commande);
			}
		}
		return subVector;
	}
	
	public static void main(String[] args) {
		FichierClient fichier = new FichierClient();
		System.out.println(fichier.clientsVierges());
		System.out.println(fichier.listerCommandes(0));
	}
}
