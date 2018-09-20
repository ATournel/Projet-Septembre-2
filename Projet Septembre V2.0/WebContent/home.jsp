<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="eventList">
		<c:forEach items="${ EventList }" var="event">
			<div class="events">
				<h3>
					<c:out value="${ event.getNom() }" />
				</h3>
				<p>
					Le
					<c:out value="${ event.getDateDebutEvenement() }" />
					à
					<c:out value="${ event.getLieu() }" />
					.
				</p>
				<form action="EventDetail" method="post">
					<input type="hidden" name="idEvent"
						value="${ event.getId_evenement() }">
					<button type="submit">Voir les détails</button>
				</form>
			</div>
		</c:forEach>
	</div>

	<a href="EventsPage">Plus d'évenements...</a>
</body>
</html>