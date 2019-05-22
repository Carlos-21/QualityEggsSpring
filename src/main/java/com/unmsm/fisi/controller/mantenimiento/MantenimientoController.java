package com.unmsm.fisi.controller.mantenimiento;

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
import com.unmsm.fisi.aspecto.enumeracion.Tipo;
import com.unmsm.fisi.controller.excepcion.anotacion.Vista;
import com.unmsm.fisi.service.impl.mantenimiento.PersonaServiceImpl;
import com.unmsm.fisi.service.impl.mantenimiento.TabDetServiceImpl;
import com.unmsm.fisi.utilitario.MultiTablaUtil;

@Vista
@Audit(accion = Accion.Visita, comentario = Comentario.Visita)
@RequestMapping("/mantenimiento")
public @Controller class MantenimientoController
{
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaServicio;
	@Autowired
	@Qualifier("tabDetServicio")
	private TabDetServiceImpl tabDetServicio;
	
    @Audit(tipo = Tipo.Persona)
    @GetMapping("/{mantenimiento:persona}")
    public String irPaginaMantenimientoPersona(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("tiposDocumento",
        		tabDetServicio.buscarIdTabla(MultiTablaUtil.TABLA_TIPO_DOCUMENTO_IDENTIDAD));
        return "seguras/mantenimiento/mantenimiento";
    }

    @Audit(tipo = Tipo.MulTabCab)
    @GetMapping("/{mantenimiento:multitabcab}")
    public String irPaginaMantenimientoTabladeTabla(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        return "seguras/mantenimiento/multiTabla";
    }
   
    @GetMapping("/{mantenimiento:proveedor}")
    public String irPaginaMantenimientoProveedor(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("tiposDocumento",
        		tabDetServicio.buscarIdTabla(MultiTablaUtil.TABLA_TIPO_DOCUMENTO_IDENTIDAD));
        return "seguras/mantenimiento/mantenimiento";
    }
        
    @GetMapping("/{mantenimiento:cliente}")
    public String irPaginaMantenimientoCliente(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("tiposDocumento",
        		tabDetServicio.buscarIdTabla(MultiTablaUtil.TABLA_TIPO_DOCUMENTO_IDENTIDAD));
        return "seguras/mantenimiento/mantenimiento";
    }

    @GetMapping("/{mantenimiento:producto}")
    public String irPaginaMantenimientoProducto(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("tiposProducto",
        		tabDetServicio.buscarIdTabla(MultiTablaUtil.TABLA_TIPO_PRODUCTO));
        return "seguras/mantenimiento/mantenimiento";
    }
    
}