package edu.bedelias.activiti.aprobacionasignatura;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.SolicitudAsignatura;
import edu.bedelias.services.SolicitudAsignaturaService;

public class GuardarSolicitud implements JavaDelegate {

	private SolicitudAsignaturaService solicitudAsignaturaService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		solicitudAsignaturaService = (SolicitudAsignaturaService) cpx
				.getBean("solicitudAsignaturaService");

		String nombreDocente = execution.getVariable("nombreDocente")
				.toString();
		String cedulaDocente = execution.getVariable("cedulaDocente")
				.toString();
		String nombreAsignatura = execution.getVariable("nombreAsignatura")
				.toString();
		String propuesta = execution.getVariable("propuesta").toString();
		String materia = execution.getVariable("materia").toString();

		Long materiaId = Long.valueOf(materia);

		SolicitudAsignatura solicitudAsignatura = new SolicitudAsignatura();
		solicitudAsignatura.setNombreDocente(nombreDocente);
		solicitudAsignatura.setCedulaDocente(cedulaDocente);
		solicitudAsignatura.setNombreAsignatura(nombreAsignatura);
		solicitudAsignatura.setPropuesta(propuesta);

		solicitudAsignaturaService.createSolicitud(solicitudAsignatura,
				materiaId);

	}

	public SolicitudAsignaturaService getSolicitudAsignaturaService() {
		return solicitudAsignaturaService;
	}

	public void setSolicitudAsignaturaService(
			SolicitudAsignaturaService solicitudAsignaturaService) {
		this.solicitudAsignaturaService = solicitudAsignaturaService;
	}

}
