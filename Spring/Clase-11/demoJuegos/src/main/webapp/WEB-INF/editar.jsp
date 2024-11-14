<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
	<%@ page isErrorPage="true" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Videojuego</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>Editar Videojuego</h1>
	<form:form action="/api/actualizar" method="POST" modelAttribute="videojuego">
		<input type="hidden" name="_method" value="PUT"/>
	
		<input type="hidden" value="${videojuego.id}" name="id"/>
	
		<form:label path="nombre">Nombre:</form:label> 
		<form:input type="text" path="nombre"/>
		<form:errors class="error" path="nombre"/>

		<form:label path="descripcion">Descripción:</form:label>
		<form:textarea path="descripcion"></form:textarea>
		<form:errors class="error" path="descripcion"/>

		<form:label path="portada">Portada:</form:label> 
		<form:input type="text" path="portada"/>
		<form:errors class="error" path="portada"/>

		<form:label path="fecha_lanzamiento">Fecha Lanzamiento:</form:label> 
		<form:input type="date" path="fecha_lanzamiento" value="${videojuego.fecha_lanzamiento}" /> 
		<form:errors class="error" path="fecha_lanzamiento"/>
		
		<form:label path="rating">Rating:</form:label>
		<form:input type="number" path="rating" step="0.1"/>
		<form:errors class="error" path="rating"/>

		<form:label path="generos">Géneros:</form:label> 
		<form:select path="generos" multiple="true">
			<c:forEach var="genero" items="${generos}">
				<option value="${genero.id}"
					 <c:forEach var="g" items="${videojuego.generos}">
                            <c:if test="${g.id == genero.id}">selected</c:if>
                     </c:forEach>
				>${genero.nombre}</option>
			</c:forEach>
		</form:select> 
		<form:errors class="error" path="generos"/>
		
		<form:label path="plataformas">Plataformas:</form:label> 
		<form:select path="plataformas" multiple="true">
			<c:forEach var="plataforma" items="${plataformas}">
				<option value="${plataforma.id}"
					<c:forEach var="p" items="${videojuego.plataformas}">
                            <c:if test="${p.id == plataforma.id}">selected</c:if>
                    </c:forEach>
				>${plataforma.nombre}</option>
			</c:forEach>
		</form:select> 
		<form:errors class="error" path="plataformas"/>
		
		<input type="hidden" value="${idUsuario}" name="creador"/>
		
		<input type="submit" value="Editar Juego"/>
	</form:form>
	<a href="/api/getGames">Volver</a>
</body>
</html>