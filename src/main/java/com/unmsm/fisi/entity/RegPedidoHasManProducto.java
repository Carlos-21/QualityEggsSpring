package com.unmsm.fisi.entity;
// Generated 19/05/2019 11:40:02 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * RegPedidoHasManProducto generated by hbm2java
 */
@Entity
@Table(name = "reg_pedido_has_man_producto", catalog = "QualityEggs")
public class RegPedidoHasManProducto implements java.io.Serializable {

	private RegPedidoHasManProductoId id;

	public RegPedidoHasManProducto() {
	}

	public RegPedidoHasManProducto(RegPedidoHasManProductoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "regPedidoClienteNIdPedido", column = @Column(name = "reg_pedido_cliente_nIdPedido", nullable = false)),
			@AttributeOverride(name = "manProductoNIdProducto", column = @Column(name = "man_producto_nIdProducto", nullable = false)) })
	public RegPedidoHasManProductoId getId() {
		return this.id;
	}

	public void setId(RegPedidoHasManProductoId id) {
		this.id = id;
	}

}
