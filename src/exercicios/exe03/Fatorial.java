package exercicios.exe03;

import exceptions.EntradaInvalidaException;


/**
 * Classe utilizada para calcular o fatorial de um numero inteiro
 * 
 * @param Inteiro entrada
 *
 */
public class Fatorial {

	private int nFatorialEntrada;
	private int nFatorialResultado = 1;

	public Fatorial(int nFatorialEntrada) throws EntradaInvalidaException {

		super();

		new ValidacaoEntradaFatorial(nFatorialEntrada);
		
		this.nFatorialEntrada = nFatorialEntrada;
		
		this.calcular();

	}

	/** Calculo do Fatorial **/
	private void calcular() {

		for (int i = 1; i <= this.nFatorialEntrada; i++) {
			nFatorialResultado *= i;
		}

	}
	
	/** Getters **/
	public int getnFatorialEntrada() {
		return nFatorialEntrada;
	}

	public int getnFatorialResultado() {
		return nFatorialResultado;
	}

	
	/**
	 * Retorna os valor inteiro de entrada e seu respectivo fatorial em unica String formatada
	 * 
	 * @return String formatacao personalizada
	 *  
	 */
	@Override
	public String toString() {
		return ("\nEntrada:   " + this.getnFatorialEntrada() + "\nResultado: " + this.getnFatorialResultado());
	}

}
