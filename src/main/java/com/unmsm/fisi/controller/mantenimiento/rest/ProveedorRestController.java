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

import com.unmsm.fisi.model.Proveedor;
import com.unmsm.fisi.model.ProveedorId;
import com.unmsm.fisi.service.impl.mantenimiento.ProveedorServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/proveedor")
public class ProveedorRestController {
	@Autowired
	@Qualifier("proveedorServicio")
	private ProveedorServiceImpl proveedorService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Proveedor> listarTodos(){
		return proveedorService.listarProveedores();
	}
	
	@GetMapping("/{sTipoDocumento}/{sNumeroDocumento}")
	public Proveedor buscarProveedor(@PathVariable String sTipoDocumento, @PathVariable String sNumeroDocumento) {
		return proveedorService.buscarProveedor(sTipoDocumento, sNumeroDocumento);
	}

	@PostMapping
    public ResponseEntity<?> registrarProveedor(@RequestBody Proveedor oProveedor){
		ProveedorId oMProveedorId = proveedorService.registrarProveedor(oProveedor);
		
		return ResponseEntity.ok(proveedorService.buscarProveedor(oMProveedorId.getsTipoDocumento(), oMProveedorId.getsNumeroDocumento()));
	}

	@PutMapping
    public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedor oProveedor){
		ProveedorId oMProveedorId = proveedorService.actualizarProveedor(oProveedor);
		
		return ResponseEntity.ok(proveedorService.buscarProveedor(oMProveedorId.getsTipoDocumento(), oMProveedorId.getsNumeroDocumento()));
	}

	@DeleteMapping
    public ResponseEntity<?> eliminarProveedor(@RequestBody Proveedor oProveedor){
		proveedorService.eliminarProveedor(oProveedor.getsTipoDocumento(), oProveedor.getsNumeroDocumento());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}

}
