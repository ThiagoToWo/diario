package Lógica;

public class Aluno {
	
	String numero;
	String nome; 
	String bimestre;
	String primeiroInst;
	String recPrimeiroInst;
	String segundoInst;
	String recSegundoInst;
	String terceiroInst;
	String recTerceiroInst;
	
	public Aluno(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
		numero = a;
		nome = b;
		bimestre = c;
		primeiroInst = d;
		recPrimeiroInst = e;
		segundoInst = f;
		recSegundoInst = g;
		terceiroInst = h;
		recTerceiroInst = i;
	}
	
	public void setNumero(String a) {
		numero = a;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNome(String b) {
		nome = b;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setBimestre(String c) {
		bimestre = c;
	}
	
	public String getBimestre() {
		return bimestre;
	}
	
	public void setPrimeiroInst(String d) {
		primeiroInst = d;
	}
	
	public String getPrimeiroInst() {
		return primeiroInst;
	}
	
	public void setRecPrimeiroInst(String e) {
		recPrimeiroInst = e;
	}
	
	public String getRecPrimeiroInst() {
		return recPrimeiroInst;
	}
	
	public void setSegundoInst(String f) {
		segundoInst = f;
	}
	
	public String getSegundoInst() {
		return segundoInst;
	}
	
	public void setRecSegundoInst(String g) {
		recSegundoInst = g;
	}
	
	public String getRecSegundoInst() {
		return recSegundoInst;
	}
	
	public void setTerceiroInst(String h) {
		terceiroInst = h;
	}
	
	public String getTerceiroInst() {
		return terceiroInst;
	}
	
	public void setRecTerceiroInst(String i) {
		recTerceiroInst = i;
	}
	
	public String getRecTerceiroInst() {
		return recTerceiroInst;		
	}	
}

