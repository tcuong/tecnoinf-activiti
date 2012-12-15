package edu.bedelias.activiti.entregatitulo;

import java.util.Iterator;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Materia;
import edu.bedelias.entities.Student;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.MateriaService;
import edu.bedelias.services.StudentService;

public class ValidarInformacion implements JavaDelegate {

	private EvaluacionService evaluacionService;
	private CarreerService carreerService;
	private MateriaService materiaService;
	private StudentService studentService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextWeb.xml");

		evaluacionService = (EvaluacionService) cpx
				.getBean("evaluacionService");
		carreerService = (CarreerService) cpx.getBean("carreerService");
		materiaService = (MateriaService) cpx.getBean("materiaService");
		studentService = (StudentService) cpx.getBean("studentService");

		Long carreraId = Long.valueOf(execution.getVariable("carreraId")
				.toString());
		Long studentId = Long.valueOf(execution.getVariable("studentId")
				.toString());
		Student student = studentService.findStudentById(studentId);

		// Me traigo las materias para la carrera
		List<Materia> materias = carreerService
				.findMateriaByCarreerId(carreraId);

		// Me traigo las evaluaciones de examen y de curso q estan aprobadas
		// para un estudiante dado
		List<Evaluacion> evaluacionesExamen = evaluacionService
				.getEvaluacionesAprobadasByStudentAndExamen(studentId);

		List<Evaluacion> evaluacionesCurso = evaluacionService
				.getEvaluacionesAprobadasByStudentAndCurso(studentId);

		Integer creditosTotalesEstudiante = 0;
		Integer creditosEstudiantes = 0;

		Carreer carrera = carreerService.findCarreer(carreraId);

		// Primero itero por materias
		Iterator<Materia> iterator = materias.iterator();
		boolean seRecibe = true;

		while (iterator.hasNext() && seRecibe) {
			Materia m = iterator.next();
			Integer creditosMateria = m.getMinCredits();
			List<Asignatura> asignaturasExamen = materiaService
					.getAsignaturasByMateriaIdAndTipoAprobacionExamen(m.getId());

			// Recorro las asignaturas de examen y sumo creditos
			for (Asignatura a : asignaturasExamen) {
				for (Evaluacion e : evaluacionesExamen) {
					long evExAsId = e.getExamen().getAsignatura().getId();
					long asigId = a.getId();
					if (evExAsId == asigId) {
						creditosEstudiantes += a.getCredits();
					}
				}
			}

			List<Asignatura> asignaturasCurso = materiaService
					.getAsignaturasByMateriaIdAndTipoAprobacionCurso((m.getId()));

			// Recorro promero las asignaturas de curso y sumo los creditos
			for (Asignatura a : asignaturasCurso) {
				for (Evaluacion e : evaluacionesCurso) {
					long evCursoAsId = e.getCurso().getAsignatura().getId();
					long asigId = a.getId();
					if (evCursoAsId == asigId) {
						creditosEstudiantes += a.getCredits();
					}
				}
			}

			// Si no complete los creditos minimos por materias seteo el flag pa
			// salir del while
			if (creditosMateria > creditosEstudiantes) {
				seRecibe = false;
			} else {
				creditosTotalesEstudiante += creditosMateria;
			}
		}

		// Aca me fijo si cumple con los creditos de la carrera
		if (seRecibe && creditosTotalesEstudiante >= carrera.getTotalCredits()) {
			execution.setVariable("seRecibe", true);
			execution.setVariable("mailEstudiante", student.getEmail());
			execution.setVariable("nombreEstudiante", student.getName());

		} else {
			execution.setVariable("seRecibe", false);
		}
	}

	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}

	public void setEvaluacionService(EvaluacionService evaluacionService) {
		this.evaluacionService = evaluacionService;
	}

	public CarreerService getCarreerService() {
		return carreerService;
	}

	public void setCarreerService(CarreerService carreerService) {
		this.carreerService = carreerService;
	}

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
