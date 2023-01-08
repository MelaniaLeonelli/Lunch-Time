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
	
	public int getCodordine(){
		return codordine;
	}
	public void setCodordine(int codordine){
		this.codordine=codordine;
	}
	
	public String getData(){
		return data;
	}
	public void setData(String data){
		this.data=data;
	}
	
	public float getImportototale(){
		return importototale;
	}
	public void setImportototale(float importototale){
		this.importototale=importototale;
	}
	
	public String getEmailutente(){
		return emailutente;
	}
	public void setEmailutente(String emailutente){
		this.emailutente=emailutente;
	}
	
	@Override
	public String toString(){
		return "Ordine [ codordine="+codordine+",data="+data+",importototale="+importototale+",emailutente"+emailutente+"]";
	}
}