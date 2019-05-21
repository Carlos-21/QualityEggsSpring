package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.MultiTabDetId;
import com.unmsm.fisi.model.TabDet;
import com.unmsm.fisi.model.TablaDetId;
import com.unmsm.fisi.repository.TabDetRepository;
import com.unmsm.fisi.service.TabDetService;
import com.unmsm.fisi.service.transform.TabDetTransform;

@Service("tabDetServicio")
public class TabDetServiceImpl implements TabDetService{
	@Autowired
	@Qualifier("tabDetRepositorio")
	private TabDetRepository oTablaDetRepository;
	@Autowired
	@Qualifier("tabDetConvertidor")
	private TabDetTransform oTablaDetTransform;
	
	@Override
	public List<TabDet> listarTodos() {
		return oTablaDetTransform.transformEM(oTablaDetRepository.findAll());
	}

	@Override
	public TabDet buscarIdTablaItem(int nIdTabla, String sIdItem) {
		MultiTabDetId oMultiTablaDetId = new MultiTabDetId();
		oMultiTablaDetId.setNidTabla(nIdTabla);
		oMultiTablaDetId.setVidItem(sIdItem);
		
		return oTablaDetTransform.transformEM(oTablaDetRepository.findOne(oMultiTablaDetId));
	}

	@Override
	public List<TabDet> buscarIdTabla(int nIdTabla) {
		List<TabDet> lTabDet = oTablaDetTransform.transformEM(oTablaDetRepository.findAll());
		lTabDet.removeIf(s -> s.getnIdTabla() != nIdTabla);
		return lTabDet;
	}

	@Override
	public TablaDetId registrarMultiTabDet(TabDet oTabDet) {
		TablaDetId oTablaDetId = new TablaDetId();
		oTablaDetId.setnIdTabla(oTabDet.getnIdTabla());
		oTablaDetId.setsIdItem(oTabDet.getsIdItem());
		
		oTablaDetRepository.save(oTablaDetTransform.transformME(oTabDet));
		return oTablaDetId;
	}

	@Override
	public TablaDetId actualizarMultiTabDet(TabDet oTabDet) {
		TablaDetId oTablaDetId = new TablaDetId();
		oTablaDetId.setnIdTabla(oTabDet.getnIdTabla());
		oTablaDetId.setsIdItem(oTabDet.getsIdItem());
		
		oTablaDetRepository.save(oTablaDetTransform.transformME(oTabDet));
		return oTablaDetId;
	}

	@Override
	public void eliminarMultiTabDet(int nIdTabla, String sIdItem) {
		MultiTabDetId oMultiTabDetId = new MultiTabDetId();
		oMultiTabDetId.setNidTabla(nIdTabla);
		oMultiTabDetId.setVidItem(sIdItem);
		
		oTablaDetRepository.delete(oMultiTabDetId);
	}

}
