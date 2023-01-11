<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">

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
<link rel="stylesheet" href="css/styleH.css">
<link rel="stylesheet" href="css/loginstyle.css">
<meta charset="UTF-8">
<title>Registrati</title>

</head>
<body class="text-center" id="corpo">

	<jsp:include page="headerRegister.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto" id="main">

		<form action="RegisterServlet" id="form" method="POST">

			<h1 class="h3 mb-3 fw-normal" id="registertext">Registrati</h1>


			<label for="nomeutente">Nome Utente*</label>
			<div class="form-floating">
				<input type="text" class="form-control" id="nomeutente" type="text"
					name="nomeutente" required placeholder="Nomeutente">
			</div>

			<label for="floatingInput">Email*</label>
			<div class="form-floating">
				<input type="emailutente" class="form-control" id="emailutente" type="text"
					name="emailutente" required placeholder="Email">
			</div>

			<label for="floatingPassword">Password*</label>
			<div class="form-floating">
				<input type="password" class="form-control" id="password"
					type="text" name="password" required placeholder="Password">
			</div>
			
			<label for="floatingInput">Codice Tessera*</label>
			<div class="form-floating">
				<input type="codicetessera" class="form-control" id="codicetessera"
					type="int" name="codicetessera" required placeholder="Codicetessera">
			</div>
			
			
			<br>
			
			
 				 <p>Seleziona la tua borsa di studio:</p>
  					<input type="radio" id="categoria" name="categoria" value="1">
 					 <label for="categoria">idoneo</label><br>
 					 <input type="radio" id="categoria" name="categoria" value="2">
					  <label for="categoria">non idoneo</label><br>
					  <input type="radio" id="categoria" name="categoria" value="3">
					  <label for="categoria">beneficiario</label>
								

	
		<button id="registerBtn" class="w-100 btn btn-lg btn-primary"
				type="submit">Registrati</button>

			<div id="formdiv">
				<label> <a href="login.jsp" id="loginLink">Hai già un
						account? Accedi.</a>
							</label>
						</div>
						</form>

	</main>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
	<script src="js/jqueryValidate.js"></script>

	<div id="footerpos">
		<jsp:include page="footer.html"></jsp:include>
	</div>
</body>
</html>