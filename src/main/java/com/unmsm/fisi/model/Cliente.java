package com.unmsm.fisi.model;

import java.util.Date;

public class Cliente extends Persona {
	private String sEmpresa;
	private String sRubro;

	public Cliente() {
		super();
	}

	public Cliente(String sTipoDocumento, String sNumeroDocumento, String sNombre, String sApellidoPaterno,
			String sApellidoMaterno, String sSexo, String sDomicilio, String sTelefonoFijo, String sTelefonoCelular,
			String sCorreo, Date dFecha, Date dHora, String sEmpresa, String sRubro) {
		super(sTipoDocumento, sNumeroDocumento, sNombre, sApellidoPaterno, sApellidoMaterno, sSexo, sDomicilio,
				sTelefonoFijo, sTelefonoCelular, sCorreo, dFecha, dHora);
		this.sEmpresa = sEmpresa;
		this.sRubro = sRubro;
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

}
