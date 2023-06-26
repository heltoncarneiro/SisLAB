package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Exception.exceptionForaDasOpcoes;
import Exception.exceptionVoltarMenu;
import Model.View.Menu;

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
	public void digitarListaExames(Scanner sc){
		for(Exame i : Exames) {
			i.digitarExame(sc);
		}
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
				if(i>0) {
					exibirTodosExames += ", ";
				}
				exibirTodosExames += Exames.get(i).exibirNome();
			}
		}
		return "ID: "+getId()+",Nome: "+getCliente().getNome()+", Exames:"+ exibirTodosExames;
	}
	
	public static Requisicao cadastraRequisicao(Scanner sc, SimpleDateFormat sdf,ArrayList<Requisicao> requisicoes,ArrayList<Medico> medicos,ArrayList<Cliente> clientes) {
		int resposta1;int resposta2;
		ArrayList<Exame> exames = new ArrayList<>();
		try {
			System.out.println("1-Deseja cadastrar um novo cliente\n2-Cadastrar com cliente ja cadastrado\nQual opção:");
			resposta1 = sc.nextInt();
			Cliente cliente = null; Medico medico = null;
			sc.nextLine();
			if(resposta1 == 1) {
				cliente = Cliente.cadastrarCliente(sc, sdf);
				clientes.add(cliente);
			}else if(resposta1 == 2){
				cliente = Cliente.procurarCliente(sc, clientes, sdf, null);
			}else {
				throw new exceptionForaDasOpcoes();
			}
			if(cliente == null) {
				throw new exceptionVoltarMenu();
			}
			System.out.println("1-Deseja cadastrar um novo médico\n2-Cadastrar com medico ja cadastrado\nQual opção:");
			resposta2 = sc.nextInt();
			sc.nextLine();
			if(resposta2 == 1) {
				medico = Medico.cadastrarMedico(sc, medicos, null, null);
				medicos.add(medico);
			}else if(resposta2 == 2){
				medico = Medico.procurarMedico(sc, medicos, null);
			}else {
				throw new exceptionForaDasOpcoes();
			}
			if(cliente == null || medico == null) {
				throw new exceptionVoltarMenu();
			}
			exames = cadastraslistaExames(sc);
			if(cliente != null && medico != null && exames != null ) {
				Requisicao requisicao = new Requisicao(cliente, medico, exames);
				cliente.addHistoricoRequisicoes(requisicao);
				return requisicao;
			}else {
				throw new exceptionVoltarMenu();
			}
		}catch (exceptionVoltarMenu e) {
			return null;
		}catch (exceptionForaDasOpcoes e) {
			System.out.println("Entrada fora das opções!\nTente cadastrar a requisição outra vez");
			return cadastraRequisicao(sc, sdf, requisicoes, medicos, clientes);
		}catch (Exception e) {
			System.out.println("ERRO");
			return null;
		}
	}
	public static ArrayList<Exame> cadastraslistaExames(Scanner sc) {
		ArrayList<Exame> exames = new ArrayList<>();
		try {
			boolean[] jaCadastrou = {false,false,false,false,false};
			int escolhaExames = 0;
			while(escolhaExames != 6) {
				System.out.println("Quais exames deseja cadastrar:");
				escolhaExames = Menu.menuCadastrarListaExames(sc, jaCadastrou);
				switch (escolhaExames) {
				case 1:
					if(jaCadastrou[0] == false) {
						exames.add(new Glicose());
						jaCadastrou[0] = true;
					}else {
						System.out.println("Glicose já foi cadastrada.\n");
					}
					break;
				case 2:
					if(jaCadastrou[1] == false) {
						exames.add(new ColesterolTotal());
						jaCadastrou[1] = true;
					}else {
						System.out.println("Colesterol total já foi cadastrada.\n");
					}
					break;
				case 3:
					if(jaCadastrou[2] == false) {
						exames.add(new Triglicerideos());
						jaCadastrou[2] = true;
					}else {
						System.out.println("Triglicerídeos já foi cadastrada.\n");
					}
					break;
				case 4:
					if(jaCadastrou[3] == false) {
						exames.add(new SumarioDeUrina());
						jaCadastrou[3] = true;
					}else {
						System.out.println("Sumario de Urina já foi cadastrada.\n");
					}
					break;
				case 5:
					if(jaCadastrou[4] == false) {
						exames.add(new Hemograma());
						jaCadastrou[4] = true;
					}else {
						System.out.println("Hemograma já foi cadastrada.\n");
					}
					break;
				case 6:
					return exames;
				}
				cadastrados(jaCadastrou);
			}
		}
		catch (Exception e) {
			System.out.println("Erro\n\nPressione Qualquer tecla para cadastrar os exames novamente\nCaso deseje voltar para o menu digite \"S\"");
			sc.nextLine();
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return cadastraslistaExames(sc);
			}
		}
		return exames;
	}
	public static void cadastrados(boolean[] jaCadastrou){
		String imprimir = "[";
		if(jaCadastrou[0] == true) {
			if( imprimir.length()>1) {
				imprimir+=", ";
			}
			imprimir += "Glicose";
		}
		if(jaCadastrou[1] == true) {
			if( imprimir.length()>1) {
				imprimir+=", ";
			}
			imprimir += "ColesterolTotal";
		}
		if(jaCadastrou[2] == true) {
			if( imprimir.length()>1) {
				imprimir+=", ";
			}
			imprimir += "Trigicerídes";
		}
		if(jaCadastrou[3] == true) {
			if( imprimir.length()>1) {
				imprimir+=", ";
			}
			imprimir += "Sumario de urina";
		}
		if(jaCadastrou[4] == true) {
			if( imprimir.length()>1) {
				imprimir+=", ";
			}
			imprimir += "Hemograma";
		}
		System.out.println("Exames cadastrados: "+imprimir+"]");
	}
	public static void ExibirTodasRequisicaos(ArrayList<Requisicao> requisicaos) {
		if(requisicaos != null) {
			for(Requisicao i : requisicaos) {
				System.out.println(i.exibirRequisicao());
			}
		}else {
			System.out.println("Não existe requisições cadastradas");
		}
	}
}
