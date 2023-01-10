package model;

public class Contiene{
	
	String idprodotto;
	String emailutente;
<<<<<<< HEAD
    int quantità;
    double importoTotale;
    
public String getIdprootto(){
=======
	double importoTotale;
	int quantita;


public String getIdprodotto(){
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
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
<<<<<<< HEAD
	return quantità;
}
public void setQuantita(int quantita) {
	this.quantità = quantita;
=======
	return quantita;
}
public void setQuantita(int quantita) {
	this.quantita = quantita;
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
}

public double getimportoTotale() {
	return importoTotale;
}
public void setimportoTotale(double importoTotale) {
	this.importoTotale = importoTotale;
}
@Override
public String toString(){
<<<<<<< HEAD
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantità="+quantità+",importoTotale="+importoTotale+"]";
=======
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantitï¿½="+quantita+",importototale"+importoTotale+"]";
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
	
  }
}
