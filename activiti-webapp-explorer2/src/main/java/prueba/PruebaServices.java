package prueba;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;
import edu.bedelias.services.TestServiceDummy;

public class PruebaServices implements IPruebaServices, JavaDelegate {

	@Autowired
	private TestServiceDummy testService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Autowired
	private StudentService studentService;

	@Override
	public void unMetodo() {
		if (testService == null) {
			System.out.println("FAIL ----------------------------------------");
		} else {
			testService.run();
		}
	}

	public TestServiceDummy getTestService() {
		return testService;
	}

	public void setTestService(TestServiceDummy testService) {
		this.testService = testService;
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Student student = testService.create(new Student("Mario",
				"unCorreo@mail.net", "Cedula", new Date(System
						.currentTimeMillis())));

		System.out
				.println("========================================================================");
		System.out.println(student.getCedula());
		this.unMetodo();
	}

}
