package com.unmsm.fisi.validacion.grupo.secuencia;

import javax.validation.GroupSequence;

import com.unmsm.fisi.validacion.grupo.IMetodo;
import com.unmsm.fisi.validacion.grupo.IParametro;

@GroupSequence({ IParametro.class, IMetodo.class })
public interface ISecuenciaValidacionController
{

}
