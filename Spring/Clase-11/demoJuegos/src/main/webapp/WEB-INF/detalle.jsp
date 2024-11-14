<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Videojuego</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div id="detalle">
	<div>
	<img src="${videojuego.portada}"/>
	<div>
	<h1>${videojuego.nombre}</h1>
	<ul>
		<li>Rating: &#160;&#160;<b>${videojuego.rating}</b> <span>&#9733;</span></li>
		<li>Fecha Lanzamiento: &#160;&#160;<b>${videojuego.fecha_lanzamiento}</b></li>
		<li>Géneros: 
			<ol>
				<c:forEach var="genero" items="${videojuego.generos}">
					<li class="gen ${genero.nombre}">${genero.nombre}</li>
				</c:forEach>
			</ol>
		</li>
		<li>Plataformas: 
			<ol>
				<c:forEach var="plataforma" items="${videojuego.plataformas}">
					<li class="plat">${plataforma.nombre}</li>
				</c:forEach>
			</ol>
		</li>
		<c:if test="${fuente == 'db'}">
			<li>Creador: <b>${videojuego.creador.nombre}</b></li>
		</c:if>
	</ul>
	</div>
	</div>
	<p>${videojuego.descripcion}</p>
	<c:if test="${fn:length(videojuego.comentarios) > 0}">
	<h4>Reseñas:</h4>
	<ul class="resenas">
		<c:forEach var="comentario" items="${videojuego.comentarios}">
			<li>${comentario.mensaje}</li>
		</c:forEach>
	</ul>
	</c:if>
	
	<c:if test="${fuente == 'db'}">
		<form:form action="/api/comentar/${videojuego.id}" method="POST" modelAttribute="comentario">
			<input type="hidden" value="${videojuego.id}" name="videojuego"/>
			<form:label path="mensaje">Escribe tu reseña:</form:label>
			<form:textarea path="mensaje"></form:textarea>
			<form:errors path="mensaje"/>
			<input type="submit" value="Enviar"/>			
		</form:form>
	</c:if>
	<a href="/api/getGames">Volver</a>
</div>
</body>
</html>