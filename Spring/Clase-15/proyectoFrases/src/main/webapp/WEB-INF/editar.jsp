<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Frase</title>
</head>
<body>
	<h1>FRASES</h1>
	<ul>
		<li><a href="/favoritos">Mis Favoritos</a></li>
		<li><a href="/frases">Todas las Frases</a></li>
		<li><a href="/form/agregar">Agregar Frase</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Editar Frase</h2>
	<form:form action="/actualizar/${frase.id}" method="POST" modelAttribute="frase">
		<input type="hidden" name="_method" value="PUT" />
	
		<form:label path="texto">Frase:</form:label>
		<form:input path="texto" type="text" />
		<form:errors path="texto"/>
		
		<form:label path="autor">Autor Original:</form:label>
		<form:input path="autor" type="text" />
		<form:errors path="autor"/>
		
		<form:label path="categoria">Categoría/Tema:</form:label>
		<form:input path="categoria" type="text" />
		<form:errors path="categoria"/>
		
		<form:label path="idioma">Idioma:</form:label>
		<form:input path="idioma" type="text" />
		<form:errors path="idioma"/>
		
		<input type="hidden" value="${idUsuario}" name="creador" />

		<input type="submit" value="Editar" />		
	</form:form>
</body>
</html>