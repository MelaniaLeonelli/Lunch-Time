package model;

public class Contiene{
	String idprodotto;
	String emailutente;
    int quantit�;
    double importoTotale;
    
public String getIdprootto(){
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
	return quantit�;
}
public void setQuantita(int quantita) {
	this.quantit� = quantita;
}

public double getimportoTotale() {
	return importoTotale;
}
public void setimportoTotale(double importoTotale) {
	this.importoTotale = importoTotale;
}
@Override
public String toString(){
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantit�="+quantit�+",importoTotale="+importoTotale+"]";
	
  }
}
