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
<title>Prodotto aggiunto ai preferiti!</title>
</head>
<body class="text-center" id="corpo">

  <%String emailutente = (String) session.getAttribute("emailutente");
     Boolean esiste = (Boolean) session.getAttribute("esistente");
      String name = (String) session.getAttribute("name");
      Boolean role = (Boolean) session.getAttribute("adminRoles");
      session.setAttribute("emailutente",emailutente);
      %>
     
    <jsp:include page="../headerAdmin.jsp"></jsp:include>
    
    
      <h1 class="h3 mb-3 fw-normal" id="registerEff">Prodotto Rimosso Dal Catalogo :c
      </h1>
   
      <label> <a href="CatalogoServlet" id="loginLink"> Torna alla home</a>
      </label>
    
  <div id="footerposRegEff">
    <jsp:include page="adminFooter.html"></jsp:include>
  </div>

</body>
</html>