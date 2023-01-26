<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/styleH.css">
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
<title>Pagina Prodotto</title>
</head>
<body>
	<%
		Prodotto p = (Prodotto) request.getAttribute("product");%>

	<%String email = (String) session.getAttribute("emailutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	  session.setAttribute("emailutente", email);
	  session.setAttribute("adminRoles", role);
	 if (email == null) { %>
	<jsp:include page="headerGuest.jsp"></jsp:include>

	<% } 
	 else if(role == Boolean.TRUE)
	 {%>
	<jsp:include page="headerAdmin.jsp"></jsp:include>
	<% }
	 else { %>
	<jsp:include page="headerUtente.jsp"></jsp:include>
	<%} %>

	<jsp:include page="searchbar.jsp"></jsp:include>


	<div class="container py-4 my-4 mx-auto d-flex flex-column">
		<div class="header">
			<div class="row r1">
				<div class="col-md-9 abc">
					<h1><%=p.getNome() + " " + "(" + p.getCategoria() + ")" %></h1>
				</div>
				<p class="text-right para">
					euro <%=p.getPrezzo()%></p>
			</div>
		</div>
		<div class="container-body mt-4">
			<div class="row r3">
				<div class="col-md-5 p-0 klo">
					<ul>
						<li><b>Codice Prodotto</b>: <%=p.getIdprodotto() %></li>
						<li><b>Descrizione</b>: <%=p.getDescrizione() %></li>
						<li><b>Nome</b>: <%=p.getNome() %></li>
						<li><b>Categoria</b>: <%=p.getCategoria() %></li>
						<li><b>Disponibile</b>: <%=p.getDisponibile() %></li>

						
						
					</ul>
				</div>
				
			</div>
		</div>
		<div class="footer d-flex flex-column mt-5">
			<div class="row r4">
				<div class="col-md-2 myt "></div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.html"></jsp:include>

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