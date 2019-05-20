package com.unmsm.fisi.service.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Perfil;
import com.unmsm.fisi.repository.PerfilRepository;
import com.unmsm.fisi.service.PerfilService;
import com.unmsm.fisi.service.transform.PerfilTransform;

@Service("perfilServicio")
public class PerfilServiceImpl implements PerfilService {
	@Autowired
	@Qualifier("perfilRepositorio")
	private PerfilRepository perfilRepository;

	@Autowired
	@Qualifier("perfilConvertidor")
	private PerfilTransform perfilTransform;

	@Override
	public List<Perfil> listarPerfiles() {
		return perfilTransform.transformEM(perfilRepository.findAll());
	}

	@Override
	public Perfil buscarPerfil(Integer nIdPerfil) {
		return perfilTransform.transformEM(perfilRepository.findOne(nIdPerfil));
	}

	@Override
	public Integer registrarPerfil(Perfil oPerfil) {
		perfilRepository.save(perfilTransform.transformME(oPerfil));
		return listarPerfiles().get(listarPerfiles().size()-1).getnIdPerfil();
	}

	@Override
	public Integer actualizarPerfil(Perfil oPerfil) {
		perfilRepository.save(perfilTransform.transformME(oPerfil));
		return listarPerfiles().get(listarPerfiles().size()-1).getnIdPerfil();
	}

	@Override
	public void eliminarPerfil(Integer nIdPerfil) {
		perfilRepository.delete(nIdPerfil);
	}

}
