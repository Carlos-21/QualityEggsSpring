package com.unmsm.fisi.service.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unmsm.fisi.entity.ManPersonaId;
import com.unmsm.fisi.model.Persona;
import com.unmsm.fisi.model.PersonaId;
import com.unmsm.fisi.repository.PersonaRepository;
import com.unmsm.fisi.service.PersonaService;
import com.unmsm.fisi.service.transform.PersonaTransform;

@Service("personaServicio")
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	@Qualifier("personaRepositorio")
	private PersonaRepository personaRepository;
	@Autowired
	@Qualifier("personaConvertidor")
	private PersonaTransform personaTrasnform;

	@Override
	public List<Persona> listarPersonas() {
		System.out.println("Entro");
		System.out.println("Cantidad : " + personaRepository.findAll().size());
		return personaTrasnform.transformEM(personaRepository.findAll());
	}

	@Override
	public Persona buscarPersona(String sTipoDocumento, String sNumeroDocumento) {
		ManPersonaId oEPersonaId = new ManPersonaId();
		oEPersonaId.setVtipoDocumento(sTipoDocumento);
		oEPersonaId.setVnumeroDocumento(sNumeroDocumento);

		return personaTrasnform.transformEM(personaRepository.findOne(oEPersonaId));
	}

	@Override
	public PersonaId registrarPersona(Persona oPersona) {
		personaRepository.save(personaTrasnform.transformME(oPersona));

		PersonaId oMPersonaId = new PersonaId();
		oMPersonaId.setsTipoDocumento(oPersona.getsTipoDocumento());
		oMPersonaId.setsNumeroDocumento(oPersona.getsNumeroDocumento());

		return oMPersonaId;
	}

	@Override
	public PersonaId actualizarPersona(Persona oPersona) {
		personaRepository.save(personaTrasnform.transformME(oPersona));

		PersonaId oMPersonaId = new PersonaId();
		oMPersonaId.setsTipoDocumento(oPersona.getsTipoDocumento());
		oMPersonaId.setsNumeroDocumento(oPersona.getsNumeroDocumento());

		return oMPersonaId;
	}

	@Override
	public void eliminarPersona(String sTipoDocumento, String sNumeroDocumento) {
		ManPersonaId oEPersonaId = new ManPersonaId();
		oEPersonaId.setVtipoDocumento(sTipoDocumento);
		oEPersonaId.setVnumeroDocumento(sNumeroDocumento);
		
		personaRepository.delete(oEPersonaId);
	}

}
