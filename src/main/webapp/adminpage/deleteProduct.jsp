<!DOCTYPE html>
<html>
<head>
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
<script type="text/javascript" src="../sfondo.js"></script>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/x-icon" href="../logo.ico">
<link rel="stylesheet" href="../css/styleH.css">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/dropdown.css">
<title>Rimuovi prodotto</title>
</head>
<body class="text-center" id="corpo">

	<jsp:include page="headerAdminPage.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto">

		<form action="RemoveFromDBServlet" method=post>

			<h1 class="h3 mb-3 fw-normal">Rimuovi un prodotto dal DataBase</h1>

			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="cp"
					onfocus="getFocusCF()" onblur="blurInput()" type="text" name="idprodotto"
					required placeholder="Codice Prodotto"> <label for="idprodotto">Codice
					Prodotto</label>
			</div>

			<input type="submit" id="loginBtn"
				class="w-100 btn btn-lg btn-primary" value="Rimuovi dal db"><br>
		</form>

	</main>

	<jsp:include page="adminFooter.html"></jsp:include>

</body>
</html>