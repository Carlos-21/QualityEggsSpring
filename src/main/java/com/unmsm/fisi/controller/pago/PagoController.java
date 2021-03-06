package com.unmsm.fisi.controller.pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unmsm.fisi.aspecto.anotacion.Audit;
import com.unmsm.fisi.aspecto.enumeracion.Accion;
import com.unmsm.fisi.aspecto.enumeracion.Comentario;
import com.unmsm.fisi.controller.excepcion.anotacion.Vista;
import com.unmsm.fisi.service.impl.mantenimiento.ClienteServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.TabDetServiceImpl;
import com.unmsm.fisi.service.impl.pago.PagoPedidoServiceImpl;
import com.unmsm.fisi.utilitario.MultiTablaUtil;

@Vista
@Audit(accion = Accion.Visita, comentario = Comentario.Visita)
@RequestMapping("/pago")
public @Controller class PagoController {
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteServicio;
	@Autowired
	@Qualifier("pagoPedidoServicio")
	private PagoPedidoServiceImpl pedidoPagoClienteServicio;
	@Autowired
	@Qualifier("tabDetServicio")
	private TabDetServiceImpl tabDetServicio;
	
	@GetMapping("/{mantenimiento:pagoPedido}")
    public String irPaginaMantenimientoPagoPedido(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("clientes", pedidoPagoClienteServicio.listarPedidoPagoCliente());
        model.addAttribute("tiposPago",
        		tabDetServicio.buscarIdTabla(MultiTablaUtil.TABLA_TIPO_PAGO));
        return "seguras/pago/mantenimiento";
    }
	
	@GetMapping("{reporte:guiaRemision}")
    public String irPaginaGuiaRemision(ModelMap model)
    {
        return "seguras/reporte/guiaRemision";
    }
	
	@GetMapping("{reporte:factura}")
    public String irPaginaFactura(ModelMap model)
    {
        return "seguras/reporte/factura";
    }
	
	@GetMapping("{reporte:reporteVenta}")
    public String irPaginaReporteVenta(ModelMap model)
    {
        return "seguras/reporte/reporteVenta";
    }
	
}
