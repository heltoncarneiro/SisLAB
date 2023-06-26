package Model.View;

import java.util.InputMismatchException;
import java.util.Scanner;


import Entities.Requisicao;
import Exception.exceptionForaDasOpcoes;

public class Menu {
	
	public Menu() {
		super();
	}

	public static int menuPricipal(Scanner sc) {
		try {
			System.out.println("\n\n1- Cadastrar cliente"
					+ "\n2- Cadastrar medico"
					+ "\n3- Cadastrar requisição"
					+ "\n4- Digitar exames"
					+ "\n5- Imprimir requisição"
					+ "\n6- Exibir requisições cadastradas"
					+ "\nEscolha uma opção:");
			int valreturn = sc.nextInt();
			sc.nextLine();
			if(valreturn<1 || valreturn >6) {
				throw new exceptionForaDasOpcoes();
			}
			return valreturn;
		}catch (InputMismatchException e) {
			System.out.println("Erro de entrada, tente outra vez digite qualquer tecla para continuar");
			sc.nextLine();
			sc.nextLine();
			return 0;
		}catch (exceptionForaDasOpcoes e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			return 0;
		}catch (Exception e) {
			System.out.println("ERRO\nDigite qualquer tecla");
			return 0;
		}
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
			System.out.println("Erro de entrada, tente outra vez digite qualquer tecla para continuar");
			sc.nextLine();
			sc.nextLine();
			Requisicao.cadastrados(jaCadastrou);
			return menuCadastrarListaExames(sc, jaCadastrou);
		}catch (exceptionForaDasOpcoes e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			Requisicao.cadastrados(jaCadastrou);
			return menuCadastrarListaExames(sc, jaCadastrou);
		}
	}
}
