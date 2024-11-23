<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle de Frase</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h1>FRASES</h1>
	<ul id="nav">
		<li><a href="/favoritos">Mis Favoritos</a></li>
		<li><a href="/frases">Todas las Frases</a></li>
		<li><a href="/form/agregar">Agregar Frase</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Detalle de Frase</h2>
	<h3>${frase.texto}</h3>
	<ul>
		<li><b>Autor Original:</b> ${frase.autor}</li>
		<li><b>Categoria/Tema:</b> ${frase.categoria}</li>
		<li><b>Idioma:</b> ${frase.idioma}</li>
		<li><b>Creador:</b> ${frase.creador.nombre} ${frase.creador.apellido}</li>
	</ul>
	<form:form action="/eliminar/${frase.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<button>Eliminar Frase</button>
	</form:form>
		<c:if test="${fn:length(frase.usuariosFavoritos) > 0}">
			<h4>Usuarios que le han dado Me Gusta:</h4>
			<ul>
				<c:forEach var="usuario" items="${frase.usuariosFavoritos}">
					<li>${usuario.nombre} ${usuario.apellido}</li>
				</c:forEach>
			</ul>
		</c:if>
</body>
</html>