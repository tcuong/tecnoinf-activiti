package edu.bedelias.activiti.inscribirestudiantecarrera;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.StudentService;

public class ExisteCedula implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private StudentService studentService = (StudentService) cpx.getBean("studentService");
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

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
