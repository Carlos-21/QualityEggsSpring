package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManPersona;
import com.unmsm.fisi.entity.ManPersonaId;
import com.unmsm.fisi.model.Persona;

@Component("personaConvertidor")
public class PersonaTransform implements Transform<Persona, ManPersona>{

	@Override
	public ManPersona transformME(Persona oModel) {
		if(oModel != null) {
			ManPersona oEPersona = new ManPersona();
			ManPersonaId oEPersonaId = new ManPersonaId();
			oEPersonaId.setVtipoDocumento(oModel.getsTipoDocumento());
			oEPersonaId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			oEPersona.setId(oEPersonaId);
			oEPersona.setVnombre(oModel.getsNombre());
			oEPersona.setVapellidoPaterno(oModel.getsApellidoPaterno());
			oEPersona.setVapellidoMaterno(oModel.getsApellidoMaterno());
			oEPersona.setVsexo(oModel.getsSexo());
			oEPersona.setVdomicilio(oModel.getsDomicilio());
			oEPersona.setVtelefonoFijo(oModel.getsTelefonoFijo());
			oEPersona.setVtelefonoCelular(oModel.getsTelefonoCelular());
			oEPersona.setVcorreo(oModel.getsCorreo());
			oEPersona.setDfecha(oModel.getdFecha());
			oEPersona.setThora(oModel.getdHora());
			
			return oEPersona;
		}
		return null;
	}

	@Override
	public List<ManPersona> transformME(List<Persona> lModel) {
		if(lModel != null) {
			List<ManPersona> lEPersona = new ArrayList<>();
			
			for(Persona oPersona : lModel) {
				ManPersona oEPersona = transformME(oPersona);
				
				lEPersona.add(oEPersona);
			}
			return lEPersona;
		}
		return null;
	}

	@Override
	public Persona transformEM(ManPersona oEntity) {
		if(oEntity != null) {
			Persona oMPersona = new Persona();
			oMPersona.setsTipoDocumento(oEntity.getId().getVtipoDocumento());
			oMPersona.setsNumeroDocumento(oEntity.getId().getVnumeroDocumento());
			oMPersona.setsNombre(oEntity.getVnombre());
			oMPersona.setsApellidoPaterno(oEntity.getVapellidoPaterno());
			oMPersona.setsApellidoMaterno(oEntity.getVapellidoMaterno());
			oMPersona.setsSexo(oEntity.getVsexo());
			oMPersona.setsDomicilio(oEntity.getVdomicilio());
			oMPersona.setsTelefonoFijo(oEntity.getVtelefonoFijo());
			oMPersona.setsTelefonoCelular(oEntity.getVtelefonoCelular());
			oMPersona.setsCorreo(oEntity.getVcorreo());
			oMPersona.setdFecha(oEntity.getDfecha());
			oMPersona.setdHora(oEntity.getThora());
			
			return oMPersona;
		}
		return null;
	}

	@Override
	public List<Persona> transformEM(List<ManPersona> lEntity) {
		if(lEntity != null) {
			List<Persona> lMPersona = new ArrayList<>();
			
			for(ManPersona oPersona : lEntity) {
				Persona oMPersona = transformEM(oPersona);
				
				lMPersona.add(oMPersona);
			}
			
			return lMPersona;
		}
		return null;
	}

}
