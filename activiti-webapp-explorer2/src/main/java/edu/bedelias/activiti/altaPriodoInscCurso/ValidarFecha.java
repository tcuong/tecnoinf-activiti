package edu.bedelias.activiti.altaPriodoInscCurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;

public class ValidarFecha implements JavaDelegate {

	private Logger logger = Logger.getLogger(Guardar.class);

	private CarreerService carreerService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		carreerService = (CarreerService) cpx.getBean("carreerService");

		boolean valido = false;
		logger.info("000000000000000000000000000000000");
		logger.info("000000000000000000000000000000000");
		logger.info("000000000000000000000000000000000");

		Date fechaInicio = (Date) execution.getVariable("fechaInicio");
		logger.info("FECHA " + fechaInicio);

		Date fechaFinComienzoDesistir = (Date) execution
				.getVariable("fechaFinComienzoDesistir");
		Date fechaFin = (Date) execution.getVariable("fechaFin");

		if (fechaInicio.before(fechaFinComienzoDesistir)
				&& fechaFinComienzoDesistir.before(fechaFin)) {
			valido = true;
		}
		execution.setVariable("validar", valido);

		Carreer carreer = carreerService.findCarreer(new Long(1));
		logger.info("000000000000000000000000000000000 " + carreer.getName());

	}

	public CarreerService getCarreerService() {
		return carreerService;
	}

	public void setCarreerService(CarreerService carreerService) {
		this.carreerService = carreerService;
	}

}
