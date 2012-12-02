package edu.bedelias.activiti.altaPeriodoInsExamen;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.PeriodoInscripcionService;

public class Guardar implements JavaDelegate {

	private PeriodoInscripcionService periodoInscripcionService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		periodoInscripcionService = (PeriodoInscripcionService) cpx
				.getBean("periodoInscripcionService");

		Date fechaInicio = (Date) execution.getVariable("fechaInicio");
		Date fechaFin = (Date) execution.getVariable("fechaFin");
		String descripcion = execution.getVariable("descripcion").toString();

		PeriodoInscripcion periodoInscripcion = new PeriodoInscripcion();
		periodoInscripcion.setFechaInicio(fechaInicio);
		periodoInscripcion.setFechaFin(fechaFin);
		periodoInscripcion.setDescripcion(descripcion);
		periodoInscripcion.setTipoInscripcion(TipoInscripcionEnum.EXAMEN);

		Date today = new Date(System.currentTimeMillis());
		if (fechaInicio.before(today) && today.before(fechaFin)) {
			periodoInscripcion.setIsHabilitado(true);
		}

		periodoInscripcionService.createPeriodoInscripcion(periodoInscripcion);
	}

}
