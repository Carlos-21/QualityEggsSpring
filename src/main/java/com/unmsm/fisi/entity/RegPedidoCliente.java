package com.unmsm.fisi.entity;
// Generated 19/05/2019 11:40:02 PM by Hibernate Tools 5.0.6.Final

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RegPedidoCliente generated by hbm2java
 */
@Entity
@Table(name = "reg_pedido_cliente", catalog = "QualityEggs")
public class RegPedidoCliente implements java.io.Serializable {

	private Integer nidPedido;
	private String manClienteManPersonaVTipoDocumento;
	private String manClienteManPersonaVNumeroDocumento;
	private Integer ncantidad;
	private Boolean vestado;
	private Date dfecha;
	private Time thora;

	public RegPedidoCliente() {
	}

	public RegPedidoCliente(String manClienteManPersonaVTipoDocumento, String manClienteManPersonaVNumeroDocumento) {
		this.manClienteManPersonaVTipoDocumento = manClienteManPersonaVTipoDocumento;
		this.manClienteManPersonaVNumeroDocumento = manClienteManPersonaVNumeroDocumento;
	}

	public RegPedidoCliente(String manClienteManPersonaVTipoDocumento, String manClienteManPersonaVNumeroDocumento,
			Integer ncantidad, Boolean vestado, Date dfecha, Time thora) {
		this.manClienteManPersonaVTipoDocumento = manClienteManPersonaVTipoDocumento;
		this.manClienteManPersonaVNumeroDocumento = manClienteManPersonaVNumeroDocumento;
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

	@Column(name = "man_cliente_man_persona_vTipoDocumento", nullable = false, length = 20)
	public String getManClienteManPersonaVTipoDocumento() {
		return this.manClienteManPersonaVTipoDocumento;
	}

	public void setManClienteManPersonaVTipoDocumento(String manClienteManPersonaVTipoDocumento) {
		this.manClienteManPersonaVTipoDocumento = manClienteManPersonaVTipoDocumento;
	}

	@Column(name = "man_cliente_man_persona_vNumeroDocumento", nullable = false, length = 20)
	public String getManClienteManPersonaVNumeroDocumento() {
		return this.manClienteManPersonaVNumeroDocumento;
	}

	public void setManClienteManPersonaVNumeroDocumento(String manClienteManPersonaVNumeroDocumento) {
		this.manClienteManPersonaVNumeroDocumento = manClienteManPersonaVNumeroDocumento;
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

	
	@Column(name = "tHora", length = 8)
	public Time getThora() {
		return this.thora;
	}

	public void setThora(Time thora) {
		this.thora = thora;
	}

}
