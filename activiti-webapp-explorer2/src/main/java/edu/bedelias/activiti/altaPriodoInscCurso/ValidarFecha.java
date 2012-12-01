package edu.bedelias.activiti.altaPriodoInscCurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.log4j.Logger;

public class ValidarFecha implements JavaDelegate {

	private Logger logger = Logger.getLogger(Guardar.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
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
	}

}
