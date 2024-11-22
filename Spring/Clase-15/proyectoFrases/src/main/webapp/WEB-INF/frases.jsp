<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FRASES</title>
</head>
<body>
	<h1>FRASES</h1>
	<ul>
		<li><a href="/favoritos">Mis Favoritos</a></li>
		<li><a href="/frases">Todas las Frases</a></li>
		<li><a href="/form/agregar">Agregar Frase</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>
	<table border="1">
	<thead>
		<th>Frase Motivacional</th>
		<th>Detalle</th>
		<th>Modificar</th>
		<th>Me Gusta</th>
	</thead>
	<tbody>
		<c:forEach var="frase" items="${frases}">
			<tr>
				<td>${frase.texto}</td>
				<td><a href="/detalle/${frase.id}">Ver</a></td>
				<td>
					<c:if test="${frase.creador.id == idUsuario}">
						<a href="/form/editar/${frase.id}">Editar</a>
					</c:if>
				</td>
				<td>
				<c:if test="${fn:length(favsUsuario) > 0}">				
					<c:forEach var="fraseUsuario" items="${favsUsuario}">
						<c:if test="${fraseUsuario.id == frase.id}">
							<form:form action="/quitarFav/${frase.id}" method="POST">
								<input type="hidden" name="_method" value="DELETE"/>
								<button style="font-size: 27px">&#9829;</button>
							</form:form>
						</c:if>
						<c:if test="${fraseUsuario.id != frase.id}">
							<form:form action="/agregarFav/${frase.id}" method="POST">
								<button style="font-size: 27px">&#9825;</button>
							</form:form>
						</c:if>
					</c:forEach>
				</c:if>
				<c:if test="${fn:length(favsUsuario) == 0}">
					<form:form action="/agregarFav/${frase.id}" method="POST">
						<button style="font-size: 27px">&#9825;</button>
					</form:form>
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>