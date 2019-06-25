package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Factura;
import com.unmsm.fisi.model.GuiaRemision;

public interface ReporteService {
	public List<GuiaRemision> listarGuiaRemision();
	public List<Factura> listarFactura();
}
