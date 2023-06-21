package Entities;

public abstract class Bioquimica implements Exame {
	private double resultado;
	private String comentario = "";
	
	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Bioquimica(double resultado, String comentario) {
		super();
		this.resultado = resultado;
		if(comentario != null) {
			this.comentario = comentario;
		}
	}
	public Bioquimica() {
	}
	public abstract String nome();
	public abstract String valoresReferencia();
}
