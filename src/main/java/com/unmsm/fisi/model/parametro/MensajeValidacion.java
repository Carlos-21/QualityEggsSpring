package com.unmsm.fisi.model.parametro;

import lombok.Value;

@Value
public class MensajeValidacion
{
	private String campoError;
    private String mensajeError;
    
    public MensajeValidacion(String campoError, String mensajeError) {
		this.campoError = campoError;
    	this.mensajeError = mensajeError;
	}

}