package com.unmsm.fisi.controller.pago.rest;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unmsm.fisi.model.PagoPedido;
import com.unmsm.fisi.service.impl.pago.PagoPedidoServiceImpl;

@RestController
@RequestMapping("/pago/pedidoPedido")
public class PagoPedidoRestController {
	@Autowired
	@Qualifier("pagoPedidoServicio")
	private PagoPedidoServiceImpl pagoPedidoService;
	
	@GetMapping(params = "accion=buscarTodos")
	public List<PagoPedido> listarTodos(){
		return pagoPedidoService.listarPagoPedido();
	}
	
	@GetMapping("/{nidPago}")
	public PagoPedido buscarPagoPedido(@PathVariable String nidPago) {
		return pagoPedidoService.buscarPagoPedido(Integer.parseInt(nidPago));
	}
	
	@PostMapping
    public ResponseEntity<?> registrarPagoPedido(@RequestBody PagoPedido oPagoPedido){
		
		System.out.println("Fecha Controller: " + oPagoPedido.getdFecha().toString());
		
		Integer nidPago = pagoPedidoService.registrarPagoPedido(oPagoPedido);
		
		return ResponseEntity.ok(pagoPedidoService.buscarPagoPedido(nidPago));
	}
	
	@PostMapping(value = "/bVoucher/", params = "accion=cargar")
    public void cargarVoucher(@RequestParam("bVoucher") MultipartFile file) {
		try {			
			if(file.getBytes().length!=0) {
				PagoPedido oPagoPedido = pagoPedidoService.listarPagoPedido().get(pagoPedidoService.listarPagoPedido().size()-1);
				oPagoPedido.setbVoucher(file.getBytes());
				
				pagoPedidoService.actualizarPagoPedido(oPagoPedido);
			}
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping
    public ResponseEntity<?> actualizarPagoPedido(@RequestBody PagoPedido oPagoPedido){
		Integer nidPago = pagoPedidoService.actualizarPagoPedido(oPagoPedido);
		
		return ResponseEntity.ok(pagoPedidoService.buscarPagoPedido(nidPago));
	}
	
	@GetMapping("/voucher/{nIdPago}")
    public PagoPedido recuperarVoucher(@PathVariable Integer nIdPago)
    {
		PagoPedido oPagoPedido = pagoPedidoService.buscarPagoPedido(nIdPago);
		
		String base64Encoded = DatatypeConverter.printBase64Binary(oPagoPedido.getbVoucher());
        byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
		
        oPagoPedido.setbVoucher(base64Decoded);		
        
        return oPagoPedido;
    }
	
}
