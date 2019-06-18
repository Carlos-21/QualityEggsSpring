package com.unmsm.fisi.utilitario;

import com.unmsm.fisi.model.PedidoTrabajador;

public class HiloCorreo extends Thread{
	private final EnviarCorreoUtil enviar = new EnviarCorreoUtil();
	private PedidoTrabajador oPedidoTrabajador;
	
	public HiloCorreo(PedidoTrabajador oPedidoTrabajador) {
		this.oPedidoTrabajador = oPedidoTrabajador;
	}
	
	public void run(){
		enviar.mensajePedidoProveedor(oPedidoTrabajador);
	}
	
}
