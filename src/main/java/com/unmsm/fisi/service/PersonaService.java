package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.PersonaId;

public interface PersonaService {
	public List<Persona> listarPersonas();
	public Persona buscarPersona(String sTipoDocumento, String sNumeroDocumento);
	public PersonaId registrarPersona(Persona oPersona);
	public PersonaId actualizarPersona(Persona oPersona);
	public void eliminarPersona(String sTipoDocumento, String sNumeroDocumento);
}
