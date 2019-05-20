package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManClienteId;
import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.ClienteId;
import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.repository.ClienteRepository;
import com.unmsm.fisi.service.ClienteService;
import com.unmsm.fisi.service.transform.ClienteTransform;

@Service("clienteServicio")
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	@Qualifier("clienteRepositorio")
	private ClienteRepository clienteRepository;
	@Autowired
	@Qualifier("clienteConvertidor")
	private ClienteTransform clienteTransform;
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaService;

	@Override
	public List<Cliente> listarClientes() {
		List<Cliente> lMCliente = clienteTransform.transformEM(clienteRepository.findAll());

		for (Cliente oCliente : lMCliente) {
			Persona oPersona = personaService.buscarPersona(oCliente.getsTipoDocumento(),
					oCliente.getsNumeroDocumento());

			oCliente.setsNombre(oPersona.getsNombre());
			oCliente.setsApellidoPaterno(oPersona.getsApellidoPaterno());
			oCliente.setsApellidoMaterno(oPersona.getsApellidoMaterno());

		}

		return lMCliente;
	}

	@Override
	public Cliente buscarCliente(String sTipoDocumento, String sNumeroDocumento) {
		ManClienteId oEClienteId = new ManClienteId();
		oEClienteId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		oEClienteId.setManPersonaVTipoDocumento(sTipoDocumento);

		Cliente oCliente = clienteTransform.transformEM(clienteRepository.findOne(oEClienteId));

		Persona oPersona = personaService.buscarPersona(oCliente.getsTipoDocumento(), oCliente.getsNumeroDocumento());
		oCliente.setsNombre(oPersona.getsNombre());
		oCliente.setsApellidoPaterno(oPersona.getsApellidoPaterno());
		oCliente.setsApellidoMaterno(oPersona.getsApellidoMaterno());

		return oCliente;
	}

	@Override
	public ClienteId registrarCliente(Cliente oCliente) {
		clienteRepository.save(clienteTransform.transformME(oCliente));

		ClienteId oMClienteId = new ClienteId();
		oMClienteId.setsNumeroDocumento(oCliente.getsNumeroDocumento());
		oMClienteId.setsTipoDocumento(oCliente.getsTipoDocumento());

		return oMClienteId;
	}

	@Override
	public ClienteId actualizarCliente(Cliente oCliente) {
		clienteRepository.save(clienteTransform.transformME(oCliente));

		ClienteId oMClienteId = new ClienteId();
		oMClienteId.setsNumeroDocumento(oCliente.getsNumeroDocumento());
		oMClienteId.setsTipoDocumento(oCliente.getsTipoDocumento());

		return oMClienteId;
	}

	@Override
	public void eliminarCliente(String sTipoDocumento, String sNumeroDocumento) {
		ManClienteId oEClienteId = new ManClienteId();
		oEClienteId.setManPersonaVNumeroDocumento(sNumeroDocumento);
		oEClienteId.setManPersonaVTipoDocumento(sTipoDocumento);
		
		clienteRepository.delete(oEClienteId);
	}

}
