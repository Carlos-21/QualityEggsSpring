package com.unmsm.fisi.utilitario;

import java.util.List;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.model.PedidoTrabajador;

public class HiloCorreo extends Thread{
	private final EnviarCorreoUtil enviar = new EnviarCorreoUtil();
	private PedidoTrabajador oPedidoTrabajador;
	private Oferta oOferta;
	private List<Cliente> lCliente;
	private boolean vBandera;
	
	public HiloCorreo(PedidoTrabajador oPedidoTrabajador, Oferta oOferta, List<Cliente> lCliente, boolean vBandera) {
		this.oPedidoTrabajador = oPedidoTrabajador;
		this.oOferta = oOferta;
		this.lCliente = lCliente;
		this.vBandera = vBandera;
	}
	
	public void run(){
		if(oPedidoTrabajador != null) {
			enviar.mensajePedidoProveedor(oPedidoTrabajador);
		}
		else {
			for(Cliente oCliente : lCliente) {
				enviar.mensajeOferta(oOferta, oCliente,vBandera);
			}
		}
	}
	
}
