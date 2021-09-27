package com.tienda.DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tienda.DTO.ProveedorDTO;

public class ProveedorDAO {

	
	//TODOS LOS METODOS QUE NECESITEMOS PARA GESTIONAR LA BASE DE DATOS - CRUD	
			PreparedStatement preparedStatement;
			
			
			public void registrarProveedor(ProveedorDTO proveedor) {
		        Conexion conex = new Conexion();
		        try {
		            Statement st = conex.getConnection().createStatement();
		            st.executeUpdate("INSERT INTO proveedores VALUES ('"+proveedor.getNitProveedor()+"', '"
		                     +proveedor.getCiudadProveedor()+"', '"+proveedor.getDireccionProveedor()+"','"+proveedor.getNombreProveedor()+"','"+proveedor.getTelefonoProveedor()+"')");
		            JOptionPane.showMessageDialog(null, "Se ha registrado el proveedor exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);;
		            st.close();
		            conex.desconectar();
		        }catch(Exception e) {
		            System.out.println(e.getMessage());
		            JOptionPane.showMessageDialog(null, "No se puedo agregar al proveedor");
		        }
		    }
			
			public ArrayList<ProveedorDTO> consultarProveedor(int documento){
		        ArrayList<ProveedorDTO> miProveedor = new ArrayList<ProveedorDTO>();
		        Conexion conex = new Conexion();
		        try {
		            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor = ?");
		            consulta.setInt(1, documento);
		            ResultSet res = consulta.executeQuery();
		            if(res.next()) {
		                ProveedorDTO proveedor = new ProveedorDTO();
		                proveedor.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
		                proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
		                proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
		                proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
		                proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
		                miProveedor.add(proveedor);
		            }
		            res.close();
		            consulta.close();
		            conex.desconectar();
		        }catch(Exception e) {
		            JOptionPane.showMessageDialog(null, "no se pudo consultar al proveedor "+e);
		        }
		        return miProveedor;
		    }
			
			public ArrayList<ProveedorDTO> listaDeProveedores() {
		        ArrayList< ProveedorDTO> miProveedor = new ArrayList< ProveedorDTO>();
		        Conexion conex= new Conexion();
		          
		        try {
		         PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
		         ResultSet res = consulta.executeQuery();
		         while(res.next()){
		             ProveedorDTO proveedor= new ProveedorDTO();
		                proveedor.setNitProveedor(Integer.parseInt(res.getString("nit_proveedor")));
		                proveedor.setCiudadProveedor(res.getString("ciudad_proveedor"));
		                proveedor.setDireccionProveedor(res.getString("direccion_proveedor"));
		                proveedor.setNombreProveedor(res.getString("nombre_proveedor"));
		                proveedor.setTelefonoProveedor(res.getString("telefono_proveedor"));
		        
		          miProveedor.add(proveedor);
		                }
		                res.close();
		                consulta.close();
		                conex.desconectar();
		         
		        } catch (Exception e) {
		         JOptionPane.showMessageDialog(null, "no se pudo consultar la Persona\n"+e);
		        }
		        
		        
		        return miProveedor;
		    }
			
			public void eliminarProveedor(int cedula) {
		        Conexion conex= new Conexion();
		        try {
		            String query = "DELETE FROM proveedores WHERE nit_proveedor = ?";
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
