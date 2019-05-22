package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManTrabajador;
import com.unmsm.fisi.entity.ManTrabajadorId;
import com.unmsm.fisi.model.Trabajador;

@Component("trabajadorConvertidor")
public class TrabajadorTransform implements Transform<Trabajador, ManTrabajador>{

	@Override
	public ManTrabajador transformME(Trabajador oModel) {
		if(oModel != null) {
			ManTrabajadorId oETrabajadorId = new ManTrabajadorId();
			oETrabajadorId.setManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oETrabajadorId.setManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			
			ManTrabajador oETrabajador = new ManTrabajador();
			oETrabajador.setId(oETrabajadorId);
			oETrabajador.setVarea(oModel.getsArea());
			oETrabajador.setVpuesto(oModel.getsPuesto());
			return oETrabajador;
		}
		return null;
	}

	@Override
	public List<ManTrabajador> transformME(List<Trabajador> lModel) {
		if(lModel != null) {
			List<ManTrabajador> lETrabajador = new ArrayList<>();
			
			for(Trabajador oTrabajador : lModel) {
				ManTrabajador oETrabajador = transformME(oTrabajador);
				lETrabajador.add(oETrabajador);
			}
			
			return lETrabajador;
		}
		return null;
	}

	@Override
	public Trabajador transformEM(ManTrabajador oEntity) {
		if(oEntity != null) {
			Trabajador oMTrabajador = new Trabajador();
			oMTrabajador.setsTipoDocumento(oEntity.getId().getManPersonaVTipoDocumento());
			oMTrabajador.setsNumeroDocumento(oEntity.getId().getManPersonaVNumeroDocumento());
			oMTrabajador.setsArea(oEntity.getVarea());
			oMTrabajador.setsPuesto(oEntity.getVpuesto());
			
			return oMTrabajador;
		}
		return null;
	}

	@Override
	public List<Trabajador> transformEM(List<ManTrabajador> lEntity) {
		if(lEntity != null) {
			List<Trabajador> lETrabajador = new ArrayList<>();
			
			for(ManTrabajador oTrabajador : lEntity) {
				Trabajador oMTrabajador = transformEM(oTrabajador);
				lETrabajador.add(oMTrabajador);
			}
			return lETrabajador;
		}
		return null;
	}

}
