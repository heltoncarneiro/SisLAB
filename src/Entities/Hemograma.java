package Entities;

import java.util.Scanner;

import Exception.exceptionPorcentagem;

public class Hemograma implements Exame{
	private double hemacias;
	private double hemoglobina;
	private double hematocrito;
	private double vcm;
	private double hcm;
	private double chcm;
	private double rdw;
	private int leucocitos;	
	private double basofilos;
	private double eosinofilos;
	private double mielocitos;
	private double metamielocitos;
	private double bastoes;
	private double segmentados;
	private double linfocitos;
	private double linfocitosAtipicos;
	private double monocitos;
	private int plaquetas;
	private String[] valorReferencia1 = {"4.00 a 5.20 milhoes/mm³","11.7 a 15.7 g%","36.00 a 47.00 %","80.0 a 100.0 fl","26.0 a 32.0 fl","32.0 a 36.0 %","12.0 a 17.0 %"};
	private String[] valorReferencia2 = {"4000 a 11000/mm³","0 a 1 %","1 a 5 %","0 a 0 %","0 a 0 %","0 a 5 %","40 a 70 %","20 a 40 %","0 a 5 %","2 a 12 %"};
	private String valorReferencia3 = "150 a 450 mil/mm³";
			
	public double getHemacias() {
		return hemacias;
	}

