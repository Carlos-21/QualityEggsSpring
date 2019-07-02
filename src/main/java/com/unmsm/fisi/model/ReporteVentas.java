package com.unmsm.fisi.model;

import java.util.Date;

public class ReporteVentas {
	private Date dFechaPedido;
	private String sEmpresaCliente;
	private String sDescripcionProducto;
	private int nCantidadProducto;
	private String sMontoTotal;

	public ReporteVentas() {

	}

	public ReporteVentas(Date dFechaPedido, String sEmpresaCliente, String sDescripcionProducto, int nCantidadProducto,
			String sMontoTotal) {
		super();
		this.dFechaPedido = dFechaPedido;
		this.sEmpresaCliente = sEmpresaCliente;
		this.sDescripcionProducto = sDescripcionProducto;
		this.nCantidadProducto = nCantidadProducto;
		this.sMontoTotal = sMontoTotal;
	}

	public Date getdFechaPedido() {
		return dFechaPedido;
	}

	public void setdFechaPedido(Date dFechaPedido) {
		this.dFechaPedido = dFechaPedido;
	}

	public String getsEmpresaCliente() {
		return sEmpresaCliente;
	}

	public void setsEmpresaCliente(String sEmpresaCliente) {
		this.sEmpresaCliente = sEmpresaCliente;
	}

	public String getsDescripcionProducto() {
		return sDescripcionProducto;
	}

	public void setsDescripcionProducto(String sDescripcionProducto) {
		this.sDescripcionProducto = sDescripcionProducto;
	}

	public int getnCantidadProducto() {
		return nCantidadProducto;
	}

	public void setnCantidadProducto(int nCantidadProducto) {
		this.nCantidadProducto = nCantidadProducto;
	}

	public String getsMontoTotal() {
		return sMontoTotal;
	}

	public void setsMontoTotal(String sMontoTotal) {
		this.sMontoTotal = sMontoTotal;
	}

}
