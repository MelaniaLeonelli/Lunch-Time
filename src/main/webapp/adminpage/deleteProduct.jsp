<!DOCTYPE html>
<html>
<head>
<%@page
	import="java.util.ArrayList, java.text.DecimalFormat, model.*, java.util.*"%>
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
<link rel="icon" type="image/x-icon" href="../icona.ico">
<link rel="icon" type="image/x-icon" href="../logo.png">
<link rel="stylesheet" href="../css/styleH.css">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/dropdown.css">
<meta charset="ISO-8859-1">
<title>Elimina prodotto</title>
</head>
<body class="text-center" id="corpo">
     <%String email = (String) session.getAttribute("emailutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	   session.setAttribute("emailutente", email);
	  session.setAttribute("adminRoles", role); %>

	<jsp:include page="headerAdminPage.jsp"></jsp:include>

	<main class="form-signin w-100 m-auto">
		<h1 class="h3 mb-3 fw-normal">Elimina un prodotto</h1>

		<label for="products">Scegli un prodotto:</label> <br>
		<br> <select name="products" id="products">
			<%ProdottoDAO pDAO = new ProdottoDAO();%>
			<%ArrayList<String> s = pDAO.getProductCodes();
  	int i = 0;%>
			<%while(i < s.size()){
	  Collections.sort(s);%>
			<option value="<%=s.get(i)%>"><%=s.get(i)%></option>
			<%i++;
  }%>
		</select> <br>
		<br>
		<button class="ottieni" onclick="Ottieni();">Elimina</button>

		<script>
	function Ottieni() {
	 	var UserOption = document.getElementById('products').value;
	 	document.location.href="/LunchTime/RemoveFromDBServlet?pcode="+UserOption;
		}
</script>

	</main>
	<jsp:include page="adminFooter.html"></jsp:include>
</body>
</html>