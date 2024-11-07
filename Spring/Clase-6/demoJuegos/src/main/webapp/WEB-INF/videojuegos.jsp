<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videojuegos</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h3>¡Bienvenido/a ${usuario.nombre}!</h3>
	<h1>Videojuegos en Plataforma:</h1>
	<ul>
		<c:forEach var="juego" items="${videojuegos}">
			<li>Nombre: <b>${juego.nombre}</b>, Fecha de Lanzamiento: <b>${juego.fecha_lanzamiento}</b>,
				<a href="/api/detalle/${juego.id}?fuente=api">Detalles</a></li>
		</c:forEach>
	</ul>
	<h1>Videojuegos de la Comunidad:</h1>
	<ul>
		<c:forEach var="jueguito" items="${videojuegosComunidad}">
			<li>Nombre: <b>${jueguito.nombre}</b>, Fecha de Lanzamiento: <b>${jueguito.fecha_lanzamiento}</b>,
				<a href="/api/detalle/${jueguito.id}?fuente=db">Detalles</a></li>
		</c:forEach>
	</ul>
	<a href="/api/form/agregar">Crear Juego</a>
	<a href="/">Salir</a>
</body>
</html>