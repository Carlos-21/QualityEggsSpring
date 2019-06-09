package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.RegPedidoTrabajador;
import com.unmsm.fisi.model.PedidoTrabajador;

@Component("pedidoTrabajadorConvertidor")
public class PedidoTrabajadorTransform implements Transform<PedidoTrabajador, RegPedidoTrabajador>{

	@Override
	public RegPedidoTrabajador transformME(PedidoTrabajador oModel) {
		if(oModel != null) {
			RegPedidoTrabajador oEPedidoTrabajador = new RegPedidoTrabajador();
			oEPedidoTrabajador.setManTrabajadorManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oEPedidoTrabajador.setManTrabajadorManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			oEPedidoTrabajador.setNcantidad(oModel.getnCantidad());
			oEPedidoTrabajador.setVestado(oModel.getvEstado());
			
			return oEPedidoTrabajador;
		}
		return null;
	}

	@Override
	public List<RegPedidoTrabajador> transformME(List<PedidoTrabajador> lModel) {
		if(lModel != null) {
			List<RegPedidoTrabajador> lEPedidoTrabajador = new ArrayList<>();
			for(PedidoTrabajador oPedidoTrabajador : lModel) {
				RegPedidoTrabajador oEPedidoTrabajdor = transformME(oPedidoTrabajador);
				lEPedidoTrabajador.add(oEPedidoTrabajdor);
			}
			return lEPedidoTrabajador;
		}
		return null;
	}

	@Override
	public PedidoTrabajador transformEM(RegPedidoTrabajador oEntity) {
		if(oEntity != null) {
			PedidoTrabajador oMPedidoTrabajador = new PedidoTrabajador();
			oMPedidoTrabajador.setnIdPedido(oEntity.getNidPedido());
			oMPedidoTrabajador.setsTipoDocumento(oEntity.getManTrabajadorManPersonaVTipoDocumento());
			oMPedidoTrabajador.setsNumeroDocumento(oEntity.getManTrabajadorManPersonaVNumeroDocumento());
			oMPedidoTrabajador.setnCantidad(oEntity.getNcantidad());
			oMPedidoTrabajador.setvEstado(oEntity.getVestado());
			
			return oMPedidoTrabajador;
		}
		return null;
	}

	@Override
	public List<PedidoTrabajador> transformEM(List<RegPedidoTrabajador> lEntity) {
		if(lEntity != null) {
			List<PedidoTrabajador> lMPedidoTrabajador = new ArrayList<>();
			for(RegPedidoTrabajador oPedidoTrabajador : lEntity) {
				PedidoTrabajador oMPedidoTrabajador =  transformEM(oPedidoTrabajador);
				lMPedidoTrabajador.add(oMPedidoTrabajador);
			}
			
			return lMPedidoTrabajador;
		}
		return null;
	}

}
