package com.unmsm.fisi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.ManCliente;
import com.unmsm.fisi.entity.ManClienteId;

@Repository
public interface ClienteRepository extends JpaRepository<ManCliente, ManClienteId>{

}
