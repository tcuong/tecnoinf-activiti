package edu.bedelias.activiti.generaractaexamen;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.ExamenService;

public class GenerarActaExamen implements JavaDelegate {

	private ExamenService examenService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		examenService = (ExamenService) cpx.getBean("examenService");

		String codigoExamen = execution.getVariable("codigoExamen").toString();
		try {
			examenService.generarActa(codigoExamen);
			execution
					.setVariable("msj", "El archivo fue genrado correctamente");

		} catch (Exception e) {
			execution.setVariable("msj",
					"Se ha producido un error, intente luego");
			e.getLocalizedMessage();
		}

	}

}
