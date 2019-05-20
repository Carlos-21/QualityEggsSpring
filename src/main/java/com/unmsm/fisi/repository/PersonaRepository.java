package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManPersona;
import com.unmsm.fisi.entity.ManPersonaId;

@Repository("personaRepositorio")
public interface PersonaRepository extends JpaRepository<ManPersona, Serializable>{
	//public abstract ManPersona findById(ManPersonaId id);

}
