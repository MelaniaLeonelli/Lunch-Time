<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
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
<body>

	<header class="p-3 bg-dark text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<svg class="bi me-2" width="40" height="32" role="img"
						aria-label="Bootstrap">
						<use xlink:href="#bootstrap"></use></svg>
				</a>

				<form action="index.jsp" method="POST">
				<div class="ruota">
					<input type="image" src="logo.png" id="logo_margin" width="60%"
						height="55%" margin-left: 20px>
						</div>
				</form>

				<form action="index.jsp" method="POST">
					<input type="image" src="logo2.png" alt="logo" id="logo">
				</form>


				<div class="text-end" id="headerButton">
					<div class="dropdown">
						<button class="btn btn-outline-light me-2" id="socialBtnSmall">Social</button>
						<div class="dropdown-content">
							<ul
								class="dropdown-menu dropdown-menu-dark d-block position-static mx-0 border-0 shadow w-220px">
								<li><a
									class="dropdown-item d-flex gap-2 align-items-center"
									href="https://www.facebook.com"> <svg class="bi" width="16"
											height="16">
											<use xlink:href="www.facebook.com"></use></svg> Facebook
								</a></li>
								<li><a
									class="dropdown-item d-flex gap-2 align-items-center"
									href="https://www.instagram.com"> <svg class="bi"
											width="16" height="16">
											<use xlink:href="#https://www.instagram.com"></use></svg> Instagram
								</a></li>
								<li><a
									class="dropdown-item d-flex gap-2 align-items-center"
									href="https://www.twitter.com"> <svg class="bi" width="16"
											height="16">
											<use xlink:href="#https://www.twitter.com"></use></svg> Twitter
								</a></li>
							</ul>
						</div>
					</div>
					<button type="button" class="btn btn-outline-light me-2"
						id="loginBtnSmall" onclick="window.location.href='login.jsp'">Login</button>
					<button type="button" class="btn btn-warning" id="registerBtnSmall"
						onclick="window.location.href='register.jsp'">Registrati</button>
				</div>
			</div>
		</div>

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark"
			aria-label="Tenth navbar example">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarsExample08"
					aria-controls="navbarsExample08" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-md-center"
					id="navbarsExample08">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="Catalogo.jsp">Catalogo</a></li>
						<li class="nav-item"><a class="nav-link"
							href="Preferiti.jsp">Preferiti</a></li>
						<li class="nav-item"><a class="nav-link"
							href="Profilo.jsp">Profilo</a></li>
						<li class="nav-item"><a class="nav-link"
							href="RicaricaTessera.jsp">Saldo</a></li>
						<li class="nav-item"><a class="nav-link"
							href="Carrello.jsp">Carrello</a></li>
					</ul>
				</div>
			</div>
		</nav>


	</header>

</body>
</html>