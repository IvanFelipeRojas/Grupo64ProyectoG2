package com.tienda.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.ClienteDTO;


public class ClienteDAO {

	
	//TODOS LOS METODOS QUE NECESITEMOS PARA GESTIONAR LA BASE DE DATOS - CRUD	
		PreparedStatement preparedStatement;
		
		
		public void registrarCliente(ClienteDTO cliente) {
	        Conexion conex = new Conexion();
	        try {
	            Statement st = conex.getConnection().createStatement();
	            st.executeUpdate("INSERT INTO clientes VALUES ('"+cliente.getCedulaCliente()+"', '"
	                     +cliente.getDireccionCliente()+"', '"+cliente.getEmailCliente()+"','"+cliente.getNombreCliente()+"','"+cliente.getTelefonoCliente()+"')");
	            JOptionPane.showMessageDialog(null, "Se ha registrado el cliente exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);;
	            st.close();
	            conex.desconectar();
	        }catch(Exception e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se puedo agregar al cliente");
	        }
	    }
		
		public ArrayList<ClienteDTO> consultarCliente(int documento){
	        ArrayList<ClienteDTO> miCliente = new ArrayList<ClienteDTO>();
	        Conexion conex = new Conexion();
	        try {
	            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = ?");
	            consulta.setInt(1, documento);
	            ResultSet res = consulta.executeQuery();
	            if(res.next()) {
	                ClienteDTO cliente = new ClienteDTO();
	                cliente.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
	                cliente.setDireccionCliente(res.getString("direccion_cliente"));
	                cliente.setEmailCliente(res.getString("email_cliente"));
	                cliente.setNombreCliente(res.getString("nombre_cliente"));
	                cliente.setTelefonoCliente(res.getString("telefono_cliente"));
	                miCliente.add(cliente);
	            }
	            res.close();
	            consulta.close();
	            conex.desconectar();
	        }catch(Exception e) {
	            JOptionPane.showMessageDialog(null, "no se pudo consultar al cliente "+e);
	        }
	        return miCliente;
	    }
		
		public ArrayList<ClienteDTO> listaDeClientes() {
	        ArrayList< ClienteDTO> miCliente = new ArrayList< ClienteDTO>();
	        Conexion conex= new Conexion();
	          
	        try {
	         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
	         ResultSet res = consulta.executeQuery();
	         while(res.next()){
	             ClienteDTO cliente= new ClienteDTO();
	                cliente.setCedulaCliente(Integer.parseInt(res.getString("cedula_cliente")));
	                cliente.setDireccionCliente(res.getString("direccion_cliente"));
	                cliente.setEmailCliente(res.getString("email_cliente"));
	                cliente.setNombreCliente(res.getString("nombre_cliente"));
	                cliente.setTelefonoCliente(res.getString("telefono_cliente"));
	        
	          miCliente.add(cliente);
	                }
	                res.close();
	                consulta.close();
	                conex.desconectar();
	         
	        } catch (Exception e) {
	         JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
	        }
	        
	        
	        return miCliente;
	    }
		
		public void eliminarCliente(int cedula) {
	        Conexion conex= new Conexion();
	        try {
	            String query = "DELETE FROM clientes WHERE cedula_cliente = ?";
	            preparedStatement = conex.getConnection().prepareStatement(query);
	            preparedStatement.setInt(1, cedula);
	            preparedStatement.executeUpdate();
	        }catch(Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
		
		//FALTARIA EL UPDATE QUE SERIA IGUAL QUE EL REGISTRAR USUARIO PERO CON EL QUERY DE UPDATE, SERÍA UN UPDARE DE USUARIOS Y CON LOS SETS Y NUEVAMENTE LE CONCATENAMOS LAS VARIABLES
		/*
		public void editarUsuario(UsuarioDTO usuario) {
	        Conexion conex = new Conexion();
	        try {
	            Statement st = conex.getConnection().createStatement();
	            st.executeUpdate("UPDATE usuarios VALUES ('"+usuario.getCedulaUsuario()+"', '"
	                     +usuario.getEmailUsuario()+"', '"+usuario.getNombreUsuario()+"','"+usuario.getPassword()+"','"+usuario.getUsuario()+"')");
	            JOptionPane.showMessageDialog(null, "Se ha registrado el usuario exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);;
	            st.close();
	            conex.desconectar();
	        }catch(Exception e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "No se puedo agregar al usuario");
	        }
	    }
	    */
	
	
	
}
