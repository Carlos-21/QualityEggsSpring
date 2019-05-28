package com.unmsm.fisi.service;

import com.unmsm.fisi.model.PedidoClienteProducto;
import com.unmsm.fisi.model.PedidoClienteProductoId;

public interface PedidoClienteProductoService {
	public PedidoClienteProductoId buscarPedidoClienteProducto(int nIdPedidoCliente, int nIdProducto);
	public PedidoClienteProductoId registrarPedidoClienteProducto(PedidoClienteProducto oPedClieProdu);
	public void eliminarPedidoClienteProducto(PedidoClienteProductoId oPedClieProdu);
}
