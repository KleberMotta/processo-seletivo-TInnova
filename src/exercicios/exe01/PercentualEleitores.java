package exercicios.exe01;

import exceptions.EntradaInvalidaException;

/**
 * Classe utilizada para calcular o percentual de votos eleitorais
 * 
 * @param Double Total de eleitores
 * @param Double Votos validos
 * @param Double Votos em branco
 * @param Double Votos nulos
 *
 */
public class PercentualEleitores {

	// Quantidades de votos
	private double totalEleitores = 0;
	private double votosValidos = 0;
	private double votosEmBranco = 0;
	private double votosNulos = 0;
	
	// Percentuais de votos
	private double percentualVotosValidos;
	private double percentualVotosEmBranco;
	private double percentualVotosNulos;
	
	
	public PercentualEleitores(long totalEleitores, long votosValidos, long votosBrancos, long votosNulos) throws EntradaInvalidaException {
		
		super();
		
		new ValidacaoEntradaPercentualEleitores(totalEleitores,votosValidos,votosBrancos,votosNulos);
		
		this.totalEleitores = totalEleitores;
		this.votosValidos = votosValidos;
		this.votosEmBranco = votosBrancos;
		this.votosNulos = votosNulos;
		
		this.percentualVotosValidos();
		this.percentualVotosEmBranco();
		this.percentualVotosNulos();
		
	}

	/** Calculo do porcentual de votos **/
	private void percentualVotosValidos() {
		this.percentualVotosValidos = this.votosValidos / this.totalEleitores;
	}

	private void percentualVotosEmBranco() {
		this.percentualVotosEmBranco = this.votosEmBranco / this.totalEleitores;
	}

	private void percentualVotosNulos() {
		this.percentualVotosNulos = this.votosNulos / this.totalEleitores;
	}

	/** Getters **/
	public double getPercentualVotosValidos() {
		return percentualVotosValidos;
	}

	public double getPercentualVotosEmBranco() {
		return percentualVotosEmBranco;
	}

	public double getPercentualVotosNulos() {
		return percentualVotosNulos;
	}
	
	public double getTotalEleitores() {
		return totalEleitores;
	}
	
	public double getVotosValidos() {
		return votosValidos;
	}

	public double getVotosEmBranco() {
		return votosEmBranco;
	}

	public double getVotosNulos() {
		return votosNulos;
	}
	
	/**
	 * Retorna os valores dos percentuais de voto formatados em uma unica string
	 * 
	 * @return String formatacao personalizada
	 *  
	 */
	@Override
	public String toString() {
		return ("\nOs percentuais de voto são: " +
				"\nVotos Válidos: " + this.getPercentualVotosValidos() +
				"\nVotos em Branco: " + this.getPercentualVotosEmBranco() +
				"\nVotos Nulos: " + this.getPercentualVotosNulos());
	}
}
