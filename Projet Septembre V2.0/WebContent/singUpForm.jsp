<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="ConnectionCreate" method="post">
		<p>
			<label for="nom">Nom:</label> <input required type="text" name="nom" id="nom" />
		</p>
		<p>
			<label for="prenom">Prenom:</label> <input required type="text" name="prenom"
				id="prenom" />
		</p>
		<p>
			<label for="pseudo">Pseudo:</label> <input required type="text" name="pseudo"
				id="pseudo" />
		</p>
		<p>
			<label for="mail">Mail:</label> <input required type="text" name="mail"
				id="mail" />
		</p>
		<p>
			<label for="pass">Mot de Passe:</label> <input required type="password"
				name="pass" id="pass" />
		</p>
		<p>
			<button type="submit">Valider</button>
		</p>
	</form>

	<P>
		<c:out value="${ invalid }" />
	</P>

	<p>
		Déja membre? <a href="connectionForm.jsp">Connexion</a>
</body>
</html>