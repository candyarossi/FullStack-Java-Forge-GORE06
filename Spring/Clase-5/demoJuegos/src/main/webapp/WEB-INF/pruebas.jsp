<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pruebas</title>
</head>
<body>
	<h1>¡Hola Mundo!</h1>
	<%!int i = 0;

	double aplicarDescuento(double precio) {
		return precio * 0.1;
	}%>
	<p><%=aplicarDescuento(40.5)%></p>
	<ul>
		<%
		for (int i = 0; i < 10; i++) {
		%>
		<li><%=i%></li>
		<%
		}
		%>
	</ul>

	<p>
		<c:out value="${mensaje}" />
	</p>
	<p>${mensaje}</p>

	<c:if test="${numero > 0}">
		<p>El número es positivo.</p>
	</c:if>

	<ul>
		<c:forEach var="item" items="${lista}">
			<li>${item}</li>
		</c:forEach>
	</ul>
</body>
</html>