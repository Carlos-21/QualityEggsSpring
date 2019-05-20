package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.RegPedidoCliente;
import com.unmsm.fisi.model.PedidoCliente;

@Component("pedidoClienteConvertidor")
public class PedidoClienteTransform implements Transform<PedidoCliente, RegPedidoCliente>{

	@Override
	public RegPedidoCliente transformME(PedidoCliente oModel) {
		if(oModel != null) {
			RegPedidoCliente oEPedidoCliente = new RegPedidoCliente();
			oEPedidoCliente.setNidPedido(oModel.getNidPedido());
			oEPedidoCliente.setManClienteManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			oEPedidoCliente.setManClienteManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oEPedidoCliente.setNcantidad(oModel.getnCantidad());
			oEPedidoCliente.setVestado(oModel.getvEstado());
			oEPedidoCliente.setDfecha(oModel.getdFecha());
			oEPedidoCliente.setThora(oModel.gettHora());
			
			return oEPedidoCliente;
		}
		return null;
	}

	@Override
	public List<RegPedidoCliente> transformME(List<PedidoCliente> lModel) {
		if(lModel != null) {
			List<RegPedidoCliente> lEPedidoCliente = new ArrayList<RegPedidoCliente>();
			for(PedidoCliente oPedidoCliente : lModel) {
				RegPedidoCliente oEPedidoCliente = transformME(oPedidoCliente);
				lEPedidoCliente.add(oEPedidoCliente);
			}
			return lEPedidoCliente;
		}
		return null;
	}

	@Override
	public PedidoCliente transformEM(RegPedidoCliente oEntity) {
		if(oEntity != null) {
			PedidoCliente oMPedidoCliente = new PedidoCliente();
			oMPedidoCliente.setNidPedido(oEntity.getNidPedido());
			oMPedidoCliente.setsNumeroDocumento(oEntity.getManClienteManPersonaVNumeroDocumento());
			oMPedidoCliente.setsTipoDocumento(oEntity.getManClienteManPersonaVTipoDocumento());
			oMPedidoCliente.setnCantidad(oEntity.getNcantidad());
		}
		return null;
	}

	@Override
	public List<PedidoCliente> transformEM(List<RegPedidoCliente> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
