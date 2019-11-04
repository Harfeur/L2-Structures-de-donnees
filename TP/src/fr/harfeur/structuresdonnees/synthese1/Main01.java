package fr.harfeur.structuresdonnees.synthese1;

import java.util.Random;
import java.util.Scanner;

public class Main01 {
	
	public static void main(String[] args) {
		
		BaseDeConnaissances base = new BaseDeConnaissances();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		boolean jeu = true;
		int score = 0;
		
		while (jeu) {
			String taille = Objet.tailles[r.nextInt(Objet.tailles.length)];
			String forme = Objet.formes[r.nextInt(Objet.formes.length)];
			String couleur = Objet.couleurs[r.nextInt(Objet.couleurs.length)];
			
			Objet objetJeu = new Objet(taille, forme, couleur); // Objet à trouver
			System.out.println(objetJeu);
			
			System.out.println("Quel est le nom de l'objet ?");
			String input = sc.nextLine();
			
			if (!base.containsKey(objetJeu)) {
				System.out.println("Je ne savais pas, je le note");
				base.put(objetJeu, input);
			}
			else {
				String nomObjet = base.get(objetJeu);
				if (nomObjet.toLowerCase().equals(input.toLowerCase())) {
					System.out.println("Gagné !");
					score++;
				}
				else {
					System.out.println("Perdu ! C'était " + nomObjet);
					jeu = false;
				}
			}
			System.out.println();
		}
		
		sc.close();
		System.out.println("Jeu terminé ! Score : " + score);
		
	}
	
}
