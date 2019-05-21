package com.unmsm.fisi.validacion.grupo.secuencia;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.unmsm.fisi.validacion.grupo.ILlave;
import com.unmsm.fisi.validacion.grupo.accion.IActualizacion;


@GroupSequence({ Default.class, ILlave.class, IActualizacion.class })
public interface ISecuenciaValidacionActualizacion
{

}