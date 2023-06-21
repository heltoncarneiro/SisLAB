package Entities;

public class Glicose extends Bioquimica {

	public Glicose(double resultado, String comentario) {
		super(resultado,comentario);
	}
	public Glicose() {
		super();
	}
	@Override
	public String valoresReferencia(){
		return "Valor de referência: 70 mg/dl a 100 mg/dl.";
	}

	@Override
	public String nome() {
		int val = 40 - (int)"Glicose de jejum".length()/2;
		String espaço = "";
		for (int i = 0; i< val; i++) {
			espaço += " ";
		}
		return espaço + "Glicose de jejum";
	}

	@Override
	public String ImprimirResultado() {
		return "--------------------------------------------------------------------------------\n"
				+ nome()
				+ String.format("\n\nResultado: %.2f", getResultado()) + "mg/dl"
				+ ".\n"+valoresReferencia()
				+"\n\nObservação: "+ getComentario()+"\n";
	}

	
}
