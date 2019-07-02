package com.unmsm.fisi.model;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PedidoCliente {
	private String idPersona;
	private Integer nCantidad;
	private Boolean vEstado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
	private Date dFecha;
	private Time tHora;
	private Integer nidPedido;
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	private String sEmpresa;
	private String sRubro;
	private String sDireccion;
	private double nMonto;
	
	public PedidoCliente() {
		
	}

	public PedidoCliente(String idPersona, Integer nCantidad, Boolean vEstado, Date dFecha, Time tHora,
			Integer nidPedido, String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sEmpresa, String sRubro, String sDireccion, double nMonto) {
		super();
		this.idPersona = idPersona;
		this.nCantidad = nCantidad;
		this.vEstado = vEstado;
		this.dFecha = dFecha;
		this.tHora = tHora;
		this.nidPedido = nidPedido;
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sNombre = sNombre;
		this.sApellidoPaterno = sApellidoPaterno;
		this.sApellidoMaterno = sApellidoMaterno;
		this.sEmpresa = sEmpresa;
		this.sRubro = sRubro;
		this.sDireccion = sDireccion;
		this.nMonto = nMonto;
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

	public Date getdFecha() {
		return dFecha;
	}

	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}

	public Time gettHora() {
		return tHora;
	}

	public void settHora(Time tHora) {
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

	public String getsDireccion() {
		return sDireccion;
	}

	public void setsDireccion(String sDireccion) {
		this.sDireccion = sDireccion;
	}

	public double getnMonto() {
		return nMonto;
	}

	public void setnMonto(double nMonto) {
		this.nMonto = nMonto;
	}

}
