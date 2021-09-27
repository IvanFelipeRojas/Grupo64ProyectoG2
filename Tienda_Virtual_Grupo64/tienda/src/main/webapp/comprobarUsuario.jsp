<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprobar Usuario</title>
</head>
<body>

	<%
	
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("pass");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendagrupo64","root","Administrador");
		PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND password = ?");
		ps.setString(1, usuario);
		ps.setString(2, password);
		ResultSet result = ps.executeQuery();
		int i = 0;
		while(result.next()){
			i++;
		}
		if(i==1){
			
			out.println("Usuario autorizado");
			response.sendRedirect("principal.jsp");
		}else{
			out.println("No hay usuarios con esos datos");
			response.sendRedirect("index.html");
		}
		
		out.println("Bienvenido "+usuario); //BORRAR DESPUES PARA EL PROYECTO
		out.println("<br>Su contraseña es: "+password); //BORRAR DESPUES PARA EL PROYECTO
		
		
	
	%>
	
	
	
	<br> <!-- //BORRAR DESPUES PARA EL PROYECTO -->
	<a href = "primerJSP.jsp">Otra pagina</a> <!-- //BORRAR DESPUES PARA EL PROYECTO -->
	<a href = "index.html">Volver al Index</a> <!-- //BORRAR DESPUES PARA EL PROYECTO -->
	<a href = "info.jsp">Volver al Index</a> <!-- //BORRAR DESPUES PARA EL PROYECTO -->

</body>
</html>