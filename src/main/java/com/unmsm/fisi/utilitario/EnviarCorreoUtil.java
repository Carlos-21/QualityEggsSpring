package com.unmsm.fisi.utilitario;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.unmsm.fisi.model.Cliente;
import com.unmsm.fisi.model.Oferta;
import com.unmsm.fisi.model.PagoPedido;
import com.unmsm.fisi.model.PedidoTrabajador;

public class EnviarCorreoUtil {
	private final String correo = "fisi.ia.1234@gmail.com";
	private final String clave = "fisi135642";
	private final SimpleDateFormat oFormatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	private String estructuraMensaje;
	static Properties properties = new Properties();

	static {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}

	public int mensajePedidoProveedor(PedidoTrabajador oPedidoTrabajador) {
		estructuraMensaje = "Empresa : Agropecuaria Janic SAC" 
				+ "\nTipo de documento: " + oPedidoTrabajador.getsTipoDocumento() 
				+ "\nNúmero de documento: " + oPedidoTrabajador.getsNumeroDocumento()
				+ "\nTrabajador: " + oPedidoTrabajador.getsApellidoPaterno() + " "
				+ oPedidoTrabajador.getsApellidoMaterno() + ", " + oPedidoTrabajador.getsNombre() 
				+ "\nEstado: " + ((oPedidoTrabajador.getvEstado()) ? "Urgente" : "Normal")
				+ "\nPor parte de la empresa mencionada, necesitamos " + oPedidoTrabajador.getnCantidad() + " jabas de huevo";

		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(correo, clave);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correo));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(oPedidoTrabajador.getsCorreo()));
			message.setSubject("Pedido a proveedor - QualityEggs");
			message.setText(estructuraMensaje);
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("error: " + e);
			return 1;
		}

		System.out.println("Mensaje de registro de Pago Enviado");
		return 0;
	}

	public int mensajeOferta(Oferta oOferta, Cliente oCliente, boolean vBandera) {
		estructuraMensaje = "Empresa : Agropecuaria Janic SAC" 
				+"\nEstimado cliente " + oCliente.getsEmpresa()
				+"\nTenemos una oferta con las siguientes características:"
				+"\nDescripción: " + oOferta.getsDescripcion()
				+"\nDescuento: " + oOferta.getnDescuento() + "%"
				+"\nFecha de Inicio: " + oFormatoFecha.format(oOferta.getdFechaInicio())
				+"\nFecha de Fin: " + oFormatoFecha.format(oOferta.getdFechaFin())
				+"\nLo consideramos un cliente valioso, por eso aproveche nuestra oferta de tiempo limitado.";

		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(correo, clave);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correo));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(oCliente.getsCorreo()));
			if(vBandera) {
				message.setSubject("Oferta de producto - QualityEggs");
			}
			else {
				message.setSubject("Oferta de producto - actualización - QualityEggs");
			}
			
			message.setText(estructuraMensaje);
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("error: " + e);
			return 1;
		}

		System.out.println("Mensaje de registro de Pago Enviado");
		return 0;
	}
	
	public int mensajePago(PagoPedido oPagoPedido, String sDestinario, boolean bBandera) {
		estructuraMensaje = "Estimado cliente " + oPagoPedido.getsEmpresa()
				+"\nHacemos conocimiento que en la fecha " + oFormatoFecha.format(oPagoPedido.getdFecha())
				+"\nse ha registrado el pago con el monto de " + oPagoPedido.getsMonto()
				+"\nque ha realizado mediante la modalidad (" + oPagoPedido.getsTipoPago()+").";

		try {
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(correo, clave);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correo));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sDestinario));
			if(bBandera) {
				message.setSubject("Registro de pago - QualityEggs");
			}
			else {
				message.setSubject("Actualización de pago - actualización - QualityEggs");
			}
			
			message.setText(estructuraMensaje);
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("error: " + e);
			return 1;
		}

		System.out.println("Mensaje de registro de Pago Enviado");
		return 0;
	}
	
}
