<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.ico">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/styleH.css">
<link rel="stylesheet" href="css/styles.css">
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
<meta charset="ISO-8859-1">
<title>Ordini</title>
</head>
<body class="text-center" id="corpoWhite">

  <%String email = (String) session.getAttribute("emailutente");
    String name = (String) session.getAttribute("name");
    Boolean Mancante = (Boolean) session.getAttribute("mancante");
    Boolean role = (Boolean) session.getAttribute("adminRoles");
    session.setAttribute("emailutente", email);
	session.setAttribute("adminRoles", role);
   if (email == null) { %>
  <jsp:include page="headerUtente.jsp"></jsp:include>

  <% } 
   else if(role == Boolean.TRUE)
   {%>
  <jsp:include page="headerAdmin.jsp"></jsp:include>
  <% }
   else { %>
  <jsp:include page="headerUtente.jsp"></jsp:include>
  <%} %>

<%if(Mancante==Boolean.TRUE){ %>
 <div id="formdivAlto"><h3>Uno dei Tuoi Prodotti non � disponibile!</h3></div>
 <label> <a href="CartServlet" id="purpleLink"> Rimuovilo</a>
  </label>
 <%} else { %>

  <%Ordine o = (Ordine) request.getAttribute("o");%>


  <div id="formdivAlto"><h3>Il tuo Saldo � insufficiente!</h3></div>

  <label> <a href="RicaricaSaldo.jsp" id="purpleLink"> Ricarica Subito!</a>
  </label>
<% }%>




  <div id="footerposOrdEff">
    <jsp:include page="footer.html"></jsp:include>
  </div>

</body>
</html>