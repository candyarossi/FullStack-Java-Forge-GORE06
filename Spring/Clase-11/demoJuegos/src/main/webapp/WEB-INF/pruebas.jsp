<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pruebas</title>
<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>¡Hola Mundo!</h1>
	<%!int i = 0;

	double aplicarDescuento(double precio) {
		return precio * 0.1;
	}%>
	<span><%=aplicarDescuento(40.5)%></span>
	<ul>
		<%
		for (int i = 0; i < 10; i++) {
		%>
		<li><%=i%></li>
		<%
		}
		%>

	</ul>
	<%!String nombre = "Cande";
	String apellido = "Yarossi";%>
	<h2>
		Hola
		<%=nombre%>
		<%=apellido%></h2>
</body>
</html>