package com.unmsm.fisi.model;

import java.sql.Time;
import java.util.Date;

public class PedidoTrabajador {
	private String idPersona;
	private String sCorreo;
	private Integer nCantidad;
	private Boolean vEstado;
	private Date dFecha;
	private Time tHora;
	private Integer nIdPedido;
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	
	public PedidoTrabajador() {
		super();
	}

	public PedidoTrabajador(String idPersona, String sCorreo, Integer nCantidad, Boolean vEstado, Date dFecha,
			Time tHora, Integer nIdPedido, String sTipoDocumento, String sNumeroDocumento, String sNombre,
			String sApellidoPaterno, String sApellidoMaterno) {
		super();
		this.idPersona = idPersona;
		this.sCorreo = sCorreo;
		this.nCantidad = nCantidad;
		this.vEstado = vEstado;
		this.dFecha = dFecha;
		this.tHora = tHora;
		this.nIdPedido = nIdPedido;
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sNombre = sNombre;
		this.sApellidoPaterno = sApellidoPaterno;
		this.sApellidoMaterno = sApellidoMaterno;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getsCorreo() {
		return sCorreo;
	}

	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
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
	
}
