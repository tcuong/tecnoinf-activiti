package edu.bedelias.activiti.ingresoactascurso;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.explorer.ui.form.ActaCursoON;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.CursoService;

public class GuardarInformacionFinal implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");

	private CursoService cursoService = (CursoService) cpx.getBean("cursoService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// obtengo la lista con objetos de negocio que generó la tabla del formulario en la tarea previa

		@SuppressWarnings("unchecked")
		List<ActaCursoON> actaCurso = (List<ActaCursoON>) execution.getVariable("tablaAuditar");

		String cursoId = execution.getVariable("curso").toString();
		
		// me tengo que fijar si ya existe la evaluación!!!
		
		

		// acá guardo las evaluaciones ingresadas para luego mandarlas guardar
//		List<Evaluacion> evaluaciones = new ArrayList<>();
//
//		Curso curso = cursoService.findCursoById(Long.valueOf(cursoId));
//
//		for (ActaCursoON acta : actaCurso) {
//
//			Evaluacion evaluacion = new Evaluacion();
//			evaluacion.setEstudiante(acta.getStudent());
//			evaluacion.setCurso(curso);
//			evaluacion.setTipoEvaluacion(TipoEvaluacionEnum.FINAL);
//
//			if (acta.getNota().equals("No se presento")) {
//				evaluacion.setNoAsistio(true);
//
//				// agrego la evaluacion
//				evaluaciones.add(evaluacion);
//			} else {
//
//				int nota = 0;
//				try {
//					nota = Integer.valueOf(acta.getNota());
//				} catch (Exception e) {
//					// si acá hay cualquier cosa y explota el casteo, tomamos
//					// como que no era una nota válida y no se crea nada
//					// la tarea queda como no finalizada
//					finalizada = false;
//				}
//				// si le ingresaron una nota la agregamos y agregamos la
//				// evaluacion
//				if (nota > 0) {
//					evaluacion.setResultado(nota);
//					evaluaciones.add(evaluacion);
//				} else {
//					finalizada = false;
//				}
//			}
//
//		}
		// guaramos las evaluaciones generadas
//		evaluacionService.createEvaluacion(evaluaciones);

		execution.setVariable("mensaje", "Ha finalizado con el ingreso de notas para el curso " + "poner nombre del curso");
	}
}
