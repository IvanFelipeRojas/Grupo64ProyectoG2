<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	int cedula = Integer.parseInt(request.getParameter("cedula"));
	Class.forName("com.mysql.jdbc.Driver");
	Connection conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendagrupo64","root","Administrador");
	PreparedStatement ps = conexion.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario = "+cedula);
	ps.executeUpdate();
	response.sendRedirect("usuarios1.jsp");
	
	%>
</body>
</html>