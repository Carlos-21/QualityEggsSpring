package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.PedidoCliente;

public interface PedidoClienteService {
	public List<PedidoCliente> listarPedidosClientes();
	public PedidoCliente buscarPedidoCliente(String sTipoDocumento, String sNumeroDocumento);
	public Integer registrarPedidoCliente(PedidoCliente oPedidoCliente);
	public Integer actualizarPedidoCliente(PedidoCliente oPedidoCliente);
	public void eliminarPedidoCliente(Integer nidPedido);
}
