package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


import Entities.Cliente;
import Entities.ColesterolTotal;
import Entities.Exame;
import Entities.Glicose;
import Entities.Hemograma;
import Entities.Medico;
import Entities.Requisicao;
import Entities.SumarioDeUrina;
import Entities.Triglicerideos;
import Exception.exceptionCrmCadastrado;
import Exception.exceptionForaDasOpcoes;
import Exception.exceptionNaoEncontrado;
import Exception.exceptionVoltarMenu;

public class program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Medico> medicos = new ArrayList<>();
		ArrayList<Requisicao> requisicaos = new ArrayList<>();
		int numOpcao;
		try {
			while(true) {
				numOpcao = menu(sc);
				switch (numOpcao) {
				case 1:
					Cliente cliente = cadastrarCliente(sc, sdf);
					if(cliente != null) {
						clientes.add(cliente);
					}
					break;
				case 2:
					Medico medico = cadastrarMedico(sc, medicos, null, null);
					if(medico != null) {
						medicos.add(medico);
					}
					break;
				case 3:
					Requisicao requisicao = cadastraRequisicao(sc, sdf, requisicaos, medicos, clientes);
					if(requisicao != null) {
						requisicaos.add(requisicao);
					}
					break;
				}
			}
			
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		sc.close();
	}
	public static int menu(Scanner sc) {
		System.out.println("\n\n1- Cadastrar cliente"
				+ "\n2- Cadastrar medico"
				+ "\n3- Cadastrar requisição"
				+ "\n4- Digitar exames"
				+ "\n5- Imprimir requisição"
				+ "\n6- Exibir requisições cadastradas"
				+ "\nEscolha uma opção:");
		int valreturn = sc.nextInt();
		sc.nextLine();
		return valreturn;
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
				cliente = (cadastrarCliente(sc, sdf));
				clientes.add(cliente);
			}else if(resposta1 == 2){
				cliente = procurarCliente(sc, clientes,sdf, null);
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
				medico = cadastrarMedico(sc, medicos, null, null);
				medicos.add(medico);
			}else if(resposta2 == 2){
				medico = procurarMedico(sc, medicos, null);
			}else {
				throw new exceptionForaDasOpcoes();
			}
			if(cliente == null || medico == null) {
				throw new exceptionVoltarMenu();
			}
			exames = cadastraslistaExames(sc);
			if(cliente != null && medico != null && exames != null ) {
				return new Requisicao(cliente, medico, exames);
			}
			System.out.println(requisicoes);
			
		}catch (exceptionVoltarMenu e) {
			return null;
		}catch (exceptionForaDasOpcoes e) {
			System.out.println("Entrada fora das opções!\nTente cadastrar a requisição outra vez");
			return cadastraRequisicao(sc, sdf, requisicoes, medicos, clientes);
		}catch (Exception e) {
			System.out.println("ERRO");
			return null;
		}
		return null;
	}
	
	public static Cliente cadastrarCliente(Scanner sc , SimpleDateFormat sdf) {
		try {
			System.out.println("Qual o nome do cliente:");
			String nome = sc.nextLine();
			System.out.println("Qual a data de nascimento:(dd/mm/yyy)");
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
				System.out.println((count+1)+"- Sair");
			}
			if(count >1 ) {
				System.out.println("Qual opção deseja:");
				int index = sc.nextInt();
				sc.nextLine();
				if(index > count || index < 0) {
					throw new exceptionForaDasOpcoes();
				}else if(index == count+1) {
					return null;
				}
				return clientes2.get(index);
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
	public static Medico cadastrarMedico(Scanner sc,ArrayList<Medico> medicos,String nome,String crm) {
		try {
			if(nome == null) {
				System.out.println("Qual o nome do medico:");
				nome = sc.nextLine();
			}
			System.out.println("Qual o numero de CRM:");
			crm = sc.nextLine();
			for(Medico i : medicos) {
				if(i.getNumCrm().equals(crm)) {
					System.out.println("CRM já cadastrado no médico:\n"+i.imprimirMedico());
					throw new exceptionCrmCadastrado();
				}
			}
			return new Medico(nome, crm);
		}catch (exceptionCrmCadastrado e) {
			System.out.print(e.getMessage());
			sc.nextLine();
			return cadastrarMedico(sc, medicos, nome, null);
		}
		catch (Exception e) {
			System.out.println("Erro\n\nPressione Qualquer tecla para cadastrar um medico outra vez\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return cadastrarMedico(sc, medicos, null, null);
			}
			return null;
		}

	}
	public static Medico procurarMedico(Scanner sc, ArrayList<Medico> medicos, String procurarNome) {
		ArrayList<Medico> medicos2 = new ArrayList<>();
		int count = 0;
		try {
			if(procurarNome == null) {
				System.out.println("Procurar por nome\nQual o nome:");
				procurarNome = sc.next();
				sc.nextLine();
			}
			for(int i=0;i<medicos.size();i++) {
				if(medicos.get(i).getNome().toLowerCase().contains(procurarNome.toLowerCase()) == true){
					count++;
					System.out.println(count+"- "+medicos.get(i).getNome());
					medicos2.add(medicos.get(i));
				}
				System.out.println((count+1)+"- Sair");
			}
			if(count >1 ) {
				System.out.println("Qual opção deseja:");
				int index = sc.nextInt();
				sc.nextLine();
				if(index > count || index < 0) {
					throw new exceptionForaDasOpcoes();
				}else if(index == count+1) {
					return null;
				}
				return medicos2.get(index);
			}else {
				throw new exceptionNaoEncontrado();
			}
			
		}catch (InputMismatchException e) {
			System.out.println("Erro de entrada\nDigite qualquer botão para tentar procurar nome mais uma vez");
			sc.nextLine();
			return procurarMedico(sc, medicos, procurarNome);
					
		}catch (exceptionForaDasOpcoes e) {
			System.out.println(e.getLocalizedMessage()+" ou digite \"s\" para voltar");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return procurarMedico(sc, medicos, procurarNome);
			}
		}catch (exceptionNaoEncontrado e) {
			System.out.println("O medico "+ e.getMessage());
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return procurarMedico(sc, medicos2, procurarNome);
			}
		}catch (Exception e) {
			System.out.println("ERRO");
			return null;
		}
		return null;
	}
	public static ArrayList<Exame> cadastraslistaExames(Scanner sc) {
		ArrayList<Exame> exames = new ArrayList<>();
		try {
			boolean[] jaCadastrou = {false,false,false,false,false};
			int escolhaExames = 0;
			while(escolhaExames != 6) {
				System.out.println("Quais exames deseja cadastrar:");
				escolhaExames = menuCadastrarListaExames(sc, jaCadastrou);
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
	public static int menuCadastrarListaExames(Scanner sc, boolean[] jaCadastrou) {
		try {
			System.out.println("1- Glicose"
					+ "\n2- Colesterol Total"
					+ "\n3- Triglicerides"
					+ "\n4- Sumario de urina"
					+ "\n5- Hemograma"
					+ "\n6- Sair"
					+ "\nEscolha uma opção:");
			int valreturn = sc.nextInt();
			sc.nextLine();
			if(valreturn > 6 || valreturn < 1) {
				throw new exceptionForaDasOpcoes();
			}
			return valreturn;
		}catch (InputMismatchException e) {
			System.out.println("Erro de entrada, tente outra vez digite qualquer coisa para continuar");
			sc.nextLine();
			sc.nextLine();
			cadastrados(jaCadastrou);
			return menuCadastrarListaExames(sc, jaCadastrou);
		}catch (exceptionForaDasOpcoes e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			cadastrados(jaCadastrou);
			return menuCadastrarListaExames(sc, jaCadastrou);
		}
	}
}
