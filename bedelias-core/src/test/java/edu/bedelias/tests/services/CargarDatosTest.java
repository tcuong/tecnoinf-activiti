package edu.bedelias.tests.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Materia;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.AprobacionEnum;
import edu.bedelias.enums.EstadoAprobacionEnum;
import edu.bedelias.enums.TipoEvaluacionEnum;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.ExamenService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.MateriaService;
import edu.bedelias.services.PeriodoInscripcionService;
import edu.bedelias.services.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class CargarDatosTest {

	@Autowired
	private StudentService studentService;

	@Autowired
	private EvaluacionService evaluacionService;

	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private CarreerService carreraService;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private ExamenService examenService;

	@Autowired
	private PeriodoInscripcionService periodoInscripcionService;

	private Long carreraId;
	private Long studentId;

	@Before
	public void cargarDatos() {

		// Creo un Estudiante

		Student student = new Student();
		student.setName("Chupito");
		student.setCedula("cedula");
		student.setEmail("chupame@eltobonia.net");
		student.setPassword("pass");
		student.setPassword("lala");
		student.setFechaInscripcionFac(new Date(System.currentTimeMillis()));
		student = studentService.createStudent(student);
		studentId = student.getId();

		// Creo un par de carreras
		List<Carreer> carreras = new ArrayList<Carreer>();
		carreras.add(new Carreer("Ingenieria Mecanica"));
		carreras.add(new Carreer("Ingenieria Civil"));
		carreras.add(new Carreer("Ingenieria Quimica"));
		carreras.add(new Carreer("Ingenieria Computacion"));
		carreraService.createCarreer(carreras);
		Carreer carrera = carreraService.createCarreer(new Carreer(
				"Ing. Alimentos"));

		// Creo Materia Asignatura y las linkeo
		Asignatura asignatura = new Asignatura();
		asignatura.setCode("asigCode");
		asignatura.setName("Una Asignatura");
		asignatura.setTipoAprobacion(AprobacionEnum.CURSO);
		asignatura.setCredits(5);
		asignatura = asignaturaService.createAsignatura(asignatura);

		Asignatura previa = new Asignatura();
		previa.setCode("soyPrevia");
		previa.setName("CHUKU");
		previa.setTipoAprobacion(AprobacionEnum.EXAMEN);
		previa.setCredits(8);
		previa = asignaturaService.createAsignatura(previa);
		asignaturaService.agregarPreviaAsignatura(asignatura, previa);

		Materia materia = new Materia();
		materia.setName("Didactica");
		materia.setCode("codigoMateria");
		materia.setMinCredits(13);
		materia = materiaService.agregarAsignaturaMateria(materia, asignatura);
		materia = materiaService.agregarAsignaturaMateria(materia, previa);

		// Asigna una Materia a una Carrera
		carreraService.agregarMateriaACarrera(carrera, materia);

		// Creo un curso y le asigno una asignatura
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

		// Creo un Examen
		Examen examen = new Examen();
		examen.setCodigo("codigo");
		examen.setFecha(new Date(System.currentTimeMillis()));
		examen = examenService.createExamen(examen, previa);

		PeriodoInscripcion periodoCarrera = new PeriodoInscripcion();
		periodoCarrera.setIsHabilitado(true);
		periodoCarrera.setCreationDate(new Date(System.currentTimeMillis()));
		periodoCarrera.setDescripcion("Periodo de Carrera");
		periodoCarrera.setTipoInscripcion(TipoInscripcionEnum.CARRERA);
		periodoCarrera = periodoInscripcionService
				.createPeriodoInscripcion(periodoCarrera);

		PeriodoInscripcion periodoCurso = new PeriodoInscripcion();
		periodoCurso.setIsHabilitado(true);
		periodoCurso.setCreationDate(new Date(System.currentTimeMillis()));
		periodoCurso.setDescripcion("Periodo de curso");
		periodoCurso.setTipoInscripcion(TipoInscripcionEnum.CURSO);
		periodoCurso = periodoInscripcionService
				.createPeriodoInscripcion(periodoCurso);

		PeriodoInscripcion periodoExamen = new PeriodoInscripcion();
		periodoExamen.setIsHabilitado(true);
		periodoExamen.setCreationDate(new Date(System.currentTimeMillis()));
		periodoExamen.setDescripcion("Periodo de curso");
		periodoExamen.setTipoInscripcion(TipoInscripcionEnum.EXAMEN);
		periodoExamen = periodoInscripcionService
				.createPeriodoInscripcion(periodoExamen);

		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setResultado(8);
		evaluacion.setCurso(curso);
		evaluacion.setEstudiante(student);
		evaluacion.setTipoEvaluacion(TipoEvaluacionEnum.FINAL);
		evaluacion.setEstado(EstadoAprobacionEnum.APROBADO);
		evaluacion.setResultado(8);
		evaluacion = evaluacionService.createEvaluacion(evaluacion);

		// Inscripcion a Carrera
		inscripcionService.InscripcionACarrera(student.getId(),
				carrera.getId(), periodoCarrera.getId());
		carreraId = carrera.getId();

		// Inscripcion a Curso
		inscripcionService.InscripcionACurso(student.getId(), curso.getId(),
				periodoCurso.getId());
		// Inscripcion a Examen
		inscripcionService.inscripcionAExamen(student.getId(), examen.getId(),
				periodoExamen.getId());

		Evaluacion evaluacionEx = new Evaluacion();
		evaluacionEx.setResultado(8);
		evaluacionEx.setExamen(examen);
		evaluacionEx.setEstudiante(student);
		evaluacionEx.setTipoEvaluacion(TipoEvaluacionEnum.FINAL);
		evaluacionEx.setEstado(EstadoAprobacionEnum.APROBADO);
		evaluacionEx.setResultado(8);
		evaluacionEx = evaluacionService.createEvaluacion(evaluacionEx);
	}

	@Test
	public void test() {
		// Me traigo las materias para la carrera
		List<Materia> materias = carreraService
				.findMateriaByCarreerId(carreraId);

		// Me traigo las evaluaciones de examen y de curso q estan aprobadas
		// para un estudiante dado
		List<Evaluacion> evaluacionesExamen = evaluacionService
				.getEvaluacionesAprobadasByStudentAndExamen(studentId);

		// TODO revisar lo de la concurrency
		List<Evaluacion> evaluacionesCurso = evaluacionService
				.getEvaluacionesAprobadasByStudentAndCurso(studentId);
		Integer creditosTotales = 0;
		Integer creditosEstudiantes = 0;

		// Primero itero por materias
		for (Materia m : materias) {
			Integer creditosMateria = m.getMinCredits();

			List<Asignatura> asignaturasExamen = materiaService
					.getAsignaturasByMateriaIdAndTipoAprobacionExamen(m.getId());

			// // Recorro las asignaturas de examen
			for (Asignatura a : asignaturasExamen) {
				for (Evaluacion e : evaluacionesExamen) {
					if (e.getExamen().getAsignatura().getId() == a.getId()) {
						creditosEstudiantes += a.getCredits();
					}
				}
			}

			List<Asignatura> asignaturasCurso = materiaService
					.getAsignaturasByMateriaIdAndTipoAprobacionCurso((m.getId()));

			// Recorro promero las asignaturas de curso
			for (Asignatura a : asignaturasCurso) {
				for (Evaluacion e : evaluacionesCurso) {
					if (e.getCurso().getAsignatura().getId() == a.getId()) {
						creditosEstudiantes += a.getCredits();
					}
				}
			}

			if (creditosMateria > creditosEstudiantes) {
				break;
			} else {
				creditosTotales += creditosMateria;
			}

			System.out.println("lalallalal");

		}
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}

	public void setEvaluacionService(EvaluacionService evaluacionService) {
		this.evaluacionService = evaluacionService;
	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public CarreerService getCarreraService() {
		return carreraService;
	}

	public void setCarreraService(CarreerService carreraService) {
		this.carreraService = carreraService;
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

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

	public ExamenService getExamenService() {
		return examenService;
	}

	public void setExamenService(ExamenService examenService) {
		this.examenService = examenService;
	}

	public PeriodoInscripcionService getPeriodoInscripcionService() {
		return periodoInscripcionService;
	}

	public void setPeriodoInscripcionService(
			PeriodoInscripcionService periodoInscripcionService) {
		this.periodoInscripcionService = periodoInscripcionService;
	}

	public Long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}
