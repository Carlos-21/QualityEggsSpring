package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unmsm.fisi.entity.ManProveedor;
import com.unmsm.fisi.entity.ManProveedorId;
import com.unmsm.fisi.model.Proveedor;

@Component("proveedorConvertidor")
public class ProveedorTransform implements Transform<Proveedor, ManProveedor>{

	@Override
	public ManProveedor transformME(Proveedor oModel) {
		if(oModel != null) {
			ManProveedorId oEProveedorId = new ManProveedorId();
			oEProveedorId.setManPersonaVTipoDocumento(oModel.getsTipoDocumento());
			oEProveedorId.setManPersonaVNumeroDocumento(oModel.getsNumeroDocumento());
			
			ManProveedor oEProveedor = new ManProveedor();
			oEProveedor.setId(oEProveedorId);
			oEProveedor.setVempresa(oModel.getsEmpresa());
			oEProveedor.setVrubro(oModel.getsRubro());
			
			return oEProveedor;
		}
		return null;
	}

	@Override
	public List<ManProveedor> transformME(List<Proveedor> lModel) {
		if(lModel != null) {
			List<ManProveedor> lEProveedor = new ArrayList<>();
			
			for(Proveedor oProveedor : lModel) {
				ManProveedor oEProveedor = transformME(oProveedor);
				lEProveedor.add(oEProveedor);
			}
			return lEProveedor;
		}
		return null;
	}

	@Override
	public Proveedor transformEM(ManProveedor oEntity) {
		if(oEntity != null) {
			Proveedor oMProveedor = new Proveedor();
			oMProveedor.setsTipoDocumento(oEntity.getId().getManPersonaVTipoDocumento());
			oMProveedor.setsNumeroDocumento(oEntity.getId().getManPersonaVNumeroDocumento());
			oMProveedor.setsEmpresa(oEntity.getVempresa());
			oMProveedor.setsRubro(oEntity.getVrubro());
			
			return oMProveedor;
		}
		return null;
	}

	@Override
	public List<Proveedor> transformEM(List<ManProveedor> lEntity) {
		if(lEntity != null) {
			List<Proveedor> lMProveedor = new ArrayList<>();
			for(ManProveedor oProveedor : lEntity) {
				Proveedor oMProveedor = transformEM(oProveedor);
				lMProveedor.add(oMProveedor);
			}
			return lMProveedor;
		}
		return null;
	}

}
