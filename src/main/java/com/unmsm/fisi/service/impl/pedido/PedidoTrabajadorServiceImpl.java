package com.unmsm.fisi.service.impl.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.PedidoTrabajador;
import com.unmsm.fisi.model.Trabajador;
import com.unmsm.fisi.repository.PedidoTrabajadorRepository;
import com.unmsm.fisi.service.PedidoTrabajadorService;
import com.unmsm.fisi.service.impl.mantenimiento.TrabajadorServiceImpl;
import com.unmsm.fisi.service.transform.PedidoTrabajadorTransform;

@Service("pedidoTrabajadorServicio")
public class PedidoTrabajadorServiceImpl implements PedidoTrabajadorService{
	@Autowired
	@Qualifier("pedidoTrabajadorRepositorio")
	private PedidoTrabajadorRepository pedidoTrabajadorRepository;
	@Autowired
	@Qualifier("pedidoTrabajadorConvertidor")
	private PedidoTrabajadorTransform pedidoTrabajadorTransform; 
	@Autowired
	@Qualifier("trabajadorServicio")
	private TrabajadorServiceImpl trabajadorServicio;
	
	@Override
	public List<PedidoTrabajador> listarPedidoTrabajador() {
		List<PedidoTrabajador> lMPedidoTrabajador = pedidoTrabajadorTransform.transformEM(pedidoTrabajadorRepository.findAll());
		for(PedidoTrabajador oPedidoTrabajador : lMPedidoTrabajador) {
			Trabajador oTrabajador = trabajadorServicio.buscarTrabajador(oPedidoTrabajador.getsTipoDocumento(), oPedidoTrabajador.getsNumeroDocumento());
			
			oPedidoTrabajador.setIdPersona(oTrabajador.getsTipoDocumento()+"/"+oTrabajador.getsNumeroDocumento());
			oPedidoTrabajador.setsNombre(oTrabajador.getsNombre());
			oPedidoTrabajador.setsApellidoMaterno(oTrabajador.getsApellidoMaterno());
			oPedidoTrabajador.setsApellidoPaterno(oTrabajador.getsApellidoPaterno());
		}
		return lMPedidoTrabajador;
	}

	@Override
	public PedidoTrabajador buscarPedidoTrabajador(Integer nIdPedido) {
		PedidoTrabajador oMPedidoTrabajador = pedidoTrabajadorTransform.transformEM(pedidoTrabajadorRepository.findOne(nIdPedido));
		Trabajador oTrabajador = trabajadorServicio.buscarTrabajador(oMPedidoTrabajador.getsTipoDocumento(), oMPedidoTrabajador.getsNumeroDocumento());
		
		oMPedidoTrabajador.setIdPersona(oTrabajador.getsTipoDocumento()+"/"+oTrabajador.getsNumeroDocumento());
		oMPedidoTrabajador.setsNombre(oTrabajador.getsNombre());
		oMPedidoTrabajador.setsApellidoMaterno(oTrabajador.getsApellidoMaterno());
		oMPedidoTrabajador.setsApellidoPaterno(oTrabajador.getsApellidoPaterno());
		
		return oMPedidoTrabajador;
	}

	@Override
	public Integer registrarPedidoTrabajador(PedidoTrabajador oPedidoTrabajador) {
		pedidoTrabajadorRepository.save(pedidoTrabajadorTransform.transformME(oPedidoTrabajador));
		return listarPedidoTrabajador().get(listarPedidoTrabajador().size()-1).getnIdPedido();
	}

	@Override
	public Integer actualizarPedidoTrabajador(PedidoTrabajador oPedidoTrabajador) {
		pedidoTrabajadorRepository.save(pedidoTrabajadorTransform.transformME(oPedidoTrabajador));
		return oPedidoTrabajador.getnIdPedido();
	}

}
