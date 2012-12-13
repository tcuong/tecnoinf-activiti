package edu.bedelias.activiti.inscripcioncurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;

public class GuardarDesistimiento implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextWeb.xml");
	private InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo los datos
		Student student = (Student) execution.getVariable("student");
		Curso curso = (Curso) execution.getVariable("curso");

		// consulto si hay algun desistimiento para el estudiante y curso pasado
		Inscripcion desistimiento = inscripcionService.getInscripcionByStudentYCurso(student, curso);
		
		if(desistimiento != null){
			// el estudiante no desistio
			
			// seteo las variables para el registro final de la inscripcion
			execution.setVariable("desistio", false);
			
		} else {
			// el estudiante desistio del curso
			
			// agrego las variables para el envio del email con la confirmación del desistimiento
			execution.setVariable("para", "brunovierag@gmail.com");
			execution.setVariable("asunto", "Confirmación de Inscripción");
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", de parte de bedelías confirmamos el desistimiento al Curso " + curso.getName());
		}
		
		
		
		 
	}
}
