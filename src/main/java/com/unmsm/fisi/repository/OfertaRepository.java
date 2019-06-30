package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManOferta;

@Repository("ofertaRepositorio")
public interface OfertaRepository extends JpaRepository<ManOferta, Serializable>{

}
