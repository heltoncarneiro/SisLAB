package Exception;

public class exceptionNaoEncontrado extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public exceptionNaoEncontrado() {
		super("não foi encontrado!!\nTente outra vez, digite qualquer tecla para tentar mais uma vez ou digite \"s\" para voltar para o menu");
	}
}
