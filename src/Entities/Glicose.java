package Entities;

import java.util.Scanner;

public final class Glicose extends Bioquimica {

	public Glicose(double resultado, String comentario) {
		super(resultado, comentario);
	}

	public Glicose() {
		super();
	}

	@Override
	public String valoresReferencia() {
		return "Valor de referência: 70 mg/dl a 100 mg/dl.";
	}

	@Override
	public String exibirNome() {
		// TODO Auto-generated method stub
		return "Glicose de jejum";
	}

	@Override
	public String imprimirNome() {
		int val = 40 - (int) "Glicose de jejum".length() / 2;
		String espaco = "";
		for (int i = 0; i < val; i++) {
			espaco += " ";
		}
		return espaco + "Glicose de jejum";
	}

	@Override
	public void digitarExame(Scanner sc) {
		System.out.println("--------------------------------------------------------------------------------\n"
				+ exibirNome()+"\n");
		System.out.println("Qual o resultado da Glicose:");
		setResultado(sc.nextDouble());
		sc.nextLine();
		System.out.println("Algum comentário do resultado:");
		setComentario(sc.nextLine());
	}

	@Override
	public String ImprimirResultado() {
		return "--------------------------------------------------------------------------------\n" + imprimirNome()
				+ String.format("\n\nResultado: %.2f", getResultado()) + "mg/dl" + ".\n" + valoresReferencia()
				+ "\n\nObservação: " + getComentario()+"\n";
	}

}
