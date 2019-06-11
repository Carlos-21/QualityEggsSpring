package com.unmsm.fisi.controller.pedido.rest;

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

import com.unmsm.fisi.model.PedidoTrabajador;
import com.unmsm.fisi.service.impl.pedido.PedidoTrabajadorServiceImpl;

@RestController
@RequestMapping("/pedido/pedidoTrabajador")
public class PedidoTrabajadorRestController {
	@Autowired
	@Qualifier("pedidoTrabajadorServicio")
	private PedidoTrabajadorServiceImpl pedidoTrabajadorService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<PedidoTrabajador> listarTodos(){
		return pedidoTrabajadorService.listarPedidoTrabajador();
	}
	
	@GetMapping("/{nidPedido}")
	public PedidoTrabajador buscarPedidoTrabajador(@PathVariable String nidPedido) {
		return pedidoTrabajadorService.buscarPedidoTrabajador(Integer.parseInt(nidPedido));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPedidoTrabajador(@RequestBody PedidoTrabajador oPedidoTrabajador){
		int nPos = oPedidoTrabajador.getIdPersona().indexOf('/');
		String sTipoDocumento = oPedidoTrabajador.getIdPersona().substring(0, nPos);
		String sNumeroDocumento = oPedidoTrabajador.getIdPersona().substring(nPos+1,  oPedidoTrabajador.getIdPersona().length()); 
		
		oPedidoTrabajador.setsNumeroDocumento(sNumeroDocumento);
		oPedidoTrabajador.setsTipoDocumento(sTipoDocumento);
		
		Integer nidPedido = pedidoTrabajadorService.registrarPedidoTrabajador(oPedidoTrabajador);
		
		return ResponseEntity.ok(pedidoTrabajadorService.buscarPedidoTrabajador(nidPedido));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarPedidoTrabajador(@RequestBody PedidoTrabajador oPedidoTrabajador){
		int nPos = oPedidoTrabajador.getIdPersona().indexOf('/');
		String sTipoDocumento = oPedidoTrabajador.getIdPersona().substring(0, nPos);
		String sNumeroDocumento = oPedidoTrabajador.getIdPersona().substring(nPos+1,  oPedidoTrabajador.getIdPersona().length()); 
		
		oPedidoTrabajador.setsNumeroDocumento(sNumeroDocumento);
		oPedidoTrabajador.setsTipoDocumento(sTipoDocumento);
		
		Integer nidPedido = pedidoTrabajadorService.actualizarPedidoTrabajador(oPedidoTrabajador);
		
		return ResponseEntity.ok(pedidoTrabajadorService.buscarPedidoTrabajador(nidPedido));
	}

}
