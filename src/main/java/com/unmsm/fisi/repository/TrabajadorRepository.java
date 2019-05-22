package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManTrabajador;

@Repository("trabajadorRepositorio")
public interface TrabajadorRepository extends JpaRepository<ManTrabajador, Serializable>{

}
