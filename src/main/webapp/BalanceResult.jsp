<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="css/loginstyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/formcheck.js"></script>
<meta charset="ISO-8859-1">
<title>Ricarica Effettuata!</title>
</head>
<body class="text-center" id="corpo">
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


	<jsp:include page="searchbar.jsp"></jsp:include>
	
	<main class="form-signin w-100 m-auto">
		<input type="image" src="logo.png" id="logo_margin" width="60%"
			height="55%" margin-left:="" 20px="">

		<form action="LoginServlet" method="post">

			<h1 class="h3 mb-3 fw-normal" id="registerEff">RicaricaEffettuata!</h1>

			<label> <a href="index.jsp" id="loginLink"> Vai alla home</a>
			</label>
		</form>
	</main>
	<div id="footer">
		<jsp:include page="footer.html"></jsp:include>
	</div>


	<div id="footerposRegEff">
		<jsp:include page="footer.html"></jsp:include>
	</div>
	

</body>
</html>