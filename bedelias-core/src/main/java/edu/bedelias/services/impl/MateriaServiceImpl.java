package edu.bedelias.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Materia;
import edu.bedelias.repositories.MateriaRepository;
import edu.bedelias.services.MateriaService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class MateriaServiceImpl implements MateriaService, Serializable {

	private static final long serialVersionUID = 1L;
	
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

	@Override
	@Transactional
	public Materia agregarAsignaturaMateria(Materia materia,
			Asignatura asignatura) {
		List<Asignatura> asignaturas = materiaRepo
				.getAsignaturasByMateriaId(materia.getId());
		if (asignaturas == null) {
			asignaturas = new ArrayList<Asignatura>();
		}
		asignaturas.add(asignatura);
		materia.setAsignaturas(asignaturas);
		materia = materiaRepo.save(materia);
		return materia;
	}

	@Override
	public List<Asignatura> getAsignaturasByMateriaId(Long id) {
		return materiaRepo.getAsignaturasByMateriaId(id);
	}

	// Getters && Setters

	public MateriaRepository getMateriaRepo() {
		return materiaRepo;
	}

	public void setMateriaRepo(MateriaRepository materiaRepo) {
		this.materiaRepo = materiaRepo;
	}

	@Override
	public Boolean existeMateria(String nombre) {
		Materia materia = materiaRepo.findMateriaByName(nombre);
		if (materia != null) {
			return true;
		}
		return false;
	}

}