	public void setHemacias(double hemacias) {
		this.hemacias = hemacias;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public double getVcm() {
		return vcm;
	}

	public void setVcm(double vcm) {
		this.vcm = vcm;
	}

	public double getHcm() {
		return hcm;
	}

	public void setHcm(double hcm) {
		this.hcm = hcm;
	}

	public double getChcm() {
		return chcm;
	}

	public void setChcm(double chcm) {
		this.chcm = chcm;
	}

	public double getRdw() {
		return rdw;
	}

	public void setRdw(double rdw) {
		this.rdw = rdw;
	}

	public int getleucocitos() {
		return leucocitos;
	}

	public void setleucocitos(int leucocitos) {
		this.leucocitos = leucocitos;
	}

	public double getBasofilos() {
		return basofilos;
	}

	public void setBasofilos(double basofilos) {
		this.basofilos = basofilos;
	}

	public double getEosinofilos() {
		return eosinofilos;
	}

	public void setEosinofilos(double eosinofilos) {
		this.eosinofilos = eosinofilos;
	}

	public double getMielocitos() {
		return mielocitos;
	}

	public void setMielocitos(double mielocitos) {
		this.mielocitos = mielocitos;
	}

	public double getMetamielocitos() {
		return metamielocitos;
	}

	public void setMetamielocitos(double metamielocitos) {
		this.metamielocitos = metamielocitos;
	}

	public double getBastoes() {
		return bastoes;
	}

	public void setBastoes(double bastoes) {
		this.bastoes = bastoes;
	}

	public double getSegmentados() {
		return segmentados;
	}

	public void setSegmentados(double segmentados) {
		this.segmentados = segmentados;
	}

	public double getLinfocitos() {
		return linfocitos;
	}

	public void setLinfocitos(double linfocitos) {
		this.linfocitos = linfocitos;
	}

	public double getLinfocitosAtipicos() {
		return linfocitosAtipicos;
	}

	public void setLinfocitosAtipicos(double linfocitosAtipicos) {
		this.linfocitosAtipicos = linfocitosAtipicos;
	}

	public double getMonocitos() {
		return monocitos;
	}

	public void setMonocitos(double monocitos) {
		this.monocitos = monocitos;
	}

	public int getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(int plaquetas) {
		this.plaquetas = plaquetas;
	}
	
	public Hemograma() {
		
	}

	public Hemograma(double hemacias, double hemoglobina, double hematocrito, double vcm, double hcm, double chcm,
			double rdw, int leucocitos, double basofilos, double eosinofilos, double mielocitos, double metamielocitos,
			double bastoes, double segmentados, double linfocitos, double linfocitosAtipicos, double monocitos,
			int plaquetas) {
		this.hemacias = hemacias;
		this.hemoglobina = hemoglobina;
		this.hematocrito = hematocrito;
		this.vcm = vcm;
		this.hcm = hcm;
		this.chcm = chcm;
		this.rdw = rdw;
		this.leucocitos = leucocitos;
		this.basofilos = basofilos;
		this.eosinofilos = eosinofilos;
		this.mielocitos = mielocitos;
		this.metamielocitos = metamielocitos;
		this.bastoes = bastoes;
		this.segmentados = segmentados;
		this.linfocitos = linfocitos;
		this.linfocitosAtipicos = linfocitosAtipicos;
		this.monocitos = monocitos;
		this.plaquetas = plaquetas;
	}
	
	@Override
	public String exibirNome() {
		return "Hemograma";
	}
	public String nomeImprimir() {
		int val = 40 - (int)"Hemograma".length()/2;
		String espaco = "";
		for (int i = 0; i< val; i++) {
			espaco += " ";
		}
		return espaco + "Hemograma";
	}
	@Override
	public void digitarExame(Scanner sc) {
		try{
		System.out.println("--------------------------------------------------------------------------------\n"
				+ nomeImprimir()+"\n");
		System.out.println("Qual a quantidade de hemácias ("+valorReferencia1[0]+"):");
		this.hemacias = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a quantidade de Hemoglobinas ("+valorReferencia1[1]+"):");
		this.hemoglobina = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a quantidade de Hmatócritos ("+valorReferencia1[2]+"):");
		this.hematocrito = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual o VCM ("+valorReferencia1[3]+"):");
		this.vcm = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual o HCM ("+valorReferencia1[4]+"):");
		this.hcm = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual o CHCM ("+valorReferencia1[5]+"):");
		this.chcm = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual o RDW ("+valorReferencia1[6]+"):");
		this.rdw = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a quantidade de leucócitos ("+valorReferencia2[0]+"):");
		this.leucocitos = sc.nextInt();
		sc.nextLine();
		System.out.println("Qual a porcentagem de basófilos ("+valorReferencia2[0]+"):");
		double basofilos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de eosinófilos ("+valorReferencia2[0]+"):");
		double eosinofilos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de mielócitos ("+valorReferencia2[0]+"):");
		double mielocitos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de metamielócitos ("+valorReferencia2[0]+"):");
		double metamielocitos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de bastões ("+valorReferencia2[0]+"):");
		double bastoes = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de segmentados ("+valorReferencia2[0]+"):");
		double segmentados = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de linfócitos ("+valorReferencia2[0]+"):");
		double linfocitos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de linfócitos Atípicos ("+valorReferencia2[0]+"):");
		double linfocitosAtipicos = sc.nextDouble();
		sc.nextLine();
		System.out.println("Qual a porcentagem de Monócitos ("+valorReferencia2[0]+"):");
		double monocitos = sc.nextDouble();
		sc.nextLine();
		double porcentagem = basofilos+eosinofilos+mielocitos+metamielocitos+bastoes+segmentados+linfocitos+linfocitosAtipicos+monocitos;
		if(porcentagem != 100) {
			throw new exceptionPorcentagem(porcentagem);
		}else {
			this.basofilos = basofilos;
			this.eosinofilos = eosinofilos;
			this.mielocitos = mielocitos;
			this.metamielocitos = metamielocitos;
			this.bastoes = bastoes;
			this.segmentados = segmentados;
			this.linfocitos = linfocitos;
			this.linfocitosAtipicos = linfocitosAtipicos;
			this.monocitos = monocitos;
		}
		System.out.println("Qual a quantidade de plaquetas ("+valorReferencia3+"):");
		this.plaquetas = sc.nextInt();
		sc.nextLine();
		}catch (exceptionPorcentagem e) {
			if(e.porcentagem > 100) {
				System.out.println("Erro\nSomatório das porcentagem: "+String.format("%.2f", e.porcentagem)+" % valor acima de 100%\nDigite qualquer tecla para tentar digitar novamente");
				sc.nextLine();
				digitarExame(sc);
			}else {
				System.out.println("Erro\nSomatório das porcentagem: "+String.format("%.2f", e.porcentagem)+" % valor abaixo de 100%\nDigite qualquer tecla para tentar digitar novamente");
				sc.nextLine();
				digitarExame(sc);
			}
		}
	}
	public String imprimirEritograma() {
		String[] nomes = {"Hemácias:","Hemoglobina:","Hematócrito:","VCM:","HCM:","CHCM:","RDW:"};
		double[] resultados = {getHemacias(),getHemoglobina(),getHematocrito(),getVcm(),getHcm(),getChcm(),getRdw()};
		String[] unidadesDeMedida = {" milhoes/mm³"," g%"," %"," fl"," fl"," %"," %"};
		String espaco1; String espaco2; String imprimir = "ERITOGRAMA                                                Valores de referência:\n\n";
		int valRound;int valFloor ;
		for(int i = 0; i<7; i++) {
			espaco1 = "";
			espaco2 = "";
			valRound = (int) (40-nomes[i].length()- Math.round(String.valueOf(resultados[i]).length() /2.0));
			valFloor = (int) (40-valorReferencia1[i].length()-unidadesDeMedida[i].length()- Math.floor(String.valueOf(resultados[i]).length()/2.0));
			for(int round = 0 ; round < valRound; round++) {
				espaco1 += " ";
			}
			for(int ceil = 0 ; ceil < valFloor; ceil++) {
				espaco2 += " ";
			}
			imprimir += nomes[i]+espaco1+resultados[i]+unidadesDeMedida[i]+espaco2+valorReferencia1[i]+"\n";
		}
		return imprimir;
	}
	public String imprimirLeucograma() {
		String[] nomes = {"Leucócitos:","Basófilos:","Eosinófilos:","Mielócitos:","Metamielócitos:","Bastões:","Segmentados:","Linfócitos:","Linfócitos atipicos:","Monócitos:"};
		double[] resultados = {getleucocitos(),getBasofilos(),getEosinofilos(),getMielocitos(),getMetamielocitos(),getBastoes(),getSegmentados(),getLinfocitos(),getLinfocitosAtipicos(),getMonocitos()};
		String[] unidadesDeMedida = {"/mm³"," %"," %"," %"," %"," %"," %"," %"," %"," %"};
		String espaco1; String espaco2; String imprimir = "\nLEUCOGRAMA:\n\n";
		int valRound;int valFloor ;
		for(int i = 0; i<10; i++) {
			espaco1 = "";
			espaco2 = "";
			valRound = (int) (40-nomes[i].length()- Math.round(String.valueOf(resultados[i]).length() /2.0));
			valFloor = (int) (40-valorReferencia2[i].length()-unidadesDeMedida[i].length()- Math.floor(String.valueOf(resultados[i]).length()/2.0));
			for(int round = 0 ; round < valRound; round++) {
				espaco1 += " ";
			}
			for(int ceil = 0 ; ceil < valFloor; ceil++) {
				espaco2 += " ";
			}
			imprimir += nomes[i]+espaco1+resultados[i]+unidadesDeMedida[i]+espaco2+valorReferencia2[i]+"\n";
		}
		return imprimir;
	}
	public String imprimirPlaquetas() {
		String espaco1 = "";
		String espaco2 = "";
		int valRound = (int) (40-"Plaquetas:".length()- Math.round(String.valueOf(getPlaquetas()).length() /2.0));
		int valFloor = (int) (40-valorReferencia3.length()-" mil/mm³".length()- Math.floor(String.valueOf(getPlaquetas()).length()/2.0));
		for(int round = 0 ; round < valRound; round++) {
			espaco1 += " ";
		}
		for(int ceil = 0 ; ceil < valFloor; ceil++) {
			espaco2 += " ";
		}
		return "\nPlaquetas:"+espaco1+getPlaquetas()+" mil/mm³"+espaco2+valorReferencia3;
	}
	@Override
	public String ImprimirResultado() {
		// TODO Auto-generated method stub
		return 	"--------------------------------------------------------------------------------\n"
		+ nomeImprimir()+"\n\n"
		+ imprimirEritograma()
		+ imprimirLeucograma()
		+ imprimirPlaquetas()+"\n";
	}
	
}
