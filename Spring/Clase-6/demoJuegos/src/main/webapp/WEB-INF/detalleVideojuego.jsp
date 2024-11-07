<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Videojuego</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>${videojuego.nombre}</h1>
	<ul>
		<li>Fecha Lanzamiento: <b>${videojuego.fecha_lanzamiento}</b></li>
		<li>Rating: <b>${videojuego.rating}</b></li>
		<li>Géneros: <b>${videojuego.generos}</b></li>
		<li>Plataformas: <b>${videojuego.plataformas}</b></li>
	</ul>
	<p>${videojuego.descripcion}</p>
	<a href="/api/getGames">Volver</a>
</body>
</html>