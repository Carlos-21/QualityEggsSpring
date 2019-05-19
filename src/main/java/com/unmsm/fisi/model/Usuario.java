package com.unmsm.fisi.model;

import java.util.Date;

public class Usuario {

	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sIdentificador;
	private String sClave;
	private Integer nidPerfil;
	private Boolean bEstado;
	private Date dFecha;
	private Date dHora;

	public Usuario() {

	}

	public Usuario(String sTipoDocumento, String sNumeroDocumento, String sIdentificador, String sClave,
			Integer nidPerfil, Boolean bEstado, Date dFecha, Date dHora) {
		super();
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sIdentificador = sIdentificador;
		this.sClave = sClave;
		this.nidPerfil = nidPerfil;
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
