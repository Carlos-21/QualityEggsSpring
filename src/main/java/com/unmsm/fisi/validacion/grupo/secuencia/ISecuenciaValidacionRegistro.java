package com.unmsm.fisi.validacion.grupo.secuencia;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.unmsm.fisi.validacion.grupo.ILlave;
import com.unmsm.fisi.validacion.grupo.accion.IRegistro;

@GroupSequence({ Default.class, ILlave.class, IRegistro.class })
public interface ISecuenciaValidacionRegistro
{

}
