package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.repositories.PeriodoInscripcionRepository;
import edu.bedelias.services.PeriodoInscripcionService;

@Service
@Transactional(readOnly = true)
public class PeriodoInscripcionServiceImpl implements PeriodoInscripcionService {

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