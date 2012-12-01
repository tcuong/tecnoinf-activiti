package edu.bedelias.activiti.altaPriodoInscCurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.services.PeriodoInscripcionService;

public class Guardar implements JavaDelegate {

	private Logger logger = Logger.getLogger(Guardar.class);
	private PeriodoInscripcionService periodoInscripcionService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		periodoInscripcionService = (PeriodoInscripcionService) cpx
				.getBean("periodoInscripcionService");

		Date fechaInicio = (Date) execution.getVariable("fechaInicio");
		Date fechaFinComienzoDesistir = (Date) execution
				.getVariable("fechaFinComienzoDesistir");
		Date fechaFin = (Date) execution.getVariable("fechaFin");
		String descripcion = execution.getVariable("descripcion").toString();

		PeriodoInscripcion periodoInscripcion = new PeriodoInscripcion();
		periodoInscripcion.setFechaInicio(fechaInicio);
		periodoInscripcion.setFechaDesist(fechaFinComienzoDesistir);
		periodoInscripcion.setFechaFin(fechaFin);
		// periodoInscripcion

	}

}
