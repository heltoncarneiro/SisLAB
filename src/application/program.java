package application;

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
					clientes.add(cadastrarCliente(sc, sdf));
					
					break;
				case 2:
					medicos.add(cadastrarMedico(sc));
					break;
				case 3:
					cadastraRequisicao(sc, sdf, requisicaos, medicos, clientes);
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
	public static void cadastraRequisicao(Scanner sc, SimpleDateFormat sdf,ArrayList<Requisicao> requisicoes,ArrayList<Medico> medicos,ArrayList<Cliente> clientes) {
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
				cliente = procurarCliente(sc, clientes,sdf);
			}
			System.out.println("1-Deseja cadastrar um novo médico\n2-Cadastrar com medico ja cadastrado\nQual opção:");
			resposta2 = sc.nextInt();
			sc.nextLine();
			if(resposta2 == 1) {
				medico = cadastrarMedico(sc);
			}else if(resposta2 == 2){
			}
			exames = cadastraslistaExames(sc);
			if(cliente != null && medico != null && exames != null ) {
				requisicoes.add(new Requisicao(cliente, medico, exames));
			}
			System.out.println(requisicoes);
			
		}catch (Exception e) {
		}
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
		}
		return null;
	}
	public static Cliente procurarCliente(Scanner sc, ArrayList<Cliente> clientes, SimpleDateFormat sdf) {
		ArrayList<Cliente> clientes2 = new ArrayList<>();
		System.out.println("1- Procurar por nome");
		int count = 1;
		System.out.println("Qual o nome:");
		String procurarNome = sc.next().toLowerCase();
		sc.nextLine();
		for(int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getNome().toLowerCase().contains(procurarNome) == true){
				System.out.println(count+"- "+clientes.get(i).getNome());
				clientes2.add(clientes.get(i));
				count++;
			}
		}
		if(count >1 ) {
			try {
				System.out.println("Qual opção deseja:");
				int index = sc.nextInt();
				if(index >= clientes2.size() && index > 0) {
				sc.nextLine();
				return clientes2.get(index);
				}else {
					System.out.println("Erro1\nPressione Qualquer tecla para tentar procurar outra vez\\nCaso deseje sair digite:\"s\"");
					if(sc.next().toLowerCase().charAt(0) != 's') {
							sc.nextLine();
							return cadastrarCliente(sc, sdf);
					}
				}
			}catch (InputMismatchException e) {
					System.out.println("Erro de entrada\nDigite qualquer botão para tentar procurar nome mais uma vez");
					sc.nextLine();
					procurarCliente(sc, clientes2, sdf);
					
				}
		}else {
			System.out.println("Usuario não encontrado\nPressione Qualquer tecla para tentar procurar outra vez\\nCaso deseje sair digite:\"s\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
					sc.nextLine();
					return cadastrarCliente(sc, sdf);
			}
		}
		return null;
	}
	public static Medico cadastrarMedico(Scanner sc) {
		try {
			System.out.println("Qual o nome do medico:");
			String nome = sc.nextLine();
			System.out.println("Qual o numero de CRM:");
			String crm = sc.nextLine();
			return new Medico(nome, crm);
		}
		catch (Exception e) {
			System.out.println("Erro\n\nPressione Qualquer tecla para cadastrar um medico outra vez\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				return cadastrarMedico(sc);
			}
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
				escolhaExames = menuCadastrarListaExames(sc);
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
	public static int menuCadastrarListaExames(Scanner sc) {
		System.out.println("1- Glicose"
				+ "\n2- Colesterol Total"
				+ "\n3- Triglicerides"
				+ "\n4- Sumario de urina"
				+ "\n5- Hemograma"
				+ "\n6- Sair"
				+ "\nEscolha uma opção:");
		int valreturn = sc.nextInt();
		sc.nextLine();
		return valreturn;
	}
}
