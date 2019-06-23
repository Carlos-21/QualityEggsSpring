package com.unmsm.fisi.model;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PagoPedido {
	private Integer nIdPago;
	private int nIdPedido;
	private double nMonto;
	private String sMonto;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
	private Date dFecha;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "EST")
	private Time tHora;
	private String sTipoPago;
	private byte[] bVoucher;
	private String sNumeroDocumento;
	private String sEmpresa;
	private String sRubro;
	
	public PagoPedido() {
		super();
	}

	public PagoPedido(Integer nIdPago, int nIdPedido, double nMonto, String sMonto, Date dFecha, Time tHora,
			String sTipoPago, byte[] bVoucher, String sNumeroDocumento, String sEmpresa, String sRubro) {
		super();
		this.nIdPago = nIdPago;
		this.nIdPedido = nIdPedido;
		this.nMonto = nMonto;
		this.sMonto = sMonto;
		this.dFecha = dFecha;
		this.tHora = tHora;
		this.sTipoPago = sTipoPago;
		this.bVoucher = bVoucher;
		this.sNumeroDocumento = sNumeroDocumento;
		this.sEmpresa = sEmpresa;
		this.sRubro = sRubro;
	}

	public Integer getnIdPago() {
		return nIdPago;
	}

	public void setnIdPago(Integer nIdPago) {
		this.nIdPago = nIdPago;
	}

	public int getnIdPedido() {
		return nIdPedido;
	}

	public void setnIdPedido(int nIdPedido) {
		this.nIdPedido = nIdPedido;
	}

	public double getnMonto() {
		return nMonto;
	}

	public void setnMonto(double nMonto) {
		this.nMonto = nMonto;
	}

	public String getsMonto() {
		return sMonto;
	}

	public void setsMonto(String sMonto) {
		this.sMonto = sMonto;
	}

	public Date getdFecha() {
		return dFecha;
	}

	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}

	public Time gettHora() {
		return tHora;
	}

	public void settHora(Time tHora) {
		this.tHora = tHora;
	}

	public String getsNumeroDocumento() {
		return sNumeroDocumento;
	}

	public void setsNumeroDocumento(String sNumeroDocumento) {
		this.sNumeroDocumento = sNumeroDocumento;
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

	public String getsTipoPago() {
		return sTipoPago;
	}

	public void setsTipoPago(String sTipoPago) {
		this.sTipoPago = sTipoPago;
	}

	public byte[] getbVoucher() {
		return bVoucher;
	}

	public void setbVoucher(byte[] bVoucher) {
		this.bVoucher = bVoucher;
	}

}
