package model;

public class Contiene{
	
	String idprodotto;
	String emailutente;
<<<<<<< HEAD
<<<<<<< HEAD
    int quantit�;
    double importoTotale;
    
=======
	double importoTotale;
	int quantit�;

public Contiene(String idprodotto,String emailutente){
	this.idprodotto=idprodotto;
	this.emailutente=emailutente;
   }
>>>>>>> e1c0f993aa4f69713ab4375caa5dd025c631b829
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
	return quantit�;
}
public void setQuantita(int quantita) {
	this.quantit� = quantita;
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
<<<<<<< HEAD
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantit�="+quantit�+",importoTotale="+importoTotale+"]";
=======
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantit�="+quantita+",importototale"+importoTotale+"]";
>>>>>>> b5f171113ed8691351bdd32889e44f1258214da2
=======
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+",quantit�="+quantit�+",importototale"+importoTotale+"]";
>>>>>>> e1c0f993aa4f69713ab4375caa5dd025c631b829
	
  }
}
