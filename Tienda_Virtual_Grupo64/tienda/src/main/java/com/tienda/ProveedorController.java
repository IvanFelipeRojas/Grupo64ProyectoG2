package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ProveedorDAO;
import com.tienda.DTO.ProveedorDTO;


//CON EL REST CONTROLER SE RECONOCE QUE ES UNA API
@RestController

public class ProveedorController {

	
	@RequestMapping("/registrarProveedor")
	public void registrarProveedor(ProveedorDTO proveedor) {
		
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.registrarProveedor(proveedor);
				
	}
	
	@RequestMapping("/consultarProveedor")
	public ArrayList<ProveedorDTO> consultarProveedor(int documento){
		
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(documento);

	}
	@RequestMapping("/listarProveedores")
	public ArrayList<ProveedorDTO> listaDeProveedores(){
		
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listaDeProveedores();
		
	}
	@RequestMapping("/eliminarProveedores")
	public void eliminarProveedor(int cedula) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(cedula);
		
	}
	
	//FALTARIA HACER LO MISMO CON EL UPDATE
	
	//@RequestMapping("/editarUsuarios")
	//public void editarUsuario(int cedula) {
		//UsuarioDAO Dao = new UsuarioDAO();
		//Dao.editarUsuario(cedula);
		
	//}
	
	/*
	@RequestMapping("/editarUsuario")
	public ArrayList<UsuarioDTO> editarUsuario(int cedula){
		
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.editarUsuario(cedula);

	}
	*/
	
	
	
}
