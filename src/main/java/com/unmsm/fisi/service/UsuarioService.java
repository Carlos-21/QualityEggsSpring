package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Usuario;

public interface UsuarioService {
	public List<Usuario> listarUsuarios();
	public Usuario buscarUsuario(String sIdentificador);
	public String registrarUsuario(Usuario oUsuario);
	public String actualizarUsuario(Usuario oUsuario);
	public void eliminarUsuario(String sIdentificador);
}
