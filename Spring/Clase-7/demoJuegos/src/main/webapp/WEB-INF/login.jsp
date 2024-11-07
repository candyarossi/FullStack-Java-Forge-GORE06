<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesión</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h2>Registrarse</h2>
	<form action="/register" method="POST">
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre">
		
		<label for="apellido">Apellido:</label>
		<input type="text" name="apellido">
		
		<label for="email">Email:</label>
		<input type="email" name="email">
		
		<label for="password">Contraseña:</label>
		<input type="text" name="password">
		<span>${errorPasswordRegister}</span>
		
		<input type="submit" value="Registrarse">
	</form>
	
	<h2>Iniciar Sesión</h2>
	<form action="/login" method="POST">
		<label for="email">Email:</label>
		<input type="email" name="email">
		
		<label for="password">Contraseña:</label>
		<input type="text" name="password">
		<span>${errorPasswordLogin}</span>
		
		<input type="submit" value="Iniciar Sesión">
	</form>
</body>
</html>