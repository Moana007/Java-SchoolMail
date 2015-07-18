<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(request.getAttribute("state") != null){ %>	
		<% String state = request.getAttribute("state").toString(); %>
		<% if(state.equals("inscription")){ %>
			<p>Vous êtes bien inscrit !</p>
		<% } %>		
	<% } %>

	<h1>Bienvenue sur votre SchoolMail <%= session.getAttribute("user_login") %> !</h1>


	<form method='POST' action='/SchoolMail-projet/Gestion_liste'>
		<input type='submit' name='gestion_liste' value='Gestion des listes' />
	</form>
	
	<form method='POST' action=''>
		<input type='submit' name='creer_contact' value='Créer un nouveau contact ' />
	</form>
	
	<form method='POST' action=''>
		<input type='submit' name='creer_liste' value=' Créer une liste' />
	</form>
	
	<form method='POST' action=''>
		<input type='submit' name='envoi_mail' value='Envoyer un mail' />
	</form>

	
	<br><br>
	<form method='POST' action='logout'>
		<input type='submit' name='logout' value='LogOut' />
	</form>

</body>
</html>