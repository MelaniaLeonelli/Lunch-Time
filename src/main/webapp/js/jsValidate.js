function validate(){
	var prezzo=document.getElementById('prezzo').value;
	var prezzook=/^[0-9]+$/;
	var prezzoResult=prezzook.test(prezzo);
	alert("nel prezzo devi mettere solo numeri");
	
	var disponibile=document.getElementById('disponibile').value;
	var disponibileok=/^[0-9]+$/;
	var disponibileResult=disponibileok.test(disponibile);
	alert("form 'disponibile' vuole solo 0 o 1");
	
	var idp=document.getElementById('idp').value;
	var idpok=/^[0-9]+$/;
	var idpResult=idpok.test(idp);
	alert("form 'idprodotto' vuole solo numeri");
	
	
	
	

}
