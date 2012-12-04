package edu.bedelias.activiti.altacurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;

public class GuardarYValidar implements JavaDelegate {

	
	private ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private CarreerService carreerService = (CarreerService) cpx.getBean("carreerService");

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo las variables de la task
//		String nombre = (String) execution.getVariable("nombre");
//		String tituloIntermedio = (String) execution.getVariable("tituloIntermedio");
//		int totalCreditos = Integer.valueOf(execution.getVariable("totalCreditos").toString());
//		int cretidosTituloIntermedio = Integer.valueOf(execution.getVariable("cretidosTituloIntermedio").toString());
		
		// verifico que no exista una carrera con el mismo nombre
// 		Boolean existe = carreerService.existeCarrera(nombre);
		
		// si no existe, la creo y la guardo
//		if(!existe){
//			try {
//				Carreer carrera = new Carreer();
//				carrera.setName(nombre);
//				carrera.setCreationDate(new Date());
//				carrera.setIntermediateCredits(cretidosTituloIntermedio);
//				carrera.setTotalCredits(totalCreditos);
//				carrera.setIntermediateTitle(tituloIntermedio);
//				
//				// guardo al carrera
//				carreerService.createCarreer(carrera);
//				
				execution.setVariable("mensaje", "La carrera se ha generado con exito.");
//			} catch (Exception e) {
//				execution.setVariable("mensaje", "Se ha generado un error. " + e.getMessage());
//			}
//			
//		} else {	
//			// si ya existe envío un mensaje al usuario
//			execution.setVariable("mensaje", "Ya existe una carrera con el mismo nombre, cambielo y vuelva a intentar.");
//		}
		
	}
}
