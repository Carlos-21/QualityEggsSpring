package com.unmsm.fisi.model;

import java.util.Date;

public class Persona {
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sNombre;
	private String sApellidoPaterno;
	private String sApellidoMaterno;
	private String sSexo;
	private String sDomicilio;
	private String sTelefonoFijo;
	private String sTelefonoCelular;
	private String sCorreo;
	private Date dFecha;
	private Date dHora;
	
	public Persona() {
		
	}
	
	public Persona(String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sSexo, String sDomicilio, String sTelefonoFijo, String sTelefonoCelular,
			String sCorreo, Date dFecha, Date dHora) {
		super();
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sNombre = sNombre;
		this.sApellidoPaterno = sApellidoPaterno;
		this.sApellidoMaterno = sApellidoMaterno;
		this.sSexo = sSexo;
		this.sDomicilio = sDomicilio;
		this.sTelefonoFijo = sTelefonoFijo;
		this.sTelefonoCelular = sTelefonoCelular;
		this.sCorreo = sCorreo;
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

	public String getsSexo() {
		return sSexo;
	}

	public void setsSexo(String sSexo) {
		this.sSexo = sSexo;
	}

	public String getsDomicilio() {
		return sDomicilio;
	}

	public void setsDomicilio(String sDomicilio) {
		this.sDomicilio = sDomicilio;
	}

	public String getsTelefonoFijo() {
		return sTelefonoFijo;
	}

	public void setsTelefonoFijo(String sTelefonoFijo) {
		this.sTelefonoFijo = sTelefonoFijo;
	}

	public String getsTelefonoCelular() {
		return sTelefonoCelular;
	}

	public void setsTelefonoCelular(String sTelefonoCelular) {
		this.sTelefonoCelular = sTelefonoCelular;
	}

	public String getsCorreo() {
		return sCorreo;
	}

	public void setsCorreo(String sCorreo) {
		this.sCorreo = sCorreo;
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
