package com.unmsm.fisi.service.impl.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.RegPedidoHasManProducto;
import com.unmsm.fisi.entity.RegPedidoHasManProductoId;
import com.unmsm.fisi.model.PedidoClienteProducto;
import com.unmsm.fisi.model.PedidoClienteProductoId;
import com.unmsm.fisi.repository.PedidoClienteProductoRepository;
import com.unmsm.fisi.service.PedidoClienteProductoService;
import com.unmsm.fisi.service.transform.PedidoClienteProductoTransform;

@Service("pedidoClienteProductoServicio")
public class PedidoClienteProductoServiceImpl implements PedidoClienteProductoService{
	@Autowired
	@Qualifier("pedidoClienteProductoRepositorio")
	private PedidoClienteProductoRepository pedCliProdRepository;
	@Autowired
	@Qualifier("pedidoClienteProductoConvertidor")
	private PedidoClienteProductoTransform pedCliProdTransform;
	
	@Override
	public PedidoClienteProductoId buscarPedidoClienteProducto(int nIdPedidoCliente, int nIdProducto) {
		RegPedidoHasManProductoId oEPedCliProd = new RegPedidoHasManProductoId();
		oEPedCliProd.setManProductoNIdProducto(nIdProducto);
		oEPedCliProd.setRegPedidoClienteNIdPedido(nIdPedidoCliente);
		RegPedidoHasManProducto oEPedidoCliente = new RegPedidoHasManProducto();
		oEPedidoCliente.setId(oEPedCliProd);
		return pedCliProdTransform.transformEM(oEPedidoCliente).getIdPedCliProd();
	}
	
	@Override
	public PedidoClienteProductoId registrarPedidoClienteProducto(PedidoClienteProducto oPedClieProdu) {
		pedCliProdRepository.save(pedCliProdTransform.transformME(oPedClieProdu));
		return oPedClieProdu.getIdPedCliProd();
	}

	@Override
	public void eliminarPedidoClienteProducto(PedidoClienteProductoId oPedClieProdu) {
		PedidoClienteProducto oMPedCliProd = new PedidoClienteProducto();
		oMPedCliProd.setIdPedCliProd(oPedClieProdu);
		
		pedCliProdRepository.delete(pedCliProdTransform.transformME(oMPedCliProd));
	}

}
