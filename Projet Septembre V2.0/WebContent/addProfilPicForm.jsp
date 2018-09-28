<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Profil Pic</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<h3>Ajouter une photo</h3>
	<form action="AddProfilPic" method="post">
	<input type="hidden" name="pseudo" value="${ sessionScope.pseudo }" id="pseudo">
		<label for="userPic">Url: </label> <input required type="text" name="userPic"
			id="userPic">
		<button type="submit">Ajouter</button>
	</form>
	<c:out value="${ wrongUrl }"></c:out>
</body>
</html>