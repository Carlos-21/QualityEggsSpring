package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.PedidoTrabajador;

public interface PedidoTrabajadorService {
	public List<PedidoTrabajador> listarPedidoTrabajador();
	public PedidoTrabajador buscarPedidoTrabajador(Integer nIdPedido);
	public Integer registrarPedidoTrabajador(PedidoTrabajador oPedidoTrabajador);
	public Integer actualizarPedidoTrabajador(PedidoTrabajador oPedidoTrabajador);
	
}
