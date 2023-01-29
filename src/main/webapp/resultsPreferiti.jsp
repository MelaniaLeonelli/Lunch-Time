<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/styleH.css">
<link rel="stylesheet" href="css/styles.css">
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
<title>Risultato ricerca</title>
</head>
<body>
	<%String email = (String) session.getAttribute("emailutente");
	  String name = (String) session.getAttribute("nomeutente");
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

	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<%ArrayList<Prodotto> p = (ArrayList<Prodotto>) request.getAttribute("array");
	  			int i = 0;
	  		    if(p.size() == 0)
	  		    {%>
	  		    <main class="form-signin w-100 m-auto">
		<input type="image" src="logo.png" id="logo_margin" width="10%"
			height="55%" margin-left:="" 20px="">

		<form action="LoginServlet" method="post">

			<h1 class="h3 mb-3 fw-normal" id="registerEff">Non Hai Alcun Prodotto Nei Preferiti. <br> Non ti Piace Nulla?</h1>

			<label> <a  href="CatalogoServlet" id="loginLink" style="color:#000000" > Aggiungilo Subito!</a>
			</label>
		</form>
	</main>
	  		    <% }
	  		    else 
	  			while(i < p.size()){%>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p.get(i).getNome()%></h5>
								<a class="btn btn-outline-danger"
									href="RemovePreferitiServlet?pcode=<%=p.get(i).getIdprodotto()%>&emailutente=<%=email%>">
									Rimuovi dai preferiti</a>
							</div>
						</div>
					</div>
				</div>
				<%i++;
	  			}%>

			</div>
		</div>
	</section>

	<jsp:include page="footer.html"></jsp:include>


</body>
</html>