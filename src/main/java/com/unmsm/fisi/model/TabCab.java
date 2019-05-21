package com.unmsm.fisi.model;

public class TabCab {
	private int nIdTabla;
	private String sNombreTabla;
	private String sDescripcion;
	
	public TabCab() {
		
	}
	
	public TabCab(int nIdTabla, String sNombreTabla, String sDescripcion) {
		super();
		this.nIdTabla = nIdTabla;
		this.sNombreTabla = sNombreTabla;
		this.sDescripcion = sDescripcion;
	}

	public int getnIdTabla() {
		return nIdTabla;
	}

	public void setnIdTabla(int nIdTabla) {
		this.nIdTabla = nIdTabla;
	}

	public String getsNombreTabla() {
		return sNombreTabla;
	}

	public void setsNombreTabla(String sNombreTabla) {
		this.sNombreTabla = sNombreTabla;
	}

	public String getsDescripcion() {
		return sDescripcion;
	}

	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}
	
}
