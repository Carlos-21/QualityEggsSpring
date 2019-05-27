package com.unmsm.fisi.model;

public class PedidoClienteProducto {
	private PedidoClienteProductoId idPedCliProd;

	public PedidoClienteProducto() {
		
	}
	
	public PedidoClienteProducto(PedidoClienteProductoId idPedCliProd) {
		super();
		this.idPedCliProd = idPedCliProd;
	}

	public PedidoClienteProductoId getIdPedCliProd() {
		return idPedCliProd;
	}

	public void setIdPedCliProd(PedidoClienteProductoId idPedCliProd) {
		this.idPedCliProd = idPedCliProd;
	}
	
}
