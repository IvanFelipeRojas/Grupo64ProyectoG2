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
		String correo = request.getParameter("correo");
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String usuario = request.getParameter("usuario");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendagrupo64","root","Administrador");
		Statement st = conexion.createStatement();
		String sql = "INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) VALUES("+cedula+",'"+correo+"','"+nombre+"','"+pass+"','"+usuario+"')";
		st.executeUpdate(sql);
		response.sendRedirect("usuarios1.jsp");
	%>
</body>
</html>