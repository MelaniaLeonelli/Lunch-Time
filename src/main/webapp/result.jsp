<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/styleH.css">
<link rel="stylesheet" href="css/styles.css">
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
	<%String emailutente = (String) session.getAttribute("emailutente");
	  String nomeutente = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	 if (emailutente == null) { %>
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

	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<%ArrayList<Prodotto> p = (ArrayList<Prodotto>) request.getAttribute("name");
	  			int i = 0;
	  			while(i < p.size()){%>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=p.get(i).getImmagine()%>"
							alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=p.get(i).getNome() + " " + p.get(i).getDescrizione()%></h5>
								<!-- Product price-->
								$<%=p.get(i).getPrezzo()%>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="ProductPageServlet?pcode=<%=p.get(i).getIdprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<%i++;
                }%>

				<%ArrayList<Prodotto> pb = (ArrayList<Prodotto>) request.getAttribute("categoria");
	  			i = 0;
	  			while(i < pb.size()){%>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="<%=pb.get(i).getImmagine()%>"
							alt="...">
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder"><%=pb.get(i).getNome() + " " + pb.get(i).getDescrizione()%></h5>
								<!-- Product price-->
								$<%=pb.get(i).getPrezzo()%>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto"
									href="ProductPageServlet?pcode=<%=pb.get(i).getIdprodotto()%>">Visualizza
									prodotto</a>
							</div>
						</div>
					</div>
				</div>
				<%i++;
                }%>
			</div>
		</div>
	</section>

	<jsp:include page="footer.html"></jsp:include>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>
</body>
</html>