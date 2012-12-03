package edu.bedelias.activiti.inscribirestudiantecarrera;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.InscripcionService;

public class GuardarInscripcion implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
			"classpath:applicationContextRemote.xml");

	private InscripcionService inscripcionService = (InscripcionService) cpx
			.getBean("inscripcionService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String cedula = (String) execution.getVariable("cedula");
		long idCarrera = Long.valueOf((String)execution.getVariable("carreraId"));
		
		String msj = inscripcionService.createInscripcion_Activiti(idCarrera, cedula);
		
		execution.setVariable("mensaje", msj);
	}

}
