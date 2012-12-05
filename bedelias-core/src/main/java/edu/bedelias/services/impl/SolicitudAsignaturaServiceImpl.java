package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Materia;
import edu.bedelias.entities.SolicitudAsignatura;
import edu.bedelias.repositories.SolicitudAsignaturaRepository;
import edu.bedelias.services.SolicitudAsignaturaService;

@Service(value = "solicitudAsignaturaServiceImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class SolicitudAsignaturaServiceImpl implements
		SolicitudAsignaturaService {

	@Autowired
	private SolicitudAsignaturaRepository solAsigRepo;

	@Override
	@Transactional
	public SolicitudAsignatura createSolicitud(
			SolicitudAsignatura solicitudAsignatura, Materia materia) {
		solicitudAsignatura.setMateria(materia);
		return solAsigRepo.save(solicitudAsignatura);
	}

	public SolicitudAsignaturaRepository getSolAsigRepo() {
		return solAsigRepo;
	}

	public void setSolAsigRepo(SolicitudAsignaturaRepository solAsigRepo) {
		this.solAsigRepo = solAsigRepo;
	}

}
