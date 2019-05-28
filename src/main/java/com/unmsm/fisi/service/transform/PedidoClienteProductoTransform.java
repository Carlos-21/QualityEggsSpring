package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.RegPedidoHasManProducto;
import com.unmsm.fisi.entity.RegPedidoHasManProductoId;
import com.unmsm.fisi.model.PedidoClienteProducto;
import com.unmsm.fisi.model.PedidoClienteProductoId;

@Component("pedidoClienteProductoConvertidor")
public class PedidoClienteProductoTransform implements Transform<PedidoClienteProducto, RegPedidoHasManProducto>{

	@Override
	public RegPedidoHasManProducto transformME(PedidoClienteProducto oModel) {
		if(oModel != null) {
			RegPedidoHasManProducto oEPedidoProducto = new RegPedidoHasManProducto();
			RegPedidoHasManProductoId oEIdPedidoProducto = new RegPedidoHasManProductoId();
			oEIdPedidoProducto.setRegPedidoClienteNIdPedido(oModel.getIdPedCliProd().getnIdPedidoCliente());
			oEIdPedidoProducto.setManProductoNIdProducto(oModel.getIdPedCliProd().getnIdProducto());
			
			oEPedidoProducto.setId(oEIdPedidoProducto);
			
			return oEPedidoProducto;
		}
		return null;
	}

	@Override
	public List<RegPedidoHasManProducto> transformME(List<PedidoClienteProducto> lModel) {
		if(lModel != null) {
			List<RegPedidoHasManProducto> lEPedidoProducto = new ArrayList<>();
			
			for(PedidoClienteProducto oPedCliProd : lModel) {
				RegPedidoHasManProducto oEPedidoProducto =  transformME(oPedCliProd);
				
				lEPedidoProducto.add(oEPedidoProducto);
			}
			
			return lEPedidoProducto;
		}
		return null;
	}

	@Override
	public PedidoClienteProducto transformEM(RegPedidoHasManProducto oEntity) {
		if(oEntity != null) {
			PedidoClienteProducto oMPedCliProd = new PedidoClienteProducto();
			PedidoClienteProductoId oMIdPedCliProd = new PedidoClienteProductoId();
			oMIdPedCliProd.setnIdPedidoCliente(oEntity.getId().getRegPedidoClienteNIdPedido());
			oMIdPedCliProd.setnIdProducto(oEntity.getId().getManProductoNIdProducto());
			
			oMPedCliProd.setIdPedCliProd(oMIdPedCliProd);
			
			return oMPedCliProd;
		}
		return null;
	}

	@Override
	public List<PedidoClienteProducto> transformEM(List<RegPedidoHasManProducto> lEntity) {
		if(lEntity != null) {
			List<PedidoClienteProducto> lMPedCliProd = new ArrayList<>();
			
			for(RegPedidoHasManProducto oPedCliProd : lEntity) {
				PedidoClienteProducto oMPedCliProd = transformEM(oPedCliProd);
				lMPedCliProd.add(oMPedCliProd);
			}
			
			return lMPedCliProd;
		}
		return null;
	}

}
