<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Favoritos</title>
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
	<h2>Mis Favoritos</h2>
	<table border="1">
	<thead>
		<th>Frase Motivacional</th>
		<th>Detalle</th>
		<th>Modificar</th>
		<th>Me Gusta</th>
	</thead>
	<tbody>
		<c:forEach var="frase" items="${favsUsuario}">
			<tr>
				<td>${frase.texto}</td>
				<td><a href="/detalle/${frase.id}">Ver</a></td>
				<td>
					<c:if test="${frase.creador.id == idUsuario}">
						<a href="/form/editar/${frase.id}">Editar</a>
					</c:if>
				</td>
				<td>
					<form:form action="/quitarFav/${frase.id}" method="POST">
						<input type="hidden" name="_method" value="DELETE"/>
						<button style="font-size: 27px">&#9829;</button>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>