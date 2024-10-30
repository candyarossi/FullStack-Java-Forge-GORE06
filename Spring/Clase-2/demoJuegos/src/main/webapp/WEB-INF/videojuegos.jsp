<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videojuegos</title>
</head>
<body>
	<h1>Videojuegos:</h1>
	<ul>
		<c:forEach var="juego" items="${videojuegos}">
			<li>Nombre: <b>${juego.nombre}</b>, Fecha de Lanzamiento: <b>${juego.fecha_lanzamiento}</b></li>
		</c:forEach>
	</ul>
</body>
</html>