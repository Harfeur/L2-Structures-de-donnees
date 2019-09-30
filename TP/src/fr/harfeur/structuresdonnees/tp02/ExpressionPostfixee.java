package fr.harfeur.structuresdonnees.tp02;

public class ExpressionPostfixee {
	
	private String expr;
	
	public ExpressionPostfixee(String expression) {
		super();
		this.expr = expression;
	}
	
	public int evaluer() throws ExceptionPileVide {
		PileContigue<Integer> pile = new PileContigue<Integer>();
		for (int i = 0; i < this.expr.length(); i++) {
			char caractere = this.expr.charAt(i);
			if (Character.isDigit(caractere))
				pile.empiler(Character.getNumericValue(caractere));
			else {
				int nb1 = pile.sommet();
				pile.depiler();
				int nb2 = pile.sommet();
				pile.depiler();
				
				switch (caractere) {
					case '+':
						pile.empiler(nb1 + nb2);
						break;
					
					case '-':
						pile.empiler(nb1 - nb2);
						break;
					
					case '*':
						pile.empiler(nb1 * nb2);
						break;
					
					case '/':
						pile.empiler(nb1/nb2);
				}
			}
		}
		return pile.sommet();
	}
	
	
	
	
	
	public static void main(String[] args) throws ExceptionPileVide {
		ExpressionPostfixee e1 = new ExpressionPostfixee("12+3+");
		ExpressionPostfixee e2 = new ExpressionPostfixee("12+3*");
		ExpressionPostfixee e3 = new ExpressionPostfixee("123*+");
		ExpressionPostfixee e4 = new ExpressionPostfixee("27+85-*");

		System.out.println(e1.evaluer());
		System.out.println(e2.evaluer());
		System.out.println(e3.evaluer());
		System.out.println(e4.evaluer());
	}
}
