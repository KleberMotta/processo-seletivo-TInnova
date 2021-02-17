package exercicios;

import exceptions.EntradaInvalidaException;

import exercicios.exe01.PercentualEleitores;
import exercicios.exe02.BubbleSort;
import exercicios.exe03.Fatorial;
import exercicios.exe04.SomaMultiplosDe3E5;


/**
 * Class principal para a execucao dos testes dos exercicios de 1 a 4
 * 
 * Devido a simplicidade dos exercicios esse abordagem foi selecionada 
 * no lugar da utilizacao de testes unitarios com JUnit, 
 * afim de evitar complexidade desnecessaria
 *
 */
public class Main {
	
	public static void main(String[] args) {

		// Exercicio 01
		System.out.println("Exercício 01 - Votos em relação ao total de eleitores");

		try {
			
			PercentualEleitores percentual = new PercentualEleitores(1000, 800, 150, 50);

			System.out.println(percentual.toString());

		} catch (EntradaInvalidaException exception) {
			System.out.println(exception.getMessage());
		} 

		// Exercicio 02
		System.out.println("\nExercício 02 - Algoritmo de ordenação BubbleSort");

		try {

			int[] vetor = { 5, 3, 2, 4, 7, 1, 0, 6 };

			BubbleSort bubbleSort = new BubbleSort(vetor);

			System.out.println(bubbleSort.toString());

		} catch (EntradaInvalidaException exception) {
			System.out.println( exception.getMessage());
		}

		// Exercicio 03
		System.out.println("\nExercício 03 - Fatorial");

		try {

			int nFatorial = 5;

			Fatorial fatorial = new Fatorial(nFatorial);		

			System.out.println(fatorial.toString());

		} catch (EntradaInvalidaException exception) {
			System.out.println(exception.getMessage());
		}
		
		// Exercicio 04
		System.out.println("\nExercício 04 - Soma dos múltiplos de 3 ou 5");
		
		int entrada = 10;
		
		SomaMultiplosDe3E5 somatorioDe3E5 = new SomaMultiplosDe3E5(entrada);
		
		System.out.println(somatorioDe3E5.toString());

	}
}
