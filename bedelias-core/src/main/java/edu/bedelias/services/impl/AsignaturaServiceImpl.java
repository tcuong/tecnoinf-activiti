package edu.bedelias.services.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	@Transactional
	public Asignatura agregarPreviaAsignatura(Asignatura asignatura,
			Asignatura previa) {
		List<Asignatura> previas = asignatura.getPrevias();// Ir a buscarla al
															// repo
		if (previas == null) {
			previas = new ArrayList<Asignatura>();
		}
		previas.add(previa);
		asignatura.setPrevias(previas);
		return asignaturaRepo.save(asignatura);
	}

	@Override
	public List<Asignatura> getPrevias(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// Getters && Setters

	public AsignaturaRepository getAsignaturaRepo() {
		return asignaturaRepo;
	}

	public void setAsignaturaRepo(AsignaturaRepository asignaturaRepo) {
		this.asignaturaRepo = asignaturaRepo;
	}

	@Override
	public List<Asignatura> findAll() {
//		return this.asignaturaRepo.findAll();
		return null;
	}

}
