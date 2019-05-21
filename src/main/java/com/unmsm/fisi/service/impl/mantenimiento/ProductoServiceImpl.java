package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Producto;
import com.unmsm.fisi.repository.ProductoRepository;
import com.unmsm.fisi.service.ProductoService;
import com.unmsm.fisi.service.transform.ProductoTransform;

@Service("productoServicio")
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	@Qualifier("productoRepositorio")
	private ProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConvertidor")
	private ProductoTransform productoTransform;

	@Override
	public List<Producto> listarProductos() {
		return productoTransform.transformEM(productoRepository.findAll());
	}

	@Override
	public Producto buscarProducto(Integer nIdentificador) {
		return productoTransform.transformEM(productoRepository.findByNidProducto(nIdentificador));
	}

	@Override
	public Integer registrarProducto(Producto oProducto) {
		productoRepository.save(productoTransform.transformME(oProducto));
		return listarProductos().get(listarProductos().size()-1).getnIdentificador();
	}

	@Override
	public Integer actualizarProducto(Producto oProducto) {
		productoRepository.save(productoTransform.transformME(oProducto));
		return oProducto.getnIdentificador();
	}

	@Override
	public void eliminarProducto(Integer nIdentificador) {
		productoRepository.delete(nIdentificador);
	}

}
