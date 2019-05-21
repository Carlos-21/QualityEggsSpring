package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.MultiTabDet;
import com.unmsm.fisi.entity.MultiTabDetId;
import com.unmsm.fisi.model.TabDet;

@Component("tabDetConvertidor")
public class TabDetTransform implements Transform<TabDet, MultiTabDet>{

	@Override
	public MultiTabDet transformME(TabDet oModel) {
		if(oModel != null) {
			MultiTabDetId oMultiTabDetId = new MultiTabDetId();
			oMultiTabDetId.setNidTabla(oModel.getnIdTabla());
			oMultiTabDetId.setVidItem(oModel.getsIdItem());
			
			MultiTabDet oMultiTabDet = new MultiTabDet();
			oMultiTabDet.setId(oMultiTabDetId);
			oMultiTabDet.setVdescripcionCorta(oModel.getsDescripcionCorta());
			oMultiTabDet.setVdescripcion(oModel.getsDescripcion());
			
			return oMultiTabDet;
		}
		return null;
	}

	@Override
	public List<MultiTabDet> transformME(List<TabDet> lModel) {
		if(lModel != null) {
			List<MultiTabDet> lMultiTabDet = new ArrayList<>();
			
			for(TabDet oTabDet : lModel) {
				MultiTabDet oMultiTabDet = transformME(oTabDet);
				lMultiTabDet.add(oMultiTabDet);
			}
			
			return lMultiTabDet;
		}
		return null;
	}

	@Override
	public TabDet transformEM(MultiTabDet oEntity) {
		if(oEntity != null) {
			TabDet oTabDet = new TabDet();
			oTabDet.setnIdTabla(oEntity.getId().getNidTabla());
			oTabDet.setsIdItem(oEntity.getId().getVidItem());
			oTabDet.setsDescripcionCorta(oEntity.getVdescripcionCorta());
			oTabDet.setsDescripcion(oEntity.getVdescripcion());
			
			return oTabDet;
		}
		return null;
	}

	@Override
	public List<TabDet> transformEM(List<MultiTabDet> lEntity) {
		if(lEntity != null) {
			List<TabDet> lTabDet = new ArrayList<>();
			for(MultiTabDet oMultiTabDet : lEntity) {
				TabDet oTabDet = transformEM(oMultiTabDet);
				lTabDet.add(oTabDet);
			}
			return lTabDet;
		}
		return null;
	}

}
