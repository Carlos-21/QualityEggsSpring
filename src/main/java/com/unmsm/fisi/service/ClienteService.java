package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.ClienteId;

public interface ClienteService {
	public List<Cliente> listarClientes();
	public Cliente buscarCliente(String sTipoDocumento, String sNumeroDocumento);
	public ClienteId registrarCliente(Cliente oCliente);
	public ClienteId actualizarCliente(Cliente oCliente);
	public void eliminarCliente(String sTipoDocumento, String sNumeroDocumento);
}
