package com.unmsm.fisi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unmsm.fisi.configuration.security.CustomGrantedAuthority;
import com.unmsm.fisi.configuration.security.CustomUser;
import com.unmsm.fisi.model.Usuario;
import com.unmsm.fisi.service.impl.seguridad.UsuarioServiceImpl;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServiceImpl usuarioServicio;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario oUsuario = usuarioServicio.buscarUsuario(login);
		CustomUser user = null;
		if (oUsuario != null) {
			user = new CustomUser(oUsuario.getsIdentificador(), oUsuario.getsClave(), oUsuario.isbEstado(), true, true,
					true, buscarPorIdUsuario(oUsuario.getNidPerfil()));
		}
		return user;
	}

	private List<GrantedAuthority> buscarPorIdUsuario(Integer idPerfil) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new CustomGrantedAuthority(String.valueOf(idPerfil), "ALL"));
		return authorities;
	}

}
