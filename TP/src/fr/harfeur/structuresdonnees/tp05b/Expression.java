package fr.harfeur.structuresdonnees.tp05b;

import fr.harfeur.structuresdonnees.tp03.ExceptionFileVide;
import fr.harfeur.structuresdonnees.tp05a.ExceptionArbreVide;
import fr.harfeur.structuresdonnees.tp05a.ExceptionCharIncorrect;

public class Expression {

	public static void main(String[] args) throws ExceptionArbreVide, ExceptionCharIncorrect, ExceptionFileVide {
		
		ArbreBinaireAm�lior�<Character> expr = new ArbreBinaireAm�lior�<Character>(
				'+',
				new ArbreBinaireAm�lior�<Character>(
						'-',
						new ArbreBinaireAm�lior�<Character>('5'),
						new ArbreBinaireAm�lior�<Character>(
								'*',
								new ArbreBinaireAm�lior�<Character>('2'),
								new ArbreBinaireAm�lior�<Character>('6'))),
				new ArbreBinaireAm�lior�<Character>(
						'*',
						new ArbreBinaireAm�lior�<Character>(
								'+',
								new ArbreBinaireAm�lior�<Character>('1'),
								new ArbreBinaireAm�lior�<Character>(
										'/',
										new ArbreBinaireAm�lior�<Character>('6'),
										new ArbreBinaireAm�lior�<Character>('3'))),
						new ArbreBinaireAm�lior�<Character>('4')));

		expr.parcoursProfondeurInfixe();
		System.out.println();
		
		System.out.println(expr.parcoursLargeur());
		
		for (Character c : expr) {
			System.out.print(c);
		}
	}

}
