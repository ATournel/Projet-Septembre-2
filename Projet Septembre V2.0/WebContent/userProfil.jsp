<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil</title>
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
		</c:when>
		<c:otherwise>
			<img src="images/ghost_person.png">
			<p><a href="addProfilPicForm.jsp">Ajouter une photo!</a></p>
		</c:otherwise>
	</c:choose>

</body>
</html>