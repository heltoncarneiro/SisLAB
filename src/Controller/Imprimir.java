package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Imprimir {
	public Imprimir() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void imprimitTxt(Scanner sc, String Imprimir) {
		String path = "C:\\Users\\helto\\OneDrive\\Documentos\\Impressão\\";
		System.out.println("Qual o nome do arquivo?");
		String nomeArquivo = sc.nextLine().replace("\n", "");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+"\\"+nomeArquivo+".txt"))) {
		bw.write(Imprimir);
		System.out.println("Impressão realizada");
		} catch (IOException e) {
		 System.out.println("Erro de impressão");
		} catch (Exception e) {
			System.out.println("Erro de impressão");
		}
	}
}
