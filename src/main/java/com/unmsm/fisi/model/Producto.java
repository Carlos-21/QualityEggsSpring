package com.unmsm.fisi.model;

import java.util.List;

public class Producto {
	private Integer nIdentificador;
	private String sNombre;
	private String sDescripcion;
	private String sTipo;
	private Integer nStock;
	private Double nPrecioUnitario;
	
	public Producto() {
		
	}
	
	public Producto(Integer nIdentificador, String sNombre, String sDescripcion, String sTipo, Integer nStock,
			Double nPrecioUnitario) {
		super();
		this.nIdentificador = nIdentificador;
		this.sNombre = sNombre;
		this.sDescripcion = sDescripcion;
		this.sTipo = sTipo;
		this.nStock = nStock;
		this.nPrecioUnitario = nPrecioUnitario;
	}

	public Integer getnIdentificador() {
		return nIdentificador;
	}

	public void setnIdentificador(Integer nIdentificador) {
		this.nIdentificador = nIdentificador;
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

	public String getsTipo() {
		return sTipo;
	}

	public void setsTipo(String sTipo) {
		this.sTipo = sTipo;
	}

	public Integer getnStock() {
		return nStock;
	}

	public void setnStock(Integer nStock) {
		this.nStock = nStock;
	}

	public Double getnPrecioUnitario() {
		return nPrecioUnitario;
	}

	public void setnPrecioUnitario(Double nPrecioUnitario) {
		this.nPrecioUnitario = nPrecioUnitario;
	}
	
}
