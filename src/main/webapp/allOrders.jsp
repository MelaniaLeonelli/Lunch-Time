<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icona.ico">
<link rel="stylesheet" href="css/dropdown.css">
<link rel="stylesheet" href="css/ordersStyle.css">
<link rel="stylesheet" href="css/styleH.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
<body>
	<%String email = (String) session.getAttribute("email");
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

	<jsp:include page="searchbar.jsp"></jsp:include>

	<%ArrayList<Ordine> or = (ArrayList<Ordine>) request.getAttribute("orders");%>
	<%if(or.size() == 0)
	%><h2>Non è stato effettuato ancora alcun ordine.</h2>
	<%;%>
	<div class="container-xl">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-4">
							<h2>
								Dettagli <b>ordini</b>
							</h2>
						</div>
					</div>
				</div>
				<%int i = 0;
	  while(i < or.size()){%>

				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Data</th>
							<th>Ora</th>
							<th>Eseguito da</th>
							<th>Visualizza dettagli</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=or.get(i).getCodordine()%></td>
							<td><%=or.get(i).getData()%></td>
							<td><%=or.get(i).getEmailutente()%></td>
							<td><a
								href="DetailsServlet?orderCode=<%=or.get(i).getCodordine()%>"
								class="view" title="Visualizza dettagli ordine"><i
									class="material-icons">&#xE5C8;</i></a></td>
						</tr>
					</tbody>
				</table>

				<%i++;}%>
			</div>
		</div>
	</div>
	<jsp:include page="footer.html"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="js/ajaxsearch.js"></script>
</body>
</html>