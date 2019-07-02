package com.unmsm.fisi.controller.pago.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unmsm.fisi.model.BusquedaParametro;
import com.unmsm.fisi.model.Factura;
import com.unmsm.fisi.model.GuiaRemision;
import com.unmsm.fisi.model.ReporteVentas;
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
	
	@GetMapping(params = "accion=buscarReporteVenta")
	public List<ReporteVentas> buscarReporteVenta(BusquedaParametro oBusquedaParametro){
		return reporteService.listarReporteVenta(oBusquedaParametro);
	}
	
	@GetMapping(params = "accion=reporteVenta")
	public ModelAndView devolverReporteVenta(ModelMap modelMap, ModelAndView modelAndView, BusquedaParametro oBusquedaParametro) {
		Date date = Calendar.getInstance().getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		List<ReporteVentas> lReporteVenta = reporteService.listarReporteVenta(oBusquedaParametro);
		
		double nMontoTotal = 0;
		
		for(ReporteVentas oReporteVenta : lReporteVenta) {
			String []lAuxiliar = oReporteVenta.getsMontoTotal().split(" ");
			nMontoTotal += Double.parseDouble(lAuxiliar[0]);
		}
		nMontoTotal = (double) Math.round(nMontoTotal * 100d) / 100d;
		
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    
		modelMap.put("datasource", new JRBeanCollectionDataSource(lReporteVenta));
		modelMap.put("dataReporte", new JRBeanCollectionDataSource(lReporteVenta));
		modelMap.put("fechaReporte", dateFormat.format(date));
		modelMap.put("personalReporte", userDetail.getUsername());
		modelMap.put("reporteSubTotal", String.valueOf(nMontoTotal));
		
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_ReporteVentas", modelMap);
			
		return modelAndView;
	}
	
}
