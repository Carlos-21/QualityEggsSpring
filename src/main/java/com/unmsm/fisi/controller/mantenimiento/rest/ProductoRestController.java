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

import com.unmsm.fisi.model.Producto;
import com.unmsm.fisi.service.impl.mantenimiento.ProductoServiceImpl;
import com.unmsm.fisi.utilitario.ConstantesGenerales;

@RestController
@RequestMapping("/mantenimiento/producto")
public class ProductoRestController {
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServiceImpl productoServicio;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<Producto> listarTodos(){
		return productoServicio.listarProductos();
	}
	
	@GetMapping("/{nIdentificador}")
	public Producto buscarProducto(@PathVariable String nIdentificador) {
		return productoServicio.buscarProducto(Integer.valueOf(nIdentificador));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody Producto oProducto){
		Integer nIdentificador = productoServicio.registrarProducto(oProducto);
		
		return ResponseEntity.ok(productoServicio.buscarProducto(nIdentificador));
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto oProducto){
		Integer nIdentificador = productoServicio.actualizarProducto(oProducto);
		
		return ResponseEntity.ok(productoServicio.buscarProducto(nIdentificador));
	}
	
	@DeleteMapping
    public ResponseEntity<?> eliminarProducto(@RequestBody Producto oProducto){
		productoServicio.eliminarProducto(oProducto.getnIdentificador());
		
		return ResponseEntity.ok(ConstantesGenerales.ELIMINACION_EXITOSA);
	}
	
}
