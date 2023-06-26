package Entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.exceptionForaDasOpcoes;
import Exception.exceptionNaoEncontrado;

public class Cliente {
	private String nome;
	private Date dataNascimento;
	private String endereco;
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
	public String getendereco() {
		return endereco;
	}
	public void setendereco(String endereco) {
		this.endereco = endereco;
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
	public Cliente(String nome, Date dataNascimento, String endereco, String cpf) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	public String ImprimirCliente() {
		if(dataNascimento != null) {
		return "Nome: "+ getNome()+"\nData de nascimento: " + createFormat().format(getDataNascimento())+"\nIdade: " + idade()+" Anos, CPF: " + getCpf();
		}
		return	"Nome: "+ getNome()+"\nCPF: " + getCpf();
	}

	public static Cliente cadastrarCliente(Scanner sc , SimpleDateFormat sdf) {
		try {
			System.out.println("Qual o nome do cliente:");
			String nome = sc.nextLine();
			System.out.println("Qual a data de nascimento:(dd/mm/yyyy)");
			Date dataDeNascimento = sdf.parse(sc.next());
			sc.nextLine();
			System.out.println("Qual o endereço:");
			String endereco = sc.nextLine();
			System.out.println("Qual o CPF do cliente:");
			String cpf = sc.next();
			sc.nextLine();
			return new Cliente(nome, dataDeNascimento, endereco, cpf);
		}
		catch (ParseException e) {
			System.out.println("Formato de data irregular\n\nPressione Qualquer tecla para cadastrar um cliente outra vez\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return cadastrarCliente(sc, sdf);
			}
		}catch (Exception e) {
			System.out.println("ERRO");
			return null;
		}
		return null;
	}
	public static Cliente procurarCliente(Scanner sc, ArrayList<Cliente> clientes, SimpleDateFormat sdf, String procurarNome) {
		ArrayList<Cliente> clientes2 = new ArrayList<>();
		int count = 0;
		try {
			if(procurarNome == null) {
				System.out.println("Procurar por nome\nQual o nome:");
				procurarNome = sc.next();
				sc.nextLine();
			}
			for(int i=0;i<clientes.size();i++) {
				if(clientes.get(i).getNome().toLowerCase().contains(procurarNome.toLowerCase()) == true){
					count++;
					System.out.println(count+"- "+clientes.get(i).getNome());
					clientes2.add(clientes.get(i));
				}
				count++;
			}
			if(count >1 ) {
				System.out.println((count)+"- Sair");
				System.out.println("Qual opção deseja:");
				int index = sc.nextInt();
				sc.nextLine();
				if(index > count || index < 0) {
					throw new exceptionForaDasOpcoes();
				}else if(index == count+1) {
					return null;
				}
				return clientes2.get(index-1);
			}else {
				throw new exceptionNaoEncontrado();
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Erro de entrada\nDigite qualquer botão para tentar procurar nome mais uma vez");
			sc.nextLine();
			return procurarCliente(sc, clientes2, sdf, procurarNome);
					
		}catch (exceptionForaDasOpcoes e) {
			System.out.println(e.getLocalizedMessage()+" ou digite \"s\" para voltar");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return procurarCliente(sc, clientes2, sdf, procurarNome);
			}
		}catch (exceptionNaoEncontrado e) {
			System.out.println("O cliente "+ e.getMessage());
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return procurarCliente(sc, clientes2, sdf, procurarNome);
			}
		}catch (Exception e) {
			System.out.println("ERRO");
			return null;
		}
		return null;
	}	
}
