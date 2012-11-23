package edu.bedelias.activiti.inscribirestudiantecarrera;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.services.StudentService;

public class ExisteCedula implements JavaDelegate {

	// @Autowired
	// private StudentService studentService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// String cedula = execution.getVariable("cedula").toString();
		// boolean existeEst = studentService.existeStudentByCedula(cedula);
		// execution.setVariable("existeEst", existeEst);

	}

	// Getters && Setters

	// public StudentService getStudentService() {
	// return studentService;
	// }

	// public void setStudentService(StudentService studentService) {
	// this.studentService = studentService;
	// }

}
