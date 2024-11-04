<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar Sesi�n</title>
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
		
		<label for="password">Contrase�a:</label>
		<input type="text" name="password">
		<span>${errorPasswordRegister}</span>
		
		<input type="submit" value="Registrarse">
	</form>
	
	<h2>Iniciar Sesi�n</h2>
	<form action="/login" method="POST">
		<label for="email">Email:</label>
		<input type="email" name="email">
		
		<label for="password">Contrase�a:</label>
		<input type="text" name="password">
		<span>${errorPasswordLogin}</span>
		
		<input type="submit" value="Iniciar Sesi�n">
	</form>
</body>
</html>