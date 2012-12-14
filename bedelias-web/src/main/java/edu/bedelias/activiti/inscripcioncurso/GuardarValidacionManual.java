package edu.bedelias.activiti.inscripcioncurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;

public class GuardarValidacionManual implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo los datos
		Student student = (Student) execution.getVariable("student");
		Curso curso = (Curso) execution.getVariable("curso");

		execution.setVariable("para", "brunovierag@gmail.com");
		execution.setVariable("asunto", "Confirmación de Inscripción");
		execution.setVariable("cuerpo", "Estimado " + student.getName() + ", liru liru liru" + curso.getName());
	}
}
