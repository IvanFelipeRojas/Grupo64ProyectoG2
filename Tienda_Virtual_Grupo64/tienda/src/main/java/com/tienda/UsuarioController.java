package com.tienda;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.DAO.UsuarioDAO;
import com.tienda.DTO.UsuarioDTO;

//CON EL REST CONTROLER SE RECONOCE QUE ES UNA API
@RestController
public class UsuarioController {

	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioDTO usuario) {
		
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(usuario);
				
	}
	
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioDTO> consultarUsuario(int documento){
		
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.consultarUsuario(documento);

	}
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioDTO> listaDeUsuarios(){
		
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.listaDeUsuarios();
		
	}
	@RequestMapping("/eliminarUsuarios")
	public void eliminarUsuario(int cedula) {
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(cedula);
		
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
