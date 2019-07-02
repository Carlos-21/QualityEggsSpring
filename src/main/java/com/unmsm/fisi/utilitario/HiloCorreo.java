package com.unmsm.fisi.utilitario;

import java.util.List;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.model.PagoPedido;
import com.unmsm.fisi.model.PedidoTrabajador;

public class HiloCorreo extends Thread{
	private final EnviarCorreoUtil enviar = new EnviarCorreoUtil();
	private PedidoTrabajador oPedidoTrabajador;
	private PagoPedido oPagoPedido;
	private String sDestinatario;
	private Oferta oOferta;
	private List<Cliente> lCliente;
	private boolean vBandera;
	
	public HiloCorreo(PedidoTrabajador oPedidoTrabajador) {
		this.oPedidoTrabajador = oPedidoTrabajador;
	}
	
	public HiloCorreo(Oferta oOferta, List<Cliente> lCliente, boolean vBandera) {
		this.oOferta = oOferta;
		this.lCliente = lCliente;
		this.vBandera = vBandera;
	}
	
	public HiloCorreo(PagoPedido oPagoPedido, String sDestinatario, boolean vBandera) {
		this.oPagoPedido = oPagoPedido;
		this.sDestinatario = sDestinatario;
		this.vBandera = vBandera;
	}
	
	public void run(){
		if(oPedidoTrabajador != null) {
			enviar.mensajePedidoProveedor(oPedidoTrabajador);
		}
		
		if(oPagoPedido != null) {
			enviar.mensajePago(oPagoPedido, sDestinatario, vBandera);
		}
		
		if(oOferta!=null && lCliente!=null) {
			if(!lCliente.isEmpty()) {
				for(Cliente oCliente : lCliente) {
					enviar.mensajeOferta(oOferta, oCliente,vBandera);
				}
			}
		}
	}
	
}
