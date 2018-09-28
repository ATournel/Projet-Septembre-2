<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<h2><c:out value="${ titre }" /></h2>
	
	<div class="eventList">
		<c:forEach items="${ EventPage }" var="event">
			<div class="events">
				<h3>
					<c:out value="${ event.getNom() }" />
				</h3>
				<p>
					Le
					<c:out value="${ event.getDateDebutEvenement() }" />
					à
					<c:out value="${ event.getLieu() }" />
				</p>
				<br /><br />
				<form action="EventDetail" method="post">
					<input type="hidden" name="idEvent"
						value="${ event.getId_evenement() }">
					<button type="submit">Voir les détails</button>
				</form>
			</div>
		</c:forEach>
	</div>
	
</body>
</html>