package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.repositories.PeriodoInscripcionRepository;

@Service
@Transactional(readOnly = true)
public class PeriodoInscripcionImpl implements PeriodoInscripcionService {

	@Autowired
	private PeriodoInscripcionRepository periodoInscripcionRepo;
	
	@Override
	@Transactional
	public PeriodoInscripcion createPeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
		if (periodoInscripcion != null) {
			periodoInscripcion = periodoInscripcionRepo.save(periodoInscripcion);
		}
		return periodoInscripcion;
	}

	@Override
	@Transactional
	public void updatePeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
		if (periodoInscripcion != null) {
			periodoInscripcion = periodoInscripcionRepo.save(periodoInscripcion);
		}
	}

	@Override
	@Transactional
	public void deletePeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
		periodoInscripcionRepo.delete(periodoInscripcion);

	}

	// Getters && Setters
	public PeriodoInscripcionRepository getPeriodoInscripcionRepo() {
		return periodoInscripcionRepo;
	}

	public void setPeriodoInscripcionRepo(
			PeriodoInscripcionRepository periodoInscripcionRepo) {
		this.periodoInscripcionRepo = periodoInscripcionRepo;
	}
	
}
