package edu.bedelias.activiti.inscribirestudiantecarrera;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;

public class ValidarPase implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");

	private StudentService studentService = (StudentService) cpx.getBean("studentService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String nombre = (String) execution.getVariable("nombre");
		String apellido = (String) execution.getVariable("apellido");
		String cedula = (String) execution.getVariable("cedula");
		String telefono = (String) execution.getVariable("telefono");
		String celular = (String) execution.getVariable("celular");
		String email = (String) execution.getVariable("email");
		String direccion = (String) execution.getVariable("direccion");
		String numPase = (String) execution.getVariable("numPase");
		String institucion = (String) execution.getVariable("Institución");

		// primero valido el pase del estudiante
		Boolean isValido = studentService.validarPase(numPase, institucion, cedula);

		// si el pase es válido doy de alta el estudiante y sigo con el proceso
		if(isValido){
			Student student = new Student(nombre, email, cedula, new Date());
			student.setLastname(apellido);
			student.setCellphone(celular);
			student.setPhone(telefono);
			student.setAddress(direccion);
			student.setNumPase(numPase);
			student.setInstitucion(institucion);
			
			// guardo el estudiante
			studentService.createStudent(student);
			
			execution.setVariable("paseValido", true);
		}
		// si el pase NO es válido envío un mensaje y termina el proceso
		execution.setVariable("paseValido", false);
		execution.setVariable("mensaje", "El pase del estudiante " + nombre
				+ " no ha sido validado por la Institución");
	}

}
