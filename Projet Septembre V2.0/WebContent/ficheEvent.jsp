<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiche Event</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="Style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<button id="myBtn">Yo</button>
<!--
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

	<script>
		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function() {
			scrollFunction()
		};

		function scrollFunction() {
			if (document.body.scrollTop > 20
					|| document.documentElement.scrollTop > 20) {
				document.getElementById("myBtn").style.display = "block";
			} else {
				document.getElementById("myBtn").style.display = "none";
			}
		}

		// When the user clicks on the button, scroll to the top of the document
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
	</script>
-->
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



		<form action="OtherProfil" method="post">
			<input type="hidden" name="otherUserPseudo"
				value="${ detailedEvent.getPseudoCreateur() }"> <label
				for="otherUser">Créé par </label>
			<button type="submit" name="otherUser">${ detailedEvent.getPseudoCreateur() }</button>
		</form>

		<p>
			<c:out value="${ detailedEvent.getDescription() }" />
		</p>

	</div>
</body>
</html>