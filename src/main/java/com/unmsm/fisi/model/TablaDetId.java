package com.unmsm.fisi.model;

public class TablaDetId {
	private int nIdTabla;
	private String sIdItem;
	
	public TablaDetId() {
		
	}
	
	public TablaDetId(int nIdTabla, String sIdItem) {
		super();
		this.nIdTabla = nIdTabla;
		this.sIdItem = sIdItem;
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
	
}
