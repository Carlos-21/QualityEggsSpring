package com.unmsm.fisi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unmsm.fisi.entity.MultiTabDet;

@Repository("tabDetRepositorio")
public interface TabDetRepository extends JpaRepository<MultiTabDet, Serializable>{

}
