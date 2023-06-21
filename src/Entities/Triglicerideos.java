package Entities;

public class Triglicerideos extends Bioquimica {

	public Triglicerideos(double resultado, String comentario) {
		super(resultado, comentario);
		// TODO Auto-generated constructor stub
	}
	public Triglicerideos() {
		super();
	}
	@Override
	public String valoresReferencia(){
		return "Valor de referência:abaixo de 150 mg/dl\n Sendo limítrofe entre 150 e 200 mg/dl e\n Risco acima de 200 mg/dl";
	}

	@Override
	public String nome() {
		int val = 40 - (int)"Triglicerídeos".length()/2;
		String espaço = "";
		for (int i = 0; i< val; i++) {
			espaço += " ";
		}
		return espaço + "Triglicerídeos";
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
