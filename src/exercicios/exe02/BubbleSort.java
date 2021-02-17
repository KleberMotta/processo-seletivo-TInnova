package exercicios.exe02;

import java.util.Arrays;

import exceptions.EntradaInvalidaException;


/**
 * Classe utilizada para ordenacao de arrays utilizando o algoritmo BubbleSort, O(n^2)
 * @param ArrayDeInteiros 
 */
public class BubbleSort {

	private int[] arrayEntrada;
	private int[] arrayOrdenado;

	public BubbleSort(int[] arrayEntrada) throws EntradaInvalidaException {

		super();

		new ValidacaoEntradaBubbleSort(arrayEntrada);

		this.arrayEntrada = arrayEntrada;
		this.arrayOrdenado = arrayEntrada.clone();
		
		this.sort();

	}

	/** Algoritmo de ordenacao **/
	private void sort() {

		boolean swapped;

		int tamanho = arrayOrdenado.length;

		for (int i = 0; i < tamanho - 1; i++) {

			swapped = false;

			for (int j = 0; j < tamanho - i - 1; j++) {
				// verifica os elementos adjacentes
				if (arrayOrdenado[j] > arrayOrdenado[j + 1]) {
					// realiza a troca, swap, dos elementos
					int temp = arrayOrdenado[j];
					arrayOrdenado[j] = arrayOrdenado[j + 1];
					arrayOrdenado[j + 1] = temp;
					swapped = true;
				}
			}

			// se nao ouve troca o array ja esta ordenado
			if (swapped == false) {
				break;
			}

		}

	}

	/** Getters **/
	public int[] getArrayEntrada() {
		return arrayEntrada;
	}

	public int[] getArrayOrdenado() {
		return arrayOrdenado;
	}
	
	/**
	 * Retorna os valores do array de entrada e do array ordenado em uma unica String formatada
	 * 
	 * @return String formatacao personalizada
	 *  
	 */
	@Override
	public String toString() {
		return ("\nVetor de entrada: " + Arrays.toString(getArrayEntrada())) +
				"\nVetor ordenado:   " + Arrays.toString(getArrayOrdenado());
	}
}