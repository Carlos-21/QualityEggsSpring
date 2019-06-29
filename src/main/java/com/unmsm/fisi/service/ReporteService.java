package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.BusquedaParametro;
import com.unmsm.fisi.model.Factura;
import com.unmsm.fisi.model.GuiaRemision;
import com.unmsm.fisi.model.ReporteVentas;

public interface ReporteService {
	public List<GuiaRemision> listarGuiaRemision(BusquedaParametro oBusquedaParametro);
	public List<Factura> listarFactura(BusquedaParametro oBusquedaParametro);
	public List<ReporteVentas> listarReporteVenta(BusquedaParametro oBusquedaParametro);
}
