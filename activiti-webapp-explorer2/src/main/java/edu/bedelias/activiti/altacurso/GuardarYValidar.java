package edu.bedelias.activiti.altacurso;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.CursoService;

public class GuardarYValidar implements JavaDelegate {

	private ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
			"classpath:applicationContextRemote.xml");
	private AsignaturaService asignaturaService = (AsignaturaService) cpx
			.getBean("asignaturaService");
	private CursoService cursoService = (CursoService) cpx
			.getBean("cursoService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		try {
			// obtengo las variables de la task
			String idAsignatura = (String) execution.getVariable("asignatura");
			String codigo = (String) execution.getVariable("codigo");
			String descripcion = (String) execution.getVariable("descripcion");
			String semestre = (String) execution.getVariable("semestre");
			String horario = (String) execution.getVariable("horario");
			String turno = (String) execution.getVariable("turno");
			String salon = (String) execution.getVariable("salon");
			Date fechaInicio = (Date) execution.getVariable("fechaInicio");
			Date fechaFin = (Date) execution.getVariable("fechaFin");

			// verifico que la asignatura exista
			if (!idAsignatura.isEmpty()) {
				// si agrego un turno sigo
				if (!turno.isEmpty()) {

					// obtengo la asignatura
					Asignatura asignatura = asignaturaService
							.findAsignatura(Long.valueOf(idAsignatura));

					// creo el curso y le seteo los valores ingresados
					Curso curso = new Curso();
					curso.setName(codigo);
					curso.setDescripcion(descripcion);
					curso.setSemestre(semestre);
					curso.setHorario(horario);
					curso.setTurno(TurnoEnum.getTurno(turno));
					curso.setSalon(salon);
					curso.setFechaInicio(fechaInicio);
					curso.setFechaFin(fechaFin);

					// guardo el curso
					cursoService.createCurso(curso, asignatura);

					execution.setVariable("mensaje",
							"El curso fue creado con éxito.");
				} else {
					execution.setVariable("mensaje",
							"Debe seleccionar un Turno.");
				}
			} else {
				execution.setVariable("mensaje",
						"Debe seleccionar una Asignatura.");
			}

		} catch (Exception e) {
			execution.setVariable("mensaje",
					"Se ha generado un error. " + e.getMessage());
		}
	}
}
