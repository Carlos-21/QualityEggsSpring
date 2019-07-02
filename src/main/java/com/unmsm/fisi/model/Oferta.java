package com.unmsm.fisi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Oferta {
	private Integer nIdOferta;
	private String sDescripcion;
	private Integer nDescuento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
	private Date dFechaInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
	private Date dFechaFin;

	public Oferta() {

	}

	public Oferta(Integer nIdOferta, String sDescripcion, Integer nDescuento, Date dFechaInicio, Date dFechaFin) {
		super();
		this.nIdOferta = nIdOferta;
		this.sDescripcion = sDescripcion;
		this.nDescuento = nDescuento;
		this.dFechaInicio = dFechaInicio;
		this.dFechaFin = dFechaFin;
	}

	public Integer getnIdOferta() {
		return nIdOferta;
	}

	public void setnIdOferta(Integer nIdOferta) {
		this.nIdOferta = nIdOferta;
	}

	public String getsDescripcion() {
		return sDescripcion;
	}

	public void setsDescripcion(String sDescripcion) {
		this.sDescripcion = sDescripcion;
	}

	public Integer getnDescuento() {
		return nDescuento;
	}

	public void setnDescuento(Integer nDescuento) {
		this.nDescuento = nDescuento;
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

}
