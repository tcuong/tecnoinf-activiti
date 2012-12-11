package edu.bedelias.activiti.inscripcioncurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;

public class GuardarInscripcionCondicional implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private StudentService studentService = (StudentService) cpx.getBean("studentService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo los datos
		Student student = (Student) execution.getVariable("student");
		Curso curso = (Curso) execution.getVariable("curso");
		PeriodoInscripcion periodo = (PeriodoInscripcion) execution.getVariable("periodo");
		
		System.out.println("LAlalalalala");
		
		// creo la inscripcion
		
		
		// la guardo
		
		
		// seteo las variables para el temporizador
		
		
		


		 String cedula = execution.getVariable("cedula").toString();
		 boolean existeEst = studentService.existeStudentByCedula(cedula);
		 execution.setVariable("existeEst", existeEst);

	}

	// Getters && Setters

	 public StudentService getStudentService() {
		 return studentService;
	 }

	 public void setstudentservice(StudentService studentservice) {
		 this.studentService  = studentservice;
	 }

}
