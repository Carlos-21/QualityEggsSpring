package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.repository.OfertaRepository;
import com.unmsm.fisi.service.OfertaService;
import com.unmsm.fisi.service.transform.OfertaTransform;

@Service("ofertaServicio")
public class OfertaServiceImpl implements OfertaService{
	@Autowired
	@Qualifier("ofertaRepositorio")
	private OfertaRepository ofertaRepository;
	@Autowired
	@Qualifier("ofertaConvertidor")
	private OfertaTransform ofertaTransform;
	
	@Override
	public List<Oferta> listarOfertas() {
		return ofertaTransform.transformEM(ofertaRepository.findAll());
	}

	@Override
	public Oferta buscarOferta(Integer nIdentificador) {
		return ofertaTransform.transformEM(ofertaRepository.findOne(nIdentificador));
	}

	@Override
	public Integer registrarOferta(Oferta oOferta) {
		ofertaRepository.save(ofertaTransform.transformME(oOferta));
		return listarOfertas().get(listarOfertas().size()-1).getnIdOferta();
	}

	@Override
	public Integer actualizarOferta(Oferta oOferta) {
		ofertaRepository.save(ofertaTransform.transformME(oOferta));
		return oOferta.getnIdOferta();
	}

}
