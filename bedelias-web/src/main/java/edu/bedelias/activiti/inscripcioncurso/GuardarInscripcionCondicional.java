package edu.bedelias.activiti.inscripcioncurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.InscripcionService;

public class GuardarInscripcionCondicional implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextWeb.xml");
	private InscripcionService inscripcionService = (InscripcionService) cpx.getBean("inscripcionService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		// obtengo los datos
		Student student = (Student) execution.getVariable("student");
		Curso curso = (Curso) execution.getVariable("curso");
		PeriodoInscripcion periodo = (PeriodoInscripcion) execution.getVariable("periodo");

		// creo la inscripcion
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCurso(curso);
		inscripcion.setEstudiante(student);
		inscripcion.setFechaInscripcion(new Date());
		inscripcion.setPeriodo(periodo);
		inscripcion.setTipo(TipoInscripcionEnum.CURSO);

		// la guardo
		inscripcion = inscripcionService.createInscripcion(inscripcion);

		// seteo las variables para el temporizador y las proximas tareas
		// ejemplo de como tiene que ir la fecha "2007-04-05T24:00" formato ISO
		// 8601
		// SimpleDateFormat formato = new
		// SimpleDateFormat("YYYY-mm-ddThh:mm:ss");
		// String fecha = formato.format(periodo.getFechaFin());

		String fecha = "2012-12-14T12:35:00";
		execution.setVariable("fechaFinDesistimiento", fecha);
		execution.setVariable("student", student);
		execution.setVariable("curso", curso);

	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}
}
