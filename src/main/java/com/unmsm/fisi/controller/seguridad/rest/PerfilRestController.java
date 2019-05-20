package com.unmsm.fisi.controller.seguridad.rest;

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

import com.unmsm.fisi.model.Perfil;
import com.unmsm.fisi.service.impl.seguridad.PerfilServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/seguridad/perfil")
public class PerfilRestController {
	@Autowired
	@Qualifier("perfilServicio")
	private PerfilServiceImpl perfilService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Perfil> buscarTodos(){
		return perfilService.listarPerfiles();
	}
	
	@GetMapping("/{nIdPerfil}")
	public Perfil buscarPerfil(@PathVariable String nIdPerfil) {
		return perfilService.buscarPerfil(Integer.parseInt(nIdPerfil));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPerfil(@RequestBody Perfil oPerfil){
		Integer nIdPerfil = perfilService.registrarPerfil(oPerfil);
		return ResponseEntity.ok(perfilService.buscarPerfil(nIdPerfil));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarPerfil(@RequestBody Perfil oPerfil){
		Integer nIdPerfil = perfilService.actualizarPerfil(oPerfil);
		return ResponseEntity.ok(perfilService.buscarPerfil(nIdPerfil));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarPerfil(@RequestBody Perfil oPerfil){
		perfilService.eliminarPerfil(oPerfil.getnIdPerfil());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
	
}
