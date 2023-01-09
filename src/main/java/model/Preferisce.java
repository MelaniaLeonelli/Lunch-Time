package model;

public class Preferisce {
	String idprodotto;
	String emailutente;
	
	
	public String getIdprodotto(){
		return idprodotto;
	}
	
	public void setIdprodotto(String idprodotto){
		this.idprodotto=idprodotto;
	}
	
	public String getEmailutente(){
		return emailutente;
	}
	public void setEmailutente(String emailutente){
		this.emailutente=emailutente;
	}
	
	@Override
	public String toString() {
		return "Preferisce [email=" + emailutente + ",prodotto="+idprodotto+"]";
	}
}