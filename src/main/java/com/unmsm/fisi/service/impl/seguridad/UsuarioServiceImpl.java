package com.unmsm.fisi.service.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Perfil;
import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.Usuario;
import com.unmsm.fisi.repository.UsuarioRepository;
import com.unmsm.fisi.service.PersonaService;
import com.unmsm.fisi.service.UsuarioService;
import com.unmsm.fisi.service.impl.mantenimiento.PersonaServiceImpl;
import com.unmsm.fisi.service.transform.UsuarioTransform;

@Service("usuarioServicio")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("usuarioRepositorio")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConvertidor")
	private UsuarioTransform usuarioTransform;
	
	@Autowired
	@Qualifier("perfilServicio")
	private PerfilServiceImpl perfilService;
	
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaService;
	
	@Autowired
	private PasswordEncoder passwordService;
	
	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> lMUsuario = usuarioTransform.transformEM(usuarioRepository.findAll()); 
		for(Usuario oUsuario : lMUsuario) {
			Persona oPersona = personaService.buscarPersona(oUsuario.getsTipoDocumento(), oUsuario.getsNumeroDocumento());
			Perfil oPerfil = perfilService.buscarPerfil(oUsuario.getNidPerfil());
			
			oUsuario.setsNombre(oPersona.getsNombre());
			oUsuario.setsApellidoMaterno(oPersona.getsApellidoMaterno());
			oUsuario.setsApellidoPaterno(oPersona.getsApellidoPaterno());
			
			oUsuario.setsNombrePerfil(oPerfil.getsNombre());
		}
		return lMUsuario;
	}

	@Override
	public Usuario buscarUsuario(String sIdentificador) {
		Usuario oUsuario = usuarioTransform.transformEM(usuarioRepository.findByVidUsuario(sIdentificador));
		
		if(oUsuario != null) {
			Persona oPersona = personaService.buscarPersona(oUsuario.getsTipoDocumento(), oUsuario.getsNumeroDocumento());
			Perfil oPerfil = perfilService.buscarPerfil(oUsuario.getNidPerfil());
			
			oUsuario.setsNombre(oPersona.getsNombre());
			oUsuario.setsApellidoMaterno(oPersona.getsApellidoMaterno());
			oUsuario.setsApellidoPaterno(oPersona.getsApellidoPaterno());
			
			oUsuario.setsNombrePerfil(oPerfil.getsNombre());
		}
		
		return oUsuario;
	}

	@Override
	public String registrarUsuario(Usuario oUsuario) {
		oUsuario.setsClave(passwordService.encode(oUsuario.getsClave()));
		usuarioRepository.save(usuarioTransform.transformME(oUsuario));
		return oUsuario.getsIdentificador();
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
