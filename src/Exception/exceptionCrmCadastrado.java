package Exception;

public class exceptionCrmCadastrado extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public exceptionCrmCadastrado() {
		super("precione qualquer tecla para tentar adicionar o crm outra vez");
	}
}
