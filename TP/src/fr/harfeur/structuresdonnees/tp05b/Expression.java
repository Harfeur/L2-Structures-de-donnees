package fr.harfeur.structuresdonnees.tp05b;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp05a.ExceptionArbreVide;
import fr.harfeur.structuresdonnees.tp05a.ExceptionCharIncorrect;

public class Expression {

	public static void main(String[] args) throws ExceptionArbreVide, ExceptionCharIncorrect, ExceptionFileVide {
		
		ArbreBinaireAmélioré<Character> expr = new ArbreBinaireAmélioré<Character>(
				'+',
				new ArbreBinaireAmélioré<Character>(
						'-',
						new ArbreBinaireAmélioré<Character>('5'),
						new ArbreBinaireAmélioré<Character>(
								'*',
								new ArbreBinaireAmélioré<Character>('2'),
								new ArbreBinaireAmélioré<Character>('6'))),
				new ArbreBinaireAmélioré<Character>(
						'*',
						new ArbreBinaireAmélioré<Character>(
								'+',
								new ArbreBinaireAmélioré<Character>('1'),
								new ArbreBinaireAmélioré<Character>(
										'/',
										new ArbreBinaireAmélioré<Character>('6'),
										new ArbreBinaireAmélioré<Character>('3'))),
						new ArbreBinaireAmélioré<Character>('4')));

		expr.parcoursProfondeurInfixe();
		System.out.println();
		
		System.out.println(expr.parcoursLargeur());
		
		for (Character c : expr) {
			System.out.print(c);
		}
	}

}
