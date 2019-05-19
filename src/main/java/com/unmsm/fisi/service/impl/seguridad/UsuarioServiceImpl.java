package com.unmsm.fisi.service.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Usuario;
import com.unmsm.fisi.repository.UsuarioRepository;
import com.unmsm.fisi.service.UsuarioService;
import com.unmsm.fisi.service.transform.UsuarioTransform;

@Service("usuarioServicio")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuarioRepositorio")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConvertidor")
	private UsuarioTransform usuarioTransform;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioTransform.transformEM(usuarioRepository.findAll());
	}

	@Override
	public Usuario buscarUsuario(String sIdentificador) {
		return usuarioTransform.transformEM(usuarioRepository.findByVidUsuario(sIdentificador));
	}

	@Override
	public String registrarUsuario(Usuario oUsuario) {
		usuarioRepository.save(usuarioTransform.transformME(oUsuario));
		return listarUsuarios().get(listarUsuarios().size()-1).getsIdentificador();
	}

	@Override
	public String actualizarUsuario(Usuario oUsuario) {
		usuarioRepository.save(usuarioTransform.transformME(oUsuario));
		return listarUsuarios().get(listarUsuarios().size()-1).getsIdentificador();
	}

	@Override
	public void eliminarUsuario(String sIdentificador) {
		usuarioRepository.delete(sIdentificador);
	}

}
