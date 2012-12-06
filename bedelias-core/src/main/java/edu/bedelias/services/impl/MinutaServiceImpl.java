package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Minuta;
import edu.bedelias.entities.SolicitudAsignatura;
import edu.bedelias.repositories.MinutaRepository;
import edu.bedelias.repositories.SolicitudAsignaturaRepository;
import edu.bedelias.services.MinutaService;

@Service(value = "minutaServiceImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class MinutaServiceImpl implements MinutaService {

	@Autowired
	private MinutaRepository minutaRepo;

	@Autowired
	private SolicitudAsignaturaRepository solicitudAsignaturaRepository;

	@Override
	@Transactional
	public Minuta createMinuta(Minuta minuta, Long solicitudAsignaturaId) {
		SolicitudAsignatura solicitudAsignatura = solicitudAsignaturaRepository
				.findOne(solicitudAsignaturaId);
		minuta.setSolicitudAsignatura(solicitudAsignatura);
		return minutaRepo.save(minuta);
	}

	public MinutaRepository getMinutaRepo() {
		return minutaRepo;
	}

	public void setMinutaRepo(MinutaRepository minutaRepo) {
		this.minutaRepo = minutaRepo;
	}

	public SolicitudAsignaturaRepository getSolicitudAsignaturaRepository() {
		return solicitudAsignaturaRepository;
	}

	public void setSolicitudAsignaturaRepository(
			SolicitudAsignaturaRepository solicitudAsignaturaRepository) {
		this.solicitudAsignaturaRepository = solicitudAsignaturaRepository;
	}

}
