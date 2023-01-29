<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList, model.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="logo.ico">

<link rel="stylesheet" href="css/catalogo.css">

<meta charset="ISO-8859-1">
<title>Risultato ricerca</title>
</head>
<body>
    <%String emailutente = (String) session.getAttribute("emailutente");
      String name = (String) session.getAttribute("name");
      Boolean role = (Boolean) session.getAttribute("adminRoles");
      session.setAttribute("emailutente",emailutente);
      
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


                
                

    <section class="container" id=container2>
    <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Menu Del Giorno</h2>
        <div class="row">
        <%ArrayList<Prodotto> p = (ArrayList<Prodotto>) request.getAttribute("array");
                  int i = 0;
                  while(i < p.size()){%>
            <div
                class="col">
                
                
					                
					  <div class="container" >
					  <div class="card h-100" style="width: 18rem;">
					    <div class="fw-bolder text-center">
					      <h5><%=p.get(i).getNome()%></h5>
					    </div>
					    <%if (emailutente  != null) { %>
					    <a class="btn btn-outline-warning"
									href="AddToCartServlet?pcode=<%=p.get(i).getIdprodotto()%>&emailutente=<%=emailutente%>">
									Aggiungi al carrello</a><% } %>   <%System.out.println("sono nela jsp e l'id prodotto è:"+p.get(i).getIdprodotto()); %>
					     </div>
					     
					</div>
					               
                    
                    
                    
                    
                </div>
                <%i++;
                }%>
                </div>
        </div>
    </section>
    
    <jsp:include page="footer.html"></jsp:include>

   
</body>
</html>