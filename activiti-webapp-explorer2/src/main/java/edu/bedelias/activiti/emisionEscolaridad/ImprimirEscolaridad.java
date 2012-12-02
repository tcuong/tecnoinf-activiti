package edu.bedelias.activiti.emisionEscolaridad;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

public class ImprimirEscolaridad implements JavaDelegate {

	private InscripcionService inscripcionService;
	private StudentService studentService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");

		String cedula = execution.getVariable("cedula").toString();

		inscripcionService = (InscripcionService) cpx
				.getBean("inscripcionService");
		studentService = (StudentService) cpx.getBean("studentService");

		Student student = studentService.findStudentByCedula(cedula);
		List<Inscripcion> inscripciones = inscripcionService
				.getInscripcionesByStudent(student);
		List<Curso> cursos = new ArrayList<Curso>();

		for (Inscripcion i : inscripciones) {
			cursos.add(i.getCurso());
		}
		// me falta aca ir a buscar la evaluicion por cada curso y
		// traerme la nota

	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
