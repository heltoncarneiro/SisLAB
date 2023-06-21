package Entities;

import java.util.ArrayList;

public class Requisicao {
	private Cliente cliente;
	private Medico medico;
	private ArrayList<Exame> Exames;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public ArrayList<Exame> getExames() {
		return Exames;
	}
	public void setExames(ArrayList<Exame> exames) {
		Exames = exames;
	}
	public Requisicao(Cliente cliente, Medico medico, ArrayList<Exame> exames) {
		this.cliente = cliente;
		this.medico = medico;
		Exames = exames;
	}
	public String imprimirRequisicao() {
		String ImprimirTodosExames = "\n";
		if(Exames != null) {
			for(Exame i : Exames) {
				ImprimirTodosExames += i.ImprimirResultado();
			}
		}
		return getCliente().ImprimirCliente()+"\n"+getMedico().imprimirMedico()+ImprimirTodosExames;
	}
}
