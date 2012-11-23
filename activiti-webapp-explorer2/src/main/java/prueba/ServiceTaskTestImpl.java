package prueba;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.bedelias.services.TestServiceDummy;

@Component
public class ServiceTaskTestImpl implements ServiceTaskTest, JavaDelegate {

	@Autowired
	private TestServiceDummy testServiceDummyImpl;

	@Override
	public void prueba() {
		Logger logger = Logger.getLogger(ServiceTaskTestImpl.class);
		logger.info("+++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Adentro de la Java Delagate");
		logger.info("+++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		this.prueba();
		testServiceDummyImpl.pruebaService();
		// Student student = new Student("Julio", "email@internet.com",
		// "cedula",
		// new Date(System.currentTimeMillis()));
		// testServiceDummyImpl.create(student);

	}

	public TestServiceDummy getTestServiceDummyImpl() {
		return testServiceDummyImpl;
	}

	public void setTestServiceDummyImpl(TestServiceDummy testServiceDummyImpl) {
		this.testServiceDummyImpl = testServiceDummyImpl;
	}

}
