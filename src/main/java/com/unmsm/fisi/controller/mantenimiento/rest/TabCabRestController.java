package com.unmsm.fisi.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.fisi.model.TabCab;
import com.unmsm.fisi.service.TabCabService;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/multiTabCab")
public class TabCabRestController {
	@Autowired
	@Qualifier("tabCabServicio")
	private TabCabService oTabCabService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<TabCab> listarTodos(){
		return oTabCabService.listarTodos();
	}
	
	@PostMapping
    public ResponseEntity<?> registrarMultiTabCab(@RequestBody TabCab oTabCab, Errors error){
		int idTabla = oTabCabService.registrarMultiTabCab(oTabCab);
		return ResponseEntity.ok(oTabCabService.buscarId(idTabla));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarMultiTabCab(@RequestBody TabCab oTabCab, Errors error){
		int idTabla = oTabCabService.actualizarMultiTabCab(oTabCab);
		return ResponseEntity.ok(oTabCabService.buscarId(idTabla));
	}
	
	@DeleteMapping
    public String eliminarMultiTabCab(@RequestBody TabCab oTabCab, Errors error){
		oTabCabService.eliminarMultiTabCab(oTabCab.getnIdTabla());
		return ConstantesGenerales.ELIMINACION_EXITOSA;
	}
	
}
