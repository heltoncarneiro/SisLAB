package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Cliente;
import Entities.ColesterolTotal;
import Entities.Exame;
import Entities.Glicose;
import Entities.Medico;
import Entities.Requisicao;
import Entities.Triglicerideos;

public class program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ArrayList<Exame> exames = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Cliente cliente = new Cliente("Helton Jose Carneiro de Lima",sdf.parse("16/08/2001"), "Rua Vereador Jose Manoel Sobrinho", "10489072444", null);
		System.out.println(cliente.ImprimirCliente());
		Cliente cliente2 = new Cliente("Helton Jose Carneiro de Lima",null, "Rua Vereador Jose Manoel Sobrinho", "10489072444", null);
		System.out.println("\n");
		System.out.println(cliente2.ImprimirCliente());
		
		Medico medico = new Medico("Hilmayara Carneiro", "651564465456213");
		System.out.println("\n\n" + medico.imprimirMedico());
		
		Glicose glicose = new Glicose(110, "Repetido e confirmado");
		System.out.println(glicose.ImprimirResultado());
	
		ColesterolTotal cl = new ColesterolTotal(250, "Resultado acima do normal");
		System.out.println(cl.ImprimirResultado());
		
		Triglicerideos tri = new Triglicerideos(500, null);
		System.out.println(tri.ImprimirResultado());
		
		exames.add(glicose);
		exames.add(cl);
		exames.add(tri);
		Requisicao requi = new Requisicao(cliente, medico,exames);
		
		System.out.println(requi.imprimirRequisicao());
	}

}
