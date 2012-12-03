package edu.bedelias.activiti.altamateria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Materia;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.MateriaService;

public class GuardarYValidar implements JavaDelegate {

	
	private ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private MateriaService materiaService = (MateriaService) cpx.getBean("materiaService");
	private CarreerService carreraService = (CarreerService) cpx.getBean("carreerService");

	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo las carreras que seleccionó el funcionario para agregar la materia
		String carrerasArray = (String) execution.getVariable("carreras");
		String[] idCarreras = carrerasArray.split("\\|");
		
		List<Carreer> carreras = new ArrayList<Carreer>();
		
		// voy a buscar las carreras y las guardo en la lista
		for (String id: idCarreras) {
			Carreer carrera = carreraService.findCarreer(Long.valueOf(id));
			carreras.add(carrera);
		}
		
		// obtengo los datos referentes a la materia
		String nombre = (String) execution.getVariable("nombre");
		String codigo = (String) execution.getVariable("codigo");
		int minCreditos = Integer.valueOf(execution.getVariable("minCredito").toString());

		// verifico que no exista una carrera con el mismo nombre
 		Boolean existe = materiaService.existeMateria(nombre);
		
		// si no existe, la creo y la guardo
		if(!existe){
			try {
				Materia materia = new Materia();
				materia.setName(nombre);
				materia.setCode(codigo);
				materia.setMinCredits(minCreditos);
				materia.setCreationDate(new Date());
				
				// guardo la materia
				materia = materiaService.createMateria(materia);
				
				// recorro todas las carreras y le agrego la materia
				for (Carreer carreer : carreras) {
					carreraService.agregarMateriaACarrera(carreer, materia);
				}
				
				execution.setVariable("mensaje", "La materia se ha generado con exito.");
			} catch (Exception e) {
				execution.setVariable("mensaje", "Se ha generado un error. " + e.getMessage());
			}
			
		} else {	
			// si ya existe envío un mensaje al usuario
			execution.setVariable("mensaje", "Ya existe una materia con el mismo nombre, cambielo y vuelva a intentar.");
		}
		
	}
}
