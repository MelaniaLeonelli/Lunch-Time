<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="searchbar">

	<form action="SearchServlet" method="post" id="searchBar">
		<input type="text" onblur="hideSearchResult()" autocomplete="off"
			id="ajaxsearch"
			class="form-control form-control-dark text-white bg-dark"
			placeholder="Cerca..." name="cerca">
		<div id="searchResult" style="display: none;"></div>
	</form>

	<%String email = (String) session.getAttribute("emailutente");
	
	
	 %>
</div>