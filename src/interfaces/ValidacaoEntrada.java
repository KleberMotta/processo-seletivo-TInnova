package interfaces;

import exceptions.EntradaInvalidaException;

/**
 * Interface de Validacao dos valores de entrada, utilizada para facilitar a organizacao e
 * legibilidade do codigo, bem como a esalabilidade e especializacao de regras diferentes 
 *
 */
public interface ValidacaoEntrada {
	public void validarEntrada() throws EntradaInvalidaException;
}
