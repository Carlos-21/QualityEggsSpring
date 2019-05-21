package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.MultiTabCab;
import com.unmsm.fisi.model.TabCab;

@Component("tabCabConvertidor")
public class TabCabTransform implements Transform<TabCab, MultiTabCab>{

	@Override
	public MultiTabCab transformME(TabCab oModel) {
		if(oModel != null) {
			MultiTabCab oMultiTabCab = new MultiTabCab();
			oMultiTabCab.setNidTabla(oModel.getnIdTabla());
			oMultiTabCab.setVnombreTabla(oModel.getsNombreTabla());
			oMultiTabCab.setVdescripcion(oModel.getsDescripcion());
			
			return oMultiTabCab;
		}
		return null;
	}

	@Override
	public List<MultiTabCab> transformME(List<TabCab> lModel) {
		if(lModel != null) {
			List<MultiTabCab> lMultiTabCab = new ArrayList<>();
			
			for(TabCab oTabCab : lModel) {
				MultiTabCab oMultiTabCab = transformME(oTabCab);
				lMultiTabCab.add(oMultiTabCab);
			}
			
			return lMultiTabCab;
		}
		return null;
	}

	@Override
	public TabCab transformEM(MultiTabCab oEntity) {
		if(oEntity != null) {
			TabCab oTabCab = new TabCab();
			oTabCab.setnIdTabla(oEntity.getNidTabla());
			oTabCab.setsNombreTabla(oEntity.getVnombreTabla());
			oTabCab.setsDescripcion(oEntity.getVdescripcion());
			
			return oTabCab;
		}
		return null;
	}

	@Override
	public List<TabCab> transformEM(List<MultiTabCab> lEntity) {
		if(lEntity != null) {
			List<TabCab> lTabCab = new ArrayList<>();
			
			for(MultiTabCab oMultiTabCab : lEntity) {
				TabCab oTabCab = transformEM(oMultiTabCab);
				lTabCab.add(oTabCab);
			}
			
			return lTabCab;
		}
		return null;
	}

}
