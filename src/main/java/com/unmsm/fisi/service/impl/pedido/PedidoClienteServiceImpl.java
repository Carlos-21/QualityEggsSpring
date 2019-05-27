package com.unmsm.fisi.service.impl.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.repository.PedidoClienteRepository;
import com.unmsm.fisi.service.PedidoClienteService;
import com.unmsm.fisi.service.transform.PedidoClienteTransform;

@Service("pedidoClienteServicio")
public class PedidoClienteServiceImpl implements PedidoClienteService{
	@Autowired
	@Qualifier("pedidoClienteRepositorio")
	private PedidoClienteRepository pedidoClienteRepository;
	@Autowired
	@Qualifier("trabajadorConvertidor")
	private PedidoClienteTransform pedidoClienteTransform;
	
	@Override
	public List<PedidoCliente> listarPedidosClientes() {
		return pedidoClienteTransform.transformEM(pedidoClienteRepository.findAll());
	}

	@Override
	public PedidoCliente buscarPedidoCliente(Integer nidPedido) {
		return pedidoClienteTransform.transformEM(pedidoClienteRepository.findOne(nidPedido));
	}

	@Override
	public Integer registrarPedidoCliente(PedidoCliente oPedidoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarPedidoCliente(PedidoCliente oPedidoCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPedidoCliente(Integer nidPedido) {
		// TODO Auto-generated method stub
		
	}

}
