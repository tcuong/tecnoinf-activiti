package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.repositories.AsignaturaRepository;
import edu.bedelias.services.AsignaturaService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	private AsignaturaRepository asignaturaRepo;
	
	@Override
	@Transactional
	public Asignatura createAsignatura(Asignatura asignatura) {
		if (asignatura != null) {
			asignatura = asignaturaRepo.save(asignatura);
		}
		return asignatura;
	}

	@Override
	@Transactional
	public void updateAsignatura(Asignatura asignatura) {
		if (asignatura != null) {
			asignatura = asignaturaRepo.save(asignatura);
		}
	}

	@Override
	@Transactional
	public void deleteAsignatura(Asignatura asignatura) {
		asignaturaRepo.delete(asignatura);

	}

	// Getters && Setters
	
	public AsignaturaRepository getAsignaturaRepo() {
		return asignaturaRepo;
	}

	public void setAsignaturaRepo(AsignaturaRepository asignaturaRepo) {
		this.asignaturaRepo = asignaturaRepo;
	}

}
