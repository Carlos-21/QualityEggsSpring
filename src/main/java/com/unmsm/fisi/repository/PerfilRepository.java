package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.SegPerfil;

@Repository("perfilRepositorio")
public interface PerfilRepository extends JpaRepository<SegPerfil, Serializable>{
	public abstract SegPerfil findByNidPerfil(Integer nidPerfil);
}
