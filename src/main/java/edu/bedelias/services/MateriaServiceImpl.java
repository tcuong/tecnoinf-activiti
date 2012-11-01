package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Materia;
import edu.bedelias.repositories.MateriaRepository;

@Service
@Transactional(readOnly = true)
public class MateriaServiceImpl implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepo;

	@Override
	@Transactional
	public Materia createMateria(Materia materia) {
		if (materia != null) {
			materia = materiaRepo.save(materia);
		}
		return materia;
	}

	@Override
	@Transactional
	public void updateMateria(Materia materia) {
		if (materia != null) {
			materiaRepo.save(materia);
		}
	}

	@Override
	@Transactional
	public void deleteMateria(Materia materia) {
		if (materia != null) {
			materiaRepo.delete(materia);
		}
	}

	// Getters && Setters

	public MateriaRepository getMateriaRepo() {
		return materiaRepo;
	}

	public void setMateriaRepo(MateriaRepository materiaRepo) {
		this.materiaRepo = materiaRepo;
	}

}
