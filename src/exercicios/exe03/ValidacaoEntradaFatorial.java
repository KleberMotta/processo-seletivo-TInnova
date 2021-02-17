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
					"N�o � poss�vel calcular o fatorial de n�meros inteiros negativos sem realizar interpola��o por Fun��o Gamma de Euler.");
		}
	}

}
