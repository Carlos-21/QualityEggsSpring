package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Trabajador;
import com.unmsm.fisi.model.TrabajadorId;

public interface TrabajadorService {
	public List<Trabajador> listarTrabajadores();
	public Trabajador buscarTrabajador(String sTipoDocumento, String sNumeroDocumento);
	public TrabajadorId registrarTrabajador(Trabajador oTrabajador);
	public TrabajadorId actualizarTrabajador(Trabajador oTrabajador);
	public void eliminarTrabajador(String sTipoDocumento, String sNumeroDocumento);
}
