package com.unmsm.fisi.service.exception;

public class ListaVaciaException extends SimpException
{
    private static final long serialVersionUID = 1L;

    public ListaVaciaException(String mensaje)
    {
        super(mensaje);
    }
}