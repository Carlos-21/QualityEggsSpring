package com.unmsm.fisi.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.fisi.entity.MultiTabDetId;
import com.unmsm.fisi.model.TabDet;
import com.unmsm.fisi.model.TablaDetId;
import com.unmsm.fisi.service.impl.mantenimiento.TabDetServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;


@RestController
@RequestMapping("/mantenimiento/multiTabDet")
public class TabDetRestController {
	@Autowired
	@Qualifier("tabDetServicio")
	private TabDetServiceImpl oTabDetService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<TabDet> listarTodos(){
		return oTabDetService.listarTodos();
	}
	
	@GetMapping("/multiTabCab/{idTabla}")
	public List<TabDet> buscarIdTabla(@PathVariable int idTabla){
		return oTabDetService.buscarIdTabla(idTabla);
	}
	
	@PostMapping
    public ResponseEntity<?> registrarMultiTabDet(@RequestBody TabDet oTabDet, Errors error){
		TablaDetId oTablaDetId = oTabDetService.registrarMultiTabDet(oTabDet);
		return ResponseEntity.ok(oTabDetService.buscarIdTablaItem(oTablaDetId.getnIdTabla(), oTablaDetId.getsIdItem()));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarMultiTabDet(@RequestBody TabDet oTabDet,Errors error){
		TablaDetId oTablaDetId = oTabDetService.registrarMultiTabDet(oTabDet);
		return ResponseEntity.ok(oTabDetService.buscarIdTablaItem(oTablaDetId.getnIdTabla(), oTablaDetId.getsIdItem()));
	}
	
	@DeleteMapping
    public String eliminarMultiTabDet(@RequestBody TabDet oTabDet, Errors error){
		oTabDetService.eliminarMultiTabDet(oTabDet.getnIdTabla(), oTabDet.getsIdItem());
		return ConstantesGenerales.ELIMINACION_EXITOSA;
	}
}
