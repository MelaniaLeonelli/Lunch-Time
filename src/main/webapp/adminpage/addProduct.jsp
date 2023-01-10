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
<meta charset="ISO-8859-1">
<script type="text/javascript" src="sfondo.js"></script>
<link rel="icon" type="image/x-icon" href="../icona.ico">
<link rel="stylesheet" href="../css/styleH.css">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/dropdown.css">
<title>Aggiungi prodotto</title>
</head>
<body id="corpo">

	<jsp:include page="headerAdminPage.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto">

		<form action="AddToDBServlet" method=post>

			<h1 class="h3 mb-3 fw-normal">Aggiungi un prodotto al Database</h1>

			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="idprodotto"
					onfocus="getFocusCF()" onblur="blurInput()" type="text" name="idprodotto"
					required placeholder="idprodotto"> <label for="cp">Codice
					Prodotto</label>
			</div>
			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="nome"
					onfocus="getFocusName()" onblur="blurInput()" type="text"
					name="nome" required placeholder="Nome"> <label for="nome">Nome</label>
			</div>
			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="categoria"
					onfocus="getFocusSurname()" onblur="blurInput()" type="text"
					name="categoria" required placeholder="Categoria"> <label
					for="categoria">Categoria</label>
			</div>
		
			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="prezzo"
					onfocus="getFocusAddress()" onblur="blurInput()" type="text"
					name="prezzo" placeholder="Costo"> <label for="costo">Prezzo</label>
			</div>
			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="immagine"
					onfocus="getFocusCity()" onblur="blurInput()" type="text"
					name="immagine" placeholder="Immagine"> <label
					for="immagine">Immagine</label>
			</div>
			<div class="form-floating" id="formdiv">
				<input type="text" class="form-control" id="genere"
					onfocus="getFocusCAP()" onblur="blurInput()" type="text"
					name="descrizione" placeholder="Descrizione"> <label for="descrizione">Descrizione</label>
			</div>
			<input type="submit" id="loginBtn"
				class="w-100 btn btn-lg btn-primary" value="Aggiungi al db"><br>
		</form>

	</main>

	<jsp:include page="adminFooter.html"></jsp:include>

</body>
</html>