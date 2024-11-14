<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Videojuegos</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="nav">
		<h3>¡Bienvenido ${nombreCompletoUsuario}!</h3>	
		<c:if test="${miVideojuego == null}">		
			<a href="/api/form/agregar">Crear Juego</a>
		</c:if>
		<a href="/logout">Salir</a>
	</div>
	<div class="content">
	<div class="vPlataforma">
	<h1>Videojuegos en Plataforma</h1>
	<ul class="videojuegos">
		<c:forEach var="juego" items="${videojuegos}">
			<li>
				<img src="${juego.portada}"/>
				<h3>${juego.nombre}</h3>
				<a href="/api/detalle/${juego.id}?fuente=api">Detalles</a>
			</li>
		</c:forEach>
	</ul>
	</div>
	<div class="vComunidad">
	<h1>Videojuegos de la Comunidad</h1>
	<ul class="videojuegos">
		<c:forEach var="jueguito" items="${videojuegosComunidad}">
			<li>
			<img src="
				<c:if test="${jueguito.portada != null}">
					${jueguito.portada}
				</c:if>
				<c:if test="${jueguito.portada == ''}">
					 https://t3.ftcdn.net/jpg/04/84/88/76/360_F_484887682_Mx57wpHG4lKrPAG0y7Q8Q7bJ952J3TTO.jpg
				</c:if>
			"/>
			<h3>${jueguito.nombre}</h3>
			<a href="/api/detalle/${jueguito.id}?fuente=db">Detalles</a>
			</li>
		</c:forEach>
	</ul>
	<c:if test="${miVideojuego != null}">
		<h1>Mi Videojuego</h1>
		<ul class="videojuegos">
			<li>
			<img src="
				<c:if test="${miVideojuego.portada != null}">
					${miVideojuego.portada}
				</c:if>
				<c:if test="${miVideojuego.portada == ''}">
					 https://t3.ftcdn.net/jpg/04/84/88/76/360_F_484887682_Mx57wpHG4lKrPAG0y7Q8Q7bJ952J3TTO.jpg
				</c:if>
			"/>
			<h3>${miVideojuego.nombre}</h3>
			<a href="/api/detalle/${miVideojuego.id}?fuente=db">Detalles</a>
			<a href="/api/form/editar/${miVideojuego.id}">Editar</a>
			<form action="/api/eliminar/${miVideojuego.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE"/>
				<button>Eliminar</button>
			</form>
			</li>
		</ul>
	</c:if>
	</div>
	</div>
</body>
</html>