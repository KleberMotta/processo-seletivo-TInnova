package exercicios.exe03;

import exceptions.EntradaInvalidaException;
import interfaces.ValidacaoEntrada;

public class ValidacaoEntradaFatorial implements ValidacaoEntrada {

	private int nFatorial;

	public ValidacaoEntradaFatorial(int nFatorial) throws EntradaInvalidaException {

		super();

		this.nFatorial = nFatorial;
		
		this.validarEntrada();
	}

	@Override
	public void validarEntrada() throws EntradaInvalidaException {
		if (nFatorial < 0) {
			throw new EntradaInvalidaException(
					"Não é possível calcular o fatorial de números inteiros negativos sem realizar interpolação por Função Gamma de Euler.");
		}
	}

}
