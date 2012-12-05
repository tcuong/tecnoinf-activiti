package edu.bedelias.activiti.generaractaexamen;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.ExamenService;

public class ValidarCodExamen implements JavaDelegate {

	private ExamenService examenService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		examenService = (ExamenService) cpx.getBean("examenService");

		String codigoExamen = execution.getVariable("codigoExamen").toString();
		Boolean existeCodigo = examenService.existeExamenByCodigo(codigoExamen);
		execution.setVariable("existeCodigo", existeCodigo);
	}

}
