package edu.bedelias.activiti.inscribirestudiantecarrera;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.bedelias.services.StudentService;
import edu.bedelias.services.StudentServiceImpl;

public class ExisteCedula implements JavaDelegate {

	private StudentService studentService = new StudentServiceImpl();

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String cedula = execution.getVariable("cedula").toString();
		boolean existeEst = studentService.existeStudentByCedula(cedula);
		execution.setVariable("existeEst", existeEst);

	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
