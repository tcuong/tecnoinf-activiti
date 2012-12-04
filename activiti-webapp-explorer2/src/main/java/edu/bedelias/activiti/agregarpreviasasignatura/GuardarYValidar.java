package edu.bedelias.activiti.agregarpreviasasignatura;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.AsignaturaService;

public class GuardarYValidar implements JavaDelegate {

	
	private ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private AsignaturaService asignaturaService = (AsignaturaService) cpx.getBean("asignaturaService");

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		try {
			
			// si viene el id de la asignatura vacio mando mensaje de error y termino
			
			// si no viene ningun id de previa mando mensaje de error y termino
			
			//me traigo la asignaturas y las previas seleccionadas
			
			// recorro todas y las asigno como previas
		
			execution.setVariable("mensaje", "Las previas se han asignado con exito.");
		} catch (Exception e) {
			execution.setVariable("mensaje", "Se ha generado un error. " + e.getMessage());
		}
	}
}
