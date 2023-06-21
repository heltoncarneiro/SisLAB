package Entities;

public class Medico {
	private String nome;
	private String numCrm;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumCrm() {
		return numCrm;
	}
	public void setNumCrm(String numCrm) {
		this.numCrm = numCrm;
	}
	public Medico(String nome, String numCrm) {
		this.nome = nome;
		this.numCrm = numCrm;
	}
	public String imprimirMedico() {
		return "Medico: " + getNome() + ", Numero CRM: " + getNumCrm()+ ".\n";
	}
	
}
