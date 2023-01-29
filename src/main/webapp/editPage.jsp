<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/dropdown.css">
<link rel="stylesheet" href="../css/styleH.css">
<link rel="stylesheet" href="../css/loginstyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Modifica Prodotto</title>
</head>
<body id="corpo">
	<%
		Prodotto p = (Prodotto) request.getAttribute("product");%>

	<%String emailutente = (String) session.getAttribute("emailutente");
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	  session.setAttribute("emailutente", emailutente);
	  session.setAttribute("adminRoles", role);
	 %>

	<jsp:include page="headerEditPage.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto">

		<form action="ProductUpdateServlet" id="editForm">
        <label for "nome"><b>IdProdotto</b>:</label>    
		<input type="text" class="form-control" id="pcode" type = "text" name="pcode" onblur="blurInput()" readonly placeholder="<%=p.getIdprodotto()%>" value="<%=p.getIdprodotto()%>"> 
	<label for "nome"><b>Nome</b>:</label>
	<div class="form-floating" id="formdiv" contentEditable="true">
		<input type="text" class="form-control" id = "name" type = "text" name = "name" onblur = "blurInput()" readonly placeholder="<%=p.getNome()%>" value="<%=p.getNome()%>">
	</div>
	<label for "nome"><b>Categoria</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "category" type = "text" name = "category" onblur = "blurInput()" readonly placeholder = "<%=p.getCategoria()%>" value="<%=p.getCategoria()%>">
	</div>
	
	<label for "nome"><b>Prezzo</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "prezzo" type = "text" name = "prezzo" onblur = "blurInput()" placeholder = "<%=p.getPrezzo()%>" value="<%=p.getPrezzo()%>">
	</div>
	<label for "nome"><b>Descrizione</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "descrizione" type = "text" name = "descrizione" onblur = "blurInput()" placeholder = "<%=p.getDescrizione()%>" value="<%=p.getDescrizione()%>">
	</div>
	<label for "nome"><b>Disponibile</b>:</label>
	<div class="form-floating" contentEditable="true" id="formdiv">
		<input type="text" class="form-control" id = "disponibile" type = "text" name = "disponibile" onblur = "blurInput()" placeholder = "<%=p.getDisponibile()%>" value="<%=p.getDisponibile()%>">
	</div>
	
	<button id = "editBtn" class="w-100 btn btn-lg btn-primary" type="submit">Modifica il prodotto</button>
  </form>

	</main>

	<jsp:include page="/adminpage/editFooter.html"></jsp:include>

	<script>
	const button = document.getElementById('button');
	const cart = document.getElementById('cart');
	const text = document.getElementById('text');
	
	button.onclick = function() {
	  if (!document.getElementsByClassName('cartAnimation').length) {
	    cart.classList.add('cartAnimation');
	    text.classList.add('textAnimation');
	    button.classList.add('buttonAnimation');
	  } else {
	    cart.classList.remove('cartAnimation');
	    text.classList.remove('textAnimation');
	    button.classList.remove('buttonAnimation');
	  }
	}	
</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>
</body>
</html>