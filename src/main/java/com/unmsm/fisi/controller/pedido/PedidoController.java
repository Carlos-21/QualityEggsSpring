package com.unmsm.fisi.controller.pedido;

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
import com.unmsm.fisi.service.impl.mantenimiento.ProveedorServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.TrabajadorServiceImpl;

@Vista
@Audit(accion = Accion.Visita, comentario = Comentario.Visita)
@RequestMapping("/pedido")
public @Controller class PedidoController {
	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServiceImpl clienteServicio;
	@Autowired
	@Qualifier("proveedorServicio")
	private ProveedorServiceImpl proveedorServicio;
	@Autowired
	@Qualifier("trabajadorServicio")
	private TrabajadorServiceImpl trabajadorServicio;
	
	@GetMapping("/{mantenimiento:pedidoCliente}")
    public String irPaginaMantenimientoPedidoCliente(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("clientes", clienteServicio.listarClientes());
        return "seguras/pedido/mantenimiento";
    }
	
	@GetMapping("/{mantenimiento:pedidoTrabajador}")
    public String irPaginaMantenimientoPedidoTrabajador(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("trabajadores", trabajadorServicio.listarTrabajadores());
        model.addAttribute("proveedores", proveedorServicio.listarProveedores());
        return "seguras/pedido/mantenimiento";
    }
	
}
