package com.unmsm.fisi.model;

import java.util.Date;

public class PedidoCliente {
	private String idPersona;
	private Integer nCantidad;
	private Boolean vEstado;
	private Integer nidPedido;
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	private String sEmpresa;
	private String sRubro;
	private Date dFecha;
	private Date tHora;
	
	public PedidoCliente() {
		
	}

	public PedidoCliente(String idPersona, Integer nCantidad, Boolean vEstado, Integer nidPedido, String sTipoDocumento,
			String sNumeroDocumento, String sNombre, String sApellidoPaterno, String sApellidoMaterno, String sEmpresa,
			String sRubro, Date dFecha, Date tHora) {
		super();
		this.idPersona = idPersona;
		this.nCantidad = nCantidad;
		this.vEstado = vEstado;
		this.nidPedido = nidPedido;
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sNombre = sNombre;
		this.sApellidoPaterno = sApellidoPaterno;
		this.sApellidoMaterno = sApellidoMaterno;
		this.sEmpresa = sEmpresa;
		this.sRubro = sRubro;
		this.dFecha = dFecha;
		this.tHora = tHora;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
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

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellidoPaterno() {
		return sApellidoPaterno;
	}

	public void setsApellidoPaterno(String sApellidoPaterno) {
		this.sApellidoPaterno = sApellidoPaterno;
	}

	public String getsApellidoMaterno() {
		return sApellidoMaterno;
	}

	public void setsApellidoMaterno(String sApellidoMaterno) {
		this.sApellidoMaterno = sApellidoMaterno;
	}

	public String getsEmpresa() {
		return sEmpresa;
	}

	public void setsEmpresa(String sEmpresa) {
		this.sEmpresa = sEmpresa;
	}

	public String getsRubro() {
		return sRubro;
	}

	public void setsRubro(String sRubro) {
		this.sRubro = sRubro;
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
