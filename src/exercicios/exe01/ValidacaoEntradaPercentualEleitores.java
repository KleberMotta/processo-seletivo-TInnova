package exercicios.exe01;

import exceptions.EntradaInvalidaException;
import interfaces.ValidacaoEntrada;

// Como nao temos uma interface nao eh necessario tratar IllegalArgumentException 


/**
 * Vaidacao especializada nos valores de entrada da Classe PercentualEleitoral 
 *
 * @param Double Total de eleitores
 * @param Double Votos validos
 * @param Double Votos em branco
 * @param Double Votos nulos
 *
 */
public class ValidacaoEntradaPercentualEleitores implements ValidacaoEntrada {

	// Valores de entrada
	private double totalEleitores = 0;
	private double votosValidos = 0;
	private double votosEmBranco = 0;
	private double votosNulos = 0;

	public ValidacaoEntradaPercentualEleitores(long totalEleitores, long votosValidos, long votosBrancos, long votosNulos) throws EntradaInvalidaException {

		super();

		this.totalEleitores = totalEleitores;
		this.votosValidos = votosValidos;
		this.votosEmBranco = votosBrancos;
		this.votosNulos = votosNulos;
		
		this.validarEntrada();
	}

	@Override
	public void validarEntrada() throws EntradaInvalidaException {

		// Validar total de votos
		if (totalEleitores <= 0) {
			throw new EntradaInvalidaException(
					"O Total de Eleitores informado, " + totalEleitores + ", n�o pode ser menor ou igual a zero.");
		}

		// Validar votos validos
		if (votosValidos < 0) {
			throw new EntradaInvalidaException(
					"A quantidade de Votos V�lidos informada, " + votosValidos + ", n�o pode ser menor que zero.");

		} else if (votosValidos > totalEleitores) {
			throw new EntradaInvalidaException(
					"A quantidade de Votos V�lidos informada, " + votosValidos + ", n�o pode ser maior que o total de eleitores.");
		}

		// Validar votos em branco
		if (votosEmBranco < 0) {
			throw new EntradaInvalidaException(
					"A quantidade de Votos em Branco informada, " + votosEmBranco + ", n�o pode menor que zero.");

		} else if (votosEmBranco > totalEleitores) {

			throw new EntradaInvalidaException(
					"A quantidade de Votos em Branco informada, " + votosValidos + ", n�o pode ser maior que o total de eleitores.");

		}

		// Validar votos nulos
		if (votosNulos < 0) {
			throw new EntradaInvalidaException(
					"A quantidade de Votos V�lidos informada, " + votosValidos + ", � inv�lida.");

		} else if (votosNulos > totalEleitores) {

			throw new EntradaInvalidaException(
					"A quantidade de Votos Nulos informada, " + votosNulos + ", n�o pode ser maior que o total de eleitores.");

		}

		// Validar a somatoria total dos votos
		if (votosValidos + votosEmBranco + votosNulos < totalEleitores) {
			throw new EntradaInvalidaException(
					"A soma dos valores Votos V�lidos, Votos em Branco e Votos Nulos � MENOR que a quantidade Total de Eleitores");
		} else if (votosValidos + votosEmBranco + votosNulos > totalEleitores) {
			throw new EntradaInvalidaException(
					"A soma dos valores Votos V�lidos, Votos em Branco e Votos Nulos � MAIOR que a quantidade Total de Eleitores");
		}

	}

}
