package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Perfil;

public interface PerfilService {
	public List<Perfil> listarPerfiles();
	public Perfil buscarPerfil(Integer nIdPerfil);
	public Integer registrarPerfil(Perfil oPerfil);
	public Integer actualizarPerfil(Perfil oPerfil);
	public void eliminarPerfil(Integer nIdPerfil);

}
