package Entities;

import java.util.Scanner;

public final class Triglicerideos extends Bioquimica {

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
	public String imprimirNome() {
		int val = 40 - (int)"Triglicerídeos".length()/2;
		String espaco = "";
		for (int i = 0; i< val; i++) {
			espaco += " ";
		}
		return espaco + "Triglicerídeos";
	}
	@Override
	public void digitarExame(Scanner sc) {
		System.out.println("Qual o resultado da Triglicerídeos:");
		setResultado(sc.nextDouble());
		sc.nextLine();
		System.out.println("Algum comentário do resultado:");
		setComentario(sc.nextLine());
	}
	@Override
	public String exibirNome() {
		// TODO Auto-generated method stub
		return "Triglicerídeos";
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
