/*
 *  Trabalho 3 feito por Eduardo Coelho e Pedro Maia.
 */

package trab_03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		infixaParaPosfixa();
	}
	
	public static void infixaParaPosfixa() {
		Pilha<Character> p = new Pilha<>();
		
		String posfixa = "";
		String infixa = "";
		Character token;
		
		Scanner scan = new Scanner(System.in);
		
		infixa = scan.next();
		
		scan.close();
		
		for (Character c : infixa.toCharArray()) {
			if(Character.isDigit(c)) {
				posfixa += c; 
			}
			else {
				if(c.equals('(')) {
					p.push(c);
				} else {
					if(c.equals(')')) {
						token = p.pop();
						
						while(!token.equals('(')) {
							posfixa += token;
							token = p.pop();
							
							if(token == null) {
								throw new IllegalArgumentException("Parênteses desbalanceados.");
							}
							
						}
					
					}
					else {
						if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
							
							while (!p.estaVazia() && precedencia(p.peek()) >= precedencia(c)) {
								token = p.pop();
								posfixa += token;
							}
							p.push(c);
						}
						else if(c.equals('^')) {
								
								while (!p.estaVazia() && precedencia(p.peek()) > precedencia(c)) {
									token = p.pop();
									posfixa += token;
								}
								p.push(c);
							
						}
						else {
							throw new IllegalArgumentException("Erro. Caractere estranho digitado.");
						}
					}
				}
			}
		}
		
		while (!p.estaVazia()) {
			Character c = p.pop();
			posfixa += c;
		}
		
		System.out.println(posfixa);
	}
	
	
	public static int precedencia(char op) {
		switch(op) {
		case '^':
			return 4;
		case '*':
		case '/':
			return 3;
		case '+':
		case '-':
			return 2;
		case '(':
			return 1;
		default:
			return 0;
		}
	}

}
