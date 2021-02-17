package exceptions;


/**
 *
 * Classe de excecoes para problemas de entrada
 * 
 * @param string personalizavel para explicar com maiores detalhes os erros de entrada
 * 
 * @return Mensagem descritiva do erro de entrada
 * 
 */
public class EntradaInvalidaException extends Exception {
	
	private static final long serialVersionUID = -163849035242728374L;

	
	public EntradaInvalidaException (String mensagem) {
		
		super("\nDesculpe, algo deu errado com os valores de entrada: " + mensagem);
		
	}
}