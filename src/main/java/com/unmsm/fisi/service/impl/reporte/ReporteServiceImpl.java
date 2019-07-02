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

import com.unmsm.fisi.model.BusquedaParametro;
import com.unmsm.fisi.model.Factura;
import com.unmsm.fisi.model.GuiaRemision;
import com.unmsm.fisi.model.PedidoCliente;
import com.unmsm.fisi.model.Producto;
import com.unmsm.fisi.model.ReporteVentas;
import com.unmsm.fisi.service.ReporteService;
import com.unmsm.fisi.service.impl.mantenimiento.ProductoServiceImpl;
import com.unmsm.fisi.service.impl.pedido.PedidoClienteServiceImpl;

@Service("reporteServicio")
public class ReporteServiceImpl implements ReporteService {
	@Autowired
	@Qualifier("pedidoClienteServicio")
	private PedidoClienteServiceImpl pedidoClienteService;
	@Autowired
	@Qualifier("productoServicio")
	private ProductoServiceImpl productoService;

	@Override
	public List<GuiaRemision> listarGuiaRemision(BusquedaParametro oBusquedaParametro) {
		Date date = Calendar.getInstance().getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		List<GuiaRemision> lGuiaRemision = new ArrayList<>();

		List<PedidoCliente> lPedidoCliente = pedidoClienteService.listarPedidosClientes();

		int i = 0;

		for (PedidoCliente oPedidoCliente : lPedidoCliente) {
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
			oGuiaRemision.setdFechaPedido(oPedidoCliente.getdFecha());
			oGuiaRemision.setvEstado(oPedidoCliente.getvEstado());

			lGuiaRemision.add(oGuiaRemision);

		}

		/*
		 * if (oBusquedaParametro.getdFechaInicio() != null &&
		 * oBusquedaParametro.getdFechaFin() != null && oBusquedaParametro.getvEstado()
		 * == false && oBusquedaParametro.getsNumeroDocumento().compareTo("") == 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaInicio()) <= 0) &&
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaFin()) >= 0)); }
		 * 
		 * if (oBusquedaParametro.getdFechaInicio() == null &&
		 * oBusquedaParametro.getdFechaFin() == null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") == 0) {
		 * lGuiaRemision.removeIf(s -> s.getvEstado() !=
		 * oBusquedaParametro.getvEstado()); } if (oBusquedaParametro.getdFechaInicio()
		 * == null && oBusquedaParametro.getdFechaFin() == null &&
		 * oBusquedaParametro.getvEstado() == false &&
		 * oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0);
		 * } if (oBusquedaParametro.getdFechaInicio() == null &&
		 * oBusquedaParametro.getdFechaFin() == null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0)
		 * && (s.getvEstado() != oBusquedaParametro.getvEstado())); } if
		 * (oBusquedaParametro.getdFechaInicio() != null &&
		 * oBusquedaParametro.getdFechaFin() != null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaInicio()) <= 0) &&
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaFin()) >= 0) &&
		 * (s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0)
		 * && (s.getvEstado() != oBusquedaParametro.getvEstado())); }
		 */

		return lGuiaRemision;
	}

