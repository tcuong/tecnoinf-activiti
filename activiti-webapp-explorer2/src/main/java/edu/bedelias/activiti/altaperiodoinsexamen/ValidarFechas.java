package edu.bedelias.activiti.altaperiodoinsexamen;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ValidarFechas implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		boolean valido = false;

		Date fechaInicio = (Date) execution.getVariable("fechaInicio");

		Date fechaFin = (Date) execution.getVariable("fechaFin");

		if (fechaInicio.before(fechaFin)) {
			valido = true;
		}

		execution.setVariable("valido", valido);
	}

}
