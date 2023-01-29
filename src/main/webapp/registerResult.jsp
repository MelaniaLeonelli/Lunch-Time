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
<title>Registrazione Completata</title>
</head>
<body class="text-center" id="corpo">

	<% Boolean exist = (Boolean) session.getAttribute("utenteEsistente");

	if (exist != true){%>

	<jsp:include page="headerRegEff.jsp"></jsp:include>
	<main class="form-signin w-100 m-auto">
		<input type="image" src="logo.png" id="logo_margin" width="60%"
			height="55%" margin-left:="" 20px="">

		<form action="LoginServlet" method="post">

			<h1 class="h3 mb-3 fw-normal" id="registerEff">Registrazione
				Completata!</h1>

			<label> <a href="login.jsp" id="loginLink"> Vai al Login</a>
			</label>
		</form>
	</main>
	<div id="footerposRegEff">
		<jsp:include page="footer.html"></jsp:include>
	</div>

	<%}
	
else{%>
	<jsp:include page="headerRegEff.jsp"></jsp:include>
	<main class="form-signin w-100 m-auto">
		<input type="image" src="logo.png" id="logo_margin" width="60%"
			height="55%" margin-left:="" 20px="">

		<form action="LoginServlet" method="post">

			<h1 class="h3 mb-3 fw-normal" id="registerEff">Utente già
				registrato.</h1>

			<label> <a href="login.jsp" id="loginLink">Prova a <b>loggare</b></a>
			</label>
		</form>
	</main>
	<div id="footerposRegEff">
		<jsp:include page="footer.html"></jsp:include>
	</div>
	<% }%>

</body>
</html>