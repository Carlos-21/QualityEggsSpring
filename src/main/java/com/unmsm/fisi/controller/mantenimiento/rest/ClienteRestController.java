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

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.ClienteId;
import com.unmsm.fisi.service.impl.mantenimiento.ClienteServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/cliente")
public class ClienteRestController {
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Cliente>listarTodos(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/{sTipoDocumento}/{sNumeroDocumento}")
	public Cliente buscarCliente(@PathVariable String sTipoDocumento, @PathVariable String sNumeroDocumento) {
		return clienteService.buscarCliente(sTipoDocumento, sNumeroDocumento);
	}
	
	@PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente oCliente){
		ClienteId oMClienteId = clienteService.registrarCliente(oCliente);
		
		return ResponseEntity.ok(clienteService.buscarCliente(oMClienteId.getsTipoDocumento(), oMClienteId.getsNumeroDocumento()));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente oCliente){
		ClienteId oMClienteId = clienteService.actualizarCliente(oCliente);
		
		return ResponseEntity.ok(clienteService.buscarCliente(oMClienteId.getsTipoDocumento(), oMClienteId.getsNumeroDocumento()));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarCliente(@RequestBody Cliente oCliente){
		clienteService.eliminarCliente(oCliente.getsTipoDocumento(), oCliente.getsNumeroDocumento());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
}
