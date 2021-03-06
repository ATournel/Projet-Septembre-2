<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>
		Bienvenue
		<c:out value="${ sessionScope.pseudo }"></c:out>
		!
	</h1>

	<c:choose>
		<c:when test="${ not empty sessionScope.userImage }">
			<img src="${ sessionScope.userImage }">
			<p>
				<a href="addProfilPicForm.jsp">Modifier la photo!</a>
			</p>
		</c:when>
		<c:otherwise>
			<img src="images/ghost_person.png">
			<p>
				<a href="addProfilPicForm.jsp">Ajouter une photo!</a>
			</p>
		</c:otherwise>
	</c:choose>
	<h2>
		<c:out value="${ sessionScope.prenom }" />
		<c:out value="${ sessionScope.nom }" />
	</h2>

	<h3>
		<c:out value="${ sessionScope.mail }" />
	</h3>
</body>
</html>