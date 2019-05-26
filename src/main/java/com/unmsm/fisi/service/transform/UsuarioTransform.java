package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManPersona;
import com.unmsm.fisi.entity.ManPersonaId;
import com.unmsm.fisi.entity.SegPerfil;
import com.unmsm.fisi.entity.SegUsuario;
import com.unmsm.fisi.model.Usuario;

@Component("usuarioConvertidor")
public class UsuarioTransform implements Transform<Usuario, SegUsuario>{

	@Override
	public SegUsuario transformME(Usuario oModel) {
		if(oModel != null) {
			SegUsuario oEUsuario = new SegUsuario();
			oEUsuario.setVidUsuario(oModel.getsIdentificador());
			
			ManPersona oEPersona = new ManPersona();
			ManPersonaId oEPersonaId = new ManPersonaId();
			oEPersonaId.setVnumeroDocumento(oModel.getsNumeroDocumento());
			oEPersonaId.setVtipoDocumento(oModel.getsTipoDocumento());
			oEPersona.setId(oEPersonaId);
			
			oEUsuario.setManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			oEUsuario.setManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oEUsuario.setVclave(oModel.getsClave());
			
			SegPerfil oEPerfil = new SegPerfil();
			oEPerfil.setNidPerfil(oModel.getNidPerfil());
			
			oEUsuario.setSegPerfilNIdPerfil(oModel.getNidPerfil());;
			oEUsuario.setBactivo(oModel.isbEstado());
			oEUsuario.setDfecha(oModel.getdFecha());
			oEUsuario.setThora(oModel.getdHora());
			
			return oEUsuario;
		}
		return null;
	}

	@Override
	public List<SegUsuario> transformME(List<Usuario> lModel) {
		if(lModel != null) {
			List<SegUsuario> lEUsuario = new ArrayList<>();
			
			for(Usuario oUsuario : lModel) {
				SegUsuario oEUsuario = transformME(oUsuario);
				lEUsuario.add(oEUsuario);
			}
			
			return lEUsuario;
		}
		return null;
	}

	@Override
	public Usuario transformEM(SegUsuario oEntity) {
		if(oEntity != null) {
			Usuario oMUsuario = new Usuario();
			oMUsuario.setsTipoDocumento(oEntity.getManPersonaVTipoDocumento());
			oMUsuario.setsNumeroDocumento(oEntity.getManPersonaVNumeroDocumento());
			oMUsuario.setsIdentificador(oEntity.getVidUsuario());
			oMUsuario.setsClave(oEntity.getVclave());
			oMUsuario.setbEstado(oEntity.getBactivo());
			oMUsuario.setNidPerfil(oEntity.getSegPerfilNIdPerfil());
			oMUsuario.setdFecha(oEntity.getDfecha());
			oMUsuario.setdHora(oEntity.getThora());
			oMUsuario.setsNumeroDocumento(oEntity.getManPersonaVNumeroDocumento());
			oMUsuario.setsTipoDocumento(oEntity.getManPersonaVTipoDocumento());
			
			return oMUsuario;
		}
		return null;
	}

	@Override
	public List<Usuario> transformEM(List<SegUsuario> lEntity) {
		if(lEntity != null) {
			List<Usuario> lMUsuario = new ArrayList<>();
			
			for(SegUsuario oUsuario : lEntity) {
				Usuario oEUsuario = transformEM(oUsuario);
				lMUsuario.add(oEUsuario);
			}
			return lMUsuario;
		}
		return null;
	}

}
