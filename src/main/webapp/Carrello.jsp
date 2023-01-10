<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, java.text.DecimalFormat, model.*"%>
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
<title>Carrello</title>
</head>
<body>

	<%String emailutente = (String) session.getAttribute("emailutente");
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("ruolo");
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

				<%ArrayList<Contiene> carrello = (ArrayList<Contiene>) request.getAttribute("emailutente");
	DecimalFormat decimalFormat = new DecimalFormat("#.##");
	ProdottoDAO pDAO = new ProdottoDAO();%>
				<%if(carrello.size() == 0)
	%><h3>
					Il carrello è vuoto<%;%>
					<%
		
	  int i = 0;
	  while(i < carrello.size()){%>
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top"
								src="<%=(pDAO.getProduct(carrello.get(i).getIdprodotto())).getImmagine()%>"
								alt="...">
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder"><%=(pDAO.getProduct(carrello.get(i).getIdprodotto())).getNome()%></h5>
									<!-- Product price-->
									$<%=(pDAO.getProduct(carrello.get(i).getIdprodotto())).getPrezzo()%>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto product"
										href="RemoveFromCartServlet?pcode=<%=carrello.get(i).getIdprodotto()%>&cf=<%=session.getAttribute("cf")%>">Rimuovi
										prodotto</a>
								</div>
							</div>
						</div>
					</div>
					<%i++;
                }%>
				
			</div>
		</div>
		<%ContieneDAO  cDAO = new ContieneDAO(); %>
		<% %>
		<%if(carrello.size() != 0){%>
		<p>
			Totale: $<%=decimalFormat.format(cDAO.getTotal((String)session.getAttribute("cf")))%>
			<%}; %>
		</p>
		<%if(carrello.size() != 0){%>
		<div class="text-center">
			<a class="wahwahButton btn btn-outline-dark mt-auto"
				href="ExecuteOrderServlet?cf=<%=session.getAttribute("cf")%>">Ordina</a>
		</div>
		<%}; %>
	</section>

	<jsp:include page="footer.html"></jsp:include>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>
</body>
</html>