<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiche Event</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="ficheEvent">
		<h1>
			<c:out value="${ detailedEvent.getNom() }" />
		</h1>
		<h3>
			Du
			<c:out value="${ detailedEvent.getDateDebutEvenement() }" />
			au
			<c:out value="${ detailedEvent.getDateFinEvenement() }" />
			, de
			<c:out value="${ detailedEvent.getHeureDebutEvenement() }" />
			à
			<c:out value="${ detailedEvent.getHeurefinEvenement() }" />
			.
		</h3>
		<h3>
			Créé par
			<c:out value="${ detailedEvent.getPseudoCreateur() }" />
			.
		</h3>
	</div>
</body>
</html>