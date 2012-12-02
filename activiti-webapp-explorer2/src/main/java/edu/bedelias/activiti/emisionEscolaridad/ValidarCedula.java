package edu.bedelias.activiti.emisionEscolaridad;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.StudentService;

public class ValidarCedula implements JavaDelegate {

	private StudentService studentService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		studentService = (StudentService) cpx.getBean("studentService");

		String cedula = execution.getVariable("cedula").toString();
		boolean existeEst = studentService.existeStudentByCedula(cedula);
		execution.setVariable("existeEst", existeEst);

	}

}
