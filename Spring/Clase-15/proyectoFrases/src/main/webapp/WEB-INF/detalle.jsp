<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle de Frase</title>
</head>
<body>
	<h1>FRASES</h1>
	<ul>
		<li><a href="/favoritos">Mis Favoritos</a></li>
		<li><a href="/frases">Todas las Frases</a></li>
		<li><a href="/form/agregar">Agregar Frase</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Detalle de Frase</h2>
	<h3>${frase.texto}</h3>
	<ul>
		<li>Autor Original: ${frase.autor}</li>
		<li>Categoria/Tema: ${frase.categoria}</li>
		<li>Idioma: ${frase.idioma}</li>
		<li>Creador: ${frase.creador.nombre} ${frase.creador.apellido}</li>
	</ul>
	<form:form action="/eliminar/${frase.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<button>Eliminar Frase</button>
	</form:form>
</body>
</html>