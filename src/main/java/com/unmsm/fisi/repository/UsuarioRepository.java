package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.SegUsuario;

@Repository("usuarioRepositorio")
public interface UsuarioRepository extends JpaRepository<SegUsuario, Serializable>{
	public abstract SegUsuario findByVidUsuario (String vidUsuario);
}
