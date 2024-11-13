<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h2>Registrarse</h2>
	<form:form action="/register" method="POST" modelAttribute="usuario">
		<form:label path="nombre">Nombre:</form:label>
		<form:input type="text" path="nombre"/>
		<form:errors path="nombre"/>
		
		<form:label path="apellido">Apellido:</form:label>
		<form:input type="text" path="apellido"/>
		<form:errors path="apellido"/>
		
		<form:label path="email">Email:</form:label>
		<form:input type="text" path="email"/>
		<form:errors path="email"/>
		
		<form:label path="password">Contraseña:</form:label>
		<form:input type="text" path="password"/>
		<form:errors path="password"/>
		
		<form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
		<form:input type="text" path="confirmarPassword"/>
		<form:errors path="confirmarPassword"/>
		
		<input type="submit" value="Registrarse">
	</form:form>
	
	<h2>Iniciar Sesión</h2>
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">
		<form:label path="email">Email:</form:label>
		<form:input type="email" path="email"/>
		<form:errors path="email"/>
		
		<form:label path="password">Contraseña:</form:label>
		<form:input type="text" path="password"/>
		<form:errors path="password"/>
		
		<input type="submit" value="Iniciar Sesión">
	</form:form>
</body>
</html>