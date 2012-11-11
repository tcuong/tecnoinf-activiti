package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Inscripcion;
import edu.bedelias.repositories.InscripcionRepository;

@Service
@Transactional(readOnly = true)
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepo;
	
	@Override
	public Inscripcion createInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
		return inscripcion;

	}

	@Override
	public void updateInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
	}

	@Override
	public void deleteInscripcion(Inscripcion inscripcion) {
		inscripcionRepo.delete(inscripcion);

	}
	
	// Getters && Setters
	
	public InscripcionRepository getInscripcionRepo() {
		return inscripcionRepo;
	}

	public void setInscripcionRepo(InscripcionRepository inscripcionRepo) {
		this.inscripcionRepo = inscripcionRepo;
	}
	
}
