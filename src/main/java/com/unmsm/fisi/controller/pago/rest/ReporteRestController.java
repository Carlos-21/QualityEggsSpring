package com.unmsm.fisi.controller.pago.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unmsm.fisi.model.BusquedaParametro;
import com.unmsm.fisi.model.Factura;
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
	
	@GetMapping(params = "accion=buscarGuiaRemision")
	public List<GuiaRemision> buscarGuiaRemision(BusquedaParametro oBusquedaParametro){
		return reporteService.listarGuiaRemision(oBusquedaParametro);
	}
			
	@GetMapping(params = "accion=guia")
	public ModelAndView devolverGuiaRemision(ModelMap modelMap, ModelAndView modelAndView, BusquedaParametro oBusquedaParametro) {
		List<GuiaRemision> lGuiaRemision = reporteService.listarGuiaRemision(oBusquedaParametro);
		
		modelMap.put("datasource", new JRBeanCollectionDataSource(lGuiaRemision));
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_GuiaRemision", modelMap);
			
		return modelAndView;
	}
	
	@GetMapping(params = "accion=buscarFactura")
	public List<Factura> buscarFactura(BusquedaParametro oBusquedaParametro){
		return reporteService.listarFactura(oBusquedaParametro);
	}
	
	@GetMapping(params = "accion=factura")
	public ModelAndView devolverFactura(ModelMap modelMap, ModelAndView modelAndView, BusquedaParametro oBusquedaParametro) {
		//fasf
		List<Factura> lFactura = reporteService.listarFactura(oBusquedaParametro);
		
		modelMap.put("datasource", new JRBeanCollectionDataSource(lFactura));
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_Factura", modelMap);
			
		return modelAndView;
	}
	
}
