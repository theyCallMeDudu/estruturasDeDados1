/*
 *  Trabalho 4 de Estrutura de Dados 1 feito por Eduardo Coelho e Pedro Maia.
 */

package trab_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		System.out.println("Insira o nome do arquivo:");

		String nome = "./src/trab_04/texto.txt";
		
		String nomeArquivo = leitor.next();
		
		if (nomeArquivo != null && !nomeArquivo.isEmpty()) {
			nome = nomeArquivo;
		}

		boolean crescente = true;

		System.out.println("Diga se quer uma lista crescente ou decrescente.");
		System.out.println("Digite 1 para crescente e 2 para decrescente:");

		if (leitor.nextInt() == 2) {
			crescente = false;
		} else {
			crescente = true;
		}
		leitor.close();

		StringBuffer montador = new StringBuffer();

		try {

			FileReader file = new FileReader(nome);

			BufferedReader lerArquivo = new BufferedReader(file);

			String linha = lerArquivo.readLine();

			while (linha != null) {
				montador.append(linha);
				linha = lerArquivo.readLine();
			}

			file.close();

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		String textoCompleto = montador.toString();

		StringTokenizer tokenizer = new StringTokenizer(textoCompleto);

		ABBPalavra abb = new ABBPalavra();

		while (tokenizer.hasMoreTokens()) {
			String conteudo = tokenizer.nextToken();

			Palavra palavra = new Palavra(conteudo);

			abb.inserir(palavra);
		}
		
		System.out.print("> Nº de palavras distintas: ");
		System.out.println(abb.quantidade());
		System.out.println();
		System.out.print("> Maior palavra presente no texto: ");
		System.out.println(abb.maior());
		System.out.println();
		System.out.println(abb);
		
	}

}
