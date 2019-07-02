package com.unmsm.fisi.model;

import java.util.Date;

public class Factura {
	private String sRUCEmpresa;
	private String sNumeroFactura;
	private String sFechaFactura;
	private String sEmpresaCliente;
	private String sRUCEmpresaCliente;
	private String sDireccionCliente;
	private String sDescripcionProducto;
	private int nCantidadProducto;
	private String sPrecioUnitario;
	private String sValorVenta;
	private String sSubTotal;
	private String sIGV;
	private String sMontoTotal;
	private Date dFechaPedido; 
	private Boolean vEstado;

	public String getsRUCEmpresa() {
		return sRUCEmpresa;
	}

	public void setsRUCEmpresa(String sRUCEmpresa) {
		this.sRUCEmpresa = sRUCEmpresa;
	}

	public String getsNumeroFactura() {
		return sNumeroFactura;
	}

	public void setsNumeroFactura(String sNumeroFactura) {
		this.sNumeroFactura = sNumeroFactura;
	}

	public String getsFechaFactura() {
		return sFechaFactura;
	}

	public void setsFechaFactura(String sFechaFactura) {
		this.sFechaFactura = sFechaFactura;
	}

	public String getsEmpresaCliente() {
		return sEmpresaCliente;
	}

	public void setsEmpresaCliente(String sEmpresaCliente) {
		this.sEmpresaCliente = sEmpresaCliente;
	}

	public String getsRUCEmpresaCliente() {
		return sRUCEmpresaCliente;
	}

	public void setsRUCEmpresaCliente(String sRUCEmpresaCliente) {
		this.sRUCEmpresaCliente = sRUCEmpresaCliente;
	}

	public String getsDireccionCliente() {
		return sDireccionCliente;
	}

	public void setsDireccionCliente(String sDireccionCliente) {
		this.sDireccionCliente = sDireccionCliente;
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

	public String getsPrecioUnitario() {
		return sPrecioUnitario;
	}

	public void setsPrecioUnitario(String sPrecioUnitario) {
		this.sPrecioUnitario = sPrecioUnitario;
	}

	public String getsValorVenta() {
		return sValorVenta;
	}

	public void setsValorVenta(String sValorVenta) {
		this.sValorVenta = sValorVenta;
	}

	public String getsSubTotal() {
		return sSubTotal;
	}

	public void setsSubTotal(String sSubTotal) {
		this.sSubTotal = sSubTotal;
	}

	public String getsIGV() {
		return sIGV;
	}

	public void setsIGV(String sIGV) {
		this.sIGV = sIGV;
	}

	public String getsMontoTotal() {
		return sMontoTotal;
	}

	public void setsMontoTotal(String sMontoTotal) {
		this.sMontoTotal = sMontoTotal;
	}

	public Date getdFechaPedido() {
		return dFechaPedido;
	}

	public void setdFechaPedido(Date dFechaPedido) {
		this.dFechaPedido = dFechaPedido;
	}

	public Boolean getvEstado() {
		return vEstado;
	}

	public void setvEstado(Boolean vEstado) {
		this.vEstado = vEstado;
	}

}
