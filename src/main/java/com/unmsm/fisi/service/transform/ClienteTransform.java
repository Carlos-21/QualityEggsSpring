package com.unmsm.fisi.service.transform;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManCliente;
import com.unmsm.fisi.model.Cliente;

@Service
public class ClienteTransform implements Transform<Cliente, ManCliente>{

	@Override
	public ManCliente transformME(Cliente oModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManCliente> transformME(List<Cliente> lModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente transformEM(ManCliente oEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> transformEM(List<ManCliente> lEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
