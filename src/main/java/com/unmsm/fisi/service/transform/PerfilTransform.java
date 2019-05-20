package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.SegPerfil;
import com.unmsm.fisi.model.Perfil;

@Component("perfilConvertidor")
public class PerfilTransform implements Transform<Perfil, SegPerfil>{

	@Override
	public SegPerfil transformME(Perfil oModel) {
		if(oModel != null) {
			SegPerfil oEPerfil = new SegPerfil();
			oEPerfil.setNidPerfil(oModel.getnIdPerfil());
			oEPerfil.setVnombre(oModel.getsNombre());
			oEPerfil.setVdescripcion(oModel.getsDescripcion());
			
			return oEPerfil;
		}
		return null;
	}

	@Override
	public List<SegPerfil> transformME(List<Perfil> lModel) {
		if(lModel != null) {
			List<SegPerfil> lEPerfil = new ArrayList<>();
			
			for(Perfil oPerfil : lModel) {
				SegPerfil oEPerfil = transformME(oPerfil);
				lEPerfil.add(oEPerfil);
			}
			return lEPerfil;
		}
		return null;
	}

	@Override
	public Perfil transformEM(SegPerfil oEntity) {
		if(oEntity != null) {
			Perfil oMPerfil = new Perfil();
			oMPerfil.setnIdPerfil(oEntity.getNidPerfil());
			oMPerfil.setsNombre(oEntity.getVnombre());
			oMPerfil.setsDescripcion(oEntity.getVdescripcion());
			
			return oMPerfil;
		}
		return null;
	}

	@Override
	public List<Perfil> transformEM(List<SegPerfil> lEntity) {
		if(lEntity != null) {
			List<Perfil> lMPerfil = new ArrayList<>();
			
			for(SegPerfil oPerfil : lEntity) {
				Perfil oMPerfil = transformEM(oPerfil);
				lMPerfil.add(oMPerfil);
			}
			return lMPerfil;
		}
		return null;
	}

}
