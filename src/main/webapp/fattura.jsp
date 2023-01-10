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
<title>Dettagli Ordine</title>
</head>
<body>

	<%String email = (String) session.getAttribute("emailutente");
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("ruolo");
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

	<jsp:include page="searchbar.jsp"></jsp:include>

	<%ArrayList<String> codes = (ArrayList<String>) request.getAttribute("codes");
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
    		Prodotto pr = new Prodotto();
    		ProdottoDAO pDAO = new ProdottoDAO();
    		AcquistoDAO aDAO = new AcquistoDAO();
    		Acquisto a = new Acquisto();
    		int ordCode = (Integer) request.getAttribute("or");
    		OrdineDAO orDAO = new OrdineDAO();
    		Ordine or = new Ordine();
    		Utente u = new Utente();
    		UtenteDAO uDAO = new UtenteDAO();
    		or = orDAO.getOrderByCode(ordCode);
    		String emailutenteAcquirente = or.getEmailutente();
    		u = uDAO.getUserByEmailutente(emailutenteAcquirente);
            int i = 0;
            double tot = 0.0;%>

	<section class="h-100 gradient-custom">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-10 col-xl-8">
					<div class="card" style="border-radius: 10px;">
						<div class="card-header px-4 py-5">
							<h5 class="text-muted mb-0">
								Ordine di <span style="color: #804cdc;"><%=u.getNomeutente()%>
									</span>
							</h5>
						</div>
						<div class="card-body p-4">
							<div
								class="d-flex justify-content-between align-items-center mb-4">
								<p class="lead fw-normal mb-0" style="color: #804cdc;">Dettagli
									Ordine</p>
							</div>

							<%while(i < codes.size()){%>
							<p style="display: none;" <%=pr = pDAO.getProduct(codes.get(i))%>>
								<%tot += aDAO.getPrezzo(ordCode, pr.getIdprodotto());%>
							
							<div class="card shadow-0 border mb-4">
								<div class="card-body">
									<div class="row">
										<div class="col-md-2">
											<img src="<%=pr.getImmagine() %>" class="img-fluid"
												alt="Phone">
										</div>
										<div
											class="col-md-2 text-center d-flex justify-content-center align-items-center">
											<p class="text-muted mb-0"><%=pr.getNome()%>
												<%=pr.getDescrizione() %></p>
										</div>
								
										<div
											class="col-md-2 text-center d-flex justify-content-center align-items-center">
											<p class="text-muted mb-0 small"><%=pr.getCategoria()%></p>
										</div>
										<div
											class="col-md-2 text-center d-flex justify-content-center align-items-center">
											<p class="text-muted mb-0 small"><%=pr.getIdprodotto()%></p>
										</div>
										<div
											class="col-md-2 text-center d-flex justify-content-center align-items-center">
											<p class="text-muted mb-0 small">
												$<%=aDAO.getPrezzo(ordCode, pr.getIdprodotto())%></p>
										</div>
									</div>
									<hr class="mb-4" style="background-color: #e0e0e0; opacity: 1;">
								</div>
							</div>

							<%i++;
                }%>

							<%double iva = tot * 0.22;%>

							<div class="d-flex justify-content-between pt-2">
								<p class="fw-bold mb-0" style="color: #804cdc;">Dettagli
									pagamento</p>
								<p class="text-muted mb-0">
									<span class="fw-bold me-4" style="color: #804cdc;">Totale
										Prodotti</span> $<%=decimalFormat.format(tot)%></p>
							</div>

							<div class="d-flex justify-content-between pt-2">
								<p class="text-muted mb-0">
									Numero Ordine:
									<%=or.getCodordine() %></p>
								<p class="text-muted mb-0">
									<span class="fw-bold me-4" style="color: #804cdc;">Sconto</span>
									$0.00
								</p>
							</div>

							<div class="d-flex justify-content-between">
								<p class="text-muted mb-0">
									Data Ordine :
									<%=or.getData()%></p>
								<p class="text-muted mb-0">
									<span class="fw-bold me-4" style="color: #804cdc;">IVA
										22%</span> $<%=decimalFormat.format(iva)%></p>
							</div>

						</div>
						<div class="card-footer border-0 px-4 py-5"
							style="background-color: #804cdc; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px;">
							<h5
								class="d-flex align-items-center justify-content-end text-white text-uppercase mb-0">
								Totale <span class="h2 mb-0 ms-2">$<%=decimalFormat.format(tot + iva)%></span>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="footer.html"></jsp:include>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>

</body>
</html>