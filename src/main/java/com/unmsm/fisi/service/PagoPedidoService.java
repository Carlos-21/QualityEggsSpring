package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.PagoPedido;

public interface PagoPedidoService {
	public List<PagoPedido> listarPagoPedido();
	public PagoPedido buscarPagoPedido(Integer nIdPago);
	public Integer registrarPagoPedido(PagoPedido oPagoPedido);
	public Integer actualizarPagoPedido(PagoPedido oPagoPedido);
}
