package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.MultiTabCab;
import com.unmsm.fisi.model.TabCab;
import com.unmsm.fisi.repository.TabCabRepository;
import com.unmsm.fisi.service.TabCabService;
import com.unmsm.fisi.service.transform.TabCabTransform;

@Service("tabCabServicio")
public class TabCabServiceImpl implements TabCabService{
	@Autowired
	@Qualifier("tabCabRepositorio")
	private TabCabRepository oTablaCabRepository;
	@Autowired
	@Qualifier("tabCabConvertidor")
	private TabCabTransform oTablaCabTransform;
	
	@Override
	public List<TabCab> listarTodos() {
		return oTablaCabTransform.transformEM(oTablaCabRepository.findAll());
	}

	@Override
	public TabCab buscarId(int nIdTabla) {
		return oTablaCabTransform.transformEM(oTablaCabRepository.findOne(nIdTabla));
	}

	@Override
	public int registrarMultiTabCab(TabCab oTabCab) {
		MultiTabCab oMultiTabCab = oTablaCabTransform.transformME(oTabCab);
		oMultiTabCab.setNidTabla((int) (oTablaCabRepository.count() + 1));
		oTablaCabRepository.save(oMultiTabCab);
		return oMultiTabCab.getNidTabla();
	}

	@Override
	public int actualizarMultiTabCab(TabCab oTabCab) {
		MultiTabCab oMultiTabCab = oTablaCabTransform.transformME(oTabCab);
		oTablaCabRepository.save(oMultiTabCab);
		return oMultiTabCab.getNidTabla();
	}

	@Override
	public void eliminarMultiTabCab(int nIdTabla) {
		oTablaCabRepository.delete(nIdTabla);
	}

}
