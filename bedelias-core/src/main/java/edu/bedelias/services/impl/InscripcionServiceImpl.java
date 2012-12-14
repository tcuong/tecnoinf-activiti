package edu.bedelias.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.repositories.CarreerRepository;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.repositories.ExamenRepository;
import edu.bedelias.repositories.InscripcionRepository;
import edu.bedelias.repositories.PeriodoInscripcionRepository;
import edu.bedelias.repositories.StudentRepository;
import edu.bedelias.services.InscripcionService;

@Service(value = "inscripcionServiceImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class InscripcionServiceImpl implements InscripcionService {

	private static Logger logger = Logger
			.getLogger(InscripcionServiceImpl.class.getName());

	@Autowired
	private InscripcionRepository inscripcionRepo;

	@Autowired
	private PeriodoInscripcionRepository periodoInscripcionRepo;

	@Autowired
	private CarreerRepository carreerRepo;

	@Autowired
	private CursoRepository cursoRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private ExamenRepository examenRepo;

	// Getters && Setters

	public InscripcionRepository getInscripcionRepo() {
		return inscripcionRepo;
	}

	public void setInscripcionRepo(InscripcionRepository inscripcionRepo) {
		this.inscripcionRepo = inscripcionRepo;
	}

	public CarreerRepository getCarreerRepo() {
		return carreerRepo;
	}

	public void setCarreerRepo(CarreerRepository carreerRepo) {
		this.carreerRepo = carreerRepo;
	}

	public CursoRepository getCursoRepo() {
		return cursoRepo;
	}

	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}

	public StudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	@Transactional
	public Inscripcion createInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
		return inscripcion;

	}

	@Override
	@Transactional
	public void updateInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
	}

	@Override
	@Transactional
	public void deleteInscripcion(Inscripcion inscripcion) {
		inscripcionRepo.delete(inscripcion);
	}

	@Override
	public List<Carreer> getCarrerasByStudent(Student student) {
		List<Inscripcion> inscripciones = this
				.getInscripcionesByStudent(student);
		List<Carreer> carreers = new ArrayList<Carreer>();
		for (Inscripcion ins : inscripciones) {
			if (ins.getTipo() == TipoInscripcionEnum.CARRERA) {
				carreers.add(carreerRepo.findOne(ins.getCarrera().getId()));
			}
		}
		return carreers;
	}

	@Override
	public List<Curso> getCursoByStudent(Student student) {

		List<Inscripcion> inscripciones = this
				.getInscripcionesByStudent(student);
		List<Curso> cursos = new ArrayList<Curso>();
		for (Inscripcion ins : inscripciones) {
			if (ins.getTipo() == TipoInscripcionEnum.CURSO) {
				cursos.add(cursoRepo.findOne(ins.getCurso().getId()));
			}
		}
		return cursos;
	}

	@Override
	public List<Inscripcion> getInscripcionesByStudent(Student student) {
		try {
			return inscripcionRepo.findInscripcionByEstudiante(student);
		} catch (IllegalArgumentException e) {
			logger.error("Estudiante es NULL");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Inscripcion> getInscripcionesByTipo(String ciEst,
			TipoInscripcionEnum tipo) {
		List<Inscripcion> ins = null;
		Student student = null;
		try {
			student = studentRepo.findStudentByCedula(ciEst);
			ins = inscripcionRepo.findInscripcionByEstudianteAndTipo(student,
					tipo);
		} catch (IllegalArgumentException e) {
			logger.error("Estudiante o Inscripcion invalidos");
			e.printStackTrace();
		}

		return ins;
	}

	@Override
	@Transactional
	public Inscripcion InscripcionACarrera(Long studentId, Long carreerId,
			Long periodoId) {
		Inscripcion ins = null;

		if (studentId != null && carreerId != null) {
			try {
				Student student = studentRepo.findOne(studentId);
				Carreer carreer = carreerRepo.findOne(carreerId);
				PeriodoInscripcion periodo = periodoInscripcionRepo
						.findOne(periodoId);

				ins = new Inscripcion();
				ins.setEstudiante(student);
				ins.setCarrera(carreer);
				ins.setPeriodo(periodo);
				ins.setTipo(TipoInscripcionEnum.CARRERA);
				ins = createInscripcion(ins);

			} catch (IllegalArgumentException e) {
				logger.error("Student or Carreer are NULL");
				e.printStackTrace();
			}
		}

		return ins;
	}

	@Override
	@Transactional
	public Inscripcion InscripcionACurso(Long studentId, Long cursoId,
			Long periodoId) {
		Inscripcion ins = null;

		if (studentId != null && cursoId != null) {
			try {
				Student student = studentRepo.findOne(studentId);
				Curso curso = cursoRepo.findOne(cursoId);
				PeriodoInscripcion periodo = periodoInscripcionRepo
						.findOne(periodoId);

				ins = new Inscripcion();
				ins.setEstudiante(student);
				ins.setCurso(curso);
				ins.setTipo(TipoInscripcionEnum.CURSO);
				ins.setPeriodo(periodo);
				ins = createInscripcion(ins);

			} catch (IllegalArgumentException e) {
				logger.error("Estudiante o Curso NULL");
				e.printStackTrace();
			}
		}

		return ins;
	}

	@Override
	@Transactional
	public Inscripcion inscripcionAExamen(Long studentId, Long examenId,
			Long periodoId) {
		Inscripcion inscripcion = null;
		if (studentId != null && examenId != null) {
			try {
				Student student = studentRepo.findOne(studentId);
				Examen examen = examenRepo.findOne(examenId);
				PeriodoInscripcion periodo = periodoInscripcionRepo
						.findOne(periodoId);

				inscripcion = new Inscripcion();
				inscripcion.setEstudiante(student);
				inscripcion.setExamen(examen);
				inscripcion.setPeriodo(periodo);
				inscripcion.setTipo(TipoInscripcionEnum.EXAMEN);
				inscripcion = this.createInscripcion(inscripcion);

			} catch (Exception e) {
				logger.error("Estudiante o Examen NULL");
				e.printStackTrace();
			}
		}

		return inscripcion;
	}

	@Override
	public List<Inscripcion> findInscripcionesByCursoId(Curso curso) {
		return inscripcionRepo.getInscripcionesByCurso(curso);
	}

	public ExamenRepository getExamenRepo() {
		return examenRepo;
	}

	public void setExamenRepo(ExamenRepository examenRepo) {
		this.examenRepo = examenRepo;
	}

	@Override
	public List<Inscripcion> getInscripcionesParaDesistir(String ciEst) {
		// aca hay que poner la logica que retorne un listado con las
		// inscripciones que el estudiante puede desistir.
		// ie: todas las inscripciones que al dia de hoy tengan un periodo de
		// desistimiento habilitado
		return new ArrayList<Inscripcion>();
	}

	public PeriodoInscripcionRepository getPeriodoInscripcionRepo() {
		return periodoInscripcionRepo;
	}

	public void setPeriodoInscripcionRepo(
			PeriodoInscripcionRepository periodoInscripcionRepo) {
		this.periodoInscripcionRepo = periodoInscripcionRepo;
	}

	@Override
	public String createInscripcion_Activiti(long idCarrera, String cedula) {

		String msg = "La inscripcion fue exitosa";
		try {
			// obtengo a partir de los datos que me envía activiti la carrera y
			// el
			// estudiante
			Carreer carrera = carreerRepo.findOne(idCarrera);
			Student estudiante = studentRepo.findStudentByCedula(cedula);

			// seteo los datos en la inscripción
			Inscripcion inscripcion = new Inscripcion();
			inscripcion.setTipo(TipoInscripcionEnum.CARRERA);
			inscripcion.setCarrera(carrera);
			inscripcion.setEstudiante(estudiante);

			// guardo la inscripcion
			inscripcionRepo.save(inscripcion);

		} catch (Exception e) {
			msg = "Se generó un error al guardar la inscripción"
					+ e.getStackTrace();
		}
		return msg;
	}

	@Override
	public List<Student> getInscriptosCursoSinEvaluar(long idCurso,
			boolean valida) {
		// Acá tengo que devolver todas los estudiantes que tienen una
		// inscripcion al curso y con el tipo de inscripcion == valida
		// y además que no tengan una evaluación creada para ese curso, es para
		// el proceso de ingreso de resultados
		return null;
	}

	@Override
	public Inscripcion getInscripcionByStudentYCurso(Student student,
			Curso curso) {
		// por ahora retorno null pero hay que implementarla
		return null;
	}

}
