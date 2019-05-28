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
		pedidoClienteRepository.save(pedidoClienteTransform.transformME(oPedidoCliente));
		return listarPedidosClientes().get(listarPedidosClientes().size()-1).getNidPedido();
	}

	@Override
	public Integer actualizarPedidoCliente(PedidoCliente oPedidoCliente) {
		pedidoClienteRepository.save(pedidoClienteTransform.transformME(oPedidoCliente));
		return listarPedidosClientes().get(listarPedidosClientes().size()-1).getNidPedido();
	}

	@Override
	public void eliminarPedidoCliente(Integer nidPedido) {
		pedidoClienteRepository.delete(nidPedido);
	}

}
