package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Producto;

public interface ProductoService {
	public List<Producto> listarProductos();
	public Producto buscarProducto(Integer nIdentificador);
	public Integer registrarProducto(Producto oProducto);
	public Integer actualizarProducto(Producto oProducto);
	public void eliminarProducto(Integer nIdentificador);
}
