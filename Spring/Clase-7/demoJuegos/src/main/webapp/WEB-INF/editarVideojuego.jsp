<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Videojuego</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>Editar Videojuego:</h1>
	<form:form action="/api/actualizar" method="POST" modelAttribute="videojuego">
		<input type="hidden" name="_method" value="PUT"/>
		
		<input type="hidden" name="id" value="${videojuego.id}"/>
	
		<form:label path="nombre">Nombre:</form:label> 
		<form:input type="text" path="nombre"/>
		<form:errors path="nombre"/>

		<form:label path="descripcion">Descripción:</form:label>
		<form:textarea path="descripcion"></form:textarea>
		<form:errors path="descripcion"/>

		<form:label path="portada">Portada:</form:label> 
		<form:input type="text" path="portada"/>
		<form:errors path="portada"/>

		<form:label path="fecha_lanzamiento">Fecha Lanzamiento:</form:label> 
		<form:input type="text" path="fecha_lanzamiento"/> 
		<form:errors path="fecha_lanzamiento"/>
		
		<form:label path="rating">Rating:</form:label>
		<form:input type="number" path="rating" step="0.1"/>
		<form:errors path="rating"/>

		<form:label path="generos">Géneros:</form:label> 
		<form:select path="generos" multiple="true">
			<option>Adventure</option>
			<option>Action</option>
			<option>Indie</option>
			<option>Shooter</option>
		</form:select> 
		<form:errors path="generos"/>
		
		<form:label path="plataformas">Plataformas:</form:label> 
		<form:select path="plataformas" multiple="true">
			<option>PC</option>
			<option>PlayStation</option>
			<option>Xbox</option>
			<option>Nintendo</option>
		</form:select> 
		<form:errors path="plataformas"/>
		
		<input type="hidden" name="creador" value="${usuario.id}"/>
		
		<input type="submit" value="Editar Juego">
	</form:form>
	<a href="/api/getGames">Volver</a>
</body>
</html>