package com.unmsm.fisi.entity;
// Generated 19/05/2019 11:40:02 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MultiTabCab generated by hbm2java
 */
@Entity
@Table(name = "multi_tab_cab", catalog = "QualityEggs")
public class MultiTabCab implements java.io.Serializable {

	private int nidTabla;
	private String vnombreTabla;
	private String vdescripcion;

	public MultiTabCab() {
	}

	public MultiTabCab(int nidTabla) {
		this.nidTabla = nidTabla;
	}

	public MultiTabCab(int nidTabla, String vnombreTabla, String vdescripcion) {
		this.nidTabla = nidTabla;
		this.vnombreTabla = vnombreTabla;
		this.vdescripcion = vdescripcion;
	}

	@Id

	@Column(name = "nIdTabla", unique = true, nullable = false)
	public int getNidTabla() {
		return this.nidTabla;
	}

	public void setNidTabla(int nidTabla) {
		this.nidTabla = nidTabla;
	}

	@Column(name = "vNombreTabla", length = 150)
	public String getVnombreTabla() {
		return this.vnombreTabla;
	}

	public void setVnombreTabla(String vnombreTabla) {
		this.vnombreTabla = vnombreTabla;
	}

	@Column(name = "vDescripcion", length = 500)
	public String getVdescripcion() {
		return this.vdescripcion;
	}

	public void setVdescripcion(String vdescripcion) {
		this.vdescripcion = vdescripcion;
	}

}
