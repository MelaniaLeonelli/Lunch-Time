<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.ico">
<link rel="stylesheet" href="css/dropdown.css">
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
	  TesseraDAO t =new TesseraDAO();
	  Tessera tessera =new Tessera();
	  tessera = t.getTesseraData(email);
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


	
			
			<div class="container">
			  <div class="row">
			    <div class="col">
			    <a class="btn btn-warning . btn-lg "
			    href="UpdateBalanceServlet?ricarica=5&codicetessera=<%=tessera.getCodicetessera()%> ">Ricarica 5 euro</a>
			    </div>
			    <div class="col">
			    <a class="btn btn-warning . btn-lg"
			    href="UpdateBalanceServlet?ricarica=10&codicetessera=<%=tessera.getCodicetessera()%> ">Ricarica 10 euro</a>
			    </div>
			    <div class="col">
			    <a class="btn btn-warning . btn-lg"
			    href="UpdateBalanceServlet?ricarica=20&codicetessera=<%=tessera.getCodicetessera()%> ">Ricarica 20 euro</a>
			    </div>
			    <div class="col">
			     <a class="btn btn-warning . btn-lg"
			   href="UpdateBalanceServlet?ricarica=50&codicetessera=<%=tessera.getCodicetessera()%> ">Ricarica 50 euro</a>
			    </div>
			    <div class="col">
			    <a class="btn btn-warning . btn-lg"
			   href="UpdateBalanceServlet?ricarica=100&codicetessera=<%=tessera.getCodicetessera()%> ">Ricarica 100 euro</a>
			    </div>
			  </div>
			</div>
			
			
		

	<jsp:include page="footer.html"></jsp:include>

	
</body>
</html>