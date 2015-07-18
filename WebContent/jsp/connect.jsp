<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel='stylesheet' href='/SchoolMail-projet/css/style.css' type='text/css' media='screen' />
	<link href="/SchoolMail-projet/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="col-md-4">
		<h1>SchoolMail</h1>
		<br>
	
		<!-- POP-UP ALERTE FORMULAIRE -->
		<% if(request.getAttribute("state") != null){ %>	
			<% String state = request.getAttribute("state").toString(); %>
			<% if(state.equals("champ_vide")){ %>
				<p>Merci de renseigner tous les champs</p>
			<% } else if(state.equals("deco")) { %>
				<p>Vous êtes bien déconnecté.<br>Merci et à bientôt !</p>
			<% } else if(state.equals("mauvais_identifiants")) { %>
				<p>Erreur d'identification : Mauvais mot de passe ou nom.</p>
			<% } else if(state.equals("mdp_differents")) { %>
				<p>Les mots de passes ne correspondent pas.</p>
			<% } else if(state.equals("mail_format")) { %>
				<p>Ce mail n'est pas valide.</p>
			<% } else if(state.equals("trop_court")) { %>
				<p>Champ trop court : minimum 4 caractères</p>
			<% } %>
		<% } %>
	
		<h2>Connexion</h2>
	<!-- 	<form enctype='application/x-www-form-urlencoded' action='/SchoolMail-projet/home' method='POST'> -->
	<!-- 		<label>Nom : <input type='text' name='nom'/></label><br/> -->
	<!-- 		<label>Mot de passe : <input type='password' name='mdp'/></label><br/> -->
	<!-- 		<input type='hidden' name='form' value="connexion"/> -->
	<!-- 		<input type='submit' value='Se connecter'/> -->
	<!-- 	</form> -->
		
		<form class="col-md-6" enctype='application/x-www-form-urlencoded' action='/SchoolMail-projet/home' method='POST'>
			<div class="form-group">
				<label for="exampleInputName">Login</label>
				<input type="text" class="form-control" name='nom' id="exampleInputName" placeholder="Login">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword">Mot de passe</label>
				<input type="password" class="form-control" name='mdp' id="exampleInputPassword" placeholder="Mot de passe">
			</div>
			<input type='hidden' name='form' value="connexion"/>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	
	</div>
	
	<br><br><br>
	<h2>Inscription</h2>
	<form enctype='application/x-www-form-urlencoded' action='/SchoolMail-projet/home' method='POST'>
		<label>Nom : <input type='text' name='nom'/></label><br/>
		<label>Mot de passe : <input type='password' name='mdp'/></label><br/>
		<label>Confirmer le mot de passe :<input type='password' name='mdp2'/></label><br/>

		<input type="radio" name="role" value="Directeur" checked>Directeur<br>
		<input type="radio" name="role" value="APEL">APEL<br>
		<input type="radio" name="role" value="Professeur">Professeur<br>
		<input type="radio" name="role" value="Administration">Administration<br>

		<input type='hidden' name='form' value="inscription"/>
		<input type='submit' value="S'inscrire"/>
	</form>
		
		

	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="/SchoolMail-projet/css/bootstrap/js/bootstrap.min.js"></script>
		
</body>
</html>