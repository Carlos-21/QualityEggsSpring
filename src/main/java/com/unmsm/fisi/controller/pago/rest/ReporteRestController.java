package com.unmsm.fisi.controller.pago.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unmsm.fisi.model.GuiaRemision;
import com.unmsm.fisi.service.impl.pedido.PedidoClienteServiceImpl;
import com.unmsm.fisi.service.impl.reporte.ReporteServiceImpl;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/pago/reporte")
public class ReporteRestController {
	@Autowired
	@Qualifier("reporteServicio")
	private ReporteServiceImpl reporteService;
	
	
	@GetMapping("/guia")
	public ModelAndView devolverGuiaRemision(ModelMap modelMap, ModelAndView modelAndView) {
		List<GuiaRemision> lGuiaRemision = reporteService.listarGuiaRemision();
		
		modelMap.put("datasource", new JRBeanCollectionDataSource(lGuiaRemision));
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_Asignacion", modelMap);
			
		return modelAndView;
	}
}
