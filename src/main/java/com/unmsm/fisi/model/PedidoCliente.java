package com.unmsm.fisi.model;

import java.util.Date;

public class PedidoCliente {
	private Integer nidPedido;
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private Integer nCantidad;
	private Boolean vEstado;
	private Date dFecha;
	private Date tHora;
	
	public PedidoCliente() {
		
	}

	public PedidoCliente(Integer nidPedido, String sTipoDocumento, String sNumeroDocumento, Integer nCantidad,
			Boolean vEstado, Date dFecha, Date tHora) {
		super();
		this.nidPedido = nidPedido;
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.nCantidad = nCantidad;
		this.vEstado = vEstado;
		this.dFecha = dFecha;
		this.tHora = tHora;
	}

	public Integer getNidPedido() {
		return nidPedido;
	}

	public void setNidPedido(Integer nidPedido) {
		this.nidPedido = nidPedido;
	}

	public String getsTipoDocumento() {
		return sTipoDocumento;
	}

	public void setsTipoDocumento(String sTipoDocumento) {
		this.sTipoDocumento = sTipoDocumento;
	}

	public String getsNumeroDocumento() {
		return sNumeroDocumento;
	}

	public void setsNumeroDocumento(String sNumeroDocumento) {
		this.sNumeroDocumento = sNumeroDocumento;
	}

	public Integer getnCantidad() {
		return nCantidad;
	}

	public void setnCantidad(Integer nCantidad) {
		this.nCantidad = nCantidad;
	}

	public Boolean getvEstado() {
		return vEstado;
	}

	public void setvEstado(Boolean vEstado) {
		this.vEstado = vEstado;
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
