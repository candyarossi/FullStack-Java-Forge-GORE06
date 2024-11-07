<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<li>Creador: <b>${videojuego.creador.email}</b></li>
	</ul>
	<p>${videojuego.descripcion}</p>
	<c:if test="${fn:length(videojuego.comentarios) > 0}">
		<h4>Comentarios:</h4>
		<ul>
			<c:forEach var="comentario" items="${videojuego.comentarios}">
				<li>${comentario.mensaje}</li>			
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${fuente == 'db'}">
		<form:form action="/api/comentar" method="POST" modelAttribute="comentario">
			<input type="hidden" name="videojuego" value="${videojuego.id}"/>
			<form:label path="mensaje">Escribe tu comentario aquí:</form:label>
			<form:textarea path="mensaje"/>
			<form:errors path="mensaje"/>
			<input type="submit" value="Enviar"/>
		</form:form>
	</c:if>
	<a href="/api/getGames">Volver</a>
</body>
</html>