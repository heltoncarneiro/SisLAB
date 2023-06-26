package Application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Controller.Imprimir;
import Entities.Cliente;
import Entities.Medico;
import Entities.Requisicao;
import Exception.exceptionForaDasOpcoes;
import Model.View.Menu;

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
				numOpcao = Menu.menuPricipal(sc);
				switch (numOpcao) {
				case 1:
					Cliente cliente = Cliente.cadastrarCliente(sc, sdf);
					if(cliente != null) {
						clientes.add(cliente);
						System.out.println("Cliente: "+cliente.getNome()+". Cadastrado");
					}
					break;
				case 2:
					Medico medico = Medico.cadastrarMedico(sc, medicos, null, null);
					if(medico != null) {
						medicos.add(medico);
						System.out.println("Medico: "+medico.getNome()+". Cadastrado");
					}
					break;
				case 3:
					Requisicao requisicao = Requisicao.cadastraRequisicao(sc, sdf, requisicaos, medicos, clientes);
					if(requisicao != null) {
						requisicaos.add(requisicao);
						System.out.println("Requisicao de "+requisicao.getCliente().getNome()+". Cadastrada");
					}
					break;
				case 4:
					try {
						Requisicao.ExibirTodasRequisicaos(requisicaos);
						System.out.println("Qual o ID da requisicao que deseja digitar os exames:");
						int id = sc.nextInt();
						sc.nextLine();
						if(id > requisicaos.size() || id<1) {
							throw new exceptionForaDasOpcoes();
						}else {
							requisicaos.get(id-1).digitarListaExames(sc);
						}
					}catch (exceptionForaDasOpcoes e) {
						System.out.println("ID não encontrado");
					}
					catch (InputMismatchException e) {
						System.out.println("Erro de entrada");
					}
					break;
				case 5:
					try {
						Requisicao.ExibirTodasRequisicaos(requisicaos);
						System.out.println("Qual o ID da requisicao que deseja imprimir os exames:");
						int id = sc.nextInt();
						sc.nextLine();
						if(id > requisicaos.size() || id<1) {
							throw new exceptionForaDasOpcoes();
						}else {
							Imprimir.imprimitTxt(sc, requisicaos.get(id-1).imprimirRequisicao());
						}
						break;
					}catch (Exception e) {
						System.out.println("Erro");
						break;
					}
				case 6:
					System.out.println("Requisições cadastradas:");
					Requisicao.ExibirTodasRequisicaos(requisicaos);
					break;
				}
			}
			
		}catch (Exception e) {
			System.out.println("Erro");
		}
		
		sc.close();
	}
}
