package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Examen;
import edu.bedelias.repositories.ExamenRepository;
import edu.bedelias.services.ExamenService;

@Service
@Transactional(readOnly = true)
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepo;
	
	@Override
	@Transactional
	public Examen createExamen(Examen examen) {
		if (examen != null) {
			examen = examenRepo.save(examen);
		}
		return examen;
	}

	@Override
	@Transactional
	public void updateExamen(Examen examen) {
		if (examen != null) {
			examen = examenRepo.save(examen);
		}
	}

	@Override
	@Transactional
	public void deleteExamen(Examen examen) {
		examenRepo.delete(examen);
	}

	// Getters && Setters
	
	public ExamenRepository getExamenRepo() {
		return examenRepo;
	}

	public void setExamenRepo(ExamenRepository examenRepo) {
		this.examenRepo = examenRepo;
	}

}
