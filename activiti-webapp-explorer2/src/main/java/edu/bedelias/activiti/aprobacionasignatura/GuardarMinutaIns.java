package edu.bedelias.activiti.aprobacionasignatura;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Minuta;
import edu.bedelias.services.MinutaService;

public class GuardarMinutaIns implements JavaDelegate {

	private MinutaService minutaService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		minutaService = (MinutaService) cpx.getBean("minutaService");

		String resolucion = execution.getVariable("resolucion").toString();
		String nombreFuncionario = execution.getVariable("nombreFuncionario")
				.toString();
		String nombreEntidad = execution.getVariable("nombreEntidad")
				.toString();

		String aprob = execution.getVariable("aprobado").toString();
		boolean aprobado = false;
		if (aprob.equals("1")) {
			aprobado = true;
		}

		Minuta minuta = new Minuta();
		minuta.setResolucion(resolucion);
		minuta.setNombreFuncionario(nombreFuncionario);
		minuta.setNombreEntidad(nombreEntidad);
		minuta.setAprobado(aprobado);

		String solicitud = execution.getVariable("solicitud").toString();
		Long solicitudId = Long.valueOf(solicitud);

		minutaService.createMinuta(minuta, solicitudId);
	}

	public MinutaService getMinutaService() {
		return minutaService;
	}

	public void setMinutaService(MinutaService minutaService) {
		this.minutaService = minutaService;
	}

}
