package edu.bedelias.activiti.agregarpreviasasignatura;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.services.AsignaturaService;

public class GuardarYValidar implements JavaDelegate {

	
	private ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private AsignaturaService asignaturaService = (AsignaturaService) cpx.getBean("asignaturaService");

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		try {
			
			// obtengo las variables desde la tarea
			String asignaturaId = (String) execution.getVariable("asignatura");
			String previas = (String) execution.getVariable("previas");
			String[] idPrevias = previas.split("\\|");
			
			// si viene el id de la asignatura vacio mando mensaje de error y termino
			if(!asignaturaId.isEmpty()){
				
				// si no viene ninguna previa mando mensaje de error y termino
				if(!previas.isEmpty()){
					
					//me traigo la asignaturas seleccionadas
					Asignatura asignatura = asignaturaService.findAsignatura(Long.valueOf(asignaturaId));
					
					// me traigo las previas seleccionadas
					List<Asignatura> asignaturas = new ArrayList<>();
					for (String id : idPrevias) {
						asignaturas.add(asignaturaService.findAsignatura(Long.valueOf(id)));
					}
					
					// recorro todas y las asigno como previas
					for (Asignatura previa : asignaturas) {
						asignaturaService.agregarPreviaAsignatura(asignatura, previa);
					}
					
					execution.setVariable("mensaje", "Las previas se han asignado con exito.");
					
				}else {
					execution.setVariable("mensaje", "Debe seleccionar previas para asignarle a la Asignatura.");
				}	
			} else {
				execution.setVariable("mensaje", "Debe seleccionar una Asignatura para agregarles previas.");
			}
			
		} catch (Exception e) {
			execution.setVariable("mensaje", "Se ha generado un error. " + e.getMessage());
		}
	}
}
