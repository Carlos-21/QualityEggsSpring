package com.unmsm.fisi.service.impl.pago;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.PagoPedido;
import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.repository.PagoPedidoRepository;
import com.unmsm.fisi.service.PagoPedidoService;
import com.unmsm.fisi.service.impl.pedido.PedidoClienteServiceImpl;
import com.unmsm.fisi.service.transform.PagoPedidoTransform;

@Service("pagoPedidoServicio")
public class PagoPedidoServiceImpl implements PagoPedidoService {
	@Autowired
	@Qualifier("pagoPedidoRepositorio")
	private PagoPedidoRepository pagoPedidoRepository;
	@Autowired
	@Qualifier("pagoPedidoConvertidor")
	private PagoPedidoTransform pagoPedidoTransform;
	@Autowired
	@Qualifier("pedidoClienteServicio")
	private PedidoClienteServiceImpl pedidoClienteServicio;

	@Override
	public List<PagoPedido> listarPagoPedido() {
		List<PagoPedido> lMPagoPedido = pagoPedidoTransform.transformEM(pagoPedidoRepository.findAll());

		for (PagoPedido oMPagoPedido : lMPagoPedido) {
			PedidoCliente oMPedidoCliente = pedidoClienteServicio.buscarPedidoCliente(oMPagoPedido.getnIdPedido());

			oMPagoPedido.setsNumeroDocumento(oMPedidoCliente.getsNumeroDocumento());
			oMPagoPedido.setsEmpresa(oMPedidoCliente.getsEmpresa());
			oMPagoPedido.setsRubro(oMPedidoCliente.getsRubro());
		}

		return lMPagoPedido;
	}

	@Override
	public PagoPedido buscarPagoPedido(Integer nIdPago) {
		PagoPedido oMPagoPedido = pagoPedidoTransform.transformEM(pagoPedidoRepository.findOne(nIdPago));

		PedidoCliente oMPedidoCliente = pedidoClienteServicio.buscarPedidoCliente(oMPagoPedido.getnIdPedido());

		oMPagoPedido.setsNumeroDocumento(oMPedidoCliente.getsNumeroDocumento());
		oMPagoPedido.setsEmpresa(oMPedidoCliente.getsEmpresa());
		oMPagoPedido.setsRubro(oMPedidoCliente.getsRubro());

		return oMPagoPedido;
	}

	@Override
	public Integer registrarPagoPedido(PagoPedido oPagoPedido) {
		pagoPedidoRepository.save(pagoPedidoTransform.transformME(oPagoPedido));
		return listarPagoPedido().get(listarPagoPedido().size() - 1).getnIdPago();
	}

	@Override
	public Integer actualizarPagoPedido(PagoPedido oPagoPedido) {
		pagoPedidoRepository.save(pagoPedidoTransform.transformME(oPagoPedido));
		return oPagoPedido.getnIdPago();
	}

}
