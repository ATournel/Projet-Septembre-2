<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>

	<ul>
		<li><a href="home.jsp">Accueil</a></li>
		<li>Logo</li>
		<c:choose>
			<c:when test="${ not empty sessionScope.isConnected }">
				<li><form action="UserProfil" method="post">
						<button type="submit">Profil</button>
					</form></li>
				<li>
					<form action="Deco" method="post">
						<button type="submit">Déconnexion</button>
					</form>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="connectionForm.jsp">Connexion</a> - <a
					href="singUpForm.jsp"> Inscription</a></li>
			</c:otherwise>
		</c:choose>
		</li>
	</ul>

</body>
</html>