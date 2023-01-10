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
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("ruolo");
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
					$<%=p.getPrezzo()%></p>
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

						<!--  <button id="button" type="button" class="button">-->
						<%if(email != null){ %>
						<%if(p.getDisponibile() != 0){%>
						<a
							href="AddToCartServlet?emailutente=<%=session.getAttribute("cf")%>&idprodotto=<%=p.getIdprodotto()%>"
							button id="button" type="button" class="button"
							style="text-decoration: none;"> <svg id="cart" class="cart"
								height="30px" viewBox="0 -31 512.00033 512" width="50px"
								xmlns="http://www.w3.org/2000/svg">
								<path
									d="m166 300.003906h271.003906c6.710938 0 12.597656-4.4375 14.414063-10.882812l60.003906-210.003906c1.289063-4.527344.40625-9.390626-2.433594-13.152344-2.84375-3.75-7.265625-5.964844-11.984375-5.964844h-365.632812l-10.722656-48.25c-1.523438-6.871094-7.617188-11.75-14.648438-11.75h-91c-8.289062 0-15 6.710938-15 15 0 8.292969 6.710938 15 15 15h78.960938l54.167968 243.75c-15.9375 6.929688-27.128906 22.792969-27.128906 41.253906 0 24.8125 20.1875 45 45 45h271.003906c8.292969 0 15-6.707031 15-15 0-8.289062-6.707031-15-15-15h-271.003906c-8.261719 0-15-6.722656-15-15s6.738281-15 15-15zm0 0" />
								<path
									d="m151 405.003906c0 24.816406 20.1875 45 45.003906 45 24.8125 0 45-20.183594 45-45 0-24.8125-20.1875-45-45-45-24.816406 0-45.003906 20.1875-45.003906 45zm0 0" />
								<path
									d="m362.003906 405.003906c0 24.816406 20.1875 45 45 45 24.816406 0 45-20.183594 45-45 0-24.8125-20.183594-45-45-45-24.8125 0-45 20.1875-45 45zm0 0" />
    </svg>
							<p id="text" class="text">Aggiungi al carrello</p>
						</a>
						<% }%>
						<% }%>
						<!--   </button>-->
					</ul>
				</div>
				<div class="col-md-7">
					<div class="immagine">
						<img src="<%=p.getImmagine()%>" id="prodIMG">
					</div>
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