package com.unmsm.fisi.model;

import java.util.Date;

public class GuiaRemision {
	private String sRUCEmpresa;
	private String sNumeroGuia;
	private String sFechaTraslado;
	private String sDireccionPartida;
	private String sDestinatario;
	private String sDireccionLlegada;
	private String sRUCCliente;
	private String sNumeroDocumento;
	private String sDocumento;
	private String sDescripcionProducto;
	private int nCantidadProducto;
	private String sRUCRemitente;
	private String sDenominacionRemitente;
	private String sMarcaPlaca;
	private String sLicenciaConducir;
	private Date dFechaPedido; 
	private Boolean vEstado;
	
	public String getsRUCEmpresa() {
		return sRUCEmpresa;
	}
	public void setsRUCEmpresa(String sRUCEmpresa) {
		this.sRUCEmpresa = sRUCEmpresa;
	}
	public String getsNumeroGuia() {
		return sNumeroGuia;
	}
	public void setsNumeroGuia(String sNumeroGuia) {
		this.sNumeroGuia = sNumeroGuia;
	}
	public String getsFechaTraslado() {
		return sFechaTraslado;
	}
	public void setsFechaTraslado(String sFechaTraslado) {
		this.sFechaTraslado = sFechaTraslado;
	}
	public String getsDireccionPartida() {
		return sDireccionPartida;
	}
	public void setsDireccionPartida(String sDireccionPartida) {
		this.sDireccionPartida = sDireccionPartida;
	}
	public String getsDestinatario() {
		return sDestinatario;
	}
	public void setsDestinatario(String sDestinatario) {
		this.sDestinatario = sDestinatario;
	}
	public String getsDireccionLlegada() {
		return sDireccionLlegada;
	}
	public void setsDireccionLlegada(String sDireccionLlegada) {
		this.sDireccionLlegada = sDireccionLlegada;
	}
	public String getsRUCCliente() {
		return sRUCCliente;
	}
	public void setsRUCCliente(String sRUCCliente) {
		this.sRUCCliente = sRUCCliente;
	}
	public String getsNumeroDocumento() {
		return sNumeroDocumento;
	}
	public void setsNumeroDocumento(String sNumeroDocumento) {
		this.sNumeroDocumento = sNumeroDocumento;
	}
	public String getsDocumento() {
		return sDocumento;
	}
	public void setsDocumento(String sDocumento) {
		this.sDocumento = sDocumento;
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
	public String getsRUCRemitente() {
		return sRUCRemitente;
	}
	public void setsRUCRemitente(String sRUCRemitente) {
		this.sRUCRemitente = sRUCRemitente;
	}
	public String getsDenominacionRemitente() {
		return sDenominacionRemitente;
	}
	public void setsDenominacionRemitente(String sDenominacionRemitente) {
		this.sDenominacionRemitente = sDenominacionRemitente;
	}
	public String getsMarcaPlaca() {
		return sMarcaPlaca;
	}
	public void setsMarcaPlaca(String sMarcaPlaca) {
		this.sMarcaPlaca = sMarcaPlaca;
	}
	public String getsLicenciaConducir() {
		return sLicenciaConducir;
	}
	public void setsLicenciaConducir(String sLicenciaConducir) {
		this.sLicenciaConducir = sLicenciaConducir;
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
