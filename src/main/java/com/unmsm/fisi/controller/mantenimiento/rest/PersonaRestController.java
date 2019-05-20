package com.unmsm.fisi.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.PersonaId;
import com.unmsm.fisi.service.impl.mantenimiento.PersonaServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/persona")
public class PersonaRestController {
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaServicio;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Persona> listarTodos(){
		return personaServicio.listarPersonas();
	}
	
	@GetMapping("/{sTipoDocumento}/{sNumeroDocumento}")
	public Persona buscarPersona(@PathVariable String sTipoDocumento, @PathVariable String sNumeroDocumento) {
		return personaServicio.buscarPersona(sTipoDocumento, sNumeroDocumento);
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPersona(@RequestBody Persona oPersona){
		PersonaId oPersonaId = personaServicio.registrarPersona(oPersona);
		
		return ResponseEntity.ok(personaServicio.buscarPersona(oPersonaId.getsTipoDocumento(), oPersonaId.getsNumeroDocumento()));
	}
    		
	@PutMapping
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona oPersona){
		PersonaId oPersonaId = personaServicio.actualizarPersona(oPersona);
		
		return ResponseEntity.ok(personaServicio.buscarPersona(oPersonaId.getsTipoDocumento(), oPersonaId.getsNumeroDocumento()));
	}		
    		
	@DeleteMapping
    public ResponseEntity<?> eliminarPersona(@RequestBody Persona oPersona){
		personaServicio.eliminarPersona(oPersona.getsTipoDocumento(), oPersona.getsNumeroDocumento());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
    		
}
