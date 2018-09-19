<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection Form</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form method="post" action="ConnectionCheck">
		<p>
			<label for="pseudo">Pseudo: </label> <input required type="text"
				name="pseudo" id="pseudo" />
		</p>
		<p>
			<label for="mdp">MdP: </label> <input required type="password"
				name="mdp" id="mdp" />
		</p>
		<p>
			<button type="submit">Valider</button>
		</p>
	</form>

	<p>
		<c:out value="${ status }">Bienvenue!</c:out>
	</p>

	<p>
		Pas encore membre? <a href="singUpForm.jsp">Inscription</a>
</body>
</html>