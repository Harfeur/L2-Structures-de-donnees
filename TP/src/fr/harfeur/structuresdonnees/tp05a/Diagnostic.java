package fr.harfeur.structuresdonnees.tp05a;

import java.util.Scanner;

public class Diagnostic {
	
	private Noeud courant;
	
	public Diagnostic() {
		super();
		this.courant = new Noeud(
				"Un affichage appara�t-il � l'�cran ?",
				new Noeud(
						"Le pointeur est-il affich� � l'�cran ?",
						new Noeud(
								"Le pointeur bouge-t-il lorsqu'on manipule la souris ?",
								new Noeud("Le syst�me fonctionne correctement."),
								new Noeud("Il s'agit d'une panne de la souris.")),
						new Noeud(
								"La souris est-elle branch�e correctement ?",
								new Noeud("Il s'agit d'une panne de la souris."),
								new Noeud("Brancher la souris."))),
				new Noeud(
						"Le voyant de marche est-il allum� ?",
						new Noeud(
								"L'appareil est-il en veille ?",
								new Noeud("Sortir l'appareil du mode veille."),
								new Noeud("Il s'agit d'une panne d'affichage.")),
						new Noeud("L'appareil est �teint, allumer l'appareil.")));
	}
	
	@Override
	public String toString() {
		return this.courant.�nonc�;
	}
	
	public boolean estR�solu() {
		return this.courant.siNon == null && this.courant.siOui == null;
	}
	
	public void progresse(String r�ponse) {
		r�ponse = r�ponse.toLowerCase();
		switch (r�ponse) {
		case "oui":
			this.courant = this.courant.siOui;
			break;

		case "non":
			this.courant = this.courant.siNon;
			break;

		default:
			System.out.println("R�ponse invalide ! R�pondez par oui ou non");
			break;
		}
	}
	
	public static void main(String[] args) {
		
		Diagnostic diagnostic = new Diagnostic();
		
		Scanner sc = new Scanner(System.in);
		
		while (!diagnostic.estR�solu()) {
			System.out.println(diagnostic);
			String r�ponse = sc.nextLine();
			diagnostic.progresse(r�ponse);
		}
		
		sc.close();
		
		System.out.println("Le probl�me est r�solu : " + diagnostic);
	}
	
}
