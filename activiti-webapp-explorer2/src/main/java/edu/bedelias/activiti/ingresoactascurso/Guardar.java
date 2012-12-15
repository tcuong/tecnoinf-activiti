package edu.bedelias.activiti.ingresoactascurso;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.explorer.ui.form.ActaCursoON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.EstadoAprobacionEnum;
import edu.bedelias.enums.TipoEvaluacionEnum;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.EvaluacionService;

public class Guardar implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
			"classpath:applicationContextRemote.xml");

	private EvaluacionService evaluacionService = (EvaluacionService) cpx
			.getBean("evaluacionService");
	private CursoService cursoService = (CursoService) cpx
			.getBean("cursoService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// obtengo la lista con objetos de negocio que generó la tabla del
		// formulario en la tarea previa

		@SuppressWarnings("unchecked")
		List<ActaCursoON> actaCurso = (List<ActaCursoON>) execution
				.getVariable("actaEstudiantes");
		String cursoId = execution.getVariable("curso").toString();

		// acá guardo las evaluaciones ingresadas para luego mandarlas guardar
		List<Evaluacion> evaluaciones = new ArrayList<>();

		Curso curso = cursoService.findCursoById(Long.valueOf(cursoId));

		for (ActaCursoON acta : actaCurso) {

			Student student = acta.getStudent();

			Evaluacion evaluacion = evaluacionService
					.getEvaluacionByStudentAndCurso(student, curso);

			if (evaluacion == null) {
				evaluacion = new Evaluacion();
				evaluacion.setEstudiante(student);
				evaluacion.setCurso(curso);
				evaluacion.setTipoEvaluacion(TipoEvaluacionEnum.CURSO);
			}

			if (acta.getNota().equals("No se presento")) {
				evaluacion.setNoAsistio(true);

				// agrego la evaluacion
				evaluaciones.add(evaluacion);

			} else {

				int nota = 0;
				try {
					nota = Integer.valueOf(acta.getNota());
				} catch (Exception e) {
					// si acá hay cualquier cosa y explota el casteo, tomamos
					// como que no era una nota válida
					// le agregamos un valor "raro" para que en la auditoria la
					// revisen
					nota = 999;
				}
				// si le ingresaron una nota la agregamos y agregamos la
				// evaluacion
				evaluacion.setResultado(nota);
				if (nota >= 3) {
					evaluacion.setEstado(EstadoAprobacionEnum.APROBADO);
				} else {
					evaluacion.setEstado(EstadoAprobacionEnum.NOAPROBADO);
				}
				evaluaciones.add(evaluacion);
			}

		}
		// guardamos las evaluaciones generadas
		evaluacionService.createEvaluacion(evaluaciones);
		execution.setVariable("curso", cursoId);
	}

}
