package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class EvaluacionTest {

	@Autowired
	private EvaluacionService evaluacionService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Test
	public void test() {

		Student student = studentService.createStudent(new Student("Chupito",
				"chupame@eltobonia.net", "someCedula", new Date(System
						.currentTimeMillis())));

		Asignatura asignatura = new Asignatura();
		asignatura.setCode("codigoAsig");
		asignatura.setName("Calculo");
		asignatura = asignaturaService.createAsignatura(asignatura);

		Curso curso = new Curso();
		curso.setCode("codigoCurso");
		curso.setName("Plastilina 101 vesp.");
		curso.setSemestre("Par");
		curso.setHorario("Los jueves de 9 a 10:30");
		curso.setFechaInicio(new Date(System.currentTimeMillis()));
		curso.setFechaFin(new Date(System.currentTimeMillis()));
		curso.setTurno(TurnoEnum.VESPERTINO);
		curso.setAsignatura(asignatura);

		curso = cursoService.createCurso(curso, asignatura);

		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setFechaEvaluacion(new Date(System.currentTimeMillis()));

		evaluacion = evaluacionService.createEvaluacion(evaluacion,
				student.getId(), curso.getId());

		assertNotNull("Evaluacion can't be null", evaluacion);
		assertNotNull("Estudiante can't be null", evaluacion.getEstudiante());
		assertNotNull("Curso can't be null", evaluacion.getCurso());

	}

	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}

	public void setEvaluacionService(EvaluacionService evaluacionService) {
		this.evaluacionService = evaluacionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

}
