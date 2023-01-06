<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>HomePage</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="icona.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic?ts=<?=time()?>&quot" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/styleH.css">
    </head>
    <body>
        <!-- Navigation-->
      <%String email = (String) session.getAttribute("email");
	String cf = (String) session.getAttribute("cf");
	  String name = (String) session.getAttribute("name");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
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

        <!-- Masthead-->
        <header class="masthead bg-warning text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5" src="logo.png" alt="..."/>
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">LunchTime</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Logo e Nome-->
                <p class="masthead-subheading font-weight-light mb-0">Mensa Universitaria</p>
            </div>
        </header>
        <!-- Portfolio Section-->
        <section class="page-section portfolio" id="portfolio">
            <div class="container" >
                <!-- Menu del giorno Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Menu Del Giorno</h2>
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
        <br>
        <!-- About Section-->
        <section class="page-section bg-warning text-white mb-0" id="about">
            <div class="container">
                <!-- About Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-white">About</h2>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <br>
                <!-- About Section Content-->
                <div class="row">
                    <div class="col-lg-4 ms-auto"><p class="lead">LunchTime è una piattaforma web di gestione della mensa ed è dedicata particolarmente agli studenti universitari di Unisa. Il nome "LunchTime" è ispirato proprio al pranzo universitario.
					</p></div>
                    <div class="col-lg-4 me-auto"><p class="lead">Qui potrai visualizzare il tuo profilo, i prodotti della nostra mensa e acquistare online il tuo pranzo per poter saltare la fila!</p></div>
                   
                </div>
                <!-- About Section Button-->
                <div class="text-center mt-4">
                    <a class="btn btn-xl btn-outline-light" href="https://web.unisa.it/vivere-il-campus/servizi/residenze-mensa-e-punti-ristoro">
                        <i class="fas fa-mouse-pointer"></i>
                        Visita il sito ufficiale!
                    </a>
                </div>
            </div>
        </section>
        
        
        
        
       
                
                
                
                <jsp:include page="footer.html"></jsp:include>
                
                
                
        
        
       
               
        
        
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>