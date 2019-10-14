package fr.harfeur.structuresdonnees.tp03.qr;

import java.util.Scanner;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp03.FileChainee;

public class QCU {

	public static void main(String[] args) throws ExceptionFileVide {

		Question q1 = new Question("Quelle est la couleur dominante du ciel ?");
		q1.ajouterReponse(new Reponse("bleu", true));
		q1.ajouterReponse(new Reponse("vert", false));
		q1.ajouterReponse(new Reponse("jaune", false));
		
		Question q2 = new Question("Quelle est la hauteur du viaduc de Millau ?");
		q2.ajouterReponse(new Reponse("42m", false));
		q2.ajouterReponse(new Reponse("100m", false));
		q2.ajouterReponse(new Reponse("343m", true));
		
		Question q3 = new Question("En quelle annee est nee Louise Brown, le premier bebe eprouvette");
		q3.ajouterReponse(new Reponse("1968", false));
		q3.ajouterReponse(new Reponse("1978", true));
		q3.ajouterReponse(new Reponse("2008", false));

		FileChainee<Question> questionnaire = new FileChainee<Question>();
		questionnaire.enfiler(q1);
		questionnaire.enfiler(q2);
		questionnaire.enfiler(q3);
		
		Scanner sc = new Scanner(System.in);
		while (!questionnaire.estVide()) {
			Question question = questionnaire.premier();
			System.out.println(question);
			int i = sc.nextInt();
			boolean reponse = question.estBonneReponse(i);
			if (reponse) {
				System.out.println("Bonne reponse");
				questionnaire.defiler();
			}
			else {
				System.out.println("Question incorrecte");
				questionnaire.enfiler(question);
				questionnaire.defiler();
			}
		}
		sc.close();
	}

}
