package fr.harfeur.structuresdonnees.tp05a;

import java.util.Scanner;

public class Diagnostic {
	
	private Noeud courant;
	
	public Diagnostic() {
		super();
		this.courant = new Noeud(
				"Un affichage apparaît-il à l'écran ?",
				new Noeud(
						"Le pointeur est-il affiché à l'écran ?",
						new Noeud(
								"Le pointeur bouge-t-il lorsqu'on manipule la souris ?",
								new Noeud("Le système fonctionne correctement."),
								new Noeud("Il s'agit d'une panne de la souris.")),
						new Noeud(
								"La souris est-elle branchée correctement ?",
								new Noeud("Il s'agit d'une panne de la souris."),
								new Noeud("Brancher la souris."))),
				new Noeud(
						"Le voyant de marche est-il allumé ?",
						new Noeud(
								"L'appareil est-il en veille ?",
								new Noeud("Sortir l'appareil du mode veille."),
								new Noeud("Il s'agit d'une panne d'affichage.")),
						new Noeud("L'appareil est éteint, allumer l'appareil.")));
	}
	
	@Override
	public String toString() {
		return this.courant.énoncé;
	}
	
	public boolean estRésolu() {
		return this.courant.siNon == null && this.courant.siOui == null;
	}
	
	public void progresse(String réponse) {
		réponse = réponse.toLowerCase();
		switch (réponse) {
		case "oui":
			this.courant = this.courant.siOui;
			break;

		case "non":
			this.courant = this.courant.siNon;
			break;

		default:
			System.out.println("Réponse invalide ! Répondez par oui ou non");
			break;
		}
	}
	
	public static void main(String[] args) {
		
		Diagnostic diagnostic = new Diagnostic();
		
		Scanner sc = new Scanner(System.in);
		
		while (!diagnostic.estRésolu()) {
			System.out.println(diagnostic);
			String réponse = sc.nextLine();
			diagnostic.progresse(réponse);
		}
		
		sc.close();
		
		System.out.println("Le problème est résolu : " + diagnostic);
	}
	
}
