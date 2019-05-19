package com.unmsm.fisi.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManProducto;
import com.unmsm.fisi.model.Producto;

@Component("productoConvertidor")
public class ProductoTransform implements Transform<Producto, ManProducto> {

	@Override
	public ManProducto transformME(Producto oModel) {
		if (oModel != null) {
			ManProducto oEProducto = new ManProducto();
			oEProducto.setNidProducto(oModel.getnIdentificador());
			oEProducto.setVnombre(oModel.getsNombre());
			oEProducto.setVdescripcion(oModel.getsDescripcion());
			oEProducto.setVtipo(oModel.getsTipo());
			oEProducto.setNstock(oModel.getnStock());
			oEProducto.setNprecioUnitario(oModel.getnPrecioUnitario());

			return oEProducto;
		}
		return null;
	}

	@Override
	public List<ManProducto> transformME(List<Producto> lModel) {
		if (lModel != null) {
			List<ManProducto> lEProducto = new ArrayList<>();

			for (Producto oProducto : lModel) {
				ManProducto oEProducto = transformME(oProducto);
				lEProducto.add(oEProducto);
			}
			return lEProducto;
		}
		return null;
	}

	@Override
	public Producto transformEM(ManProducto oEntity) {
		if (oEntity != null) {
			Producto oMProducto = new Producto();
			oMProducto.setnIdentificador(oEntity.getNidProducto());
			oMProducto.setsNombre(oEntity.getVnombre());
			oMProducto.setsDescripcion(oEntity.getVdescripcion());
			oMProducto.setsTipo(oEntity.getVtipo());
			oMProducto.setnStock(oEntity.getNstock());
			oMProducto.setnPrecioUnitario(oEntity.getNprecioUnitario());

			return oMProducto;

		}
		return null;
	}

	@Override
	public List<Producto> transformEM(List<ManProducto> lEntity) {
		if (lEntity != null) {
			List<Producto> lMProducto = new ArrayList<>();
			for (ManProducto oProducto : lEntity) {
				Producto oMProducto = transformEM(oProducto);
				lMProducto.add(oMProducto);
			}
			return lMProducto;
		}
		return null;
	}

}
