<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>primer JSP</title>

<style>
	body{
	
		background-color: yellow;
	
	}
	
	h1{
	
		color: blue;
	
	}
	
	span{
	
		color: red;
	}


</style>
</head>
<body>
	
	<h1>Primer JSP</h1>
	<span><%= new java.util.Date() %></span><br>
	Convertir a mayúsculas <%= new String ("Camilo").toUpperCase() %><br>
	La suma de 5 y 7 es: <%= 5+7 %>
	10 es mayor 100?? <%= 10>100 %>
	
	<%
	
		for(int i = 0; i<10; i++){
			
			out.println("<br>Es el mensaje "+i);
		}
	%>
	
	<%!
		private int resultado;
		public int metodoSuma(int num1, int num2){
			resultado = num1 + num2;
			return resultado;
		}
	%>
	<br>
	<%= metodoSuma(7,5) %>
	<br>
	Petición datos del navegador <%= request.getHeader("User-Agent") %>
	<br>
	Petición de idioma utilizado <%= request.getLocale() %>
	
	<jsp:Include page= "info.jsp"></jsp:Include>   <!-- SIRVE PARA TRAER LA INFORMACIÓN DEL JSP INFO, UTILIZAR PARA EL MENU LLAMAR EN TODAS LAS PAGINAS LO MISMO -->
	
</body>
</html>