package com.unmsm.fisi.service.impl.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.repository.PedidoClienteRepository;
import com.unmsm.fisi.service.PedidoClienteService;
import com.unmsm.fisi.service.impl.mantenimiento.ClienteServiceImpl;
import com.unmsm.fisi.service.transform.PedidoClienteTransform;

@Service("pedidoClienteServicio")
public class PedidoClienteServiceImpl implements PedidoClienteService{
	@Autowired
	@Qualifier("pedidoClienteRepositorio")
	private PedidoClienteRepository pedidoClienteRepository;
	@Autowired
	@Qualifier("pedidoClienteConvertidor")
	private PedidoClienteTransform pedidoClienteTransform;
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteService;
	
	@Override
	public List<PedidoCliente> listarPedidosClientes() {
		List<PedidoCliente> lMPedidoCliente  = pedidoClienteTransform.transformEM(pedidoClienteRepository.findAll());
		for(PedidoCliente oPedidoCliente : lMPedidoCliente) {
			Cliente oCliente = clienteService.buscarCliente(oPedidoCliente.getsTipoDocumento(), oPedidoCliente.getsNumeroDocumento());
			
			oPedidoCliente.setIdPersona(oCliente.getsTipoDocumento()+"/"+oCliente.getsNumeroDocumento());
			oPedidoCliente.setsNombre(oCliente.getsNombre());
			oPedidoCliente.setsApellidoMaterno(oCliente.getsApellidoMaterno());
			oPedidoCliente.setsApellidoPaterno(oCliente.getsApellidoPaterno());
			oPedidoCliente.setsEmpresa(oCliente.getsEmpresa());
			oPedidoCliente.setsRubro(oCliente.getsRubro());
		}
		return lMPedidoCliente;
	}

	@Override
	public PedidoCliente buscarPedidoCliente(Integer nidPedido) {
		PedidoCliente oPedidoCliente = pedidoClienteTransform.transformEM(pedidoClienteRepository.findOne(nidPedido));
		
		Cliente oCliente = clienteService.buscarCliente(oPedidoCliente.getsTipoDocumento(), oPedidoCliente.getsNumeroDocumento());
		
		oPedidoCliente.setIdPersona(oCliente.getsTipoDocumento()+"/"+oCliente.getsNumeroDocumento());
		oPedidoCliente.setsNombre(oCliente.getsNombre());
		oPedidoCliente.setsApellidoMaterno(oCliente.getsApellidoMaterno());
		oPedidoCliente.setsApellidoPaterno(oCliente.getsApellidoPaterno());
		oPedidoCliente.setsEmpresa(oCliente.getsEmpresa());
		oPedidoCliente.setsRubro(oCliente.getsRubro());
		return oPedidoCliente;
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
