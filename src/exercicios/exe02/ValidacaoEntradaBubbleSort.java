package exercicios.exe02;

import exceptions.EntradaInvalidaException;
import interfaces.ValidacaoEntrada;


/**
 * Vaidacao especializada nos valores de entrada da Classe BubbleSort
 *
 * @param ArrayDeInteiros
 * 
 */
public class ValidacaoEntradaBubbleSort implements ValidacaoEntrada {
	
	private int[] arrayEntrada;
	
	public ValidacaoEntradaBubbleSort(int[] arrayEntrada) throws EntradaInvalidaException {
		super();
		
		this.arrayEntrada = arrayEntrada;
		this.validarEntrada();
	}

	@Override
	public void validarEntrada() throws EntradaInvalidaException {
		if (arrayEntrada == null || arrayEntrada.length == 0) {
			throw new EntradaInvalidaException("O vetor de entrada informado é nulo ou vazio");
		}
	}
}
