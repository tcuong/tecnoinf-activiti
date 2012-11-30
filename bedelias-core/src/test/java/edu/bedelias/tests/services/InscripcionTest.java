package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.ExamenService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.PeriodoInscripcionService;
import edu.bedelias.services.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class InscripcionTest {

	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ExamenService examenService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Autowired
	private PeriodoInscripcionService periodoInscripcionService;

	@Autowired
	private CursoService cursoService;

	@Ignore
	@Test
	public void test() {
		Asignatura asignatura = new Asignatura();
		asignatura.setName("Platilina 101");
		asignatura.setCode("elcodigooo");
		asignatura = asignaturaService.createAsignatura(asignatura);

		Examen examen = new Examen();
		examen.setNota(8);
		examen.setFecha(new Date(System.currentTimeMillis()));
		examen = examenService.createExamen(examen, asignatura);

		Student student = studentService.createStudent(new Student("Chupito",
				"chupame@eltobonia.net", "someCedula", new Date(System
						.currentTimeMillis())));

		// FIXME Inscripcion inscripcion =
		// inscripcionService.inscripcionAExamen(
		// student.getId(), examen.getId());

		// assertNotNull("Inscripcion can't be null", inscripcion);
		// examen = inscripcion.getExamen();
		// asignatura = examen.getAsignatura();
		// assertNotNull("Examen can't be null", examen);
		// assertNotNull("Asignatura can't be null", asignatura);

	}

	@Test
	public void test2() {

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

		Student student = studentService.createStudent(new Student("Chupito",
				"chupame@eltobonia.net", "someCedula", new Date(System
						.currentTimeMillis())));

		PeriodoInscripcion periodoInscripcion = new PeriodoInscripcion();
		periodoInscripcion.setIsHabilitado(true);
		periodoInscripcion
				.setCreationDate(new Date(System.currentTimeMillis()));
		periodoInscripcion.setDescripcion("Periodo de fiesta");
		periodoInscripcion.setTipoInscripcion(TipoInscripcionEnum.CURSO);
		periodoInscripcion = periodoInscripcionService
				.createPeriodoInscripcion(periodoInscripcion);

		Inscripcion inscripcion = inscripcionService.InscripcionACurso(
				student.getId(), curso.getId(), periodoInscripcion.getId());

		assertNotNull("Asignatura can't be null", inscripcion);

	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ExamenService getExamenService() {
		return examenService;
	}

	public void setExamenService(ExamenService examenService) {
		this.examenService = examenService;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

	public PeriodoInscripcionService getPeriodoInscripcionService() {
		return periodoInscripcionService;
	}

	public void setPeriodoInscripcionService(
			PeriodoInscripcionService periodoInscripcionService) {
		this.periodoInscripcionService = periodoInscripcionService;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}
