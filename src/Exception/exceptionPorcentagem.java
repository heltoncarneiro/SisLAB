package Exception;

public class exceptionPorcentagem extends RuntimeException{
	public double porcentagem;
	private static final long serialVersionUID = 3756057209498279098L;
	public exceptionPorcentagem(Double porcentagem){
		super();
		this.porcentagem = porcentagem;
	}
}
