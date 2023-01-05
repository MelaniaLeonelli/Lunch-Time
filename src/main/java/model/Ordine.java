package model;

public class Ordine{
	int codordine;
	String data;
	float importototale;
	String emailutente;
	
	public Ordine(int codordine,String data,float importototale,String emailutente){
		this.codordine=codordine;
		this.data=data;
		this.importototale=importototale;
		this.emailutente=emailutente;
		
	}
}