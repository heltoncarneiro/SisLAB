package Entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Exception.exceptionCrmCadastrado;
import Exception.exceptionForaDasOpcoes;
import Exception.exceptionNaoEncontrado;

public class Medico {
	private String nome;
	private String numCrm;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumCrm() {
		return numCrm;
	}
	public void setNumCrm(String numCrm) {
		this.numCrm = numCrm;
	}
	public Medico(String nome, String numCrm) {
		this.nome = nome;
		this.numCrm = numCrm;
	}
	public String imprimirMedico() {
		return "Medico: " + getNome() + ", Numero CRM: " + getNumCrm()+ "\n";
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
				return medicos2.get(index-1);
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
}
