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
<title>Il Tuo Profilo</title>
</head>
<body>

	<%String emailutente = (String) session.getAttribute("emailutente");
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	  Integer codicetessera = (Integer) session.getAttribute("codtessera");
	  Integer categoria = (Integer) session.getAttribute("cattessera");
	  Integer saldo = (Integer) session.getAttribute("saldo");
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

	

	<section class="w-auto p-3" style="background-color: #f4f5f7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white"
              style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
             <%if (role == Boolean.TRUE){ %>
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"
              alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
             <% } 
              else { %>
               <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava5-bg.webp"
               alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
              <% } %>
                
              <h5 style="color: #000000;">Il Tuo Nome:<span style="color: #804cdc;"><%=name%></span></h5>
              <% System.out.println(categoria);
              if (role == Boolean.TRUE){ %>
              <p style="color:#804cdc;"> Sei un Amministratore</p>
             
               <% } 
              else { %>
               <p style="color: #000000;">Sei un Utente</p>
            
              <% } %>
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-8">
              <div class="card-body p-4">
                <h6>Il Tuo Profilo</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted"><span stlye="color: #FFFF00;"><%=emailutente %></span></p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Categoria</h6>
                    <%if (categoria == 1){ %>
              <p style="color:000000;"> Sei Idoneo</p>
             
               <% } 
              else if(categoria == 2) { %>
               <p style="color: #000000;">Sei Non idoneo</p>
            
              <% } 
              else if(categoria == 3) { %>
               <p style="color: #000000;">Sei Beneficiario!</p>
            
              <% } %>
                </div>
                <h6>Le Tue Informazioni Tessera</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Codice Tessera</h6>
                    <p class="text-muted"><span stlye="color: #FFFF00;"><%=codicetessera %></span></p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Saldo Attuale</h6>
                    <p class="text-muted"><span stlye="color: #FFFF00;"><%=saldo %> Euro</span></p>
                    <%if(saldo == 0){
                    	%>
                    	<a class="text-muted" href="saldo.jsp">Sarà meglio ricaricare!</a>
                    <%} %>
                  </div>
                </div>
                <div class="d-flex justify-content-start">
                  <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                  <a class="lunchtime btn btn-outline-dark mt-auto "
				href="OrderUtenteServlet">Cronologia ordini</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
</section>
	<jsp:include page="footer.html"></jsp:include>

	
</body>
</html>
