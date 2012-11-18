package prueba;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bedelias.entities.Student;
import edu.bedelias.services.TestServiceDummy;

@Service(value = "pruebaService")
public class PruebaServices implements JavaDelegate {

	@Autowired
	private TestServiceDummy testService;

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
	}

}
