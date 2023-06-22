package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
					cadastrarCliente(sc, sdf, clientes);
					break;
				case 2:
					cadastrarMedico(sc, sdf, medicos);
					break;
				case 3:
					cadastraslistaExames(sc);
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
	public static void cadastrarCliente(Scanner sc , SimpleDateFormat sdf,ArrayList<Cliente> clientes) {
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
			clientes.add(new Cliente(nome, dataDeNascimento, endereco, cpf));
		}
		catch (ParseException e) {
			System.out.println("Formato de data irregular\n\nPressione Qualquer tecla para cadastrar um cliente outra vez\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				cadastrarCliente(sc, sdf, clientes);
			}
		}
	}
	public static void cadastrarMedico(Scanner sc , SimpleDateFormat sdf,ArrayList<Medico> medicos) {
		try {
			System.out.println("Qual o nome do medico:");
			String nome = sc.nextLine();
			System.out.println("Qual o numero de CRM:");
			String crm = sc.nextLine();
			medicos.add(new Medico(nome, crm));
		}
		catch (Exception e) {
			System.out.println("Erro\n\nPressione Qualquer tecla para cadastrar um medico outra vez\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				cadastrarMedico(sc, sdf, medicos);
			}
		}

	}
	public static void cadastraslistaExames(Scanner sc) {
		ArrayList<Exame> exames = new ArrayList<>();
		try {
			boolean[] jaCadastrou = {false,false,false,false,false};
			int escolhaExames;
			while(true) {
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
				}
				cadastrados(jaCadastrou);
	
			}
		}
		catch (Exception e) {
			System.out.println("Erro\n\nPressione Qualquer tecla para cadastrar os exames novamente\nCaso deseje voltar para o menu digite \"S\"");
			if(sc.next().toLowerCase().charAt(0) != 's') {
				sc.nextLine();
				cadastraslistaExames(sc);
			}
		}
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
				+ "\nEscolha uma opção:");
		int valreturn = sc.nextInt();
		sc.nextLine();
		return valreturn;
	}
}
