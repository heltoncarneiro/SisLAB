package Entities;

public final class ColesterolTotal extends Bioquimica {
	
	public ColesterolTotal(double resultado, String comentario) {
		super(resultado, comentario);
		// TODO Auto-generated constructor stub
	}
	public ColesterolTotal() {
		super();
	}
	@Override
	public String valoresReferencia(){
		return "Valor de referência:\npara adultos maiores de 20 anos: menor que 190 mg/dl\nValor de referência para crianças e adolescentes: menor que 170 mg/dl";
	}

	@Override
	public String imprimirNome() {
		int val = 40 - (int)"Colesterol Total".length()/2;
		String espaco = "";
		for (int i = 0; i< val; i++) {
			espaco += " ";
		}
		return espaco + "Colesterol Total";
	}
	@Override
	public String exibirNome() {
		// TODO Auto-generated method stub
		return "Colesterol Total";
	}
	@Override
	public String ImprimirResultado() {
		return "--------------------------------------------------------------------------------\n"
				+ imprimirNome()
				+ String.format("\n\nResultado: %.2f", getResultado()) + "mg/dl"
				+ ".\n"+valoresReferencia()
				+"\n\nObservação: "+ getComentario()+"\n";
	}
	
}
