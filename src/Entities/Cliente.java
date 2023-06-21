package Entities;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private String nome;
	private Date dataNascimento;
	private String endereço;
	private String cpf;
	private ArrayList<Requisicao> historicoRequisicoes;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	public ArrayList<Requisicao> getHistoricoRequisicoes() {
		return historicoRequisicoes;
	}
	public void addHistoricoRequisicoes(Requisicao requisicao) {
		this.historicoRequisicoes.add(requisicao);
	}
	public void removerHistoricoRequisicoes(Requisicao requisicao) {
		for(int i = 0; i < historicoRequisicoes.size(); i++) {
			if(historicoRequisicoes.get(i).equals(requisicao)) {
				this.historicoRequisicoes.remove(i);
				System.out.println("Removido.");
				break;
			}
			if(i == historicoRequisicoes.size()-1) {
				System.out.println("Requisição não existe no histórico, não pode ser removida");
			}
		}
	}
	public Cliente(String nome, Date dataNascimento, String endereço, String cpf, ArrayList<Requisicao> históricoRequisições) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereço = endereço;
		this.cpf = cpf;
		this.historicoRequisicoes = new ArrayList<>();;
	}
	public String ImprimirCliente() {
		return "nome: "+ getNome()+"\nData de nascimento:" + getDataNascimento()+"\n CPF:" + getNome();
	}
	

}
