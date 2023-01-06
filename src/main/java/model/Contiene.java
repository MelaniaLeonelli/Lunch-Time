package model;

public class Contiene{
	String idprodotto;
	String emailutente;

public Contiene(String idprodotto,String emailutente){
	this.idprodotto=idprodotto;
	this.emailutente=emailutente;
   }
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
@Override
public String toString(){
	return "Contiene [idprodotto="+idprodotto+",emailutente="+emailutente+"]";
	
  }
}
