package edu.bedelias.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.repositories.CarreerRepository;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.repositories.InscripcionRepository;
import edu.bedelias.repositories.StudentRepository;

@Service
@Transactional(readOnly = true)
public class InscripcionServiceImpl implements InscripcionService {

	private static Logger log = Logger.getLogger(InscripcionServiceImpl.class);

	@Autowired
	private InscripcionRepository inscripcionRepo;

	@Autowired
	private CarreerRepository carreerRepo;

	@Autowired
	private CursoRepository cursoRepo;

	@Autowired
	private StudentRepository studentRepo;

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
			log.error("Estudiante es NULL");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Inscripcion> getInscripcionesByTipo(Student student,
			TipoInscripcionEnum tipo) {
		List<Inscripcion> ins = null;
		try {
			ins = inscripcionRepo.findInscripcionByEstudianteAndTipo(student,
					tipo);
		} catch (IllegalArgumentException e) {
			log.error("Estudiante o Inscripcion invalidos");
			e.printStackTrace();
		}

		return ins;
	}

	@Override
	@Transactional
	public Inscripcion InscripcionACarrera(Long studentId, Long carreerId) {
		Inscripcion ins = null;

		if (studentId != null && carreerId != null) {
			try {
				Student student = studentRepo.findOne(studentId);
				Carreer carreer = carreerRepo.findOne(carreerId);

				ins = new Inscripcion();
				ins.setEstudiante(student);
				ins.setCarrera(carreer);
				ins.setTipo(TipoInscripcionEnum.CARRERA);
				ins = createInscripcion(ins);

			} catch (IllegalArgumentException e) {
				log.error("Student or Carreer are NULL");
				e.printStackTrace();
			}
		}
		
		return ins;
	}

	@Override
	@Transactional
	public Inscripcion InscripcionACurso(Long studentId, Long cursoId) {
		Inscripcion ins = null;

		if (studentId != null && cursoId != null) {
			try {
				Student student = studentRepo.findOne(studentId);
				Curso curso = cursoRepo.findOne(cursoId); // FIXME traer SOLAMENTE los cursos de una carrera a la que este asociado el student

				ins = new Inscripcion();
				ins.setEstudiante(student);
				ins.setCurso(curso);
				ins.setTipo(TipoInscripcionEnum.CURSO);
				ins = createInscripcion(ins);

			} catch (IllegalArgumentException e) {
				log.error("Estudiante o Curso NULL");
				e.printStackTrace();
			}
		}
		
		return ins;
	}

}
