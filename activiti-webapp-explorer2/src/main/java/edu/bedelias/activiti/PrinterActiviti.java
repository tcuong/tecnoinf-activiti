package edu.bedelias.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;

public class PrinterActiviti {

	private Curso curso;
	private Student student;
	private boolean aprobada;

	public void guardarValidacionManual(DelegateExecution execution) {

		// estas variables siempre van a ir por que son para el envio del email
		execution.setVariable("para", "brunovierag@gmail.com");
		execution.setVariable("asunto", "Confirmación de Inscripción");
		student = (Student) execution.getVariable("student");
		curso = (Curso) execution.getVariable("curso");

		// obtengo el valor ingresado por el funcionario de bedelias para la
		// inscripción
		aprobada = (boolean) execution.getVariable("aprobada");

		if (aprobada) {
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", su inscripción al curso " + curso.getName() + "a sido aprobada.");
		} else {
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", su inscripción al curso " + curso.getName() + "ha sido REPROBADA en la validación de privas.");
		}
	}

	public void guardarInscripcionFinal(DelegateExecution execution) {
		
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
		InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");

		// obtengo la inscripcion
		Inscripcion inscripcion = inscripcionService.getInscripcionByStudentYCurso(student, curso);

		// dependiendo el estado de la solicitud la guardo como valida o no
		if (aprobada) {
			// la seteo como válida
			inscripcion.setIsValid(true);
		} else {
			// la seteo como NO válida
			inscripcion.setIsValid(false);
		}

		// la guardo
		inscripcionService.updateInscripcion(inscripcion);

	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}
}
