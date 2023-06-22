package Entities;

public final class SumarioDeUrina implements Exame {
	private String densidade = "não informada";
	private String ph = "não informado";
	private String proteina = "Ausente";
	private String hemacias = "Ausente";
	private String glicose = "Ausente";
	private String leucocitos = "Ausente";
	private String cetonas = "Ausente";
	private String urobilinogenio = "Ausente";
	private String bilirrubina  = "Ausente";
	private String nitrito = "Ausente";
	private String piocitos = "não informado";
	private String celulasEpiteliais = "não informado";
	private String bacterias = "não informado";

	public String getPiocitos() {
		return piocitos;
	}

	public void setPiocitos(String piocitos) {
		this.piocitos = piocitos;
	}

	public String getCelulasEpiteliais() {
		return celulasEpiteliais;
	}

	public void setCelulasEpiteliais(String celulasEpiteliais) {
		this.celulasEpiteliais = celulasEpiteliais;
	}

	public String getBacterias() {
		return bacterias;
	}

	public void setBacterias(String bacterias) {
		this.bacterias = bacterias;
	}

	public String getDensidade() {
		return densidade;
	}

	public void setDensidade(String densidade) {
		this.densidade = densidade;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getProteina() {
		return proteina;
	}

	public void setProteina(String proteina) {
		this.proteina = proteina;
	}

	public String getHemacias() {
		return hemacias;
	}

	public void setHemacias(String hemacias) {
		this.hemacias = hemacias;
	}
	
	public String getGlicose() {
		return glicose;
	}

	public void setGlicose(String glicose) {
		this.glicose = glicose;
	}

	public String getleucocitos() {
		return leucocitos;
	}

	public void setleucocitos(String leucocitos) {
		this.leucocitos = leucocitos;
	}

	public String getCetonas() {
		return cetonas;
	}

	public void setCetonas(String cetonas) {
		this.cetonas = cetonas;
	}

	public String getUrobilinogenio() {
		return urobilinogenio;
	}

	public void setUrobilinogenio(String urobilinogenio) {
		this.urobilinogenio = urobilinogenio;
	}

	public String getBilirrubina() {
		return bilirrubina;
	}

	public void setBilirrubina(String bilirrubina) {
		this.bilirrubina = bilirrubina;
	}

	public String getNitrito() {
		return nitrito;
	}

	public void setNitrito(String nitrito) {
		this.nitrito = nitrito;
	}


	public SumarioDeUrina() {
	}

	public SumarioDeUrina(String densidade, String ph, String proteina, String hemacias, String glicose,
			String leucocitos, String cetonas, String urobilinogenio, String bilirrubina, String nitrito
			, String piocitos, String celulasEpiteliais, String bacterias) {
		if(densidade != null) {
		this.densidade = densidade;
		}
		if(ph != null) {
		this.ph = ph;
		}
		if(proteina != null) {
		this.proteina = proteina;
		}
		if(hemacias != null) {
		this.hemacias = hemacias;
		}
		if(glicose != null) {
		this.glicose = glicose;
		}
		if(leucocitos!= null) {
		this.leucocitos = leucocitos;
		}
		if(cetonas!= null) {
		this.cetonas = cetonas;
		}
		if(urobilinogenio!= null) {
		this.urobilinogenio = urobilinogenio;
		}
		if(bilirrubina != null) {
		this.bilirrubina = bilirrubina;
		}
		if(nitrito != null) {
		this.nitrito = nitrito;
		}
		if(piocitos != null) {
		this.piocitos = piocitos;
		}
		if(celulasEpiteliais != null) {
		this.celulasEpiteliais = celulasEpiteliais;
		}
		if(bacterias != null) {
		this.bacterias = bacterias;
		}
	}

	@Override
	public String exibirNome() {
		return "Sumario de Urina";
	}

	public String nomeImprimir() {
		int val = 40 - (int)"Sumario de Urina".length()/2;
		String espaco = "";
		for (int i = 0; i< val; i++) {
			espaco += " ";
		}
		return espaco + "Sumario de Urina";
	}
	private String imprimirExameFisico() {
		String [] nomes =  {"Proteina:","Hemoglobina:"}; 
		String [] valorReferecia = {"1.010 a 1.030","5.5 a 7.0"};
		String [] resultado = {getDensidade(),getPh()};
		String espaco1; String espaco2; String imprimir = "EXAME FISICO:                       Resultado:             Valores Referenciais:\n\n";
		int valRound;int valFloor ;
		for(int i = 0; i<2; i++) {
			espaco1 = "";
			espaco2 = "";
			valRound = (int) (40-nomes[i].length()- Math.round(resultado[i].length() /2.0));
			valFloor = (int) (40-valorReferecia[i].length()- Math.floor(resultado[i].length()/2.0));
			for(int round = 0 ; round < valRound; round++) {
				espaco1 += " ";
			}
			for(int ceil = 0 ; ceil < valFloor; ceil++) {
				espaco2 += " ";
			}
			imprimir += nomes[i]+espaco1+resultado[i]+espaco2+valorReferecia[i]+"\n";
		}
		return imprimir;
	}
	private String imprimirExameQuimico() {
		String [] nomes = {"Proteina:","Hemacias:","Glicose:","leucocitos:","Cetonas:","Urobilinogenio:","Bilirrubina:","Nitrito:"};
		String [] valorReferecia = {"Ausente","Ausente","Ausente","Ausente","Ausente","Ausente","Normal","Negativo"};
		String [] resultado = {getProteina(),getHemacias(),getGlicose(),getleucocitos(),getCetonas(),getUrobilinogenio(),getBilirrubina(),getNitrito()};
		String espaco1; String espaco2; String imprimir = "\nEXAME QUÃ�MICO:\n\n";
		for(int i = 0; i<8; i++) {
			espaco1 = "";
			espaco2 = "";
			int valRound = (int) (40-nomes[i].length()- Math.round(resultado[i].length()/2.0));
			int valFloor = (int) (40-valorReferecia[i].length()- Math.floor(resultado[i].length()/2.0));
			for(int round = 0 ; round < valRound; round++) {
				espaco1 += " ";
			}
			for(int ceil = 0 ; ceil < valFloor; ceil++) {
				espaco2 += " ";
			}
			imprimir += nomes[i]+espaco1+resultado[i]+espaco2+valorReferecia[i]+"\n";
		}
		return imprimir;
	}
	private String imprimirSedimentoscopia() {
		String [] nomes =  {"Piocitos:","Celulas Epiteliais:" , "Bacterias:"}; 
		String [] valorReferecia = {"<5 Piocitos","Raras","Não observado"};
		String [] resultado = {getPiocitos(),getCelulasEpiteliais(),getBacterias()};
		String espaco1; String espaco2; String imprimir = "\nSEDIMENTOSCOPIA:\n\n";
		int valRound;int valFloor ;
		for(int i = 0; i<2; i++) {
			espaco1 = "";
			espaco2 = "";
			valRound = (int) (40-nomes[i].length()- Math.round(resultado[i].length() /2.0));
			valFloor = (int) (40-valorReferecia[i].length()- Math.floor(resultado[i].length()/2.0));
			for(int round = 0 ; round < valRound; round++) {
				espaco1 += " ";
			}
			for(int ceil = 0 ; ceil < valFloor; ceil++) {
				espaco2 += " ";
			}
			imprimir += nomes[i]+espaco1+resultado[i]+espaco2+valorReferecia[i]+"\n";
		}
		return imprimir;
	}
	@Override
	public String ImprimirResultado() {
		return 	"--------------------------------------------------------------------------------\n"
				+ nomeImprimir()+"\n\n"
				+ imprimirExameFisico()
				+ imprimirExameQuimico()
				+ imprimirSedimentoscopia();
	}

}
