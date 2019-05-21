package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.TabDet;
import com.unmsm.fisi.model.TablaDetId;

public interface TabDetService {
	public List<TabDet> listarTodos();
	public TabDet buscarIdTablaItem(int nIdTabla, String sIdItem);
	public List<TabDet> buscarIdTabla(int nIdTabla);
	public TablaDetId registrarMultiTabDet(TabDet oTabDet);
	public TablaDetId actualizarMultiTabDet(TabDet oTabDet);
	public void eliminarMultiTabDet(int nIdTabla, String sIdItem);
}
