package com.unmsm.fisi.entity;
// Generated 18/05/2019 03:01:04 PM by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RegPedidoTrabajador generated by hbm2java
 */
@Entity
@Table(name = "reg_pedido_trabajador", catalog = "qualityeggs")
public class RegPedidoTrabajador implements java.io.Serializable {

	private Integer nidPedido;
	private ManTrabajador manTrabajador;
	private Integer ncantidad;
	private Boolean vestado;
	private Date dfecha;
	private Date thora;

	public RegPedidoTrabajador() {
	}

	public RegPedidoTrabajador(ManTrabajador manTrabajador) {
		this.manTrabajador = manTrabajador;
	}

	public RegPedidoTrabajador(ManTrabajador manTrabajador, Integer ncantidad, Boolean vestado, Date dfecha,
			Date thora) {
		this.manTrabajador = manTrabajador;
		this.ncantidad = ncantidad;
		this.vestado = vestado;
		this.dfecha = dfecha;
		this.thora = thora;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "nIdPedido", unique = true, nullable = false)
	public Integer getNidPedido() {
		return this.nidPedido;
	}

	public void setNidPedido(Integer nidPedido) {
		this.nidPedido = nidPedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "man_trabajador_man_persona_vNumeroDocumento", referencedColumnName = "man_persona_vNumeroDocumento", nullable = false),
			@JoinColumn(name = "man_trabajador_man_persona_vTipoDocumento", referencedColumnName = "man_persona_vTipoDocumento", nullable = false) })
	public ManTrabajador getManTrabajador() {
		return this.manTrabajador;
	}

	public void setManTrabajador(ManTrabajador manTrabajador) {
		this.manTrabajador = manTrabajador;
	}

	@Column(name = "nCantidad")
	public Integer getNcantidad() {
		return this.ncantidad;
	}

	public void setNcantidad(Integer ncantidad) {
		this.ncantidad = ncantidad;
	}

	@Column(name = "vEstado")
	public Boolean getVestado() {
		return this.vestado;
	}

	public void setVestado(Boolean vestado) {
		this.vestado = vestado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dFecha", length = 10)
	public Date getDfecha() {
		return this.dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "tHora", length = 8)
	public Date getThora() {
		return this.thora;
	}

	public void setThora(Date thora) {
		this.thora = thora;
	}

}
