package edu.bedelias.activiti.emisionEscolaridad;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

		inscripcionService = (InscripcionService) cpx
				.getBean("inscripcionService");
		studentService = (StudentService) cpx.getBean("studentService");

		Student student = studentService.inscripcionService
				.getCarrerasByStudent(student);

	}

}
