package exercicios.exe04;

/**
 * Classe utilizada para descobrir a soma de todos os valores multiplos de 3 e 5
 * no intervalo de 0 à N
 * 
 * @param Inteiro N
 *
 */
public class SomaMultiplosDe3E5 {

	private int entrada;
	private int resultadoSomatorio;

	public SomaMultiplosDe3E5(int entrada) {
		super();
		this.entrada = entrada;
		this.calcular();
	}

	/** Calcular soma dos multiplos de 3 e 5 **/
	private void calcular() {

		int soma = 0;

		for (int i = 3; i < this.entrada; i++) {

			if (i % 3 == 0 || i % 5 == 0) {
				soma += i;
			}

		}

		this.resultadoSomatorio = soma;

	}

	/** Getters **/
	public int getEntrada() {
		return entrada;
	}

	public int getResultadoSomatorio() {
		return resultadoSomatorio;
	}

	/** Mensagem **/
	@Override
	public String toString() {
		return ("\nEntrada:   " + this.getEntrada() + "\nResultado: " + this.getResultadoSomatorio());
	}

}
