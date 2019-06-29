package com.unmsm.fisi.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BusquedaParametro {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dFechaFin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dFechaInicio;
	private String sNumeroDocumento;
	private Boolean vEstado;

	public BusquedaParametro() {

	}

	public BusquedaParametro(String sNumeroDocumento, Date dFechaInicio, Date dFechaFin, Boolean vEstado) {
		super();
		this.sNumeroDocumento = sNumeroDocumento;
		this.dFechaInicio = dFechaInicio;
		this.dFechaFin = dFechaFin;
		this.vEstado = vEstado;
	}

	public String getsNumeroDocumento() {
		return sNumeroDocumento;
	}

	public void setsNumeroDocumento(String sNumeroDocumento) {
		this.sNumeroDocumento = sNumeroDocumento;
	}

	public Date getdFechaInicio() {
		return dFechaInicio;
	}

	public void setdFechaInicio(Date dFechaInicio) {
		this.dFechaInicio = dFechaInicio;
	}

	public Date getdFechaFin() {
		return dFechaFin;
	}

	public void setdFechaFin(Date dFechaFin) {
		this.dFechaFin = dFechaFin;
	}

	public Boolean getvEstado() {
		return vEstado;
	}

	public void setvEstado(Boolean vEstado) {
		this.vEstado = vEstado;
	}

}
