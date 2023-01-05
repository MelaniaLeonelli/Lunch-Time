package model;

public class Carrello {

	String emailutente;
	
	public Carrello(String emailutente) {
		this.emailutente = emailutente;
	}

	public String getSEmailutente() {
		return emailutente;
	}
	public void setEmailutente(String emailutente) {
		this.emailutente = emailutente;
	}
	@Override
	public String toString() {
		return "Carrello [email=" + emailutente + "]";
	}
	
}