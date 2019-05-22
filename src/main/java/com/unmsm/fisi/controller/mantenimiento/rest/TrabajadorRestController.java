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

import com.unmsm.fisi.model.Trabajador;
import com.unmsm.fisi.model.TrabajadorId;
import com.unmsm.fisi.service.impl.mantenimiento.TrabajadorServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/trabajador")
public class TrabajadorRestController {
	@Autowired
	@Qualifier("trabajadorServicio")
	private TrabajadorServiceImpl trabajadorService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Trabajador>listarTodos(){
		return trabajadorService.listarTrabajadores();
	}
	
	@GetMapping("/{sTipoDocumento}/{sNumeroDocumento}")
	public Trabajador buscarTrabajador(@PathVariable String sTipoDocumento, @PathVariable String sNumeroDocumento) {
		return trabajadorService.buscarTrabajador(sTipoDocumento, sNumeroDocumento);
	}
	
	@PostMapping
    public ResponseEntity<?> registrarTrabajador(@RequestBody Trabajador oTrabajador){
		TrabajadorId oMTrabajadorId = trabajadorService.registrarTrabajador(oTrabajador);
		
		return ResponseEntity.ok(trabajadorService.buscarTrabajador(oMTrabajadorId.getsTipoDocumento(), oMTrabajadorId.getsNumeroDocumento()));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarTrabajador(@RequestBody Trabajador oTrabajador){
		TrabajadorId oMTrabajadorId = trabajadorService.actualizarTrabajador(oTrabajador);
		
		return ResponseEntity.ok(trabajadorService.buscarTrabajador(oMTrabajadorId.getsTipoDocumento(), oMTrabajadorId.getsNumeroDocumento()));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarTrabajador(@RequestBody Trabajador oTrabajador){
		trabajadorService.eliminarTrabajador(oTrabajador.getsTipoDocumento(), oTrabajador.getsNumeroDocumento());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
	
}
