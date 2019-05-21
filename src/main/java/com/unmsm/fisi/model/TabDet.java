package com.unmsm.fisi.model;

public class TabDet {
	private int nIdTabla;
	private String sIdItem;
	private String sDescripcionCorta;
	private String sDescripcion;
	
	public TabDet() {
		
	}
	
	public TabDet(int nIdTabla, String sIdItem, String sDescripcionCorta, String sDescripcion) {
		super();
		this.nIdTabla = nIdTabla;
		this.sIdItem = sIdItem;
		this.sDescripcionCorta = sDescripcionCorta;
		this.sDescripcion = sDescripcion;
	}

	public int getnIdTabla() {
		return nIdTabla;
	}

	public void setnIdTabla(int nIdTabla) {
		this.nIdTabla = nIdTabla;
	}

	public String getsIdItem() {
		return sIdItem;
	}

	public void setsIdItem(String sIdItem) {
		this.sIdItem = sIdItem;
	}

	public String getsDescripcionCorta() {
		return sDescripcionCorta;
	}

	public void setsDescripcionCorta(String sDescripcionCorta) {
		this.sDescripcionCorta = sDescripcionCorta;
	}

	public String getsDescripcion() {
		return sDescripcion;
	}

	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}
	
}
