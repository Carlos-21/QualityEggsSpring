package com.unmsm.fisi.controller.pedido.rest;

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

import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.service.impl.pedido.PedidoClienteServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/pedido/pedidoCliente")
public class PedidoClienteRestController {
	@Autowired
	@Qualifier("productoServicio")
	private PedidoClienteServiceImpl pedidoClienteService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<PedidoCliente> listarTodos(){
		return pedidoClienteService.listarPedidosClientes();
	}
	
	@GetMapping("/{nidPedido}")
	public PedidoCliente buscarPedidoCliente(@PathVariable String nidPedido) {
		return pedidoClienteService.buscarPedidoCliente(Integer.parseInt(nidPedido));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPedidoCliente(@RequestBody PedidoCliente oPedidoCliente){
		Integer nidPedido = pedidoClienteService.registrarPedidoCliente(oPedidoCliente);
		
		return ResponseEntity.ok(pedidoClienteService.buscarPedidoCliente(nidPedido));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarPedidoCliente(@RequestBody PedidoCliente oPedidoCliente){
		Integer nidPedido = pedidoClienteService.actualizarPedidoCliente(oPedidoCliente);
		
		return ResponseEntity.ok(pedidoClienteService.buscarPedidoCliente(nidPedido));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarPedidoCliente(@RequestBody PedidoCliente oPedidoCliente){
		pedidoClienteService.eliminarPedidoCliente(oPedidoCliente.getNidPedido());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
	
}
