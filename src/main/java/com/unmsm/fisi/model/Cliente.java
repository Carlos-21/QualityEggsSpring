package com.unmsm.fisi.model;

import java.util.Date;

public class Cliente extends Persona {
	private String sEmpresa;
	private String sRubro;
	private String sTipoDocumentoAntiguo;
	private String sNumeroDocumentoAntiguo;

	public Cliente() {
		super();
	}

	public Cliente(String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sSexo, String sDomicilio, String sTelefonoFijo, String sTelefonoCelular,
			String sCorreo, Date dFecha, Date dHora, String sEmpresa, String sRubro, String sTipoDocumentoAntiguo, String sNumeroDocumentoAntiguo) {
		super(sTipoDocumento, sNumeroDocumento, sNombre, sApellidoPaterno, sApellidoMaterno, sSexo, sDomicilio,
				sTelefonoFijo, sTelefonoCelular, sCorreo, dFecha, dHora);
		this.sEmpresa = sEmpresa;
		this.sRubro = sRubro;
		this.sTipoDocumentoAntiguo = sTipoDocumentoAntiguo;
		this.sNumeroDocumentoAntiguo = sNumeroDocumentoAntiguo;
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

	public String getsTipoDocumentoAntiguo() {
		return sTipoDocumentoAntiguo;
	}

	public void setsTipoDocumentoAntiguo(String sTipoDocumentoAntiguo) {
		this.sTipoDocumentoAntiguo = sTipoDocumentoAntiguo;
	}

	public String getsNumeroDocumentoAntiguo() {
		return sNumeroDocumentoAntiguo;
	}

	public void setsNumeroDocumentoAntiguo(String sNumeroDocumentoAntiguo) {
		this.sNumeroDocumentoAntiguo = sNumeroDocumentoAntiguo;
	}

}
