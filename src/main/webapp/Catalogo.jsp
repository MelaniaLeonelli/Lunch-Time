<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.ico">

<link rel="stylesheet" href="css/catalogo.css">
<link rel="stylesheet" href="css/dropdown.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


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
	  String name = (String) session.getAttribute("nomeutente");
	  Boolean role = (Boolean) session.getAttribute("adminRoles");
	  session.setAttribute("emailutente", emailutente);
	  session.setAttribute("adminRoles", role);
      
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

    <section class="container" id=container2>
        <div class="row">
        <%ArrayList<Prodotto> p = (ArrayList<Prodotto>) request.getAttribute("array");
                  int i = 0;
                  while(i < p.size()){%>
            <div
                class="col">
                
                
                          
            <div class="container" id=container2>
            <div class="row top-buffer">
              <div class="col">
                <h5><%=p.get(i).getNome()%></h5>
              </div>
              <div class="col">
               <%=p.get(i).getDescrizione()%>
              </div>
              <div class="col">
                euro <%=p.get(i).getPrezzo()%>
              </div>
              <div class="col">
               <a class="btn btn-outline-primary mt-auto product"
                     href="ProductPageServlet?pcode=<%=p.get(i).getIdprodotto()%>">Visualizza prodotto</a>
              </div>
              <div class="col">
             <a class="btn btn-outline-danger"
                     href="AddPreferitiServlet?pcode=<%=p.get(i).getIdprodotto()%>&emailutente=<%=emailutente%>"> Aggiungimi ai preferiti</a>
               
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