package edu.bedelias.activiti.inscripcioncurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;

public class ValidarPrevias implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		Curso curso = (Curso) execution.getVariable("curso");
		Student student = (Student) execution.getVariable("student");
		// estoy en Activiti
		
		// si esta todo ok, ya seteo las variables para el email y para la tarea de guardado final
		
		execution.setVariable("validacion", false);
		execution.setVariable("student", student);
		execution.setVariable("curso", curso);
		execution.setVariable("para", "brunovierag@gmail.com");
		execution.setVariable("asunto", "Confirmación de Inscripción");
		execution.setVariable("cuerpo", "Estimado " + student.getName() + ", de parte de bedelías confirmamos su inscripción al Curso " + curso.getName());
	
				
	}
}
