package com.unmsm.fisi.model;

public class PedidoClienteProductoId {
	private int nIdPedidoCliente;
	private int nIdProducto;
	
	public PedidoClienteProductoId() {
		
	}
	
	public PedidoClienteProductoId(int nIdPedidoCliente, int nIdProducto) {
		super();
		this.nIdPedidoCliente = nIdPedidoCliente;
		this.nIdProducto = nIdProducto;
	}

	public int getnIdPedidoCliente() {
		return nIdPedidoCliente;
	}

	public void setnIdPedidoCliente(int nIdPedidoCliente) {
		this.nIdPedidoCliente = nIdPedidoCliente;
	}

	public int getnIdProducto() {
		return nIdProducto;
	}

	public void setnIdProducto(int nIdProducto) {
		this.nIdProducto = nIdProducto;
	}
	
}
