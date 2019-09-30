package fr.harfeur.structuresdonnees.tp02;

import java.util.Stack;

public class Expression {
	
	static char[] ouvrant = {'(', '[', '{'};	
	static char[] fermant = {')', ']', '}'};
	String expr;
	
	public Expression(String expression) {
		super();
		this.expr = expression;		
	}
	
	public boolean estCorrecte() {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < this.expr.length(); i++) {
			char caractere = this.expr.charAt(i);
			for (int j = 0; j < ouvrant.length; j++) {
				if (caractere == ouvrant[j]) stack.push(ouvrant[j]);
				else if (caractere == fermant[j]) {
					if (stack.empty() || stack.peek() != ouvrant[j]) return false;
					stack.pop();
				}
			}
		}
		return stack.empty();	
	}
	
	
	
	
	
	public static void main(String[] args) {
		Expression e1 = new Expression("e<-sommet(empiler(empiler(de´piler(empiler(pile_vide(),a)),b),c))");
		Expression e2 = new Expression("(define (smallest L A) (cond ( (null? L) A) ( (< (car L) A) (smallest (cdr L)(car L))) (else (smallest (cdr L) A )) ) )");
		Expression e3 = new Expression("print(L[len(L)//2-1],L[len(l)//2])");
		Expression e4 = new Expression("$(’form div’).filter(’span .actif’).each(function() { $(this).bind(’click’, function() { $(this).prop(’disabled’, true); }); });");

		System.out.println(e1.estCorrecte());
		System.out.println(e2.estCorrecte());
		System.out.println(e3.estCorrecte());
		System.out.println(e4.estCorrecte());
	}
}
