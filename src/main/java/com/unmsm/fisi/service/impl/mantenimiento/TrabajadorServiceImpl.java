package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManTrabajadorId;
import com.unmsm.fisi.model.PedidoTrabajador;
import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.Trabajador;
import com.unmsm.fisi.model.TrabajadorId;
import com.unmsm.fisi.model.Usuario;
import com.unmsm.fisi.repository.TrabajadorRepository;
import com.unmsm.fisi.service.TrabajadorService;
import com.unmsm.fisi.service.impl.pedido.PedidoTrabajadorServiceImpl;
import com.unmsm.fisi.service.impl.seguridad.UsuarioServiceImpl;
import com.unmsm.fisi.service.transform.TrabajadorTransform;

@Service("trabajadorServicio")
public class TrabajadorServiceImpl implements TrabajadorService{
	@Autowired
	@Qualifier("trabajadorRepositorio")
	private TrabajadorRepository trabajadorRepository;
	@Autowired
	@Qualifier("trabajadorConvertidor")
	private TrabajadorTransform trabajadorTransform;
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaService;
	@Autowired
	@Qualifier("pedidoTrabajadorServicio")
	private PedidoTrabajadorServiceImpl pedidoTrabajadorService;
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServiceImpl usuarioService;
	
	@Override
	public List<Trabajador> listarTrabajadores() {
		List<Trabajador> lMTrabajador = trabajadorTransform.transformEM(trabajadorRepository.findAll());
		
		for (Trabajador oTrabajador : lMTrabajador) {
			Persona oPersona = personaService.buscarPersona(oTrabajador.getsTipoDocumento(),
					oTrabajador.getsNumeroDocumento());

			oTrabajador.setsNombre(oPersona.getsNombre());
			oTrabajador.setsApellidoPaterno(oPersona.getsApellidoPaterno());
			oTrabajador.setsApellidoMaterno(oPersona.getsApellidoMaterno());
			oTrabajador.setsSexo(oPersona.getsSexo());
			oTrabajador.setsDomicilio(oPersona.getsDomicilio());
			oTrabajador.setsTelefonoFijo(oPersona.getsTelefonoFijo());
			oTrabajador.setsTelefonoCelular(oPersona.getsTelefonoCelular());
			oTrabajador.setsCorreo(oPersona.getsCorreo());
			oTrabajador.setdFecha(oPersona.getdFecha());
			oTrabajador.setdHora(oPersona.getdHora());

		}

		return lMTrabajador;
	}

	@Override
	public Trabajador buscarTrabajador(String sTipoDocumento, String sNumeroDocumento) {
		ManTrabajadorId oETrabajadorId = new ManTrabajadorId();
		oETrabajadorId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		oETrabajadorId.setManPersonaVTipoDocumento(sTipoDocumento);
		
		Trabajador oTrabajador = trabajadorTransform.transformEM(trabajadorRepository.findOne(oETrabajadorId));
		
		Persona oPersona = personaService.buscarPersona(oTrabajador.getsTipoDocumento(),
				oTrabajador.getsNumeroDocumento());

		oTrabajador.setsNombre(oPersona.getsNombre());
		oTrabajador.setsApellidoPaterno(oPersona.getsApellidoPaterno());
		oTrabajador.setsApellidoMaterno(oPersona.getsApellidoMaterno());
		oTrabajador.setsSexo(oPersona.getsSexo());
		oTrabajador.setsDomicilio(oPersona.getsDomicilio());
		oTrabajador.setsTelefonoFijo(oPersona.getsTelefonoFijo());
		oTrabajador.setsTelefonoCelular(oPersona.getsTelefonoCelular());
		oTrabajador.setsCorreo(oPersona.getsCorreo());
		oTrabajador.setdFecha(oPersona.getdFecha());
		oTrabajador.setdHora(oPersona.getdHora());
		
		return oTrabajador;
	}

	@Override
	public TrabajadorId registrarTrabajador(Trabajador oTrabajador) {
		Persona oPersona = oTrabajador;

		personaService.registrarPersona(oPersona);
		
		trabajadorRepository.save(trabajadorTransform.transformME(oTrabajador));
		
		TrabajadorId oMTrabajadorId = new TrabajadorId();
		oMTrabajadorId.setsTipoDocumento(oTrabajador.getsTipoDocumento());
		oMTrabajadorId.setsNumeroDocumento(oTrabajador.getsNumeroDocumento());
		
		return oMTrabajadorId;
	}

	@Override
	public TrabajadorId actualizarTrabajador(Trabajador oTrabajador) {
		Persona oPersona = oTrabajador;

		personaService.registrarPersona(oPersona);
		
		trabajadorRepository.save(trabajadorTransform.transformME(oTrabajador));
		
		TrabajadorId oMTrabajadorId = new TrabajadorId();
		oMTrabajadorId.setsTipoDocumento(oTrabajador.getsTipoDocumento());
		oMTrabajadorId.setsNumeroDocumento(oTrabajador.getsNumeroDocumento());
		
		List<PedidoTrabajador> listaPedidoTrabajador = pedidoTrabajadorService.listarPedidoTrabajador();
		listaPedidoTrabajador.removeIf(s -> s.getsTipoDocumento().compareTo(oTrabajador.getsTipoDocumentoAntiguo()) != 0 && s.getsNumeroDocumento().compareTo(oTrabajador.getsNumeroDocumentoAntiguo()) != 0);
		for(PedidoTrabajador oPedidoTrabajador : listaPedidoTrabajador) {
			oPedidoTrabajador.setsTipoDocumento(oTrabajador.getsTipoDocumento());
			oPedidoTrabajador.setsNumeroDocumento(oTrabajador.getsNumeroDocumento());
			
			pedidoTrabajadorService.actualizarPedidoTrabajador(oPedidoTrabajador);
		}
		
		List<Usuario> listaUsuario = usuarioService.listarUsuarios();
		listaUsuario.removeIf(s -> s.getsTipoDocumento().compareTo(oTrabajador.getsTipoDocumentoAntiguo()) != 0 && s.getsNumeroDocumento().compareTo(oTrabajador.getsNumeroDocumentoAntiguo()) != 0);
		for(Usuario oUsuario : listaUsuario) {
			oUsuario.setsTipoDocumento(oTrabajador.getsTipoDocumento());
			oUsuario.setsNumeroDocumento(oTrabajador.getsNumeroDocumento());
			
			usuarioService.actualizarUsuario(oUsuario);
		}
		
		eliminarTrabajador(oTrabajador.getsTipoDocumentoAntiguo(), oTrabajador.getsNumeroDocumentoAntiguo());
		
		return oMTrabajadorId;
	}

	@Override
	public void eliminarTrabajador(String sTipoDocumento, String sNumeroDocumento) {
		ManTrabajadorId oETrabajadorId = new ManTrabajadorId();
		oETrabajadorId.setManPersonaVTipoDocumento(sTipoDocumento);
		oETrabajadorId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		
		trabajadorRepository.delete(oETrabajadorId);
		
		personaService.eliminarPersona(sTipoDocumento, sNumeroDocumento);
	}

}
