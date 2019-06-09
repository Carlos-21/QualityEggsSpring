package com.unmsm.fisi.model;

import java.util.Date;

public class PedidoTrabajador {
	private Integer nIdPedido;
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private Integer nCantidad;
	private Boolean vEstado;
	private Date dFecha;
	private Date tHora;
	
	public PedidoTrabajador() {
		super();
	}
	
	public PedidoTrabajador(Integer nIdPedido, String sTipoDocumento, String sNumeroDocumento, Integer nCantidad,
			Boolean vEstado, Date dFecha, Date tHora) {
		super();
		this.nIdPedido = nIdPedido;
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.nCantidad = nCantidad;
		this.vEstado = vEstado;
		this.dFecha = dFecha;
		this.tHora = tHora;
	}

	public Integer getnIdPedido() {
		return nIdPedido;
	}

	public void setnIdPedido(Integer nIdPedido) {
		this.nIdPedido = nIdPedido;
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
