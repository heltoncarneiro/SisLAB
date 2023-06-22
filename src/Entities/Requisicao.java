package Entities;

import java.util.ArrayList;

public class Requisicao {
	private static int idSequence = 1;
	private Cliente cliente;
	private Medico medico;
	private ArrayList<Exame> Exames;
	private int id;
	
	public int getId() {
		return id;
	}
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
		this.id = idSequence++;
	} 
	public String imprimirRequisicao() {
		String imprimirTodosExames = "\n";
		if(Exames != null) {
			for(Exame i : Exames) {
				imprimirTodosExames += i.ImprimirResultado();
			}
		}
		return getCliente().ImprimirCliente()+"\n"+getMedico().imprimirMedico()+imprimirTodosExames;
	}
	public String exibirRequisicao() {
		String exibirTodosExames = "";
		if(Exames != null) {
			for(int i = 0; i<Exames.size();i++) {
				exibirTodosExames += Exames.get(i).exibirNome();
			}
		}
		return "ID: "+getId()+",Nome: "+getCliente().getNome()+", Exames:"+ exibirTodosExames;
	}
}
