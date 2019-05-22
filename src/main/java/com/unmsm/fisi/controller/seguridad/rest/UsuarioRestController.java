package com.unmsm.fisi.controller.seguridad.rest;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.fisi.aspecto.anotacion.Audit;
import com.unmsm.fisi.aspecto.enumeracion.Accion;
import com.unmsm.fisi.aspecto.enumeracion.Comentario;
import com.unmsm.fisi.aspecto.enumeracion.Dato;
import com.unmsm.fisi.aspecto.enumeracion.Tipo;
import com.unmsm.fisi.model.Usuario;
import com.unmsm.fisi.service.impl.seguridad.UsuarioServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;
import com.unmsm.fisi.utilitario.ValidatorUtil;
import com.unmsm.fisi.validacion.grupo.accion.IRegistro;

@RestController
@RequestMapping("/seguridad/usuario")
public class UsuarioRestController {
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Usuario> buscarTodos(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/{sIdentificador}")
	public Usuario buscarUsuario(@PathVariable String sIdentificador) {
		return usuarioService.buscarUsuario(sIdentificador);
	}
	
	@PostMapping
    public ResponseEntity<?> registrarUsuario(@Validated({ IRegistro.class, Default.class }) @RequestBody Usuario oUsuario,
            Errors error){
		
		if (error.hasErrors())
        {
            return ResponseEntity.badRequest()
                    .body(ValidatorUtil.obtenerMensajeValidacionError(error));
        }
		
		if(oUsuario==null) {
			System.out.println("nulo");
			
		}
		else {
			System.out.println("nulo");
		}
		int nPos = oUsuario.getIdPersona().indexOf('/');
		String sTipoDocumento = oUsuario.getIdPersona().substring(0, nPos);
		String sNumeroDocumento = oUsuario.getIdPersona().substring(nPos+1, oUsuario.getsNumeroDocumento().length()-1); 
		
		oUsuario.setsNumeroDocumento(sNumeroDocumento);
		oUsuario.setsTipoDocumento(sTipoDocumento);
		
		String sIdentificador = usuarioService.registrarUsuario(oUsuario);
		
		return ResponseEntity.ok(usuarioService.buscarUsuario(sIdentificador));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario oUsuario){
		/*int nPos = oUsuario.getsNumeroDocumento().indexOf('/');
		String sTipoDocumento = oUsuario.getsNumeroDocumento().substring(0, nPos);
		String sNumeroDocumento = oUsuario.getsNumeroDocumento().substring(nPos+1, oUsuario.getsNumeroDocumento().length()-1); 
		
		oUsuario.setsNumeroDocumento(sNumeroDocumento);
		oUsuario.setsTipoDocumento(sTipoDocumento);*/
		
		String sIdentificador = usuarioService.actualizarUsuario(oUsuario);
		
		return ResponseEntity.ok(usuarioService.buscarUsuario(sIdentificador));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarUsuario(@RequestBody Usuario oUsuario){
		usuarioService.eliminarUsuario(oUsuario.getsIdentificador());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
	
}
