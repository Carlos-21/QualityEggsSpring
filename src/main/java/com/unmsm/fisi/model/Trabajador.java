package com.unmsm.fisi.model;

import java.util.Date;

public class Trabajador extends Persona{
	private String sArea;
	private String sPuesto;
	private String sTipoDocumentoAntiguo;
	private String sNumeroDocumentoAntiguo;
	
	public Trabajador() {
		
	}

	public Trabajador(String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sSexo, String sDomicilio, String sTelefonoFijo, String sTelefonoCelular,
			String sCorreo, Date dFecha, Date dHora,String sArea, String sPuesto) {
		super(sTipoDocumento, sNumeroDocumento, sNombre, sApellidoPaterno, sApellidoMaterno, sSexo, sDomicilio,
				sTelefonoFijo, sTelefonoCelular, sCorreo, dFecha, dHora);
		this.sArea = sArea;
		this.sPuesto = sPuesto;
	}

	public String getsArea() {
		return sArea;
	}

	public void setsArea(String sArea) {
		this.sArea = sArea;
	}

	public String getsPuesto() {
		return sPuesto;
	}

	public void setsPuesto(String sPuesto) {
		this.sPuesto = sPuesto;
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
