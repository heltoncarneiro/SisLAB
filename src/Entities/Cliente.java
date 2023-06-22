package Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
	public int idade() {
		LocalDate DataAtual = LocalDate.now();
		if(dataNascimento != null) {
			Period periodo = Period.between(getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), DataAtual);
			return periodo.getYears();
		}else {
			return 0;
		}
	}
	private static final DateFormat createFormat() {
	    return new SimpleDateFormat("dd/MM/yyyy");
	}
	public Cliente(String nome, Date dataNascimento, String endereço, String cpf) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereço = endereço;
		this.cpf = cpf;
	}
	public String ImprimirCliente() {
		if(dataNascimento != null) {
		return "Nome: "+ getNome()+"\nData de nascimento: " + createFormat().format(getDataNascimento())+"\nIdade: " + idade()+" Anos, CPF: " + getCpf();
		}
		return	"Nome: "+ getNome()+"\nCPF: " + getCpf();
	}

}
