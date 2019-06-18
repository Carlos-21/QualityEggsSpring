package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.RegPago;
import com.unmsm.fisi.model.PagoPedido;

@Component("pagoPedidoConvertidor")
public class PagoPedidoTransform implements Transform<PagoPedido, RegPago>{

	@Override
	public RegPago transformME(PagoPedido oModel) {
		if(oModel != null) {
			RegPago oEPagoPedido = new RegPago();
			oEPagoPedido.setRegPedidoClienteNIdPedido(oModel.getnIdPedido());
			oEPagoPedido.setNpagoTotal(oModel.getnMonto());
			oEPagoPedido.setDfecha(oModel.getdFecha());
			oEPagoPedido.setThora(oModel.gettHora());
			
			System.out.println("Fecha M: " + oModel.getdFecha().toString());
			System.out.println("Fecha E: " + oEPagoPedido.getDfecha().toString());
			return oEPagoPedido;
		}
		return null;
	}

	@Override
	public List<RegPago> transformME(List<PagoPedido> lModel) {
		if(lModel != null) {
			List<RegPago> lEPagoPedido = new ArrayList<>();
			
			for(PagoPedido oPagoPedido : lModel) {
				RegPago oEPagoPedido =  transformME(oPagoPedido);
				lEPagoPedido.add(oEPagoPedido);
			}
			
			return lEPagoPedido;
		}
		return null;
	}

	@Override
	public PagoPedido transformEM(RegPago oEntity) {
		if(oEntity != null) {
			PagoPedido oMPagoPedido = new PagoPedido();
			oMPagoPedido.setnIdPago(oEntity.getNidPago());
			oMPagoPedido.setnIdPedido(oEntity.getRegPedidoClienteNIdPedido());
			oMPagoPedido.setnMonto(oEntity.getNpagoTotal());
			oMPagoPedido.setdFecha(oEntity.getDfecha());
			oMPagoPedido.settHora(oEntity.getThora());
			oMPagoPedido.setsMonto(String.valueOf(oEntity.getNpagoTotal()) + " soles");
			return oMPagoPedido;
		}
		return null;
	}

	@Override
	public List<PagoPedido> transformEM(List<RegPago> lEntity) {
		if(lEntity != null) {
			List<PagoPedido> lMPagoPedido = new ArrayList<>();
			for(RegPago oPagoPedido : lEntity) {
				PagoPedido oMPagoPedido = transformEM(oPagoPedido);
				lMPagoPedido.add(oMPagoPedido);
			}
			
			return lMPagoPedido;
		}
		return null;
	}

}
