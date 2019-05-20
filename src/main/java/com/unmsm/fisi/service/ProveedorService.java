package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Proveedor;
import com.unmsm.fisi.model.ProveedorId;

public interface ProveedorService {
	public List<Proveedor> listarProveedores();
	public Proveedor buscarProveedor(String sTipoDocumento, String sNumeroDocumento);
	public ProveedorId registrarProveedor(Proveedor oProveedor);
	public ProveedorId actualizarProveedor(Proveedor oProveedor);
	public void eliminarProveedor(String sTipoDocumento, String sNumeroDocumento);
	
}
