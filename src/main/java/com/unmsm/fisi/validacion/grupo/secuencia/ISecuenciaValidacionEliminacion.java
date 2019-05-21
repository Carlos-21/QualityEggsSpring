package com.unmsm.fisi.validacion.grupo.secuencia;

import javax.validation.GroupSequence;

import com.unmsm.fisi.validacion.grupo.ILlave;
import com.unmsm.fisi.validacion.grupo.accion.IActualizacion;

@GroupSequence({ ILlave.class, IActualizacion.class })
public interface ISecuenciaValidacionEliminacion
{

}