<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="content">
	<form:form action="/register" method="POST" modelAttribute="usuario">
	<h2>Registrarse</h2>
		<form:label path="nombre">Nombre:</form:label> 
		<form:input type="text" path="nombre"/>
		<form:errors class="error" path="nombre"/>

		<form:label path="apellido">Apellido:</form:label>
		<form:input type="text" path="apellido"/>
		<form:errors class="error" path="apellido"/>

		<form:label path="email">Email:</form:label> 
		<form:input type="email" path="email"/>
		<form:errors class="error" path="email"/>

		<form:label path="password">Contraseña:</form:label> 
		<form:input type="password" path="password"/> 
		<form:errors class="error" path="password"/>
		
		<form:label path="confirmarPassword">Confirmar contraseña:</form:label> 
		<form:input type="password" path="confirmarPassword"/> 
		<form:errors class="error" path="confirmarPassword"/>
		
		<input type="submit" value="Registrarse">
	</form:form>
	
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">
	<h2>Iniciar Sesión</h2>
		<form:label path="email">Email:</form:label> 
		<form:input type="email" path="email"/>
		<form:errors class="error" path="email"/>

		<form:label path="password">Contraseña:</form:label> 
		<form:input type="password" path="password"/> 
		<form:errors class="error" path="password"/>
		
		<input type="submit" value="Iniciar Sesión">
	</form:form>
</div>
</body>
</html>