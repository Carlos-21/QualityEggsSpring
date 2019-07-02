package com.unmsm.fisi.service;

import java.util.List;

import com.unmsm.fisi.model.Oferta;

public interface OfertaService {
	public List<Oferta> listarOfertas();
	public Oferta buscarOferta(Integer nIdentificador);
	public Integer registrarOferta(Oferta oOferta);
	public Integer actualizarOferta(Oferta oOferta);
}
