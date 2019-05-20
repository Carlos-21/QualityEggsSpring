package com.unmsm.fisi.model;

import java.util.Date;

public class Usuario {

	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	private String sIdentificador;
	private String sClave;
	private Integer nidPerfil;
	private String sNombrePerfil;
	private Boolean bEstado;
	private Date dFecha;
	private Date dHora;

	public Usuario() {

	}

	public Usuario(String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sIdentificador, String sClave, Integer nidPerfil, String sNombrePerfil,
			Boolean bEstado, Date dFecha, Date dHora) {
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sNombre = sNombre;
		this.sApellidoPaterno = sApellidoPaterno;
		this.sApellidoMaterno = sApellidoMaterno;
		this.sIdentificador = sIdentificador;
		this.sClave = sClave;
		this.nidPerfil = nidPerfil;
		this.sNombrePerfil = sNombrePerfil;
		this.bEstado = bEstado;
		this.dFecha = dFecha;
		this.dHora = dHora;
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

	public String getsIdentificador() {
		return sIdentificador;
	}

	public void setsIdentificador(String sIdentificador) {
		this.sIdentificador = sIdentificador;
	}

	public String getsClave() {
		return sClave;
	}

	public void setsClave(String sClave) {
		this.sClave = sClave;
	}

	public Integer getNidPerfil() {
		return nidPerfil;
	}

	public void setNidPerfil(Integer nidPerfil) {
		this.nidPerfil = nidPerfil;
	}

	public String getsNombrePerfil() {
		return sNombrePerfil;
	}

	public void setsNombrePerfil(String sNombrePerfil) {
		this.sNombrePerfil = sNombrePerfil;
	}

	public Boolean getbEstado() {
		return bEstado;
	}

	public void setbEstado(Boolean bEstado) {
		this.bEstado = bEstado;
	}

	public Date getdFecha() {
		return dFecha;
	}

	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}

	public Date getdHora() {
		return dHora;
	}

	public void setdHora(Date dHora) {
		this.dHora = dHora;
	}

}
