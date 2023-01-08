<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.png">
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
<title>Risultato Login</title>
</head>
<body class="text-center" id="corpo">
	<jsp:include page="headerLogin.jsp"></jsp:include>
	<main class="form-signin w-100 m-auto">
		<input type="image" src="logo.png" id="logo_margin" width="60%"
			height="55%" margin-left:="" 20px="">

		<form action="LoginServlet" method="post">
			<h1 class="h3 mb-3 fw-normal" id="loginWrong">Login</h1>

		</form>
	</main>

	<%Boolean notRegistred = false;
	notRegistred = (Boolean) session.getAttribute("nonRegistrato");

	if (notRegistred == true){%>
	<h4 class="h3 mb-3 fw-normal" id="loginWrongMessage">Email o
		Password errati!</h4>
	<label> <a href="login.jsp" id="loginLink"> Torna al login</a>
	</label>
	<%}
  else{%>
	<p>Login effettuato.</p>
	<label> <a href="index.jsp" id="loginLink"> Torna alla home</a>
	</label>
	<% }%>

	<div id="footerposLogRes">
		<jsp:include page="footer.html"></jsp:include>
	</div>
</body>
</html>