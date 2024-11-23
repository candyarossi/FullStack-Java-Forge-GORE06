<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h1>FRASES</h1>
	<ul id="nav">
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
	</ul>
	<h2>Iniciar Sesión</h2>
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">

		<form:label path="email">Email:</form:label>
		<form:input path="email" type="text" />
		<form:errors path="email" />
		
		<form:label path="password">Contraseña:</form:label>
		<form:input path="password" type="text" />
		<form:errors path="password" />
		
		<input type="submit" value="Iniciar Sesión" />
	</form:form>
</body>
</html>