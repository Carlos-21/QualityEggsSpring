package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManOferta;
import com.unmsm.fisi.model.Oferta;

@Component("ofertaConvertidor")
public class OfertaTransform implements Transform<Oferta, ManOferta> {

	@Override
	public ManOferta transformME(Oferta oModel) {
		if (oModel != null) {
			ManOferta oEOferta = new ManOferta();
			if (oModel.getnIdOferta() != null) {
				oEOferta.setNidOferta(oModel.getnIdOferta());
			}
			oEOferta.setVdescripcion(oModel.getsDescripcion());
			oEOferta.setNdescuento(oModel.getnDescuento());
			oEOferta.setDfechaInicio(oModel.getdFechaInicio());
			oEOferta.setDfechaFin(oModel.getdFechaFin());
			return oEOferta;
		}
		return null;
	}

	@Override
	public List<ManOferta> transformME(List<Oferta> lModel) {
		if (lModel != null) {
			List<ManOferta> lEOferta = new ArrayList<>();

			for (Oferta oOferta : lModel) {
				ManOferta oEOferta = transformME(oOferta);
				lEOferta.add(oEOferta);
			}

			return lEOferta;

		}
		return null;
	}

	@Override
	public Oferta transformEM(ManOferta oEntity) {
		if(oEntity != null) {
			Oferta oMOferta = new Oferta();
			oMOferta.setnIdOferta(oEntity.getNidOferta());
			oMOferta.setsDescripcion(oEntity.getVdescripcion());
			oMOferta.setnDescuento(oEntity.getNdescuento());
			oMOferta.setdFechaInicio(oEntity.getDfechaInicio());
			oMOferta.setdFechaFin(oEntity.getDfechaFin());
			
			return oMOferta;
		}
		return null;
	}

	@Override
	public List<Oferta> transformEM(List<ManOferta> lEntity) {
		if(lEntity != null) {
			List<Oferta> lMOferta = new ArrayList<>();
			
			for(ManOferta oOferta : lEntity) {
				Oferta oMOferta = transformEM(oOferta);
				
				lMOferta.add(oMOferta);
			}
			
			return lMOferta;
		}
		return null;
	}

}
