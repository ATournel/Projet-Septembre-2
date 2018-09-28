<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>

	<div class="wrapper">
		<div class="container headerFull">
			<div class="row justify-content-md-center">
				<div class="col">
					<img src="images/LogoMakr_15OHZR.png" class="logo">
				</div>
			</div>
			<div class="row justify-content-md-center">
				<div class="col headerCol">
					<h1 class="headerTitre">Vous cherchez un évenement?</h1>
					<form action="EventsPage" method="post">
						<input type="text" name="eventNameSearch"
							placeholder="Evenement.."> <select name="categorie"
							class="search-bar">
							<option></option>
							<option>Atelier Coworking</option>
							<option>Hackathon</option>
							<option>Tech</option>
							<option>Fooding</option>
						</select> <input type="submit" class="search-icon" value="Trouver">
					</form>
				</div>
			</div>
			<div class="row justify-content-md-center">
				<div class="col">
					<form action="HomePage">
						<button type="submit" class="btn btn-outline-primary">Accueil</button>
					</form>
				</div>
				<div class="col">
					<form action="EventsPage">
						<Button type="submit" class="btn btn-outline-primary">Tous
							les évenements</Button>
					</form>
				</div>
				<div class="col">
					<c:choose>
						<c:when test="${ not empty sessionScope.isConnected }">
							<form action="UserProfil" method="post">
								<button type="submit" class="btn btn-outline-primary">Profil</button>
							</form>

						</c:when>
						<c:otherwise>
							<a class="btn btn-outline-primary" href="connectionForm.jsp"
								role="button">Connexion</a>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col">
					<c:choose>
						<c:when test="${ not empty sessionScope.isConnected }">

							<form action="Deco" method="post">
								<button type="submit" class="btn btn-outline-primary">Déconnexion</button>
							</form>

						</c:when>
						<c:otherwise>
							<a class="btn btn-outline-primary" href="singUpForm.jsp"
								role="button"> Inscription</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>




</body>
</html>