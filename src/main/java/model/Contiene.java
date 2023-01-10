package model;

public class Contiene{
	
	String idprodotto;
	String emailutente;
	double importoTotale;
	int quantita;


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

public int getQuantita() {
	return quantita;
}
public void setQuantita(int quantita) {
	this.quantita = quantita;
}

public double getimportoTotale() {
	return importoTotale;
}
public void setimportoTotale(double importoTotale) {
	this.importoTotale = importoTotale;
}
@Override
public String toString(){
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantita="+quantita+",importototale"+importoTotale+"]";
	
  }
}
