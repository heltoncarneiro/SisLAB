package Exception;

public class exceptionForaDasOpcoes extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public exceptionForaDasOpcoes() {
		super("Entrada fora das opções!\nTente outra vez, digite qualquer tecla para tentar mais uma vez");
	}
}
