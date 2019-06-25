package com.unmsm.fisi.service.impl.reporte;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.model.GuiaRemision;
import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.service.ReporteService;
import com.unmsm.fisi.service.impl.pedido.PedidoClienteServiceImpl;

@Service("reporteServicio")
public class ReporteServiceImpl implements ReporteService{
	@Autowired
	@Qualifier("pedidoClienteServicio")
	private PedidoClienteServiceImpl pedidoClienteService;
	
	@Override
	public List<GuiaRemision> listarGuiaRemision() {
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		List<GuiaRemision> lGuiaRemision = new ArrayList<>();
		
		List<PedidoCliente> lPedidoCliente = pedidoClienteService.listarPedidosClientes();
		
		int i = 0;
		
		for(PedidoCliente oPedidoCliente : lPedidoCliente) {
			i++;
			
			GuiaRemision oGuiaRemision = new GuiaRemision();
			oGuiaRemision.setsRUCEmpresa("12345678912");
			oGuiaRemision.setsNumeroGuia("N° 001 - 0000000" + String.valueOf(i));
			oGuiaRemision.setsFechaTraslado(dateFormat.format(date));
			oGuiaRemision.setsDireccionPartida("Av. Los Olivos n°156");
			oGuiaRemision.setsDestinatario(oPedidoCliente.getsEmpresa());
			oGuiaRemision.setsDireccionLlegada(oPedidoCliente.getsDireccion());
			oGuiaRemision.setsRUCCliente(oPedidoCliente.getsNumeroDocumento());
			oGuiaRemision.setsNumeroDocumento("");
			oGuiaRemision.setsDocumento("");
			oGuiaRemision.setsDescripcionProducto("Jabas de huevo de gallina");
			oGuiaRemision.setnCantidadProducto(oPedidoCliente.getnCantidad());
			oGuiaRemision.setsRUCRemitente(oPedidoCliente.getsNumeroDocumento());
			oGuiaRemision.setsDenominacionRemitente(oPedidoCliente.getsEmpresa());
			oGuiaRemision.setsMarcaPlaca("Volvo XX-0101");
			oGuiaRemision.setsLicenciaConducir("TA-1234567");
			
			lGuiaRemision.add(oGuiaRemision);
			
		}
		
		return lGuiaRemision;
	}

}
