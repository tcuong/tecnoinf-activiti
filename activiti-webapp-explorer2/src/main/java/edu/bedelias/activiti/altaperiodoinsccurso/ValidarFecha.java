package edu.bedelias.activiti.altaperiodoinsccurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ValidarFecha implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		boolean valido = false;

		Date fechaInicio = (Date) execution.getVariable("fechaInicio");

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
