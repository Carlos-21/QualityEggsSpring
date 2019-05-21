package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.TabCab;

public interface TabCabService {
	public List<TabCab> listarTodos();
	public TabCab buscarId(int nIdTabla);
	public int registrarMultiTabCab(TabCab oTabCab);
	public int actualizarMultiTabCab(TabCab oTabCab);
	public void eliminarMultiTabCab(int nIdTabla);
	
}
