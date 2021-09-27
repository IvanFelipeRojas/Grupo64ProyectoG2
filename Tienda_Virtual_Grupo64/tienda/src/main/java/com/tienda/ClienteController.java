package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.ClienteDAO;

import com.tienda.DTO.ClienteDTO;


//CON EL REST CONTROLER SE RECONOCE QUE ES UNA API
@RestController

public class ClienteController {

	@RequestMapping("/registrarCliente")
	public void registrarCliente(ClienteDTO cliente) {
		
		ClienteDAO Dao = new ClienteDAO();
		Dao.registrarCliente(cliente);
				
	}
	
	@RequestMapping("/consultarCliente")
	public ArrayList<ClienteDTO> consultarCliente(int documento){
		
		ClienteDAO Dao = new ClienteDAO();
		return Dao.consultarCliente(documento);

	}
	@RequestMapping("/listarClientes")
	public ArrayList<ClienteDTO> listaDeClientes(){
		
		ClienteDAO Dao = new ClienteDAO();
		return Dao.listaDeClientes();
		
	}
	@RequestMapping("/eliminarClientes")
	public void eliminarCliente(int cedula) {
		ClienteDAO Dao = new ClienteDAO();
		Dao.eliminarCliente(cedula);
		
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
