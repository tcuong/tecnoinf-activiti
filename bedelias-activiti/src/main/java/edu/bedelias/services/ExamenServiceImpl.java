package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Examen;
import edu.bedelias.repositories.ExamenRepository;

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

}
