package fr.harfeur.structuresdonnees.tp05;

public class Expression {

	public static void main(String[] args) throws ExceptionArbreVide, ExceptionCharIncorrect {
		
		ArbreBinaire<Character> expr = new ArbreBinaire<Character>(
				'+',
				new ArbreBinaire<Character>(
						'-',
						new ArbreBinaire<Character>('5'),
						new ArbreBinaire<Character>(
								'*',
								new ArbreBinaire<Character>('2'),
								new ArbreBinaire<Character>('6'))),
				new ArbreBinaire<Character>(
						'*',
						new ArbreBinaire<Character>(
								'+',
								new ArbreBinaire<Character>('5'),
								new ArbreBinaire<Character>(
										'/',
										new ArbreBinaire<Character>('6'),
										new ArbreBinaire<Character>('2'))),
						new ArbreBinaire<Character>('3')));

		System.out.println("Taille : " + expr.taille());
		System.out.println("Hauteur : " + expr.hauteur());
		
		System.out.println("Résultat : " + traiter(expr));
	}
	
	private static int traiter(ArbreBinaire<Character> expr) throws ExceptionArbreVide, ExceptionCharIncorrect {
		if (expr.est_vide()) throw new ExceptionArbreVide();
		if (Character.isDigit(expr.racine())) return Character.getNumericValue(expr.racine());
		else {
			int int1 = traiter(expr.sag());
			int int2 = traiter(expr.sad());
			switch (expr.racine()) {
			case '+':
				return int1 + int2;

			case '-':
				return int1 - int2;
			
			case '*':
				return int1 * int2;
			
			case '/':
				return int1 / int2;
			
			default:
				throw new ExceptionCharIncorrect(expr.racine());
			}
		}
	}

}
