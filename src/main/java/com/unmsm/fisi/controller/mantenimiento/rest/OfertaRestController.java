package com.unmsm.fisi.controller.mantenimiento.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.service.impl.mantenimiento.ClienteServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.OfertaServiceImpl;
import com.unmsm.fisi.utilitario.HiloCorreo;

@RestController
@RequestMapping("/mantenimiento/oferta")
public class OfertaRestController {
	@Autowired
	@Qualifier("ofertaServicio")
	private OfertaServiceImpl ofertaService;
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Oferta> listarTodos(){
		return ofertaService.listarOfertas();
	}
	
	@GetMapping("/{nIdOferta}")
	public Oferta buscarOferta(@PathVariable String nIdOferta) {
		return ofertaService.buscarOferta(Integer.valueOf(nIdOferta));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta oOferta){
		Integer nIdOferta = ofertaService.registrarOferta(oOferta);
		
		HiloCorreo oHiloCorreo = new HiloCorreo(null, oOferta, clienteService.listarClientes(), true);
		oHiloCorreo.start();
		
		return ResponseEntity.ok(ofertaService.buscarOferta(nIdOferta));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarOferta(@RequestBody Oferta oOferta){
		Integer nIdOferta = ofertaService.actualizarOferta(oOferta);
		
		HiloCorreo oHiloCorreo = new HiloCorreo(null, oOferta, clienteService.listarClientes(), false);
		oHiloCorreo.start();
		
		return ResponseEntity.ok(ofertaService.buscarOferta(nIdOferta));
	}
	
}
