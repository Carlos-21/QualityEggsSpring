package com.unmsm.fisi.service.impl.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.model.Producto;
import com.unmsm.fisi.repository.PedidoClienteRepository;
import com.unmsm.fisi.service.PedidoClienteService;
import com.unmsm.fisi.service.impl.mantenimiento.ClienteServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.OfertaServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.ProductoServiceImpl;
import com.unmsm.fisi.service.transform.PedidoClienteTransform;

@Service("pedidoClienteServicio")
public class PedidoClienteServiceImpl implements PedidoClienteService {
	@Autowired
	@Qualifier("pedidoClienteRepositorio")
	private PedidoClienteRepository pedidoClienteRepository;
	@Autowired
	@Qualifier("pedidoClienteConvertidor")
	private PedidoClienteTransform pedidoClienteTransform;
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteService;
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServiceImpl productoService;
	@Autowired
	@Qualifier("ofertaServicio")
	private OfertaServiceImpl ofertaService;

	@Override
	public List<PedidoCliente> listarPedidosClientes() {
		Producto oProducto = productoService.buscarProducto(1);
		List<PedidoCliente> lMPedidoCliente = pedidoClienteTransform.transformEM(pedidoClienteRepository.findAll());
		for (PedidoCliente oPedidoCliente : lMPedidoCliente) {
			Cliente oCliente = clienteService.buscarCliente(oPedidoCliente.getsTipoDocumento(),
					oPedidoCliente.getsNumeroDocumento());

			oPedidoCliente.setIdPersona(oCliente.getsTipoDocumento() + "/" + oCliente.getsNumeroDocumento());
			oPedidoCliente.setsNombre(oCliente.getsNombre());
			oPedidoCliente.setsApellidoMaterno(oCliente.getsApellidoMaterno());
			oPedidoCliente.setsApellidoPaterno(oCliente.getsApellidoPaterno());
			oPedidoCliente.setsEmpresa(oCliente.getsEmpresa());
			oPedidoCliente.setsRubro(oCliente.getsRubro());
			oPedidoCliente.setnMonto(
					(double) Math.round((oPedidoCliente.getnCantidad() * oProducto.getnPrecioUnitario()) * 100d)
							/ 100d);
			oPedidoCliente.setsDireccion(oCliente.getsDomicilio());
		}
		return lMPedidoCliente;
	}

	@Override
	public PedidoCliente buscarPedidoCliente(Integer nidPedido) {
		Producto oProducto = productoService.buscarProducto(1);

		PedidoCliente oPedidoCliente = pedidoClienteTransform.transformEM(pedidoClienteRepository.findOne(nidPedido));

		Cliente oCliente = clienteService.buscarCliente(oPedidoCliente.getsTipoDocumento(),
				oPedidoCliente.getsNumeroDocumento());

		oPedidoCliente.setIdPersona(oCliente.getsTipoDocumento() + "/" + oCliente.getsNumeroDocumento());
		oPedidoCliente.setsNombre(oCliente.getsNombre());
		oPedidoCliente.setsApellidoMaterno(oCliente.getsApellidoMaterno());
		oPedidoCliente.setsApellidoPaterno(oCliente.getsApellidoPaterno());
		oPedidoCliente.setsEmpresa(oCliente.getsEmpresa());
		oPedidoCliente.setsRubro(oCliente.getsRubro());

		double dValorVenta = (double) Math
				.round((oPedidoCliente.getnCantidad() * oProducto.getnPrecioUnitario()) * 100d) / 100d;
		double nIGV = (double) Math.round((dValorVenta * 0.18) * 100d) / 100d;
		double nMontoTotal = (double) Math.round((dValorVenta + nIGV) * 100d) / 100d;
		
		List<Oferta> lOferta = ofertaService.listarOfertas();
		if(lOferta != null) {
			if(!lOferta.isEmpty()) {
				Oferta oOferta = lOferta.get(lOferta.size()-1);
				
				if(oPedidoCliente.getdFecha().compareTo(oOferta.getdFechaInicio())>=0 && oPedidoCliente.getdFecha().compareTo(oOferta.getdFechaFin())<=0) {
					double dDescuento = (double) Math.round((oOferta.getnDescuento()/100d) * 100d) / 100d;
					
					nMontoTotal = (double) Math.round((nMontoTotal - (nMontoTotal*dDescuento)) * 100d) / 100d;
				}
			}
			
		}
		
		oPedidoCliente.setnMonto(nMontoTotal);
		oPedidoCliente.setsDireccion(oCliente.getsDomicilio());
		return oPedidoCliente;
	}

	@Override
	public Integer registrarPedidoCliente(PedidoCliente oPedidoCliente) {
		pedidoClienteRepository.save(pedidoClienteTransform.transformME(oPedidoCliente));
		return listarPedidosClientes().get(listarPedidosClientes().size() - 1).getNidPedido();
	}

	@Override
	public Integer actualizarPedidoCliente(PedidoCliente oPedidoCliente) {
		pedidoClienteRepository.save(pedidoClienteTransform.transformME(oPedidoCliente));
		return listarPedidosClientes().get(listarPedidosClientes().size() - 1).getNidPedido();
	}

	@Override
	public void eliminarPedidoCliente(Integer nidPedido) {
		pedidoClienteRepository.delete(nidPedido);
	}

}
