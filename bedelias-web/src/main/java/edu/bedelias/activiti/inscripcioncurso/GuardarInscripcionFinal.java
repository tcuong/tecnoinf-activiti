package edu.bedelias.activiti.inscripcioncurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;

public class GuardarInscripcionFinal implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo los datos
		Student student = (Student) execution.getVariable("student");
		Curso curso = (Curso) execution.getVariable("curso");
		
		
		// obtengo la inscripcion
		Inscripcion inscripcion = inscripcionService.getInscripcionByStudentYCurso(student, curso);
		
		// la seteo como válida
		inscripcion.setIsValid(true);
		
		// la guardo
		inscripcionService.updateInscripcion(inscripcion);
	}
}
