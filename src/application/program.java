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
					cadastrasCliente(sc, sdf, clientes);
					System.out.println(clientes);
					break;
				case 2:
					cadastrasMedico(sc, sdf, medicos);
					System.out.println(medicos);
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
		System.out.println("1- Cadastrar cliente"
				+ "\n2- Cadastrar medico"
				+ "\n3- Cadastrar requisição"
				+ "\n4- Digitar exames"
				+ "\n5- Imprimir requisição"
				+ "\nEscolha uma opção:");
		int valreturn = sc.nextInt();
		sc.nextLine();
		return valreturn;
	}
	public static void cadastrasCliente(Scanner sc , SimpleDateFormat sdf,ArrayList<Cliente> clientes) {
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
				cadastrasCliente(sc, sdf, clientes);
			}
		}
	}
	public static void cadastrasMedico(Scanner sc , SimpleDateFormat sdf,ArrayList<Medico> medicos) {
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
				cadastrasMedico(sc, sdf, medicos);
			}
		}

	}
}
