package com.unmsm.fisi.controller.pago.rest;

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

import com.unmsm.fisi.model.PagoPedido;
import com.unmsm.fisi.service.impl.pago.PagoPedidoServiceImpl;

@RestController
@RequestMapping("/pago/pedidoPedido")
public class PagoPedidoRestController {
	@Autowired
	@Qualifier("pagoPedidoServicio")
	private PagoPedidoServiceImpl pagoPedidoService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<PagoPedido> listarTodos(){
		return pagoPedidoService.listarPagoPedido();
	}
	
	@GetMapping("/{nidPago}")
	public PagoPedido buscarPagoPedido(@PathVariable String nidPago) {
		return pagoPedidoService.buscarPagoPedido(Integer.parseInt(nidPago));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPagoPedido(@RequestBody PagoPedido oPagoPedido){
		
		System.out.println("Fecha Controller: " + oPagoPedido.getdFecha().toString());
		
		Integer nidPago = pagoPedidoService.registrarPagoPedido(oPagoPedido);
		
		return ResponseEntity.ok(pagoPedidoService.buscarPagoPedido(nidPago));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarPagoPedido(@RequestBody PagoPedido oPagoPedido){
		Integer nidPago = pagoPedidoService.actualizarPagoPedido(oPagoPedido);
		
		return ResponseEntity.ok(pagoPedidoService.buscarPagoPedido(nidPago));
	}
	
}
