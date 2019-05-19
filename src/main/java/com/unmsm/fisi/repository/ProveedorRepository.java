package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManProveedor;
import com.unmsm.fisi.entity.ManProveedorId;

@Repository("proveedorRepositorio")
public interface ProveedorRepository extends JpaRepository<ManProveedor, Serializable>{
	public abstract ManProveedor findById(ManProveedorId id);
}
