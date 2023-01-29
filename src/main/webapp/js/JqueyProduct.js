$().ready(function() {
	 $('#cf').keyup(function(){
 		this.value=this.value.toUpperCase();
	});
	
	jQuery.validator.addMethod("code_regex", function(value) { 
        var regex = "^[0-9]", textbox.Text;
        return value. match(regex);  
    }, "Formato codice  non valido");
    
    jQuery.validator.addMethod("cf_checkdigit", function(value) { 
        return cf_validation(value);  
    }, "Formato codice fiscale non valido");
    
    
    
    
    
    
    
    function validate()
{
  var code = document.getElementById('idp').value;
  var codeRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
  var codeResult = codeRGEX.test(code);
  alert("idprodotto:"+codeResult );
  
  var disp = document.getElementById("disponibile").value;
  var dispRGEX = /^[0-9]{1}/i;
  var dispResult = dispRGEX.test(disp);
  alert("phone:"+phoneResult + ", postal code: "+postalResult);
  
  var prezzo = document.getElementById("prezzo").value;
  var prezzoRGEX = /^[0-9]{1}/i;
  var prezzoResult = prezzoRGEX.test(prezzo);
  alert("phone:"+phoneResult + ", postal code: "+postalResult);
  
  return false;
  
  
}

    
    
    
    
    
    
    $("#form").validate({
        rules : {
  
            name : {
				required: true,
				lettersonly: true,
			},
            categoria : {
                required : true,
                
            },
            genere : {
                required : true,
                lettersonly:true,
                
            },
            
			
        messages: {
	
			nome: {
				required:"Campo obbligatorio",
				lettersonly:"Inserisci un nome corretto."
			},
			categoria:{
				required:"Campo obbligatorio",
				
			},
			
			genere: {
				required:"Campo obbligatorio",
				lettersonly:"Inserisci un nome corretto."
			},
            
        submitHandler: function(form) {
            form.submit();
        }  
,}
,}
})
});/**
 * 
 */