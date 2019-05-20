package com.unmsm.fisi.model;

public class UsuarioForm {
	private String sTipoDocumento;
	private String sNumeroDocumento;
	private String sIdentificador;
	private String sClave;
	private Integer nidPerfil;
	private Boolean bEstado;
	
	public UsuarioForm() {
		
	}

	public UsuarioForm(String sTipoDocumento, String sNumeroDocumento, String sIdentificador, String sClave,
			Integer nidPerfil, Boolean bEstado) {
		super();
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sIdentificador = sIdentificador;
		this.sClave = sClave;
		this.nidPerfil = nidPerfil;
		this.bEstado = bEstado;
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
	
}
