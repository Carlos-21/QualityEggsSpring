package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManProveedorId;
import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.Proveedor;
import com.unmsm.fisi.model.ProveedorId;
import com.unmsm.fisi.repository.ProveedorRepository;
import com.unmsm.fisi.service.ProveedorService;
import com.unmsm.fisi.service.transform.ProveedorTransform;

@Service("proveedorServicio")
public class ProveedorServiceImpl implements ProveedorService{
	@Autowired
	@Qualifier("proveedorRepositorio")
	private ProveedorRepository proveedorRepository;
	@Autowired
	@Qualifier("proveedorConvertidor")
	private ProveedorTransform proveedorTransform;
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaService;
	
	@Override
	public List<Proveedor> listarProveedores() {
		List<Proveedor> lMProveedor = proveedorTransform.transformEM(proveedorRepository.findAll());

		for (Proveedor oProveedor : lMProveedor) {
			Persona oPersona = personaService.buscarPersona(oProveedor.getsTipoDocumento(),
					oProveedor.getsNumeroDocumento());

			oProveedor.setsNombre(oPersona.getsNombre());
			oProveedor.setsApellidoPaterno(oPersona.getsApellidoPaterno());
			oProveedor.setsApellidoMaterno(oPersona.getsApellidoMaterno());
			oProveedor.setsSexo(oPersona.getsSexo());
			oProveedor.setsDomicilio(oPersona.getsDomicilio());
			oProveedor.setsTelefonoFijo(oPersona.getsTelefonoFijo());
			oProveedor.setsTelefonoCelular(oPersona.getsTelefonoCelular());
			oProveedor.setsCorreo(oPersona.getsCorreo());
			oProveedor.setdFecha(oPersona.getdFecha());
			oProveedor.setdHora(oPersona.getdHora());

		}

		return lMProveedor;
	}

	@Override
	public Proveedor buscarProveedor(String sTipoDocumento, String sNumeroDocumento) {
		ManProveedorId oEProveedorId = new ManProveedorId();
		oEProveedorId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		oEProveedorId.setManPersonaVTipoDocumento(sTipoDocumento);

		Proveedor oProveedor = proveedorTransform.transformEM(proveedorRepository.findOne(oEProveedorId));

		Persona oPersona = personaService.buscarPersona(oProveedor.getsTipoDocumento(), oProveedor.getsNumeroDocumento());
		oProveedor.setsNombre(oPersona.getsNombre());
		oProveedor.setsApellidoPaterno(oPersona.getsApellidoPaterno());
		oProveedor.setsApellidoMaterno(oPersona.getsApellidoMaterno());
		oProveedor.setsSexo(oPersona.getsSexo());
		oProveedor.setsDomicilio(oPersona.getsDomicilio());
		oProveedor.setsTelefonoFijo(oPersona.getsTelefonoFijo());
		oProveedor.setsTelefonoCelular(oPersona.getsTelefonoCelular());
		oProveedor.setsCorreo(oPersona.getsCorreo());
		oProveedor.setdFecha(oPersona.getdFecha());
		oProveedor.setdHora(oPersona.getdHora());

		return oProveedor;
	}

	@Override
	public ProveedorId registrarProveedor(Proveedor oProveedor) {
		Persona oPersona = oProveedor;
		
		personaService.registrarPersona(oPersona);
		
		proveedorRepository.save(proveedorTransform.transformME(oProveedor));
		
		ProveedorId oMProveedorId = new ProveedorId();
		oMProveedorId.setsNumeroDocumento(oProveedor.getsNumeroDocumento());
		oMProveedorId.setsTipoDocumento(oProveedor.getsTipoDocumento());

		return oMProveedorId;
	}

	@Override
	public ProveedorId actualizarProveedor(Proveedor oProveedor) {
		Persona oPersona = oProveedor;
		
		personaService.actualizarPersona(oPersona);
		
		proveedorRepository.save(proveedorTransform.transformME(oProveedor));

		ProveedorId oMProveedorId = new ProveedorId();
		oMProveedorId.setsNumeroDocumento(oProveedor.getsNumeroDocumento());
		oMProveedorId.setsTipoDocumento(oProveedor.getsTipoDocumento());
		
		eliminarProveedor(oProveedor.getsTipoDocumentoAntiguo(), oProveedor.getsNumeroDocumentoAntiguo());

		return oMProveedorId;
	}

	@Override
	public void eliminarProveedor(String sTipoDocumento, String sNumeroDocumento) {
		ManProveedorId oEProveedorId = new ManProveedorId();
		oEProveedorId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		oEProveedorId.setManPersonaVTipoDocumento(sTipoDocumento);
		
		proveedorRepository.delete(oEProveedorId);
		
		personaService.eliminarPersona(sTipoDocumento, sNumeroDocumento);
	}

}
