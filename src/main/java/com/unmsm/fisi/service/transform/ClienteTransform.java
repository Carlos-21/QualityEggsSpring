package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManCliente;
import com.unmsm.fisi.entity.ManClienteId;
import com.unmsm.fisi.model.Cliente;

@Component("clienteConvertidor")
public class ClienteTransform implements Transform<Cliente, ManCliente>{

	@Override
	public ManCliente transformME(Cliente oModel) {
		if(oModel != null) {
			ManClienteId oEClienteId = new ManClienteId();
			oEClienteId.setManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oEClienteId.setManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			
			ManCliente oECliente = new ManCliente();
			oECliente.setId(oEClienteId);
			oECliente.setVempresa(oModel.getsEmpresa());
			oECliente.setVrubro(oModel.getsRubro());
			
			return oECliente;
		}
		return null;
	}

	@Override
	public List<ManCliente> transformME(List<Cliente> lModel) {
		if(lModel != null) {
			List<ManCliente> lECliente = new ArrayList<>();
			
			for(Cliente oCliente : lModel) {
				ManCliente oECliente = transformME(oCliente);
				lECliente.add(oECliente);
			}
			
			return lECliente;
		}
		return null;
	}

	@Override
	public Cliente transformEM(ManCliente oEntity) {
		if(oEntity != null) {
			Cliente oMCliente = new Cliente();
			oMCliente.setsTipoDocumento(oEntity.getId().getManPersonaVTipoDocumento());
			oMCliente.setsNumeroDocumento(oEntity.getId().getManPersonaVNumeroDocumento());
			oMCliente.setsEmpresa(oEntity.getVempresa());
			oMCliente.setsRubro(oEntity.getVrubro());
			
			return oMCliente;
		}
		return null;
	}

	@Override
	public List<Cliente> transformEM(List<ManCliente> lEntity) {
		if(lEntity != null) {
			List<Cliente> lMCliente = new ArrayList<>();
			
			for(ManCliente oCliente : lEntity) {
				Cliente oMCliente = transformEM(oCliente);
				lMCliente.add(oMCliente);
			}
			return lMCliente;
		}
		return null;
	}
	
}