	@Override
	public List<Factura> listarFactura(BusquedaParametro oBusquedaParametro) {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd MMMM yyyy");

		List<Factura> lFactura = new ArrayList<>();

		List<PedidoCliente> lPedidoCliente = pedidoClienteService.listarPedidosClientes();

		Producto oProducto = productoService.buscarProducto(1);

		int i = 0;

		for (PedidoCliente oPedidoCliente : lPedidoCliente) {
			i++;

			Factura oFactura = new Factura();

			oFactura.setsRUCEmpresa("12345678912");
			oFactura.setsNumeroFactura("N° 001 - 0000000" + String.valueOf(i));
			oFactura.setsFechaFactura(formatoFecha.format(date).replace(" ", " de "));
			oFactura.setsEmpresaCliente(oPedidoCliente.getsEmpresa());
			oFactura.setsRUCEmpresaCliente(oPedidoCliente.getsNumeroDocumento());
			oFactura.setsDireccionCliente(oPedidoCliente.getsDireccion());
			oFactura.setsDescripcionProducto(oProducto.getsDescripcion());
			oFactura.setnCantidadProducto(oPedidoCliente.getnCantidad());
			oFactura.setsPrecioUnitario(String.valueOf(oProducto.getnPrecioUnitario()));
			oFactura.setsValorVenta(String.valueOf(
					(double) Math.round((oPedidoCliente.getnCantidad() * oProducto.getnPrecioUnitario()) * 100d)
							/ 100d));
			oFactura.setsSubTotal(oFactura.getsValorVenta());

			double nIGV = (double) Math.round((Double.valueOf(oFactura.getsSubTotal()) * 0.18) * 100d) / 100d;

			oFactura.setsIGV(String.valueOf(nIGV));

			double nMontoTotal = (double) Math
					.round((Double.valueOf(oFactura.getsSubTotal()) + Double.valueOf(oFactura.getsIGV())) * 100d)
					/ 100d;

			oFactura.setsMontoTotal(String.valueOf(nMontoTotal));
			oFactura.setdFechaPedido(oPedidoCliente.getdFecha());
			oFactura.setvEstado(oPedidoCliente.getvEstado());

			lFactura.add(oFactura);
		}

		/*
		 * if (oBusquedaParametro.getdFechaInicio() != null &&
		 * oBusquedaParametro.getdFechaFin() != null && oBusquedaParametro.getvEstado()
		 * == false && oBusquedaParametro.getsNumeroDocumento().compareTo("") == 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaInicio()) <= 0) &&
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaFin()) >= 0)); }
		 * 
		 * if (oBusquedaParametro.getdFechaInicio() == null &&
		 * oBusquedaParametro.getdFechaFin() == null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") == 0) {
		 * lGuiaRemision.removeIf(s -> s.getvEstado() !=
		 * oBusquedaParametro.getvEstado()); } if (oBusquedaParametro.getdFechaInicio()
		 * == null && oBusquedaParametro.getdFechaFin() == null &&
		 * oBusquedaParametro.getvEstado() == false &&
		 * oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0);
		 * } if (oBusquedaParametro.getdFechaInicio() == null &&
		 * oBusquedaParametro.getdFechaFin() == null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0)
		 * && (s.getvEstado() != oBusquedaParametro.getvEstado())); } if
		 * (oBusquedaParametro.getdFechaInicio() != null &&
		 * oBusquedaParametro.getdFechaFin() != null && oBusquedaParametro.getvEstado()
		 * == true && oBusquedaParametro.getsNumeroDocumento().compareTo("") != 0) {
		 * lGuiaRemision.removeIf(s ->
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaInicio()) <= 0) &&
		 * (s.getdFechaPedido().compareTo(oBusquedaParametro.getdFechaFin()) >= 0) &&
		 * (s.getsRUCCliente().compareTo(oBusquedaParametro.getsNumeroDocumento()) != 0)
		 * && (s.getvEstado() != oBusquedaParametro.getvEstado())); }
		 */

		return lFactura;
	}

	@Override
	public List<ReporteVentas> listarReporteVenta(BusquedaParametro oBusquedaParametro) {
		List<ReporteVentas> lReporteVenta = new ArrayList<>();

		List<PedidoCliente> lPedidoCliente = pedidoClienteService.listarPedidosClientes();

		Producto oProducto = productoService.buscarProducto(1);

		for (PedidoCliente oPedidoCliente : lPedidoCliente) {

			ReporteVentas oReporteVenta = new ReporteVentas();
			oReporteVenta.setdFechaPedido(oPedidoCliente.getdFecha());
			oReporteVenta.setsEmpresaCliente(oPedidoCliente.getsNumeroDocumento() + " - " + oPedidoCliente.getsEmpresa());
			oReporteVenta.setnCantidadProducto(oPedidoCliente.getnCantidad());
			oReporteVenta.setsDescripcionProducto(oProducto.getsDescripcion());

			double valorVenta = (double) Math
					.round((oPedidoCliente.getnCantidad() * oProducto.getnPrecioUnitario()) * 100d) / 100d;
			double IGV = (double) Math.round((valorVenta * 0.18) * 100d) / 100d;

			double nMontoTotal = (double) Math.round((valorVenta + IGV) * 100d) / 100d;

			oReporteVenta.setsMontoTotal(String.valueOf(nMontoTotal) + " soles");
			
			lReporteVenta.add(oReporteVenta);
		}

		return lReporteVenta;
	}

}
