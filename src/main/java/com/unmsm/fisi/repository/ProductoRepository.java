package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManProducto;

@Repository("productoRepositorio")
public interface ProductoRepository extends JpaRepository<ManProducto, Serializable>{
	public abstract ManProducto findByNidProducto(Integer nidProducto);
}
