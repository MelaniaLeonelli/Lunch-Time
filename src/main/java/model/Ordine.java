package model;

public class Ordine{
	int codordine;
	String data;
	double importototale;
	String emailutente;
	
<<<<<<< HEAD
=======
	
	
>>>>>>> e1c0f993aa4f69713ab4375caa5dd025c631b829
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
	
	public double getImportototale(){
		return importototale;
	}
	public void setImportototale(double importototale){
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