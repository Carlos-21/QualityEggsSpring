package com.unmsm.fisi.controller.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.unmsm.fisi.service.impl.seguridad.PerfilServiceImpl;

@Vista
@Audit(accion = Accion.Visita, comentario = Comentario.Visita)
@RequestMapping("/seguridad")
public @Controller class SeguridadController {
	@Autowired
	@Qualifier("perfilServicio")
	private PerfilServiceImpl perfilService;
	@Autowired
	@Qualifier("personaServicio")
	private PersonaServiceImpl personaServicio;
	
	
    @GetMapping("/{mantenimiento:perfil}")
    public String irPaginaMantenimientoPerfil(@PathVariable String mantenimiento, ModelMap model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        return "seguras/seguridad/mantenimiento";
    }
	
    @Audit(tipo = Tipo.Usu)
    @GetMapping(value = "/{mantenimiento:usuario}")
    public String irPaginaMantenimientoUsuario(@PathVariable String mantenimiento, Model model)
    {
        model.addAttribute("mantenimiento", mantenimiento);
        model.addAttribute("perfiles", perfilService.listarPerfiles());
        model.addAttribute("personas", personaServicio.listarPersonas());
        return "seguras/seguridad/mantenimiento";
    }
	
}
