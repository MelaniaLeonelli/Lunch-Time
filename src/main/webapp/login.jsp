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
<title>Login</title>
</head>
<body class="text-center" id="corpo">
	<jsp:include page="headerLogin.jsp"></jsp:include>
	<main class="form-signin w-100 m-auto">
		

		<form action="LoginServlet" method="post">
			<h1 class="h3 mb-3 fw-normal" id="logintext">Login</h1>

			<div class="form-floating" id="formdiv">
				<input type="email" class="form-control" id="floatingInput"
					onfocus="getFocusMail()" onblur="blurInput()" placeholder="Emailutente"
					name="emailutente" required=""> <label for="floatingInput">Indirizzo
					Email</label>
			</div>
			<div class="form-floating" id="formdiv">
				<input type="password" class="form-control" id="floatingPassword"
					onfocus="getFocusPW()" onblur="blurInput()" placeholder="Password"
					name="password" required=""> <label for="floatingPassword">Password</label>
			</div>


			<button id="loginBtn" class="w-100 btn btn-lg btn-primary"
				type="submit">Login</button>
			<div>
				<label> <a href="register.jsp" id="registerLink">Non hai
						un account? Registrati.</a>
				</label>
			</div>
		</form>
	</main>
	<div id="footerpos">
		<jsp:include page="footer.html"></jsp:include>
	</div>
</body>
</html>