package com.unmsm.fisi.model;

import java.util.Date;

public class PagoPedido {
	private Integer nIdPago;
	private int nIdPedido;
	private Double nMonto;
	private Date dFecha;
	private Date tHora;
	
	public PagoPedido() {
		super();
	}
	
	public PagoPedido(Integer nIdPago, int nIdPedido, Double nMonto, Date dFecha, Date tHora) {
		super();
		this.nIdPago = nIdPago;
		this.nIdPedido = nIdPedido;
		this.nMonto = nMonto;
		this.dFecha = dFecha;
		this.tHora = tHora;
	}
	
	public Integer getnIdPago() {
		return nIdPago;
	}
	public void setnIdPago(Integer nIdPago) {
		this.nIdPago = nIdPago;
	}
	public int getnIdPedido() {
		return nIdPedido;
	}
	public void setnIdPedido(int nIdPedido) {
		this.nIdPedido = nIdPedido;
	}
	public Double getnMonto() {
		return nMonto;
	}
	public void setnMonto(Double nMonto) {
		this.nMonto = nMonto;
	}
	public Date getdFecha() {
		return dFecha;
	}
	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}
	public Date gettHora() {
		return tHora;
	}
	public void settHora(Date tHora) {
		this.tHora = tHora;
	}
	
}
