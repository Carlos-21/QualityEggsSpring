package com.unmsm.fisi.model;

public class PersonaId {
	private String sTipoDocumento;
	private String sNumeroDocumento;

	public PersonaId() {

	}

	public PersonaId(String sTipoDocumento, String sNumeroDocumento) {
		this.sTipoDocumento = sTipoDocumento;
		this.sNumeroDocumento = sNumeroDocumento;
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

}
