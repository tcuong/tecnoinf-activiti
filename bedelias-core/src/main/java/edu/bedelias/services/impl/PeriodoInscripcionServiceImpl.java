package edu.bedelias.services.impl;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.repositories.PeriodoInscripcionRepository;
import edu.bedelias.services.PeriodoInscripcionService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class PeriodoInscripcionServiceImpl implements PeriodoInscripcionService {

	@Autowired
	private PeriodoInscripcionRepository periodoInscripcionRepo;

	@Override
	@Transactional
	public PeriodoInscripcion createPeriodoInscripcion(
			PeriodoInscripcion periodoInscripcion) {
		if (periodoInscripcion != null) {
			periodoInscripcion = periodoInscripcionRepo
					.save(periodoInscripcion);
		}
		return periodoInscripcion;
	}

	@Override
	@Transactional
	public void updatePeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
		if (periodoInscripcion != null) {
			periodoInscripcion = periodoInscripcionRepo
					.save(periodoInscripcion);
		}
	}

	@Override
	public PeriodoInscripcion getPeriodoActivoByTipo(boolean isActivo, TipoInscripcionEnum tipo) {
		return periodoInscripcionRepo.getPeriodoActivoByTipo(isActivo, tipo);
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

	@Override
	public void test() {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:activiti.cfg.xml");
		ac.getBean(ProcessEngine.class);
		ProcessEngine pe = (ProcessEngine) ac.getBean(ProcessEngine.class);
		pe.getRuntimeService().startProcessInstanceById("GenerarActaDeCurso");

	}

}
