package com.unmsm.fisi.model;

public class Perfil {
	private Integer nIdPerfil;
	private String sNombre;
	private String sDescripcion;

	public Perfil() {

	}

	public Perfil(Integer nIdPerfil, String sNombre, String sDescripcion) {
		super();
		this.nIdPerfil = nIdPerfil;
		this.sNombre = sNombre;
		this.sDescripcion = sDescripcion;
	}

	public Integer getnIdPerfil() {
		return nIdPerfil;
	}

	public void setnIdPerfil(Integer nIdPerfil) {
		this.nIdPerfil = nIdPerfil;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsDescripcion() {
		return sDescripcion;
	}

	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}

}
