$().ready(function() {
	 $('#cf').keyup(function(){
 		this.value=this.value.toUpperCase();
	});
	
	jQuery.validator.addMethod("cf_regex", function(value) { 
        var regex = /[A-Za-z]{6}[0-9lmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9lmnpqrstuvLMNPQRSTUV]{2}[A-Za-z]{1}[0-9lmnpqrstuvLMNPQRSTUV]{3}[A-Za-z]{1}/;
        return value. match(regex);  
    }, "Formato codice fiscale non valido");
    
    jQuery.validator.addMethod("cf_checkdigit", function(value) { 
        return cf_validation(value);  
    }, "Formato codice fiscale non valido");
    
    $("#form").validate({
        rules : {
  
            nomeutente : {
				required: true,
				lettersonly: true,
			},
            emailutente : {
                required : true,
                email : true
            },
            password : {
                required : true,
                minlength : 5,
                maxlength : 8
            },
            codicetessera : "required",
            categoria : "required",
			
        messages: {
	
			nomeutente: {
				required:"Campo obbligatorio",
				lettersonly:"Inserisci un nome corretto."
			},
			emailutente:{
				required:"Campo obbligatorio",
				email:"Formato email invalido"
			},
            password: {
                required: "Campo obbligatorio",
                minlength: "La password deve essere lunga minimo 5 caratteri",
                maxlength: "La password deve essere lunga al massimo 8 caratteri"
            },
        submitHandler: function(form) {
            form.submit();
        }  
,}
,}
})
});